package com.pshop.station.service;

import java.util.List;

import com.pshop.station.persistence.pojo.Coleccion;

public interface ColeccionService {
	List<Coleccion> getColeccionDao(boolean tipoOrden);
	List<Coleccion> getAll();
	void saveOrUpdate(Coleccion coleccion);
}
