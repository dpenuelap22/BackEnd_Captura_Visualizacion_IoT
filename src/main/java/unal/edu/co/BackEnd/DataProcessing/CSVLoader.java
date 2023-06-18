/*********************************************************************************************
 Descripción: Clase encargada de cargar datos desde un archivo CSV
 Autor: Diego Andres Peñuela Pardo
 idGestion: -----------------------
 @Copyright (c) 2023 Diego Andres Peñuela Pardo. Todos los derechos reservados. Última actualización: 25 de marzo de 2023.
 ********************************************************************************************/
// Importaciones necesarias para leer archivos, procesar datos de fecha y hora, interactuar con la base de datos, etc.

package unal.edu.co.BackEnd.DataProcessing;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import unal.edu.co.BackEnd.Model.DispositivoIoT;
import unal.edu.co.BackEnd.Model.Medida;

import java.io.BufferedReader;



@Component
public class CSVLoader implements CommandLineRunner{
    // Método principal que se ejecuta al inicio del programa
	@Override
    @Transactional
    public void run(String... args) {
        try {
            loadData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private EntityManager entityManager;


 
    public void loadData() throws Exception {
        String csvFile = "Datos_Dispositivo_IoT/Datos_Dispositivo_IoT.csv";
        String line = "";
        String cvsSplitBy = ",";
        System.out.println("Iniciando la carga de datos desde el archivo CSV...");
        
        // Busca el dispositivo predeterminado en la base de datos
        List<DispositivoIoT> dispositivos = entityManager.createQuery("FROM DispositivoIoT WHERE Tipo_Dispositivo = 'Dispositivo IoT' AND Marca = 'Sonoff' AND Ubicacion = 'Medellin'", DispositivoIoT.class).getResultList();

        DispositivoIoT dispositivoPredeterminado;
        if (dispositivos.isEmpty()) {
            // Crea el dispositivo predeterminado si no existe
            dispositivoPredeterminado = new DispositivoIoT();
            dispositivoPredeterminado.setTipoDispositivo("WiFi Smart Power Meter Switch");
            dispositivoPredeterminado.setMarca("SONOFF");
            dispositivoPredeterminado.setModelo("POWR316D");
            dispositivoPredeterminado.setUbicacion("Medellin");
            entityManager.persist(dispositivoPredeterminado);
        } else {
            dispositivoPredeterminado = dispositivos.get(0);
        }

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                // divide la línea por coma
                String[] data = line.split(cvsSplitBy);

                String fecha = data[0];
                String[] rangoHora = data[1].split("-");
                double consumo = Double.parseDouble(data[2]);

                Medida medidaEntity = new Medida();
                medidaEntity.setFecha(LocalDate.parse(fecha, DateTimeFormatter.ofPattern("yyyy/M/d")));
                medidaEntity.setHoraInicio(LocalTime.parse(rangoHora[0], DateTimeFormatter.ofPattern("H:mm")));
                medidaEntity.setHoraFin(LocalTime.parse(rangoHora[1], DateTimeFormatter.ofPattern("H:mm")));
                medidaEntity.setConsumo(consumo);
                medidaEntity.setDispositivoIoT(dispositivoPredeterminado);
                // Creación de una nueva medida y persistencia en la base de datos

                 medidaEntity.calcularPotencia();
                 medidaEntity.calcularCorriente();
                 medidaEntity.calcularVoltaje();

                entityManager.persist(medidaEntity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
