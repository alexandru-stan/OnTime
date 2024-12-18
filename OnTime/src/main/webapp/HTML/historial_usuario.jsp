<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="com.model.Sesiones"%>
<%@ page import="com.ies.baroja.Controller"%>
<%@ page import="java.util.LinkedList"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html lang="es" dir="ltr">
  <head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <meta charset="utf-8">
    <title>OnTime! - Historial</title>
    <link rel="stylesheet" href="css/Usuario.css">
  </head>
  <body>
    <header>
      <nav class="navbar navbar-expand-lg navbar-dark bg-danger">
         <a class="navbar-brand" href="">&nbsp; OnTime!</a>
         <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
           <span class="navbar-toggler-icon"></span>
         </button>
         <div class="collapse navbar-collapse" id="navbarSupportedContent">

           <ul class="margen-down navbar-nav me-auto mb-2 mb-lg-0">
             <li class="nav-item">
               <a class="nav-link  active" href="fichaje_usuario.jsp">Fichaje</a>
             </li>
             <li class="nav-item">
               <a class="nav-link" href="perfil_usuario.jsp">Perfil</a>
             </li>
             <li class="nav-item">
               <a class="nav-link" href="faltas_usuario.jsp">Ver Faltas</a>
             </li>
             <li class="nav-item">
               <a class="nav-link" href="historial_usuario.jsp">Ver Historial</a>
             </li>
           </ul>
         </div>
       </nav>

    </header>
    <article>
      &nbsp;
      <h2>Historial de asistencia</h2>

    <div class="cuadrofaltas">
      <table class="table table-striped table-bordered table-hover table-dark">
        <thead>
          <tr>
            <th>C�digo de sesi�n</th>
            <th>Fecha</th>
            <th>Horas Trabajadas</th>
            
          </tr>
        <tbody>
          <%
         String dni = (String) request.getSession().getAttribute("dni");
          LinkedList<Sesiones> lista = Controller.getHistorial(dni);
          for (int i = 0; i < lista.size(); i++) {
          if ( i % 2 == 0){
          out.println("<tr  class='table-primary' >");
          }
          else {
          out.println("<tr  class='table-success'>");
          }
          out.println("<td>" + lista.get(i).getCodsesion() + "</td>");
          out.println("<td>" + lista.get(i).getFecha() + "</td>");
          out.println("<td>" + lista.get(i).getHorastrabajadas() + "</td>");
          out.println("</tr>");
          }
%>
        </tbody>
        </thead>
      </table>
    </div>
  		</article>



      </section>







    </article>
    <footer class= "bg-danger">
      <nav class="navbar navbar-expand-lg navbar-dark bg-danger">
        <div class="collapse navbar-collapse" id="navbarText2">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
              <form action="../../ServletLogoff" method="POST">
            <button type="submit" style="background-color:transparent;border:none;color:white;">Salir</button>
              </form>
            </li>
          </ul>
        </div>
      </nav>
    </footer>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    <script>

    </script>
  </body>
</html>
