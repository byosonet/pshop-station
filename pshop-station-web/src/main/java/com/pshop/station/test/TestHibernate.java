package com.pshop.station.test;

import com.pshop.station.persistence.dao.CompraDao;
import com.pshop.station.persistence.dao.CompraDaoImpl;
import com.pshop.station.persistence.dao.PublicacionDao;
import com.pshop.station.persistence.dao.PublicacionDaoImpl;
import com.pshop.station.persistence.dao.UsuarioDaoImpl;
import com.pshop.station.persistence.pojo.Compra;
import com.pshop.station.persistence.pojo.CompraId;
import com.pshop.station.persistence.pojo.Publicacion;
import com.pshop.station.persistence.pojo.Usuario;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
 
public class TestHibernate {
 
    public static void main(String[] args) throws Exception
    {
    	System.out.println("--Testxx::");
        ApplicationContext context = new FileSystemXmlApplicationContext(""
        		+ "//Users/ulysses/proyectos/refactorBS/refactorBookStore/bstore-web/src/main/java/com/bstore/services/test/applicationContextHibernate.xml");
        
        UsuarioDaoImpl usuario = (UsuarioDaoImpl) context.getBean("usuarioDao");
        System.out.print(" -- Load Usario::");
        
        System.out.println(" -- User: "+usuario.byId(1).toString());
        
        
        CompraDaoImpl compra = (CompraDaoImpl) context.getBean("compraDao");
        System.out.println(" -- Buscando compra:::");
        
        CompraId id = new CompraId();
        id.setIdPublicacion(5);
        id.setIdUsuario(3);
        
        Compra c = compra.getCompra(id);
        
        System.out.println(" -- Compra id: "+c.getId());
        System.out.println(" -- Compra id: "+c.getFormaPago().getFormaPago());
        System.out.println(" -- Compra: "+c.toString());
        
        
        PublicacionDao publicacion = (PublicacionDaoImpl) context.getBean("publicacionDao");
        System.out.println(" -- Buscando Publicacion:::");
        Publicacion p = publicacion.getPublicacion(1);
        
        List<Publicacion> lista = publicacion.getPublicaciones(2);
        System.out.println(" Lista publicaciones: "+lista.toString());
        System.out.println("autor: "+lista.get(0).getFuente().getAutor());
        
        System.out.println(" -- Publicacion: "+p.getNombre());
        System.out.println(" -- Fuente: "+p.getFuente().getNombreBiblioteca());
        System.out.println(" -- Editorial: "+p.getEditorial().getNombre());
        System.out.println(" -- Coleccion: "+p.getColeccion().getNombre());
        System.out.println(" -- Usuario creo: "+p.getUsuario().getNombre());
    }
}
