package com.pshop.station.persistence.dao;

import java.util.List;

import com.pshop.station.persistence.pojo.Compra;
import com.pshop.station.persistence.pojo.CompraId;

public interface CompraDao {
	Compra getCompra(CompraId compraId);
	List<Compra> getComprasPorUsuario(int idUsuario);
	List<Compra> getUlrimasComprasPorUsuarioParaMenuMensajes(int idUsuario, int total);
	void generarCompra(Compra compra);
}
