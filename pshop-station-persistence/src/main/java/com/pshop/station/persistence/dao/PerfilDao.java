package com.pshop.station.persistence.dao;

import java.util.List;

import com.pshop.station.persistence.pojo.Perfil;

/**
 * 
 * @author hustler
 *
 */
public interface PerfilDao {
	Perfil getPerfil(int id);
	List<Perfil> getAll();
}
