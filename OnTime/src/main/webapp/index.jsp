<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
  <title>OnTime!</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/Wruczek/Bootstrap-Cookie-Alert@gh-pages/cookiealert.css">
  <style>

body{
   background-color:#43464B;
   background-image: url("https://fondosmil.com/fondo/75479.jpg");
   background-repeat: no-repeat;
   background-attachment: fixed;
   background-size: 100% 100%;
}



form {
margin-top:10em;
background-color:#43464B;
border-radius:5%;
padding:3%;
box-shadow: 10px 10px 4px #37393d;
}

input[type=text] {
  width: 200px;
  margin-left:15%;

}
input[type=text]:hover {
  width: 200px;
  margin-left:15%;
  box-shadow: 3px 3px 0px white;
}

input[type=password] {
  width: 200px;
  margin-left:15%;
}
input[type=password]:hover {
  width: 200px;
  margin-left:15%;
  box-shadow: 3px 3px 0px white;
}


#boton{
margin-left:30%;
}

#admin{
  color: white;
margin-left:19%;
}

#usu{
  color: white;
  margin-left:1%;
}


#titulo{
  color: white;
  margin-left:23%;
}


h6{
  color: white;
  margin-left:10% ;
}



  </style>
</head>

<body>

<div class="alert text-center cookiealert" role="alert">
    <b>Do you like cookies?</b> &#x1F36A; We use cookies to ensure you get the best experience on our website. <a href="https://cookiesandyou.com/" target="_blank">Learn more</a>

    <button type="button" class="btn btn-primary btn-sm acceptcookies">
        I agree
    </button>
</div>

<script src="https://cdn.jsdelivr.net/gh/Wruczek/Bootstrap-Cookie-Alert@gh-pages/cookiealert.js"></script>
<!--T-->
<div class="col-3 container">

  <form action="ServletLogin" method="POST">

    <div class="row" style="margin-top:5%">

      <div id="ontime">
    <h1 id="titulo">OnTime!<h1>
      </div>
<div class="mt-3">

    <label style="color:white" for="tipo">Vas a acceder como</label>
              <select name="tipo" size="1" id="tipo">
                <option value="usuario" selected>Usuario</option>
                <option value="administrador">Administrador</option>
              </select>

</div>

    <div class="-xs-3 mt-3">
      <input type="text" class="form-control "  name="username" placeholder="Usuario" required>
    </div>


    <div class="-xs-3 mt-3">
      <input type="password" class="form-control"  name="password"  placeholder="Contrase&ntilde;a" required>
    </div>

    </div>



    <div id="boton" class="mt-4">
    <button  type="submit" class="btn btn-danger">Iniciar sesi&oacute;n</button>
    </div>

  </form>

</div>




</body>

</html>
