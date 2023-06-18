/*********************************************************************************************
Descripción: Controlador que expone endpoints REST para interactuar con la entidad Medida
Autor: Diego Andres Peñuela Pardo
idGestion: -----------------------
@Copyright (c) 2023 Diego Andres Peñuela Pardo. Todos los derechos reservados. Última actualización: 25 de marzo de 2023.
********************************************************************************************/
package unal.edu.co.BackEnd.Controller;
//Importación de las bibliotecas necesarias para la creación del controlador
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unal.edu.co.BackEnd.Model.Medida;
import unal.edu.co.BackEnd.Repository.MedidaRepository;

@RestController
@RequestMapping("/api/medida")
@CrossOrigin({"*"})
public class MedidaController {
	// Inyección de dependencia del repositorio MedidaRepository
	 @Autowired(required=true)
	  private MedidaRepository medidaRepository;
	  @GetMapping("/Datos")
	// Endpoint para obtener todas las medidas
	    public List<Medida> getAllMedidas() {
	        return medidaRepository.findAll();
	    }
	}


