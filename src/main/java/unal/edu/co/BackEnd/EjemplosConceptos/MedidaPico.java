package unal.edu.co.BackEnd.EjemplosConceptos;

public class MedidaPico extends Medida {
    private double tiempo;  // Atributo adicional para la MedidaPico

    public MedidaPico(double potencia, double tiempo) {  // Constructor de la clase
        super(potencia);  // Llamada al constructor de la clase padre
        this.tiempo = tiempo;
    }

    // Método getter para obtener el tiempo
    public double getTiempo() {
        return tiempo;
    }

    // Método setter para establecer el tiempo
    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    
    @Override
    public void mostrarDatos() {  // Implementación del método abstracto
    System.out.println("Potencia: " + getPotencia() + ", Tiempo: " + getTiempo());
    }
		
}

