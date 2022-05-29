package com.ies.baroja;

import com.bbdd.ConexionBBDD;

import com.model.Administradores;
import com.model.Faltas;
import com.model.Sesiones;
import com.model.Usuarios;

import java.io.PrintStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class Controller
{
	

	
	//DOS VARIABLES QUE UTILIZO PARA TRAERME TODOS LOS USUARIOS DE LA BASE DE DATOS
  private static String sConsultaAdministradores = "SELECT * FROM administradores;";
  private static String sConsultaUsuarios = "SELECT * FROM usuarios;";
  
  
  public Controller() {}
  
  
  //M�TODO PARA ACCEDER A LA TABLA ADMINISTRADORES DE LA BASE DE DATOS Y TRAER CREDENCIALES DE LOGIN
  public static Administradores getLoginAdministradores(String consulta) throws SQLException {
   

//GUARDO LA CONSULTA EN UNA VARIABLE
	  String Vconsulta = consulta;
    
	//CREO UN OBJETO DE LA CLASE CONEXIONBBDD PARA ACCEDER A LA BASE DE DATOS
    ConexionBBDD miConexion = new ConexionBBDD();
    
      miConexion.conectar();
      

      //GUARDO DENTRO DE UNA VARIABLE DE TIPO RESULT SET EL RESULTADO DE LA CONSULTA
      ResultSet rsResultado = miConexion.ejecutarConsulta(Vconsulta);
      
     //CREO UN OBJETO DE TIPO ADMINISTRADOR CON 3 ATRIBUTOS (NOMBRE,NOMBRE_USUARIO, Y CONTRASE�A)
    Administradores administrador = new Administradores(null,null,null);

    //SI LA CONSULTA DEVUELVE RESULTADOS RELLENO LOS ATRIBUTOS DEL OBJETO ADMINISTRADOR CON LOS DATOS SACADOS DE LA BBDD
       if (rsResultado.next()) {
    	  
    	   System.out.println("CUENTA ENCONTRADA");
   
    	   administrador.setNombre(rsResultado.getString("nombre"));
    	   administrador.setNombre_usuario( rsResultado.getString("nombre_usuario"));
    	   administrador.setContraseña( rsResultado.getString("contraseña"));
    	   
    	   
       
       } else{
    	   
    	   System.out.println("LA CONSULTA NO DEVUELVE RESULTADOS");
    	   
       }
       
       
       //UTILIZO EL OBJETO PARA DESCONECTARME DE LA BASE DE DATOS Y HAGO UN RETURN PARA DEVOLVER EL OBJETO ADMINISTRADOR
       miConexion.desconectar();
       return administrador;

 
 
  }
  
  
  //ES EL MISMO M�TODO QUE EL ANTERIOR PERO ESTA VEZ ACCEDE A LA TABLA USUARIOS
  
  public static Usuarios getLoginUsuarios(String consulta) throws SQLException {
	  String Vconsulta = consulta;
	    
	    ConexionBBDD miConexion = new ConexionBBDD();
	    
	      miConexion.conectar();
	      


	      ResultSet rsResultado = miConexion.ejecutarConsulta(Vconsulta);
	      
	    Usuarios usuario = new Usuarios(null,null,null,null,null,0);

	       if (rsResultado.next()) {
	    	  

	    	   usuario.setDni(rsResultado.getString("dni"));
	    	   usuario.setNombre(rsResultado.getString("nombre"));
	    	   usuario.setApellido(rsResultado.getString("apellido"));
	    	   usuario.setNombre_usuario( rsResultado.getString("nombre_usuario"));
	    	   usuario.setContraseña( rsResultado.getString("contraseña"));
	    	   usuario.setTelefono(Integer.parseInt(rsResultado.getString("telefono")));
	    	   
	    	   System.out.println("EL OBJETO USUARIO TIENE DNI+"+usuario.getDni());
	    	   System.out.println("EL OBJETO USUARIO TIENE NOMBRE+"+usuario.getNombre());
	    	   
	       
	       }
	       
	       
	       
	       miConexion.desconectar();
	       return usuario;
	  }
  
  //M�TODO PARA CREAR CUENTA
  public static boolean crearCuentaUsuario(Usuarios usuario) throws SQLException {
	//VARIABLE DE TIPO BOOLEAN PARA PODER RASTREAR POSIBLES ERRORES
	  boolean resultado = true;
	  //ACCEDO A LA BBDD
	  ConexionBBDD miConexion = new ConexionBBDD();
	  
	  miConexion.conectar();
	  //INVOCO EL M�TODO INSERTAR USUARIO Y LE PASO COMO PAR�METRO EL USUARIO CON LOS ATRIBUTOS QUE DEBE TENER
	  int iresultado = miConexion.insertarUsuario(usuario);
	  
	  System.out.println("RESULTADO DE INSERTAR EL USUARIO "+iresultado);
	  
	  miConexion.desconectar();
	  
	  
	  return resultado;
	  
	  
	  
	  
  }
  
  // LO MISMO QUE EL M�TODO ANTERIOR PERO ESTA VEZ CON LA TABLA ADMINISTRADORES
  public static boolean crearCuentaAdministrador(Administradores administrador) throws SQLException {
	  boolean resultado = true;
	  
	  ConexionBBDD miConexion = new ConexionBBDD();
	  
	  miConexion.conectar();
	  int iresultado = miConexion.insertarAdministrador(administrador);
	  
	  System.out.println("RESULTADO DE INSERTAR EL USUARIO "+iresultado);
	  
	  miConexion.desconectar();
	  
	  
	  return resultado;
  }
  
  
  public static boolean crearSesionTrabajo(Sesiones sesionTrabajo) throws SQLException {
	  boolean resultado = true;
	  
	  ConexionBBDD miConexion = new ConexionBBDD();
	  
	  miConexion.conectar();
	  int iresultado = miConexion.insertarSesion(sesionTrabajo);
	  
	  System.out.println("RESULTADO DE INSERTAR EL USUARIO "+iresultado);
	  
	  miConexion.desconectar();
	  
	  
	  return resultado;
  }
  
  
  
  //M�TODO QUE DEVUELVE UNA LISTA CON TODOS LOS REGISTROS DE LA TABLA ADMINISTRADORES
  public static LinkedList<Administradores> getAllAdministradores() throws SQLException {
	  //LISTA QUE GUARDAR� OBJETOS DE TIPO ADMINISTRADORES
	  LinkedList<Administradores> lista = new LinkedList<Administradores>();
	  
	  ConexionBBDD miConexion = new ConexionBBDD();
	  
	  miConexion.conectar();
	  
	  
	  
	  ResultSet rsResultado = miConexion.ejecutarConsulta(sConsultaAdministradores);
	  
	  if (rsResultado != null) {
		  
		  while(rsResultado.next()) {
			  
			  
			 
				  
				  
				  Administradores administrador = new Administradores(rsResultado.getString("dni"),
						  rsResultado.getString("nombre"),
						  rsResultado.getString("apellido"),
						  rsResultado.getString("nombre_usuario"),
						  rsResultado.getString("contraseña"),
						  rsResultado.getInt("telefono"));
				  
				  
				  lista.add(administrador);
				  
			  }
			  
			  
			  
			  
		  } else {
			  
			  System.out.println("LA CONSULTA NO DEVUELVE RESULTADOS");
		  }
		  
	  System.out.println("N�MERO DE REGISTROS="+lista.size());
	  
	  
	  
	  return lista;
	  
	  
  }
  
public static LinkedList<Usuarios> getAllUsuarios() throws SQLException {
	  
	  LinkedList<Usuarios> lista = new LinkedList<Usuarios>();
	  
	  ConexionBBDD miConexion = new ConexionBBDD();
	  
	  miConexion.conectar();
	  
	  
	  
	  ResultSet rsResultado = miConexion.ejecutarConsulta(sConsultaUsuarios);
	  
	  if (rsResultado != null) {
		  
		  while(rsResultado.next()) {
			  
			  
			 
				  
				  
			  Usuarios usuario = new Usuarios(rsResultado.getString("dni"),
						  rsResultado.getString("nombre"),
						  rsResultado.getString("apellido"),
						  rsResultado.getString("nombre_usuario"),
						  rsResultado.getString("contraseña"),
						  rsResultado.getInt("telefono"));
				  
				  
				  lista.add(usuario);
				  
			  }
			  
			  
			  
			  
		  } else {
			  
			  System.out.println("LA CONSULTA NO DEVUELVE RESULTADOS");
		  }
		  
	  System.out.println("N�MERO DE REGISTROS="+lista.size());
	  
	  
	  
	  return lista;
	  
	  
  }

	public static int borrarCuenta(String nombre_usuario) throws SQLException {
		
		String usu=nombre_usuario;
		
		
		int res=0;
		
		
		System.out.println("EL USUARIO QUE SERÁ BORRADO ES"+usu);
		
		ConexionBBDD miConexion = new ConexionBBDD();
		
	
	
		miConexion.conectar();
		
		
		
		 ResultSet admins = miConexion.ejecutarConsulta("SELECT nombre_usuario FROM administradores WHERE nombre_usuario='"+usu+"';");
		 ResultSet users = miConexion.ejecutarConsulta("SELECT nombre_usuario FROM usuarios WHERE nombre_usuario='"+usu+"';");
		 
		 
		 //IMPORTANTE:
		 //UN RESULT SET NUNCA DA COMO RESULTADO NULL POR MUCHO QUE LA SELECT NO D� NING�N RESULTADO, POR LO TANTO SIEMPRE QUE TRABAJEMOS CON RESULTSET HAY QUE UTILIZAR EL M�TODO NEXT();
		 
		if (admins.next()) {
			
			System.out.println("USUARIO ENCONTRADO EN LA TABLA ADMINISTRADORES");
			
			res = ConexionBBDD.borrarAdministrador(usu);
			
			System.out.println("RESULTADO DE LA OPERACI�N:"+res);
			
			
			
		} else if (users.next()) {
			
			System.out.println("USUARIO ENCONTRADO EN LA TABLA USUARIOS");
			
			res = ConexionBBDD.borrarUsuario(usu);
			
			System.out.println("RESULTADO DE LA OPERACI�N:"+res);
			
		} else {
			
			System.out.println("USUARIO NO ENCONTRADO");
			System.out.println("RESULTADO DE LA OPERACIÓN:"+res);
			
			
		}
		 
		 
		
		 
		 
		 
		 
		 
		 
		 
		 
		 miConexion.desconectar();
		 
		 
		 
		 
		 return res;	 
	
	}


	public static LinkedList<Sesiones> getHistorial(String dni) throws SQLException {
		  //LISTA QUE GUARDAR� OBJETOS DE TIPO ADMINISTRADORES
		String dni_usuario=dni;
		  LinkedList<Sesiones> lista = new LinkedList<Sesiones>();
		  
		  ConexionBBDD miConexion = new ConexionBBDD();
		  
		  miConexion.conectar();
		  
		  
		  
		  ResultSet rsResultado = miConexion.ejecutarConsulta("SELECT codsesion,fecha,horastrabajadas FROM sesiones WHERE dni='"+dni_usuario+"';");
		  
		  if (rsResultado != null) {
			  
			  while(rsResultado.next()) {
				  
				  
				 
					  
					  
					  Sesiones sesionTrabajo= new Sesiones(Integer.parseInt(rsResultado.getString("codsesion")),
							  rsResultado.getString("fecha"),
							  rsResultado.getString("horastrabajadas"));
					  
					  
					  lista.add(sesionTrabajo);
					  
				  }
				  
				  
				  
				  
			  } else {
				  
				  System.out.println("LA CONSULTA NO DEVUELVE RESULTADOS");
			  }
			  
		  System.out.println("N�MERO DE REGISTROS="+lista.size());
		  
		  
		  
		  return lista;
		  
		  
	  }
  
	public static LinkedList<Faltas> getFaltas(String dni) throws SQLException {
		  //LISTA QUE GUARDAR� OBJETOS DE TIPO ADMINISTRADORES
		String dniusu = dni;
		  LinkedList<Faltas> lista = new LinkedList<Faltas>();
		  
		  ConexionBBDD miConexion = new ConexionBBDD();
		  
		  miConexion.conectar();
		  
		  
		  
		  ResultSet rsResultado = miConexion.ejecutarConsulta("SELECT * FROM faltas WHERE dni='"+dniusu+"';");
		  
		  if (rsResultado != null) {
			  
			  while(rsResultado.next()) {
				  
				  
				 
					  
					  
					Faltas falta = new Faltas(Integer.parseInt(rsResultado.getString("codfalta")),
							rsResultado.getString("fecha"),
							null,
							Integer.parseInt(rsResultado.getString("falta_justificada")),
							rsResultado.getString("motivo"),
							Integer.parseInt(rsResultado.getString("solicitada")));
					  
					  
					  lista.add(falta);
					  
				  }
				  
				  
				  
				  
			  } else {
				  
				  System.out.println("LA CONSULTA NO DEVUELVE RESULTADOS");
			  }
			  
		  System.out.println("N�MERO DE REGISTROS="+lista.size());
		  
		  
		  
		  return lista;
		  
		  
	  }
  
	
	
	
}
