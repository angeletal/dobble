/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Baraja;
import modelo.Carta;

/**
 *
 * @author Angel
 */
@WebServlet(name = "controladorCartas", urlPatterns = {"/controladorCartas"})
public class controladorCartas extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=latin1");
        try ( PrintWriter out = response.getWriter()) {
            HttpSession sesion = request.getSession();

            // Lo mismo que en dobble.jsp, que redirija al index si el atributo
            // nombre no está inicializado en la sesión.
            String nombre = (String) sesion.getAttribute("nombre");
            if (nombre == null) {
                response.sendRedirect(("index.jsp"));
                return;
            }
            int intento = (int) sesion.getAttribute("intento");

            // If para saber que boton ha sido pulsado en base al name de cada botón.
            String opcion = "";
            boolean botonEncontrado = false;
            for (int i = 1; i < 7 && !botonEncontrado; i++) {
                if (request.getParameter("bot" + i) != null) {
                    opcion = request.getParameter("bot" + i);
                    botonEncontrado = true;
                }
            }

            // Declaración de la hora a la que pulsa el usuario el botón.
            LocalTime horaPulsar = LocalTime.now();

            // Obtiene la diferencia entre las dos horas.
            Duration diferencia = Duration.between((LocalTime) sesion.getAttribute("horaMostrar"), horaPulsar);

            // Obtiene la duración en segundos de la diferencia entre ambas horas.
            long segundos = diferencia.getSeconds();

            // Declaramos la carta que se muestra a la derecha, es decir, de la que hay que adivinar su figura.
            Carta carta2 = ((Baraja) sesion.getAttribute("baraja")).get(intento);

            // Recuperamos de la sesión los puntos que tiene el jugador.
            Double puntos = (Double) sesion.getAttribute("puntos");

            // Según los segundos que haya tardado que se sume o no la cantidad de puntos que corresponda.
            if (carta2.compararOpciones(opcion) && segundos <= 8) {
                if (segundos <= 2) {
                    puntos += 1;
                } else if (segundos <= 4) {
                    puntos += 0.75;
                } else if (segundos <= 6) {
                    puntos += 0.5;
                } else if (segundos <= 8) {
                    puntos += 0.25;
                }

                // Modificamos la puntuación de la sesión.
                sesion.setAttribute("puntos", puntos);
            }

            // Si a la baraja no le quedan cartas que vaya a la ventana del final.
            if (intento == 30) {
                sesion.setAttribute("juegoFinalizado", true);
                response.sendRedirect("resultado.jsp");
                return;
            } else {
                // Si quedan cartas por mostrar, que incremente el intento y continue el juego.
                sesion.setAttribute("intento", intento + 1);
                response.sendRedirect("dobble.jsp");
                return;
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
