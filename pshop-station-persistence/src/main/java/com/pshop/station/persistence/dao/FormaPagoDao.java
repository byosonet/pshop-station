package com.pshop.station.persistence.dao;

import java.util.List;

import com.pshop.station.persistence.pojo.FormaPago;

/**
 * 
 * @author hustler
 *
 */
public interface FormaPagoDao {
	FormaPago getFormaPago(int id);
	List<FormaPago> getAll();
	void saveOrUpdate(FormaPago formaPago);
}