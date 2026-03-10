package com.mx.ApiRestCinepolis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ApiRestCinepolis.model.Peliculas;
import com.mx.ApiRestCinepolis.service.PelisSerImp;

@RestController
@RequestMapping(path = "api/cinepolis")
@CrossOrigin
public class PeliculasWebService {

	@Autowired
	PelisSerImp pelisSerImp;

	// http://localhost:9000/api/cinepolis/mostrar

	@GetMapping("mostrar")
	public List<Peliculas> mostrarPeiculas() {
		return pelisSerImp.mostrar();
	}

}
