package com.pshop.station.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.pshop.station.persistence.dao.CompraDao;
import com.pshop.station.persistence.dao.PropertyDao;
import com.pshop.station.persistence.dao.PublicacionDao;
import com.pshop.station.persistence.pojo.Compra;
import com.pshop.station.persistence.pojo.Properties;
import com.pshop.station.persistence.pojo.Publicacion;

public class PublicacionServiceImpl implements PublicacionService{
	private final Logger log = Logger.getLogger(PublicacionServiceImpl.class);
	
	private final String VALUE_PERCENTAGE = "com.conekta.porcentaje";
	private final String VALUE_AMOUNT = "com.conekta.cantidad";
	private final String VALUE_TAXE = "com.conekta.iva";
	private final String VALUE_ROUND = "com.conekta.factor.redondeo";
	private final int VALUE_100 = 100;;
	private final int REDONDEO_DECIMALES = 3;
	
	
	
	
	@Autowired
	private PublicacionDao publicacionDao;
	
	@Autowired 
	private CompraDao compraDao;
	
	@Autowired
	private PropertyDao propertyDao;

	@Override
	@Transactional(readOnly=true)
	public List<Publicacion> getPublicacionesByColeccionID(int idColeccion, int idUsuario) {
		
		List<Publicacion> lista = new ArrayList<Publicacion>();
		List<Integer> idPublicacionCompra = new ArrayList<Integer>();
		List<Compra> compras = this.compraDao.getComprasPorUsuario(idUsuario);
		if(compras!=null){
			if(compras.size()>0){
				for(Compra c: compras){
					idPublicacionCompra.add(c.getId().getIdPublicacion());
				}
			}
		}
		lista = this.publicacionDao.getPublicaciones(idColeccion);
		if(idPublicacionCompra.size()>0){
			for(Publicacion pub: lista){
				pub.setPrecio(this.calculatePriceWithComissionConekta(pub.getPrecio()));
				idCompra: for(int id: idPublicacionCompra){
					if(pub.getId() == id){
						pub.setComprada(true);
						break idCompra;
					}
				}
			}
		}else{
			for(Publicacion pub: lista){
				pub.setPrecio(this.calculatePriceWithComissionConekta(pub.getPrecio()));
			}
		}
		log.info("Buscando publicaciones por idColeccion: "+idColeccion);
		return lista;
	}

	@Override
	@Transactional(readOnly=true)
	public Publicacion getPublicacion(int id) {
		Publicacion pub = this.publicacionDao.getPublicacion(id);
		if(pub!=null){
			pub.setPrecio(this.calculatePriceWithComissionConekta(pub.getPrecio()));
		}
		return pub;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Publicacion> getAll() {
		log.info("getAll");
		List<Publicacion> lista = publicacionDao.getAll();
		if(lista!=null && lista.size()>0){
			for(Publicacion pub: lista){
				pub.setPrecio(this.calculatePriceWithComissionConekta(pub.getPrecio()));
			}
		}
		return lista;
	}
	
	@Override
	@Transactional
	public BigDecimal precioRealPublicacion(int idPublicacion) {
		Publicacion pub = this.publicacionDao.getPublicacion(idPublicacion);
		log.info("Retornando precio original de la publicacion: "+pub.getPrecio());
		return pub.getPrecio();
	}

	private BigDecimal calculatePriceWithComissionConekta(BigDecimal price){
		Properties valuePorcentaje = this.propertyDao.getValueByKey(VALUE_PERCENTAGE);
		Properties valueCantidad = this.propertyDao.getValueByKey(VALUE_AMOUNT);
		Properties valueIva = this.propertyDao.getValueByKey(VALUE_TAXE);
		Properties valueRedondeo = this.propertyDao.getValueByKey(VALUE_ROUND);
		if(valuePorcentaje!=null && valueCantidad!=null && valueIva!=null && valueRedondeo!=null){
			this.log.info("Price recibido para calcular:::"+price);
			BigDecimal nPrice = BigDecimal.ZERO;
			BigDecimal fporcentaje = new BigDecimal(this.propertyDao.getValueByKey(VALUE_PERCENTAGE).getValue());
			fporcentaje = fporcentaje.divide(new BigDecimal(VALUE_100),REDONDEO_DECIMALES,BigDecimal.ROUND_HALF_UP);
			BigDecimal fcantidad = new BigDecimal(this.propertyDao.getValueByKey(VALUE_AMOUNT).getValue());
			BigDecimal fiva = new BigDecimal(this.propertyDao.getValueByKey(VALUE_TAXE).getValue());
			BigDecimal fredondeo = new BigDecimal(this.propertyDao.getValueByKey(VALUE_ROUND).getValue());
			fiva = fiva.divide(new BigDecimal(VALUE_100),REDONDEO_DECIMALES,BigDecimal.ROUND_HALF_UP);
			this.log.info("Factor porcentaje para conekta es de: "+fporcentaje);
			this.log.info("Factor cantidad para conekta es de: "+fcantidad);
			this.log.info("Factor iva para conekta es de: "+fiva);
			this.log.info("Ejecutando operaciones...");
			nPrice = price.multiply(fporcentaje).add(fcantidad);
			this.log.info("Primera operacion: "+nPrice);
			nPrice = nPrice.add(nPrice.multiply(fiva));
			this.log.info("Segunda operacion: "+nPrice);
			nPrice = nPrice.add(price).setScale(2, BigDecimal.ROUND_HALF_UP);
			this.log.info("Tercera operacion precio de Conekta: "+nPrice);
			nPrice = nPrice.add(fredondeo);
			this.log.info("Operacion Final precio de Conekta + factor de Redondeo::: "+nPrice);
			return nPrice;
		}else{
			this.log.info("No se aplica ninguna comision las propiedades no has sido definidas en sistemas:::");
			return price;
		}
	}

	@Override
	public void saveOrUpdate(Publicacion publicacion) {
		log.info("saveOrUpdate publicacion: "+publicacion.toString());
		publicacionDao.saveOrUpdate(publicacion);
	}
	
}
