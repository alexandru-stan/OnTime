package com.model;

public class Usuarios {

	String dni;
	String nombre;
	String apellido;
	String nombre_usuario;
	String contraseña;
	int telefono;
	
	public Usuarios(String dni, String nombre, String apellido, String nombre_usuario, String contraseña,
			int telefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nombre_usuario = nombre_usuario;
		this.contraseña = contraseña;
		this.telefono = telefono;
	}
	
	public Usuarios(String dni,String nombre,String nombre_usuario,String contraseña) {
		this.dni = dni;
		this.nombre=nombre;
		this.nombre_usuario=nombre_usuario;
		this.contraseña = contraseña;
		
	}
	
	

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	
	
	
	
}
