package com.mx.ApiRestCinepolis.service;

import java.util.List;

import com.mx.ApiRestCinepolis.model.Peliculas;

public interface PelisServ {

	public List<Peliculas> mostrar();

	public boolean guardar(Peliculas pelicula);

	public Peliculas buscar(Integer idPeli);

	public boolean editar(Peliculas pelicula);

	public boolean eliminar(Integer idPelicula);
}
