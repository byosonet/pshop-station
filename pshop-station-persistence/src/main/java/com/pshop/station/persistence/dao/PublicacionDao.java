package com.pshop.station.persistence.dao;

import java.util.List;

import com.pshop.station.persistence.pojo.Publicacion;

public interface PublicacionDao {
	Publicacion getPublicacion(int idPublicacion);
	List<Publicacion> getPublicaciones(int idColeccion);
	List<Publicacion> getAll();
	void saveOrUpdate(Publicacion publicacion);
}
