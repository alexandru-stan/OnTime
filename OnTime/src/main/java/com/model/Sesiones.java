package com.model;

public class Sesiones {
	int codsesion;
	String fecha;
	String dni;
	String horastrabajadas;
	public Sesiones(int codsesion, String fecha, String dni, String horastrabajadas) {
		super();
		this.codsesion = codsesion;
		this.fecha = fecha;
		this.dni = dni;
		this.horastrabajadas = horastrabajadas;
	}
	
	public  Sesiones(String dni,String horastrabajadas) {
		
		this.dni = dni;
		this.horastrabajadas=horastrabajadas;
	}
	
	
	public  Sesiones(int codsesion,String fecha,String horastrabajadas) {
		this.codsesion=codsesion;
		this.fecha=fecha;
		this.horastrabajadas=horastrabajadas;
	}
	
	
	public int getCodsesion() {
		return codsesion;
	}
	public void setCodsesion(int codsesion) {
		this.codsesion = codsesion;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getHorastrabajadas() {
		return horastrabajadas;
	}
	public void setHorastrabajadas(String horastrabajadas) {
		this.horastrabajadas = horastrabajadas;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
