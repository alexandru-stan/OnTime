<!DOCTYPE html>
<html lang="es">
<head>
  <title>Gesti�n</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>


<div class="container mt-3">  
<h1 class="text-primary">Bienvenido, esto es para Usuario  ${sessionScope.name}</h1>

<%
HttpSession misesion = request.getSession();
//colocar variables en la sesi�n

//obtener variables de la sesi�n
//guarda todo como Object, el casteo es obligatorio
String nombreusuario = (String) misesion.getAttribute("name_user"); 
out.println("Tu nombre de usuario es:"+nombreusuario);

%>


  
  
 </div>
 
   
 

</body>
</html>
