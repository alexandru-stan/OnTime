package com.ies.baroja;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Administradores;
import com.model.Usuarios;

/**
 * Servlet implementation class ServletCrear
 */
@WebServlet("/ServletCrear")
public class ServletCrear extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCrear() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean res;
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		if (request.getParameter("tipo").equals("administrador")) {
			
			Administradores administrador = new Administradores(
					request.getParameter("dni"),
					request.getParameter("nombre"),
					request.getParameter("apellido"),
					request.getParameter("nombre_usuario"),
					request.getParameter("contrasena"),
					Integer.parseInt(request.getParameter("telefono")));
			
			
			
			
			
			try {
				res = Controller.crearCuentaAdministrador(administrador);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response.sendRedirect("HTML/exitoCrear.html");
			
		} else {
			
			
			Usuarios usuario = new Usuarios(
					request.getParameter("dni"),
					request.getParameter("nombre"),
					request.getParameter("apellido"),
					request.getParameter("nombre_usuario"),
					request.getParameter("contrasena"),
					Integer.parseInt(request.getParameter("telefono")));
			
			try {
				res = Controller.crearCuentaUsuario(usuario);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("ERROR SQL");
			}
			
		
			
				response.sendRedirect("HTML/exitoCrear.html");
		
		
		
		}
		
	}

}
