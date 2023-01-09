<%-- 
    Document   : dobble
    Created on : 13 dic 2022, 22:59:23
    Author     : Angel
--%>
<%@page import="java.time.LocalTime"%>
<%@page import="modelo.Baraja"%>
<%@page import="modelo.Carta"%>

<%@page contentType="text/html" pageEncoding="latin1"%>
<%
    HttpSession sesion = request.getSession();

    // Si la variable nombre no ha sido inicializada en sesión es que
    // no hay sesión creada, por tanto que vuelva al login.
    if (sesion.getAttribute("nombre") == null) {
        response.sendRedirect("index.jsp");
        return;
    }
    String nombre = (String) sesion.getAttribute("nombre");
    

    // Recuperamos el valor de la baraja creada previamente y lo metemos en una variable.
    Baraja baraja = (Baraja) sesion.getAttribute("baraja");

    // Si la variable intento o la variable puntos no ha sido inicializada aún, que lo haga.
    // Esto sirve para que se inicialicen cuando el juego esté en la primera ronda.
    if (sesion.getAttribute("intento") == null) {
        sesion.setAttribute("intento", 1);
    }
    if (sesion.getAttribute("puntos") == null) {
        sesion.setAttribute("puntos", 0.0);
    }

    // Recuperamos el valor de las sesiones intento y puntos.
    int intento = (int) sesion.getAttribute("intento");
    Double puntos = (Double) sesion.getAttribute("puntos");

    // Inicializamos las cartas que vamos a mostrarle al usuario, dado que intento se declara a 1 la carta del usuario la
    // primera vez tiene el índice 0 y la que hay que adivinar tiene el 1. A partir de ahí como intento va a ir aumentando
    // por cada ronda la carta del usuario siempre va a ser la que había que adivinar y se sacaría una carta para adivinar nueva.
    Carta carta1 = baraja.get(intento - 1);
    Carta carta2 = baraja.get(intento);

    // Variable para los botones, al poner estos valores así se ven con el fondo de la página, lo pongo aquí para no repetir líneas.
    String cosasDiseno = "background-position: center;background-size: 80% 80%;background-repeat: no-repeat;";

    // En el caso de que la puntuación sea un número entero que lo muestra sin decimales, en caso de no ser entero que lo muestre con ellos.
    String puntuacion = String.valueOf(puntos);
    if (puntos % 1 == 0) {
        puntuacion = String.valueOf((int) Math.round(puntos));
    }

    // Almacenamos en la sesión el momento en el que al usuario se le muestran las cartas
    LocalTime horaMostrar = LocalTime.now();
    sesion.setAttribute("horaMostrar", horaMostrar);
%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=latin1">
        <title>Dobble</title>
        <link rel="stylesheet" href="resources/styles/juego.css"/>
    </head>
    <body>
        <h1>DOBBLE NAVIDEÑO</h1>
        <div id="info">
            <h2>Jugador: <%=nombre%></h2><br>   
            <h2>Puntuación: <%=puntuacion%></h2>
        </div>
        <h2 id="derecha">Cartas restantes: <%=31 - intento%></h2>

        <div class="cartas">
            <div><h2>Tu carta</h2><img id="img1" src="<%=carta1%>" alt="Carta Usuario"></div>
            <div><h2>Carta Adivinar</h2><img src="<%=carta2%>" alt="Carta Adivinar"></div>

        </div>
        <form action="controladorCartas" method="POST">
            <div><input type="submit" name="bot1" value="<%=carta1.getOpcion1()%>" style='background: url("<%=carta1.getOpcion1()%>");<%=cosasDiseno%>'></div>
            <div><input type="submit" name="bot2" value="<%=carta1.getOpcion2()%>" style='background: url("<%=carta1.getOpcion2()%>");<%=cosasDiseno%>'></div>
            <div><input type="submit" name="bot3" value="<%=carta1.getOpcion3()%>" style='background: url("<%=carta1.getOpcion3()%>");<%=cosasDiseno%>'></div>
            <div><input type="submit" name="bot4" value="<%=carta1.getOpcion4()%>" style='background: url("<%=carta1.getOpcion4()%>");<%=cosasDiseno%>'></div>
            <div><input type="submit" name="bot5" value="<%=carta1.getOpcion5()%>" style='background: url("<%=carta1.getOpcion5()%>");<%=cosasDiseno%>'></div>
            <div><input type="submit" name="bot6" value="<%=carta1.getOpcion6()%>" style='background: url("<%=carta1.getOpcion6()%>");<%=cosasDiseno%>'></div>
        </form>
    </body>
</html>