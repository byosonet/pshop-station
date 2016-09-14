package com.pshop.station.service;

import java.util.List;

import com.pshop.station.persistence.pojo.Perfil;

/**
 * 
 * @author hustler
 *
 */
public interface PerfilService {
	Perfil getPerfil(int id);
	List<Perfil> getAll();
	void saveOrUpdate(Perfil perfil);
}
