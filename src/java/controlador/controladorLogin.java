/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.Baraja;

/**
 *
 * @author Angel
 */
@WebServlet(name = "controladorLogin", urlPatterns = {"/controladorLogin"})
public class controladorLogin extends HttpServlet {

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
        HttpSession sesion = request.getSession();
        String nombre = request.getParameter("nombre");
        // Si el nombre está vacío o no está inicializado que vuelva al login y muestre el error correspondiente.
        if (nombre == null || nombre.trim().equals("")) {
            sesion.setAttribute("error", "El nombre no puede estar vacío.");
            response.sendRedirect(("index.jsp"));
            return;
        }

        // Si el nombre tiene más de 8 carácteres que vuelva al login y muestre el error correspondiente.
        if (nombre.trim().length() > 8) {
            sesion.setAttribute("error", "El nombre no puede tener más de 8 carácteres.");
            response.sendRedirect(("index.jsp"));
            return;
        }
        
        // Si todo está bien se declara la baraja (que ya estaría barajada), se añade a la sesión 
        // junto al nombre de usuario y se redirecciona al juego.
        Baraja baraja = new Baraja();
        sesion.setAttribute("baraja", baraja);
        sesion.setAttribute("nombre", nombre);
        response.sendRedirect("Dobble.jsp");
        return;
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
        return "Controlador para el login";
    }// </editor-fold>

}
