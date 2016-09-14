package com.pshop.station.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.pshop.station.persistence.dao.FormaPagoDao;
import com.pshop.station.persistence.pojo.FormaPago;

/**
 * 
 * @author hustler
 *
 */
public class FormaPagoServiceImpl implements FormaPagoService {

	private Logger logger = Logger.getLogger(FormaPagoServiceImpl.class);
	
	@Autowired
	private FormaPagoDao formaPagoDao;
	
	@Override
	@Transactional
	public FormaPago getFormaPago(int id) {
		logger.info("getformaPago; id: "+id);
		return formaPagoDao.getFormaPago(id);
	}

	@Override
	@Transactional
	public List<FormaPago> getAll() {
		logger.info("getFormaPagoList...");
		return formaPagoDao.getAll();
	}

	@Override
	@Transactional
	public void saveOrUpdate(FormaPago formaPago) {
		logger.info("saveOrUpdate");
		formaPagoDao.saveOrUpdate(formaPago);
	}

}
