package com.pshop.station.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.pshop.station.persistence.dao.ColeccionDao;
import com.pshop.station.persistence.pojo.Coleccion;

public class ColeccionServiceImpl implements ColeccionService{
	
	@Autowired
	private ColeccionDao coleccionDao;

	@Override
	@Transactional
	public List<Coleccion> getColeccionDao(boolean tipoOrden) {
		return this.coleccionDao.getColecion(tipoOrden);
	}

	@Override
	@Transactional
	public List<Coleccion> getAll() {
		return coleccionDao.getAll();
	}

	@Override
	public void saveOrUpdate(Coleccion coleccion) {
		try{
			coleccionDao.saveOrUpdate(coleccion);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
