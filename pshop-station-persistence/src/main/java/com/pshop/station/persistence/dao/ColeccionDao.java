package com.pshop.station.persistence.dao;

import java.util.List;

import com.pshop.station.persistence.pojo.Coleccion;

public interface ColeccionDao {
	List<Coleccion> getColecion(boolean tipoOrden);
	List<Coleccion> getAll();
	void saveOrUpdate(Coleccion coleccion);
}
