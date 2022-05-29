package com.model;

public class Faltas {

	int codfalta;
	String fecha;
	String dni;
	int falta_justificada;
	String motivo;
	int solicitada;//ESTE ATRIBUTO INDICA SI EL USUARIO HA SOLICITADO JUSTIFICAR LA FALTA EN CUESTI�N
	public Faltas(int codfalta, String fecha, String dni, int falta_justificada, String motivo,
			int solicitada) {
		super();
		this.codfalta = codfalta;
		this.fecha = fecha;
		this.dni = dni;
		this.falta_justificada = falta_justificada;
		this.motivo = motivo;
		this.solicitada = solicitada;
	}
	public int getCodfalta() {
		return codfalta;
	}
	public void setCodfalta(int codfalta) {
		this.codfalta = codfalta;
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
	public int getFalta_justificada() {
		return falta_justificada;
	}
	public void setFalta_justificada(int falta_justificada) {
		this.falta_justificada = falta_justificada;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public int getSolicitada() {
		return solicitada;
	}
	public void setSolicitada(int solicitada) {
		this.solicitada = solicitada;
	}
	
	
}
