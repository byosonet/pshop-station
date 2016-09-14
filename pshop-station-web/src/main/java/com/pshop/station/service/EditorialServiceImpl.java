package com.pshop.station.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.pshop.station.persistence.dao.EditorialDao;
import com.pshop.station.persistence.pojo.Editorial;

/**
 * 
 * @author hustler
 *
 */
public class EditorialServiceImpl implements EditorialService {

	@Autowired
	private EditorialDao editorialDao;
	
	@Override
	@Transactional
	public Editorial getEditorial(int id) {
		return editorialDao.getEditorial(id);
	}

	@Override
	@Transactional
	public void saveOrUpdate(Editorial editorial) {
		editorialDao.saveOrUpdate(editorial);
	}
	
	@Override
	@Transactional
	public List<Editorial> getAll(){
		return editorialDao.getAll();
	}
}
