package com.ies.baroja;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletModificar
 */
@WebServlet("/ServletModificar")
public class ServletModificar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModificar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String dni=request.getParameter("dni");
		String nombre=request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String nombre_usuario = request.getParameter("nombre_usuario");
		String contraseña = request.getParameter("contrasena");
		int telefono = Integer.parseInt((request.getParameter("telefono")));
		
		System.out.println(dni);
		System.out.println(nombre);
		
		
		
		
		
		
		
		
	}

}
