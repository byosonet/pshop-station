package com.pshop.station.persistence.pojo;
// Generated 02-jun-2016 21:47:36 by Hibernate Tools 3.4.0.CR1

import java.util.Arrays;
import java.util.Date;

/**
 * Usuario generated by hbm2java
 */
public class Usuario implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6269529491327180701L;
	private int id;
	private String nombre;
	private String AMaterno;
	private String APaterno;
	private String sexo;
    private Date fechaAlta;
    private Date ultConexion;
    private String notificaciones;
    private String login;
    private String email;
    private String password;
    private Date fechaNacimiento;
    private String actividad;
    private byte[] foto;
	private int estatus;
	private Perfil perfil;
	private String telefono;

	public Usuario() {
	}

	public Usuario(int id, String nombre, String aMaterno, String aPaterno, String sexo, Date fechaAlta, Date ultConexion,
			String notificaciones, String login, String email, String password, Date fechaNacimiento, String actividad,
			byte[] foto, int estatus, Perfil perfil, String telefono) {
		this.id = id;
		this.nombre = nombre;
		AMaterno = aMaterno;
		APaterno = aPaterno;
		this.sexo = sexo;
		this.fechaAlta = fechaAlta;
		this.ultConexion = ultConexion;
		this.notificaciones = notificaciones;
		this.login = login;
		this.email = email;
		this.password = password;
		this.fechaNacimiento = fechaNacimiento;
		this.actividad = actividad;
		this.foto = foto;
		this.estatus = estatus;
		this.perfil = perfil;
		this.telefono = telefono;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAMaterno() {
		return AMaterno;
	}

	public void setAMaterno(String aMaterno) {
		AMaterno = aMaterno;
	}

	public String getAPaterno() {
		return APaterno;
	}

	public void setAPaterno(String aPaterno) {
		APaterno = aPaterno;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getUltConexion() {
		return ultConexion;
	}

	public void setUltConexion(Date ultConexion) {
		this.ultConexion = ultConexion;
	}

	public String getNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(String notificaciones) {
		this.notificaciones = notificaciones;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", AMaterno=" + AMaterno + ", APaterno=" + APaterno
				+ ", sexo=" + sexo + ", fechaAlta=" + fechaAlta + ", ultConexion=" + ultConexion + ", notificaciones="
				+ notificaciones + ", login=" + login + ", email=" + email + ", password=" + password
				+ ", fechaNacimiento=" + fechaNacimiento + ", actividad=" + actividad + ", foto="
				+ Arrays.toString(foto) + ", estatus=" + estatus + ", perfil=" + perfil + "]";
	}

}
