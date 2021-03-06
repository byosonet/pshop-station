package com.pshop.station.persistence.pojo;
// Generated 02-jun-2016 21:47:36 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * Fuente generated by hbm2java
 */
public class Fuente implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5691928170489158502L;
	private int id;
	private String nombreBiblioteca;
	private String paginaWeb;
	private String email;
	private String telefono;
	private int estatus;
	private String rfc;
	private Date fechaUmodif;
	private String autor;
	private int idUsuarioUmodif;
	private String usuario;

	public Fuente() {
	}

	public Fuente(int id, String nombreBiblioteca, int estatus, Date fechaUmodif, int idUsuarioUmodif, String autor) {
		this.id = id;
		this.nombreBiblioteca = nombreBiblioteca;
		this.estatus = estatus;
		this.fechaUmodif = fechaUmodif;
		this.idUsuarioUmodif = idUsuarioUmodif;
		this.autor = autor;
	}

	public Fuente(int id, String nombreBiblioteca, String paginaWeb, String email, String telefono, int estatus,
			String rfc, Date fechaUmodif, int idUsuarioUmodif, String autor) {
		this.id = id;
		this.nombreBiblioteca = nombreBiblioteca;
		this.paginaWeb = paginaWeb;
		this.email = email;
		this.telefono = telefono;
		this.estatus = estatus;
		this.rfc = rfc;
		this.fechaUmodif = fechaUmodif;
		this.idUsuarioUmodif = idUsuarioUmodif;
		this.autor = autor;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreBiblioteca() {
		return this.nombreBiblioteca;
	}

	public void setNombreBiblioteca(String nombreBiblioteca) {
		this.nombreBiblioteca = nombreBiblioteca;
	}

	public String getPaginaWeb() {
		return this.paginaWeb;
	}

	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getEstatus() {
		return this.estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	public String getRfc() {
		return this.rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public Date getFechaUmodif() {
		return this.fechaUmodif;
	}

	public void setFechaUmodif(Date fechaUmodif) {
		this.fechaUmodif = fechaUmodif;
	}

	public int getIdUsuarioUmodif() {
		return this.idUsuarioUmodif;
	}

	public void setIdUsuarioUmodif(int idUsuarioUmodif) {
		this.idUsuarioUmodif = idUsuarioUmodif;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Fuente [id=" + id + ", nombreBiblioteca=" + nombreBiblioteca + ", paginaWeb=" + paginaWeb + ", email="
				+ email + ", telefono=" + telefono + ", estatus=" + estatus + ", rfc=" + rfc + ", fechaUmodif="
				+ fechaUmodif + ", autor=" + autor + ", idUsuarioUmodif=" + idUsuarioUmodif + "]";
	}

}
