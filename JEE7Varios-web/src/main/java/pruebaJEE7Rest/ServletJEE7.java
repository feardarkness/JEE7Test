package pruebaJEE7Rest;

import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import prueba.ejb.PruebaStatelessSinInterfaz;

/**
 *
 * @author aalvarado
 */
@WebServlet(name = "ServletJEE7", urlPatterns = {"/servlet1"})
public class ServletJEE7 extends HttpServlet {

    @Inject
    PruebaStatelessSinInterfaz numero;

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

        response.setContentType("text/html;charset=UTF-8");
        String parametroRedireccion = request.getParameter("redireccion");
        if (parametroRedireccion != null && parametroRedireccion.equals("true")) {
            request.getRequestDispatcher("prueba2url").forward(request, response);
        } else {
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet ServletJEE7</title>");
                out.println("</head>");
                out.println("<body>");
                out.println(numero);
                out.println("<h1>Servlet ServletJEE7 at " + request.getContextPath() + "</h1>");
                out.println("<p>Primer servlet jee7, bien hecho!!!</p>");
                out.println("<p>El numero devuelto de la inyeccion de dependencias con inject es: " + numero+ "</p>");
                out.println("</body>");
                out.println("</html>");
            }
        }

    }

    public void init() {
        System.out.println("Entro a Init");
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
