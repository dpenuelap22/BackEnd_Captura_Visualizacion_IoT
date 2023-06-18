/*********************************************************************************************
 Descripcion: Clase encargada de realizar el mapeo de la entidad DispositivoIoT del modelo Entidad-Relación
 Autor:		  Diego Andres Peñuela Pardo
 idGestion:   -----------------------
 @Copyright (c) 2023 Diego Andres Peñuela Pardo. Todos los derechos reservados. Última actualización: 25 de marzo de 2023.
 ********************************************************************************************/
// Definición del paquete donde reside la clase
package unal.edu.co.BackEnd.Model;
//Importaciones necesarias
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
//Importaciones de Lombok para reducir código boilerplate
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Anotaciones de Lombok para generar getters, setters, constructor por defecto y constructor con todos los campos
@NoArgsConstructor
@AllArgsConstructor
//Anotaciones de Jakarta Persistence para definir la entidad y la tabla correspondiente en la base de datos
@Entity(name="DispositivoIoT")
@Table(name="DispositivoIoT")
public class DispositivoIoT {
    // Identificador único del dispositivo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id_Dispositivo;
    
    // Tipo de dispositivo IoT
    @Column(name="Tipo_Dispositivo", length = 30, nullable = false)
    private String Tipo_Dispositivo;
    
    // Marca del dispositivo
    @Column(name="Marca", length = 30,nullable = false)
    private String Marca;
    
    //Modelo del dispositivo
    @Column(name="Modelo_Dispositivo", length = 30, nullable = false)
    private String Modelo;
    
    // Ubicación del dispositivo
    @Column(name="Ubicacion",length = 30, nullable = false)
    private String Ubicacion;
    
    // Lista de medidas asociadas al dispositivo
    @OneToMany(mappedBy = "dispositivoIoT", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Medida> medidas;
    
    public void setTipoDispositivo(String tipoDispositivo) {
        this.Tipo_Dispositivo = tipoDispositivo;
    }

    public String getTipoDispositivo() {
        return Tipo_Dispositivo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        this.Marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        this.Modelo = modelo;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.Ubicacion = ubicacion;
    }
}
