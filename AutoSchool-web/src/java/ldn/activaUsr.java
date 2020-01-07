/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldn;

import acceso.Acceso_Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author The Real Technology
 */
public class activaUsr extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/wsAutoSchool/acceso.wsdl")
    private Acceso_Service service;

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

        try (PrintWriter out = response.getWriter()) {
            request.setCharacterEncoding("UTF-8");
            String usr = request.getParameter("usr");

            String acc = "";
            String Acc = "";
            boolean prende = false;
            if (request.getParameter("xAcc") != null) {
                acc = request.getParameter("xAcc");
                if (acc.equals("1")) {
                    prende = true;

                    String active = activaUsr(usr);
                    if (active.equalsIgnoreCase("Usuario activado")) {
                        out.print("<script>alert('" + active + "');"
                                + "var pagina = 'index.jsp'; "
                                + "document.location.href=pagina;"
                                + "</script>");
                    } else {
                        out.print("<script>"
                                + "var pagina = 'login.jsp'; "
                                + "document.location.href=pagina;"
                                + "alert('" + active + "');</script>");
                    }
                } else if (acc.equals("2")) {
                    prende = false;
                    out.print("<script>"
                            + "var pagina = 'login.jsp'; "
                            + "document.location.href=pagina;"
                            + "</script>");
                }
            } else {
                Acc = "2";
                out.print("<script>"
                        + "var pagina = 'login.jsp'; "
                        + "document.location.href=pagina;"
                        + "</script>");
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

    private String activaUsr(java.lang.String usr) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        acceso.Acceso port = service.getAccesoPort();
        return port.activaUsr(usr);
    }

}
