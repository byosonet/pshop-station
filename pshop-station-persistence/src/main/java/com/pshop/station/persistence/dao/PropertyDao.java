package com.pshop.station.persistence.dao;

import com.pshop.station.persistence.pojo.Properties;

public interface PropertyDao {
	Properties getValueByKey(String key);
}
