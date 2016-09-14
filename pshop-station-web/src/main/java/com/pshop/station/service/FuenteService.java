package com.pshop.station.service;

import java.util.List;

import com.pshop.station.persistence.pojo.Fuente;

/**
 * 
 * @author hustler
 *
 */
public interface FuenteService {
	Fuente getFuente(int id);
	void saveOrUpdateFuente(Fuente fuente);
	List<Fuente> getAll();
}
