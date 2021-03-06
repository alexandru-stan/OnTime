<!DOCTYPE html>
<html lang="es" dir="ltr">
  <head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <meta charset="utf-8">
    <title>OnTime! - Perfil</title>
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
      <h2>Mi Perfil</h2>

      

    <div class="cuadroperfil">
     <h5 id="txtmodi">DNI: ${sessionScope.dni}</h6>
     <h5 id="txtmodi">Nombre: ${sessionScope.nombre} </h6>
     <h5 id="txtmodi">Apellidos: ${sessionScope.apellido}</h6>
     <h5 id="txtmodi">Nombre de Usuario: ${sessionScope.nombre_usuario}</h6>
     <h5 id="txtmodi">Tel&eacutefono: ${sessionScope.telefono}</h6>
    </div>
  		</article>



      </section>







    </article>
    <footer class= "bg-danger">
      <nav class="navbar navbar-expand-lg navbar-dark bg-danger">
        <div class="collapse navbar-collapse" id="navbarText2">
          <ul class="navbar-nav mr-auto">
            <form action="../../ServletLogoff" method="POST">
            <button type="submit" style="background-color:transparent;border:none;color:white;">Salir</button>
              </form>
          </ul>
        </div>
      </nav>
    </footer>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>

  </body>
</html>