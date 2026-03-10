package com.mx.ApiRestCinepolis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ApiRestCinepolis.dao.PeliculasDao;
import com.mx.ApiRestCinepolis.model.Peliculas;

@Service
public class PelisSerImp implements PelisServ {
	
	
@Autowired
PeliculasDao peliculasDao;

@Transactional(readOnly=true)
	@Override
	public List<Peliculas> mostrar() {
		// TODO Auto-generated method stub
	List<Peliculas>RegistrodePelis=peliculasDao.findAll();
		return RegistrodePelis;
	}

	@Override
	public boolean guardar(Peliculas pelicula) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Peliculas buscar(Integer idPeli) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean edita(Peliculas pelicula) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Integer idPelicula) {
		// TODO Auto-generated method stub
		return false;
	}

}
