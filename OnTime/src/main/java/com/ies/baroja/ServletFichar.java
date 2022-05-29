package com.ies.baroja;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Sesiones;

/**
 * Servlet implementation class ServletFichar
 */
@WebServlet("/ServletFichar")
public class ServletFichar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFichar() {
        super();
      
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
		boolean res;
		String dni=(String) request.getSession().getAttribute("dni");
		String horas=request.getParameter("horastrabajadas");
		
		System.out.println("DNI:"+dni);
		System.out.println("HORAS TRABAJADAS:"+horas);
		
		Sesiones sesionTrabajo = new Sesiones(dni,horas);
		
		try {
			res = Controller.crearSesionTrabajo(sesionTrabajo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("ERROR SQL");
		}
		
		response.sendRedirect("HTML/sesionExito.html");
		
		
	}

}
