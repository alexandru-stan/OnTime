<!DOCTYPE html>
<html lang="es" dir="ltr">
  <head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <meta charset="utf-8">
    <title>OnTime! - Fichajes</title>
    <link rel="stylesheet" href="css/Usuario.css">
  </head>
  <style>

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
      <h2>Hola, ${sessionScope.nombre}.</h2>
      &nbsp;
      <div class="cuadro">
        <p id="demo"></p>
        <div id="reloj"/>
      </div>
      <h1 id="timeset"><time>00:00:00</time></h1>
      <input id="strt" type="button" onclick="myFunction()" class="btn btn-danger" value="Empezar"></input>
      <button id="stp" class="btn btn-secondary">Pausar</button>
      <form action="../../ServletFichar" method="POST">
        <input id="acab" type="submit"  value='Acabar' class="btn btn-dark"></input>
        <input type="hidden" id="IdContador" name="horastrabajadas"> </input>
      </form>

    </article>
    <footer class= "bg-danger fixed-bottom">
      <nav class="navbar fixed-bottom navbar-dark bg-danger">
      <a class="navbar-brand"></a>
       <form action="../../ServletLogoff" method="POST">
            <button type="submit" style="background-color:transparent;border:none;color:white;">Salir</button>
              </form>
    </nav>
    </footer>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    <script>

//CONTADOR DE HORAS TRABAJADAS
var h1 = document.getElementsByTagName('h1')[0];
var start = document.getElementById('strt');
var stop = document.getElementById('stp');
var acabar = document.getElementById('acab');

//var reset = document.getElementById('rst');
var sec = 0;
var min = 0;
var hrs = 0;
var t;

function tick(){
    sec++;
    if (sec >= 60) {
        sec = 0;
        min++;
        if (min >= 60) {
            min = 0;
            hrs++;
        }
    }
}
function add() {
    tick();
    h1.textContent = (hrs > 9 ? hrs : "0" + hrs)
        	 + ":" + (min > 9 ? min : "0" + min)
       		 + ":" + (sec > 9 ? sec : "0" + sec);
    timer();
}
function timer() {
    t = setTimeout(add, 1000);
}

timer();
window.onload = clearTimeout(t);

strt.onclick = function() {
  if (document.getElementById("strt").value=="Empezar") { //bot�n en "Empezar"
    timer(); //ir  la funci�n timer
document.getElementById("strt").disabled = true;
document.getElementById("strt").value="Continuar";
     }
  else if (document.getElementById("strt").value=="Continuar") {  //Bot�n en "Continuar"
      timer();
      document.getElementById("strt").disabled = true;
     }
  }


stop.onclick = function() {
    clearTimeout(t);
    h1.textContent = (hrs > 9 ? hrs : "0" + hrs)
        	 + ":" + (min > 9 ? min : "0" + min)
       		 + ":" + (sec > 9 ? sec : "0" + sec) + " horas trabajadas.";
   document.getElementById("strt").disabled = false;
}
acabar.onclick = function() {
	clearTimeout(t);
    h1.textContent = (hrs > 9 ? hrs : "0" + hrs)
        	 + ":" + (min > 9 ? min : "0" + min)
       		 + ":" + (sec > 9 ? sec : "0" + sec) ;
   var sample_text =
   document.getElementById("timeset").textContent;
   document.getElementById("IdContador").innerHTML = sample_text;
   document.getElementById("IdContador").setAttribute("value", sample_text);
   
}
//RESETEO DEL CONTADOR


/*reset.onclick = function() {
    h1.textContent = "00:00:00";
    sec = 0; min = 0; hrs = 0;
}*/

//RELOJ ACTIVO
      function muestraReloj() {
    var fechaHora = new Date();
    var horas = fechaHora.getHours();
    var minutos = fechaHora.getMinutes();
    var segundos = fechaHora.getSeconds();

    if(horas < 10) { horas = '0' + horas; }
    if(minutos < 10) { minutos = '0' + minutos; }
    if(segundos < 10) { segundos = '0' + segundos; }

    document.getElementById("reloj").innerHTML = 'Son las '+horas+':'+minutos;
  }

  window.onload = function() {
    setInterval(muestraReloj, 1000);
}
    </script>
  </body>
  </html>