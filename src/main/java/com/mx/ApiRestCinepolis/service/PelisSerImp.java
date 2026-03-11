package com.mx.ApiRestCinepolis.service;

import java.util.List;

/*Guardar---Validar que el nombre de la pelicula no se repita
Buscar por idPelicula
Editar---Validar que el idPelicula exista
Eliminar---Validar que el idPelicula exista*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ApiRestCinepolis.dao.PeliculasDao;
import com.mx.ApiRestCinepolis.model.Peliculas;

@Service
public class PelisSerImp implements PelisServ {

	@Autowired
	PeliculasDao peliculasDao;

	@Transactional(readOnly = true)
	@Override
	public List<Peliculas> mostrar() {
		// TODO Auto-generated method stub
		List<Peliculas> RegistrodePelis = peliculasDao.findAll();
		return RegistrodePelis;
	}

	@Override
	public boolean guardar(Peliculas pelicula) {

		boolean bandera = false;

		for (Peliculas p : mostrar()) {

			if (p.getNombre().equalsIgnoreCase(pelicula.getNombre())) {
				bandera = true;
				break;
			}
		}

		if (!bandera) {
			peliculasDao.save(pelicula);
			return true;
		}

		return false;
	}

	@Override

	public Peliculas buscar(Integer idPeli) {
		// TODO Auto-generated method stub
		Peliculas peli = peliculasDao.findById(idPeli).orElse(null);
		return peli;

	}

	@Transactional(readOnly = true)
	@Override

	public boolean editar(Peliculas pelicula) {
		// TODO Auto-generated method stub
		if (peliculasDao.existsById(pelicula.getIdPeli())) {
			peliculasDao.save(pelicula);
			return true;
		} else
			return false;
	}

	@Override

	public boolean eliminar(Integer idPelicula) {
		// TODO Auto-generated method stub
		if (peliculasDao.existsById(idPelicula)) {
			peliculasDao.deleteById(idPelicula);
			return true;
		} else

			return false;
	}

}
