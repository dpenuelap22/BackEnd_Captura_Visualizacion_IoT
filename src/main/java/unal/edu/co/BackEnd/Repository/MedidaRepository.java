/*********************************************************************************************
Descripción: Interfaz de repositorio para operaciones CRUD en la tabla Medida
Autor: Diego Andres Peñuela Pardo
idGestion: -----------------------
@Copyright (c) 2023 Diego Andres Peñuela Pardo. Todos los derechos reservados. Última actualización: 25 de marzo de 2023.
********************************************************************************************/

package unal.edu.co.BackEnd.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import unal.edu.co.BackEnd.Model.Medida;

@Repository
public interface MedidaRepository extends JpaRepository<Medida, Long>{
// Métodos de acceso y manipulación de datos pueden ser definidos aquí si es necesario

}
