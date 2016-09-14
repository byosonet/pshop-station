package com.pshop.station.persistence.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pshop.station.persistence.pojo.Compra;
import com.pshop.station.persistence.pojo.CompraId;
import com.pshop.station.persistence.utils.TransacctionMySQL;

public class CompraDaoImpl extends HibernateDaoSupport implements CompraDao {
	private final Logger log = Logger.getLogger(CompraDaoImpl.class);
    TransacctionMySQL mysql = new TransacctionMySQL();

	public Compra getCompra(CompraId compraId) {
		this.log.info("Buscando compra by id:: "+compraId.toString());
        return (Compra) this
                .getSession()
                .createQuery("FROM Compra c WHERE c.id = :compraId")
                .setParameter("compraId", compraId)
                .uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Compra> getComprasPorUsuario(int idUsuario) {
		this.log.info("Recuperando lista de compras por idUsuario: "+idUsuario);
		return (List<Compra>) this
				.getSession()
				.createQuery("FROM Compra c where c.id.idUsuario = :idUsuario ORDER BY fechaCompra DESC")
				.setParameter("idUsuario", idUsuario)
				
				.list();
	}

	@SuppressWarnings("unchecked")
	public List<Compra> getUlrimasComprasPorUsuarioParaMenuMensajes(int idUsuario, int total) {
		this.log.info("Recuperando lista de ultimas compras por idUsuario: "+idUsuario);
		this.log.info("Total a recuperar: "+total);
		return (List<Compra>) this
				.getSession()
				.createQuery("FROM Compra c where c.id.idUsuario = :idUsuario ORDER BY fechaCompra DESC")
				.setParameter("idUsuario", idUsuario)
				.setMaxResults(total)
				.list();
	}

	public void generarCompra(Compra compra) {
		 try {
            this.mysql.iniciarOperacion();
            this.mysql.getSesion().save(compra);
            this.mysql.getSesion().flush();
	        this.mysql.getTx().commit();
        } catch (HibernateException he) {
	            this.mysql.manejarException(he);
	            throw he;
        } finally {
	            this.mysql.getSesion().close();
        }
	}
	
}
