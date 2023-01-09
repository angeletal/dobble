<%-- 
    Document   : resultado
    Created on : 19 dic 2022, 20:23:04
    Author     : Angel
--%>

<%@page import="modelo.Baraja"%>
<%@page contentType="text/html" pageEncoding="latin1"%>
<%
    HttpSession sesion = request.getSession();

    // Si se intenta acceder a la página de resultado sin haber terminado, que se vuelva al login.
    if (sesion.getAttribute("juegoFinalizado") == null) {
        response.sendRedirect("index.jsp");
        return;
    }
    // Si el input reiniciar tiene valor...
    if (request.getParameter("reiniciar") != null) {
        // Que se guarde primero el nombre del usuario es una variable.
        String nombre = (String) session.getAttribute("nombre");
        // Eliminamos la sesión por completo.
        sesion.invalidate();
        // Creamos una sesión nueva.
        HttpSession sesion2 = request.getSession();
        // A esta le añadimos el nombre del usuario en base al String que declaramos antes de borrar la sesión previa.
        sesion2.setAttribute("nombre", nombre);
        // Por último creamos una nueva baraja, la almacenamos en la sesión y redireccionamos a la ventana de juego. 
        Baraja nueva = new Baraja();
        sesion2.setAttribute("baraja", nueva);
        response.sendRedirect("Dobble.jsp");
        return;
    }

    // Recuperamos los puntos de la sesión y como en dobble.jsp mostramos los puntos sin decimales si
    // es un número entero y con decimales y no lo es.
    Double puntos = (Double) sesion.getAttribute("puntos");
    String puntuacion = String.valueOf(puntos);
    if (puntos % 1 == 0) {
        puntuacion = String.valueOf((int) Math.round(puntos));
        // Si la puntuación total es 1 que tras indicar los puntos que obtuvo aparezca la palabra "punto" en lugar de "puntos". 
        if (puntos == 1) {
            puntuacion += " punto";
        } else {
            puntuacion += " puntos";
        }
    }

    // Si la puntuación total es menor que 12 que se cargue un archivo CSS u otro y se muestre un mensaje según si ha ganado o perdido.
    // Dado que conseguir 12 puntos es díficil, para probar la victoria y no tener que jugar hasta ganar basta con cambiar el signo del if.
    String rutaCSS = "";
    String texto = "";
    if (puntos >12) {
        rutaCSS = "resources/styles/derrota.css";
        texto = "<p>Vaya " + (String) session.getAttribute("nombre") + "... acabas de perder.<br><br> Para ganar tienes que llegar al menos<br> a 12 puntos y obtuviste solo " + puntuacion + " :C<br>Ahora El Grinch va a robar la Navidad por tu culpa.<br> ¡Si quieres impedirlo juega de nuevo hasta que ganes!";
    } else {
        rutaCSS = "resources/styles/victoria.css";
        texto = "¡Enhorabuena " + (String) session.getAttribute("nombre") + ", has ganado el juego Dobble<br>con una puntuación de " + puntuacion + " !<br><br>Al haber ganado significa que esta preparado/a para<br>pasar unas Navidades estupendas, así que ya sabes<br>estas navidades te toca disfrutar y descansar, ¡Feliz Navidad!";

    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=latin1">
        <title>Resultado</title>
        <link rel="stylesheet" href="<%=rutaCSS%>"/>
    </head>
    <body>
        <div id="contenedor">
            <div><p><%=texto%></p></div>
        </div>
        <form>
            <input type="submit" name="reiniciar" value="Volver a jugar">
        </form>
    </body>
</html>
