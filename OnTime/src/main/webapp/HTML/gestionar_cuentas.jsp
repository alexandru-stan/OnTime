<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="com.model.Administradores"%>
<%@ page import="com.model.Usuarios"%>
<%@ page import="com.ies.baroja.Controller"%>
<%@ page import="java.util.LinkedList"%>
<!DOCTYPE html>
<html lang="es" dir="ltr">
  <head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <meta charset="utf-8">
    <title>OnTime! - Cuentas</title>
    <link rel="stylesheet" href="css/Perfil.css">
    <link rel="stylesheet" href="css/Usuario.css">

    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300,400,600' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Raleway:100' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet' type='text/css'>
  </head>
  <style>
 

  h2{
    color:white;
    box-shadow: 4px 4px 1px #37393d;
    background-color: #43464B;
    width: 25%;
      margin-left: 37%;

  }
  </style>
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
              <a class="nav-link active" href="gestionar_cuentas.jsp">Cuentas</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="gestionar_sesiones.html">Sesiones</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="gestionar_faltas.html">Faltas</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="crear_cuentas.html">Crear</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="modificar_cuentas.html">Modificar</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="borrar_cuentas.html">Borrar</a>
            </li>
          </ul>
        </div>
      </nav>

    </header>
    <article>
      &nbsp;
      <h2>Administradores</h2>
<table class="table table-striped">
<thead class="table-dark">
<tr>
<th>DNI</th>
<th>Nombre</th>
<th>Apellido</th>
<th>Nombre_usuario</th>
<th>Contraseña</th>
<th>Telefono</th>
</tr>
</thead>
<tbody>
<%
LinkedList<Administradores> lista = Controller.getAllAdministradores();
for (int i = 0; i < lista.size(); i++) {
if ( i % 2 == 0){
out.println("<tr class='table-primary'>");
}
else {
out.println("<tr class='table-success'>");
}
out.println("<td>" + lista.get(i).getDni() + "</td>");
out.println("<td>" + lista.get(i).getNombre() + "</td>");
out.println("<td>" + lista.get(i).getApellido() + "</td>");
out.println("<td>" + lista.get(i).getNombre_usuario() + "</td>");
out.println("<td>" + lista.get(i).getContraseña() + "</td>");
out.println("<td>" + lista.get(i).getTelefono() + "</td>");
out.println("</tr>");
}
%>
</tbody>
</table>


   <h2>Usuarios</h2>
<table class="table table-striped">
<thead class="table-dark">
<tr>
<th>DNI</th>
<th>Nombre</th>
<th>Apellido</th>
<th>Nombre_usuario</th>
<th>Contraseña</th>
<th>Telefono</th>
</tr>
</thead>
<tbody>
<%
LinkedList<Usuarios> lista2 = Controller.getAllUsuarios();
for (int i = 0; i < lista2.size(); i++) {
if ( i % 2 == 0){
out.println("<tr class='table-primary'>");
}
else {
out.println("<tr class='table-success'>");
}
out.println("<td>" + lista2.get(i).getDni() + "</td>");
out.println("<td>" + lista2.get(i).getNombre() + "</td>");
out.println("<td>" + lista2.get(i).getApellido() + "</td>");
out.println("<td>" + lista2.get(i).getNombre_usuario() + "</td>");
out.println("<td>" + lista2.get(i).getContraseña() + "</td>");
out.println("<td>" + lista2.get(i).getTelefono() + "</td>");
out.println("</tr>");
}
%>
</tbody>
</table>


 


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
  </body>
</html>
