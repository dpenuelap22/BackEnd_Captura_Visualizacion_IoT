/*********************************************************************************************
 Descripción: Clase encargada de descargar archivos desde Google Drive
 Autor: Diego Andres Peñuela Pardo
 idGestion: -----------------------
 @Copyright (c) 2023 Diego Andres Peñuela Pardo. Todos los derechos reservados. Última actualización: 25 de marzo de 2023.
 ********************************************************************************************/


package unal.edu.co.BackEnd.ApiGoogle;
//Importaciones necesarias para interactuar con Google Drive, leer y escribir archivos, etc.
import com.google.api.services.drive.model.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.util.Collections;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;

import com.google.api.services.drive.model.FileList;

import jakarta.annotation.PostConstruct;
//Anotación que indica a Spring que esta clase es un componente

@Component
public class DriveDownload {
	// Constantes utilizadas para la interacción con Google Drive
	private static final String APPLICATION_NAME = "CapturaDatosIOT";
    private static final String CREDENTIALS_FILE_PATH = "credential.json";
    private static final String FOLDER_ID = "11FKb8tGR18zVw7h8_fEhqDjPmyuM8C_C";
    private static final String LOCAL_DOWNLOAD_PATH = "Datos_Dispositivo_IoT/Datos_Dispositivo_IoT.csv";
    private static final JacksonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String FILE_NAME="DatosDispositivoIoT.csv";
    
    // Método invocado después de la creación del bean, se encarga de la descarga del archivo.
    @PostConstruct
    public void downloadFile() throws IOException {
    	System.out.println("Iniciando la descarga de archivos desde Google Drive...");
   
    	// Lectura del archivo de credenciales y creación de las credenciales de Google
        GoogleCredential credential;
        try (InputStream is = new FileInputStream(CREDENTIALS_FILE_PATH)) {
            credential = GoogleCredential.fromStream(is)
                .createScoped(Collections.singleton(DriveScopes.DRIVE));
        }

        // Creación del servicio de Google Drive
        Drive drive = new Drive.Builder(new NetHttpTransport(), JSON_FACTORY, credential)
            .setApplicationName(APPLICATION_NAME)
            .build();

     // Búsqueda del archivo a descargar
        String fileId = null;
        FileList result = drive.files().list()
            .setQ("'" + FOLDER_ID + "' in parents and name = '" + FILE_NAME + "'")
            .setFields("files(id, name)")
            .execute();
        for (File file : result.getFiles()) {
            fileId = file.getId();
            break; 
        }
        if (fileId == null) {
            System.out.println("No se encontró el archivo con el nombre: " + FILE_NAME);
            return;
        }

        // Descarga del archivo
        try (OutputStream outputStream = new FileOutputStream(LOCAL_DOWNLOAD_PATH)) {
            drive.files().get(fileId).executeMediaAndDownloadTo(outputStream);
        }
    }
}