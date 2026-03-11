package com.mx.ApiRestCinepolis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ApiRestCinepolis.model.Peliculas;
import com.mx.ApiRestCinepolis.service.PelisSerImp;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "api/cinepolis")
@CrossOrigin
public class PeliculasWebService {

	@Autowired
	PelisSerImp pelisSerImp;

	// http://localhost:9000/api/cinepolis/mostrar
	@GetMapping(path = "mostrar")
	public List<Peliculas> mostrarPeiculas() {
		return pelisSerImp.mostrar();
	}

	// http://localhost:9000/api/cinepolis/mostrar
	@PostMapping(path = "guardar")
	public ResponseEntity<?> guardar(@RequestBody Peliculas peliculas) {
		try {
			boolean response = pelisSerImp.guardar(peliculas);
			if (!response)
				return new ResponseEntity<String>("No se guardó, ya existe ese nombre de película", HttpStatus.OK);
			else
				return new ResponseEntity<Peliculas>(peliculas, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Error al guardar " + e.getMessage(), HttpStatus.OK);
		}
	}

	// http://localhost:9000/api/cinepolis/buscar
	@PostMapping(path = "buscar")
	public ResponseEntity<?> buscar(@RequestBody Peliculas peliculas) {
		Peliculas encunPeli = pelisSerImp.buscar(peliculas.getIdPeli());
		if (encunPeli == null)
			return new ResponseEntity<String>("No existe este registro", HttpStatus.OK);
		else
			return new ResponseEntity<Peliculas>(encunPeli, HttpStatus.OK);

	}

	// http://localhost:9000/api/cinepolis/editar
	@PutMapping(path = "editar")
	public ResponseEntity<?> editar(@RequestBody Peliculas peliculas) {
		try {
			boolean response = pelisSerImp.editar(peliculas);

			if (response == true)
				return new ResponseEntity<Peliculas>(peliculas, HttpStatus.OK);
			else
				return new ResponseEntity<String>("No se pudo editar,no existe el registro", HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>("Error al editar " + e.getMessage(), HttpStatus.OK);
		}
	}

	// http://localhost:9000/api/cinepolis/eliminar
	@DeleteMapping(path = "eliminar")
	public ResponseEntity<?> eliminar(@RequestBody Peliculas peliculas) {

		try {

			boolean response = pelisSerImp.eliminar(peliculas.getIdPeli());

			if (response)
				return new ResponseEntity<String>("Registro eliminado correctamente", HttpStatus.OK);
			else
				return new ResponseEntity<String>("No existe el registro", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<String>("Error al eliminar " + e.getMessage(), HttpStatus.OK);
		}

	}
}
