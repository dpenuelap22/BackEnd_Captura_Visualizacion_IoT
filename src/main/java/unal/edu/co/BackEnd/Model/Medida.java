/*********************************************************************************************
 Descripcion: Clase encargada de realizar el mapeo de la entidad Medida del modelo Entidad-Relación
 Autor:		  Diego Andres Peñuela Pardo
 idGestion:   -----------------------
 @Copyright (c) 2023 Diego Andres Peñuela Pardo. Todos los derechos reservados. Última actualización: 25 de marzo de 2023.
 ********************************************************************************************/
// Especificación del paquete de la clase
package unal.edu.co.BackEnd.Model;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

// Importación de las clases y anotaciones necesarias para definir la entidad
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Definición de la entidad Medida y la tabla correspondiente en la base de datos
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Medida")
@Table(name="Medida")
public class Medida {
	
	
    private static final double VOLTAJE_CONSTANTE = 120.0; 
 // Identificador de la medida
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private long id_Medida;

 // Valor de la medida de potencia
 @Column(name="Potencia",length = 10,nullable = false)
 private Double potencia;
 
 // Valor de la medida de corriente
 @Column(name="Corriente",length = 10,nullable = false)
 private Double corriente;
 
 // Valor de la medida de Voltaje
 @Column(name="Voltaje",length = 10,nullable = false)
 private Double voltaje;
 
 // Fecha en la que se tomó la medida
 @Column(name="Fecha",length = 20,nullable = false)
 private LocalDate fecha;
 
 // Hora en la que se tomó la medida
 @Column(name="HoraInicio",length = 20,nullable = false)
 private LocalTime horaInicio;

 // Hora en la que finalizó la medida
 @Column(name="HoraFin",length = 20,nullable = false)
 private LocalTime horaFin;

 // Consumo registrado en KWh
 @Column(name="Consumo",length = 10,nullable = false)
 private Double consumo;

 // Dispositivo IoT al que pertenece la medida
 @ManyToOne(fetch = FetchType.LAZY)
 @JsonIgnore
 @JoinColumn(name = "Fk_Id_Dispositivo")
 private DispositivoIoT dispositivoIoT;

 // A continuación, se presentan los getters y setters de todos los campos anteriores.

 public long getId() {
     return id_Medida;
 }

 public void setId(long id) {
     this.id_Medida = id;
 }

 public Double getPotencia() {
     return potencia;
 }

 public void setPotencia(Double potencia) {
     this.potencia = potencia;
 }

 public Double getCorriente() {
     return corriente;
 }

 public void setCorriente(Double corriente) {
     this.corriente = corriente;
 }

 public Double getVoltaje() {
     return voltaje;
 }

 public void setVoltaje(Double voltaje) {
     this.voltaje = voltaje;
 }

 public LocalDate getFecha() {
     return fecha;
 }

 public void setFecha(LocalDate fecha) {
     this.fecha = fecha;
 }

 public LocalTime getHoraInicio() {
     return horaInicio;
 }

 public void setHoraInicio(LocalTime horaInicio) {
     this.horaInicio = horaInicio;
 }

 public LocalTime getHoraFin() {
     return horaFin;
 }

 public void setHoraFin(LocalTime horaFin) {
     this.horaFin = horaFin;
 }

 public Double getConsumo() {
     return consumo;
 }

 public void setConsumo(Double consumo) {
     this.consumo = consumo;
 }

 public DispositivoIoT getDispositivoIoT() {
     return dispositivoIoT;
 }

 public void setDispositivoIoT(DispositivoIoT dispositivoIoT) {
     this.dispositivoIoT = dispositivoIoT;
 }

 // Este método calcula la potencia basada en el consumo y la constante de voltaje.

 public void calcularPotencia() {
	    if (this.consumo != 0) {
	        this.potencia = this.consumo;
	    } else {
	        this.potencia = 0.0;
	    }
	}
 // Este método calcula la corriente basada en la potencia y la constante de voltaje.

	public void calcularCorriente() {
	    if (this.potencia != 0) {
	        this.corriente = this.potencia / this.VOLTAJE_CONSTANTE;
	    } else {
	        this.corriente = 0.0;
	    }
	}
    // Este método establece el valor del voltaje en base a si hay consumo o no.

	public void calcularVoltaje() {
	    if (this.consumo != 0) {
	        this.voltaje = this.VOLTAJE_CONSTANTE;
	    } else {
	        this.voltaje = 0.0;
	    }
	}

}