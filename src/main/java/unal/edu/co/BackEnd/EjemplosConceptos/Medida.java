package unal.edu.co.BackEnd.EjemplosConceptos;

public abstract class Medida {
   
	private double potencia;  // Atributo privado

    public Medida(double potencia) {  // Constructor de la clase
        this.potencia = potencia;
    }

    public double getPotencia() {  // Método para obtener el valor de la potencia
        return potencia;
    }
    
    public void setPotencia(double potencia) {  // Método para establecer el valor de la potencia
        this.potencia = potencia;
    }
    public abstract void mostrarDatos();  // Método abstracto para mostrar datos
}



