package com.pshop.station.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.pshop.station.persistence.dao.PropertyDao;
import com.pshop.station.persistence.pojo.Properties;

public class PropertyServiceImpl implements PropertyService{
	
	private final Logger log = Logger.getLogger(PropertyServiceImpl.class);
	
	@Autowired
	private PropertyDao propertyDao;

	@Override
	@Transactional
	public Properties getValueKey(String key) {
		 this.log.info(" -- Obteniendo valor de la propiedad::::");
	        Properties prop = this.propertyDao.getValueByKey(key);
	        if(prop!=null){
	        	return prop;
	        }else{
	        	return null;
	        }
	}

}
