package unal.edu.co.BackEnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({
    "unal.edu.co.BackEnd", 
    "unal.edu.co.BackEnd.ApiGoogle", 
    "unal.edu.co.BackEnd.Controller", 
    "unal.edu.co.BackEnd.DataProcessing", 
    "unal.edu.co.BackEnd.EjemplosConceptos",
    "unal.edu.co.BackEnd.Model", 
    "unal.edu.co.BackEnd.Repository"
})
public class BackEndCapturaVisualizacionIoTApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackEndCapturaVisualizacionIoTApplication.class, args);
		 
		
	}
	

}
