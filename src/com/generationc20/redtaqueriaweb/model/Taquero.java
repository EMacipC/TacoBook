package com.generationc20.redtaqueriaweb.model;

import javax.xml.crypto.Data;

public class Taquero {
	private int id;
	private int idTaqueria;
	private String nombre;
	private int experiencia;
	private int limpieza;
	private int velocidad;
	private int calificacion;
	private String frase;
	private Data fecha;
	private String rLimpieza;
	
	public Taquero() {}
	
	public Taquero(int id,int idTaqueria, String nombre, int experiencia , int limpieza, int velocidad ,int calificacion, String frase,Data fecha,String rLimpieza) {
		this.id=id;
		this.idTaqueria=idTaqueria;
		this.nombre= nombre;
		this.experiencia=experiencia;
		this.limpieza=limpieza;
		this.velocidad=velocidad;
		this.calificacion=calificacion;
		this.frase=frase;
		this.fecha=fecha;
		this.rLimpieza=rLimpieza;
	}

	public String getrLimpieza() {
		return rLimpieza;
	}

	public void setrLimpieza(String rLimpieza) {
		this.rLimpieza = rLimpieza;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdTaqueria() {
		return idTaqueria;
	}

	public void setIdTaqueria(int idTaqueria) {
		this.idTaqueria = idTaqueria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public int getLimpieza() {
		return limpieza;
	}

	public void setLimpieza(int limpieza) {
		this.limpieza = limpieza;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public String getFrase() {
		return frase;
	}

	public void setFrase(String frase) {
		this.frase = frase;
	}

	public Data getFecha() {
		return fecha;
	}

	public void setFecha(Data fecha) {
		this.fecha = fecha;
	}
	

}
