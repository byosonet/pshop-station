package com.pshop.station.service;

import java.util.List;

import com.pshop.station.persistence.pojo.FormaPago;

/**
 * 
 * @author hustler
 *
 */
public interface FormaPagoService {
	FormaPago getFormaPago(int id);
	List<FormaPago> getAll();
	void saveOrUpdate(FormaPago formaPago);
}
