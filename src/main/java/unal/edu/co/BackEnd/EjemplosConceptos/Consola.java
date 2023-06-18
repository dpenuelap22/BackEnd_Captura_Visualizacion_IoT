package unal.edu.co.BackEnd.EjemplosConceptos;

 

public class Consola {
	
	public static void main(String[] args) {
	
	/**	Código de ejemplo del objeto medida
	Medida medida = new Medida(100.5);  // Crear un objeto con una potencia inicial de 100.5
	System.out.println(medida.getPotencia());//Imprime "100.5"
	medida.setPotencia(120.7);  // Cambiar la potencia a 120.7
	System.out.println(medida.getPotencia());  // Imprime "120.7"*/	
	
	
	/**Codigo de ejemplo del objeto con herencia
	 MedidaPico medidaPico = new MedidaPico(120.5, 10.0);  // Crear un objeto con una potencia de 120.5 y tiempo de 10.0
     System.out.println("Potencia: " + medidaPico.getPotencia() + " W");  // Imprime "Potencia: 120.5 W"
     System.out.println("Tiempo: " + medidaPico.getTiempo() + " s");  // Imprime "Tiempo: 10.0 s"*/
     
		
	/**Codigo de ejemplo del objeto con Polimorfismo
     Medida medidaBase = new Medida(100.5);  // Un objeto de la clase Medida
     Medida medidaPico = new MedidaPico(120.7, 5);  // Un objeto de la clase MedidaPico

     // Ambos objetos pueden ser tratados como objetos de la clase Medida
     System.out.println("Potencia Base: " + medidaBase.getPotencia());
     System.out.println("Potencia Pico: " + medidaPico.getPotencia());*/
		
	MedidaPico medidaPico = new MedidaPico(120.7, 5);
	medidaPico.mostrarDatos();  // Muestra "Potencia: 120.7, Tiempo: 5"
     
  }
}


