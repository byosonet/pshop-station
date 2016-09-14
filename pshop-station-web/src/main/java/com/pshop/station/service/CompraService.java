package com.pshop.station.service;

import java.util.List;
import java.util.Map;

import com.pshop.station.persistence.pojo.Coleccion;
import com.pshop.station.persistence.pojo.Compra;
import com.pshop.station.persistence.pojo.CompraId;
import com.pshop.station.persistence.pojo.Publicacion;

public interface CompraService {
	Compra getCompra(CompraId compraId);
	Map<Coleccion, List<Publicacion>> getMenuColeccion(int idUsuario);
	List<Publicacion> ultimasCompras(int idUsuario);
	void crearCompra(Compra compra);
	List<Compra> obtenetComprasbyUsuario(int idUsuario);
}
