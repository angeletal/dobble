<%-- 
    Document   : index
    Created on : 19 dic 2022, 13:34:08
    Author     : Angel
--%>

<%@page contentType="text/html" pageEncoding="latin1"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=latin1">
        <title>Login</title>
        <link rel="stylesheet" href="resources/styles/login.css"/>
    </head>
    <body>
        <div class="contenedor">
            <form action="controladorLogin" method="POST">
                <h1>DOBBLE ÁNGEL</h1>
                <div class="formulario">
                    <div class="input">
                        <input type="text" name="nombre" placeholder="Nombre de usuario" autocomplete="off">
                    </div>
                </div>
                <div class="enviar">
                    <input type="submit" name="acceder" value="Jugar">
                    <!-- H2 para mostrar error en caso de que haya alguno. -->
                    <h2><%=session.getAttribute("error") != null ? (String) session.getAttribute("error") : ""%></h2>
                </div>
            </form>
        </div>
    </body>
</html>
<%
    // Con este scriptlet se cerrarían todas las sesiones una vez el usuario entre a Login. De
    // esta forma siempre que entre se le cerraría su sesión y al logarse crearía una nueva partida.
    session.invalidate();%>