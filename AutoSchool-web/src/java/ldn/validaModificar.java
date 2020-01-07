/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldn;

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
 * @author Personal
 */
public class validaModificar extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/wsAutoSchool/datosProfesor.wsdl")
    private DatosProfesor_Service service;

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
            String xid, nombre, apePat, apeMat, huella, acepta, usr, psw, psw2, error, guarda, contraConf, email;
            if (sesion.getAttribute("usr") != null) {
                guarda = request.getParameter("guarda");
                acepta = request.getParameter("acepta") == null ? null : "No es vacío";

                xid = sesion.getAttribute("xid").toString();
                usr = sesion.getAttribute("usr").toString();
                getTodosLosDatos(usr);
                nombre = request.getParameter("nombre") == null ? getNombre() : request.getParameter("nombre");
                apePat = request.getParameter("paterno") == null ? getApePaterno() : request.getParameter("paterno");
                apeMat = request.getParameter("materno") == null ? getApeMaterno() : request.getParameter("materno");
                email = request.getParameter("email") == null ? getEmail() : request.getParameter("email");
                psw = request.getParameter("contra") == null ? sesion.getAttribute("psw").toString() : request.getParameter("contra");
                psw2 = request.getParameter("ncontra") == null || request.getParameter("ncontra").equals("") ? sesion.getAttribute("psw").toString() : request.getParameter("ncontra");;
                contraConf = request.getParameter("confContra") == null ? "" : request.getParameter("confContra");;;
                String comprobar = sesion.getAttribute("psw").toString();
                if (contraConf.equals(sesion.getAttribute("psw").toString()) && !acepta.isEmpty()) {
                    if (psw.equals(psw2)) {
                        error = modificaProfe(xid, nombre, apePat, apeMat, "0", usr, psw, email);
                        if (error.equalsIgnoreCase("Usuario actualizado")) {
                            response.sendRedirect("perfilM.jsp");
                        } else {
                            out.print("<script>alert('" + error + "');"
                                    + "var pagina = 'javascript:history.go(-1)'; "
                                    + "document.location.href=pagina;"
                                    + "</script>");
                        }
                    } else {
                        out.print("<script>alert('Las contraseñas no coinciden');"
                                + "var pagina = 'javascript:history.go(-1)'; "
                                + "document.location.href=pagina;"
                                + "</script>");
                    }

                } else {
                    String elmsj = "Error: ";
                    if (!contraConf.equals(sesion.getAttribute("psw").toString())) {
                        elmsj += "La contraseña es incorrecta";
                    } else {
                        elmsj += "Alto ahí, compadre.";
                    }
                    out.print("<script>alert('"+elmsj+"');"
                            + "var pagina = 'javascript:history.go(-1)'; "
                            + "document.location.href=pagina;"
                            + "</script>");
                }

            } else {
                out.print("no jaló la sesión");
                /*out.print("<script>"
                        + "var pagina = 'javascript:history.go(-1)'; "
                        + "document.location.href=pagina;"
                        + "</script>");*/
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

    private String modificaProfe(java.lang.String xid, java.lang.String name, java.lang.String apePat, java.lang.String apeMat, java.lang.String xhuella, java.lang.String xUsr, java.lang.String xPswd, java.lang.String xEmail) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        profesor.DatosProfesor port = service.getDatosProfesorPort();
        return port.modificaProfe(xid, name, apePat, apeMat, xhuella, xUsr, xPswd, xEmail);
    }

    private String getTodosLosDatos(java.lang.String usr) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        profesor.DatosProfesor port = service.getDatosProfesorPort();
        return port.getTodosLosDatosProfe(usr);
    }

    private String getApeMaterno() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        profesor.DatosProfesor port = service.getDatosProfesorPort();
        return port.getApeMaterno();
    }

    private String getApePaterno() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        profesor.DatosProfesor port = service.getDatosProfesorPort();
        return port.getApePaterno();
    }

    private String getHuella() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        profesor.DatosProfesor port = service.getDatosProfesorPort();
        return port.getHuella();
    }

    private String getNombre() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        profesor.DatosProfesor port = service.getDatosProfesorPort();
        return port.getNombre();
    }

    private String getEmail() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        profesor.DatosProfesor port = service.getDatosProfesorPort();
        return port.getEmail();
    }

}
