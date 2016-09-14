package com.pshop.station.persistence.dao;

import java.util.List;

import com.pshop.station.persistence.pojo.Fuente;

/**
 * 
 * @author hustler
 *
 */
public interface FuenteDao {
	Fuente getFuente(int id);
	List<Fuente> getAll();
	void saveOrUpdateFuente(Fuente fuente);
}
