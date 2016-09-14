package com.pshop.station.service;

import java.util.List;

import com.pshop.station.persistence.pojo.Editorial;

/**
 * 
 * @author hustler
 *
 */
public interface EditorialService {
	Editorial getEditorial(int id);
	void saveOrUpdate(Editorial editorial);
	List<Editorial> getAll();
}
