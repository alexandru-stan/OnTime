package com.bbdd;

import com.model.Administradores;
import com.model.Sesiones;
import com.model.Usuarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionBBDD
{
  static Connection conexion;
  
  
  int port = 3306;
  String host = "localhost";
  String db = "ontime";
  String user = "root";
  String password = "";
  
  String url = String.format("jdbc:mysql://%s:%d/%s?useSSL=false", new Object[] { host, Integer.valueOf(port), db });
  
  public void conectar() throws SQLException {

	  conexion = DriverManager.getConnection(url,user,password);
  }
  
  public void desconectar()
  {
    try {
      conexion.close();
    } catch (SQLException sqlex) {
      System.out.println("Error: " + sqlex.getMessage());
    }
  }
  




  public ResultSet ejecutarConsulta(String sentencia)
  {
    ResultSet rsResultado = null;
    try {
      System.out.println("Ejecutando: " + sentencia);
      PreparedStatement prepStatement = conexion.prepareStatement(sentencia);
      rsResultado = prepStatement.executeQuery();
    } catch (SQLException sqlex) {
      System.out.println("Error: " + sqlex.getMessage());
    }
    return rsResultado;
  }
  








  public int insertarUsuario(Usuarios usuario)
  {
    int iRes = 0;
    String sInsert = "insert into usuarios (dni, nombre, apellido, nombre_usuario, contraseña, telefono ) values (?, ?, ?, ?, ?, ?);";
    try {
      System.out.println("Ejecutando: " + sInsert);
      System.out.println("datos: " + usuario);
      PreparedStatement prepStatement = 
        conexion.prepareStatement(sInsert);
      prepStatement.setString(1, usuario.getDni());
      prepStatement.setString(2, usuario.getNombre());
      prepStatement.setString(3, usuario.getApellido());
      prepStatement.setString(4, usuario.getNombre_usuario());
      prepStatement.setString(5, usuario.getContraseña());
      prepStatement.setInt(6, usuario.getTelefono());
      iRes = prepStatement.executeUpdate();
    } catch (SQLException sqlex) {
      System.out.println("Error: " + sqlex.getMessage());
      sqlex.printStackTrace();
    }
    return iRes;
  }
  
  
  public int insertarAdministrador(Administradores administrador)
  {
    int iRes = 0;
    String sInsert = "insert into administradores (dni, nombre, apellido, nombre_usuario, contraseña, telefono ) values (?, ?, ?, ?, ?, ?);";
    try {
      System.out.println("Ejecutando: " + sInsert);
      System.out.println("datos: " + administrador);
      PreparedStatement prepStatement = 
        conexion.prepareStatement(sInsert);
      prepStatement.setString(1, administrador.getDni());
      prepStatement.setString(2, administrador.getNombre());
      prepStatement.setString(3, administrador.getApellido());
      prepStatement.setString(4, administrador.getNombre_usuario());
      prepStatement.setString(5, administrador.getContraseña());
      prepStatement.setInt(6, administrador.getTelefono());
      iRes = prepStatement.executeUpdate();
    } catch (SQLException sqlex) {
      System.out.println("Error: " + sqlex.getMessage());
      sqlex.printStackTrace();
    }
    return iRes;
  }
  
  public int insertarSesion(Sesiones sesionTrabajo)
  {
    int iRes = 0;
    String sInsert = "insert into sesiones  values (NULL, NOW(), ?, ?);";
    try {
      System.out.println("Ejecutando: " + sInsert);
      System.out.println("datos: " + sesionTrabajo);
      PreparedStatement prepStatement = 
        conexion.prepareStatement(sInsert);
      prepStatement.setString(1, sesionTrabajo.getDni());
      prepStatement.setString(2, sesionTrabajo.getHorastrabajadas());
    
      iRes = prepStatement.executeUpdate();
    } catch (SQLException sqlex) {
      System.out.println("Error: " + sqlex.getMessage());
      sqlex.printStackTrace();
    }
    return iRes;
  }
  public static int borrarAdministrador(String username) throws SQLException {
	  String usu = username;
	  int res =0;
	  
	  String Delete="DELETE FROM administradores WHERE nombre_usuario = '"+usu+"';";
	  PreparedStatement consulta = conexion.prepareStatement(Delete);
	  
	  res = consulta.executeUpdate();
	  return res;
	  
  }
  
  
  public static  int borrarUsuario(String username) throws SQLException{
	  
	  String usu = username;
	  int res = 0;
	  
	  String Delete ="DELETE FROM usuarios WHERE nombre_usuario = '"+usu+"';";
	  
	  PreparedStatement consulta = conexion.prepareStatement(Delete);
	  
	  res = consulta.executeUpdate();
	  
	  return res;
	  
  }
  
  
  
  
  
  
 
  
}
