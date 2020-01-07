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
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import profesor.DatosProfesor_Service;

/**
 *
 * @author Alumno
 */
public class validaLogin extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/wsAutoSchool/datosProfesor.wsdl")
    private DatosProfesor_Service service_1;

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
            HttpSession sesion = request.getSession();

            if (request.getParameter("cerrar") != null) {
                sesion.invalidate();
                response.sendRedirect("index.jsp");
            }

            String usr = request.getParameter("txtUsuario");
            String psw = request.getParameter("txtContra");
            String enviar = request.getParameter("btnIngresar");
            if (enviar != null) {
                if (accesoProfesor(usr, psw).equalsIgnoreCase("Bienvenido Docente")) {
                    sesion.setAttribute("xid", getDatosProfesor());
                    getTodosLosDatos(usr);
                    sesion.setAttribute("xHue", getHuella());
                    sesion.setAttribute("xTipo", "1");
                    sesion.setAttribute("usr", usr);
                    sesion.setAttribute("psw", psw);

                    response.sendRedirect("perfilM.jsp");

                } else if (accesoProfesor(usr, psw).equalsIgnoreCase("Bienvenido Administrador")) {
                    sesion.setAttribute("xid", getDatosProfesor());
                    getTodosLosDatos(usr);
                    sesion.setAttribute("xHue", getHuella());
                    sesion.setAttribute("xTipo", "2");
                    sesion.setAttribute("usr", usr);
                    sesion.setAttribute("psw", psw);

                    response.sendRedirect("main.jsp");
                } else {
                    out.print("<script>alert('" + accesoProfesor(usr, psw) + "');"
                            + "var pagina = 'javascript:history.go(-1)'; "
                            + "document.location.href=pagina;"
                            + "</script>");
                }
            } else {
                out.print("<script>"
                        + "var pagina = 'javascript:history.go(-1)'; "
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

    private String accesoProfesor(java.lang.String usr, java.lang.String psw) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        acceso.Acceso port = service.getAccesoPort();
        return port.accesoProfesor(usr, psw);
    }

    private String getDatosProfesor() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        acceso.Acceso port = service.getAccesoPort();
        return port.getDatosProfesor();
    }

    private String getTodosLosDatos(java.lang.String usr) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        profesor.DatosProfesor port = service_1.getDatosProfesorPort();
        return port.getTodosLosDatosProfe(usr);
    }

    private String getHuella() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        profesor.DatosProfesor port = service_1.getDatosProfesorPort();
        return port.getHuella();
    }

}
