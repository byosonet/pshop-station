package com.pshop.station.service;

import java.math.BigDecimal;
import java.util.List;

import com.pshop.station.persistence.pojo.Publicacion;

public interface PublicacionService {
	List<Publicacion> getPublicacionesByColeccionID(int idColeccion, int idUsuario);
	Publicacion getPublicacion(int id);
	List<Publicacion> getAll();
	BigDecimal precioRealPublicacion(int idPublicacion);
	void saveOrUpdate(Publicacion publicacion);
}
