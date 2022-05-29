package com.ies.baroja;

import com.model.Administradores;
import com.model.Usuarios;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({ "/ServletLogin" })
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletLogin() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		

		if (request.getParameter("tipo").equals("administrador")) {

			try {
				loginAdministrador(request, response);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			try {
				loginUsuario(request, response);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public static void loginAdministrador(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession sesion = request.getSession();
		String sUsername = request.getParameter("username");
		String sPassword = request.getParameter("password");

		Administradores administrador = Controller
				.getLoginAdministradores("SELECT * FROM administradores WHERE nombre_usuario='" + sUsername + "';");
										//SELECT * FROM administradores WHERE nombre_usuario= 'alex';

		String passintroducida = administrador.getContraseña();

		if (sPassword.equals(passintroducida)) {

			String nombre = administrador.getNombre();
			sesion.setAttribute("name", nombre);
			sesion.setAttribute("name_user", sUsername);
			

			response.sendRedirect("HTML//gestionar_cuentas.jsp");

		} else {
			
			response.sendRedirect("HTML//error.html");

		}

	}

	public static void loginUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException { 
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
	  HttpSession sesion = request.getSession();
	  String sUsername = request.getParameter("username");
	  String sPassword = request.getParameter("password");
	  Usuarios usuario = Controller.getLoginUsuarios("SELECT * FROM usuarios WHERE nombre_usuario='"+sUsername+"';");
	  
	  String passintroducida = usuario.getContraseña();
	  
	  if (sPassword.equals(passintroducida)) {
		  String dni = usuario.getDni();
		  String nombre = usuario.getNombre();
		  String apellido = usuario.getApellido();
		  int telefono = usuario.getTelefono();
		  
		  sesion.setAttribute("dni",dni);
		  sesion.setAttribute("nombre", nombre);
		  sesion.setAttribute("nombre_usuario", sUsername);
		  sesion.setAttribute("apellido", apellido);
		  sesion.setAttribute("telefono", telefono);
		  
		  response.sendRedirect("HTML//fichaje_usuario.jsp");
	  } else { 
		  
		  
		  response.sendRedirect("HTML//error.html");
		  
		  
	  }
	  
	  }

}
