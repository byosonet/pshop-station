package com.pshop.station.persistence.dao;

import java.util.List;

import com.pshop.station.persistence.pojo.Editorial;

/**
 * 
 * @author hustler
 *
 */
public interface EditorialDao {
	Editorial getEditorial(int id);
	void saveOrUpdate(Editorial editorial);
	List<Editorial> getAll();
}
