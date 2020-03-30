package com.generationc20.redtaqueriaweb.model;

import java.util.Date;

public class Taqueria {
	private int id;
	private String nombre;
	private int popularidad;
	private int nivelLimpieza;
	private String ubicacion;
	private int olor;
	private Date fechaCreacion;
	private String usuario;
	private String vPass;
	private String pass;
	
	public Taqueria() {}
	public Taqueria(int id, String nombre, int popularidad,int nivelLimpieza,String ubicacion, int olor,Date fechaCreacion, String usuario, String vPass,String pass) {
		this.id=id;
		this.nombre=nombre;
		this.popularidad=popularidad;
		this.nivelLimpieza=nivelLimpieza;
		this.ubicacion=ubicacion;
		this.olor=olor;
		this.fechaCreacion=fechaCreacion;
		this.usuario=usuario;
		this.vPass=vPass;
		this.pass=pass;
		
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getvPass() {
		return vPass;
	}
	public void setvPass(String vPass) {
		this.vPass = vPass;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
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
	public int getPopularidad() {
		return popularidad;
	}
	public void setPopularidad(int popularidad) {
		this.popularidad = popularidad;
	}
	public int getNivelLimpieza() {
		return nivelLimpieza;
	}
	public void setNivelLimpieza(int nivelLimpieza) {
		this.nivelLimpieza = nivelLimpieza;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public int getOlor() {
		return olor;
	}
	public void setOlor(int olor) {
		this.olor = olor;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	

}
