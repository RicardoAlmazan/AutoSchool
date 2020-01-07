/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldn;

import administrador.Administrador_Service;
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
 * @author CECyT9
 */
public class modificaAdmin extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/wsAutoSchool/administrador.wsdl")
    private Administrador_Service serviceAlumno;

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/wsAutoSchool/datosProfesor.wsdl")
    private DatosProfesor_Service serviceProfe;

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
            String xid = "", nombre = "", apePat = "", apeMat = "", acepta = "",
                    usr = "", psw = "", psw2 = "", error = "", guarda = "", contraConf = "", email = "",
                    pswAdmin = "";
            if (sesion.getAttribute("usr") != null) {
                guarda = request.getParameter("guarda");
                acepta = request.getParameter("acepta") == null ? null : "No es vacío";

                xid = sesion.getAttribute("xid2").toString();
                usr = sesion.getAttribute("Usr2").toString();

                if (request.getParameter("oxq").equals("2")) {
                    getTodosLosDatosAlumno(usr);
                    nombre = request.getParameter("nombre") == null ? getNombreAlum() : request.getParameter("nombre");
                    apePat = request.getParameter("paterno") == null ? getApePaternoAlum() : request.getParameter("paterno");
                    apeMat = request.getParameter("materno") == null ? getApeMaternoAlum() : request.getParameter("materno");
                    email = request.getParameter("grupo") == null ? getGrupoAlum() : request.getParameter("grupo");
                    out.print("Alumno");
                } else if (request.getParameter("oxq").equals("1")) {
                    getTodosLosDatos(usr);
                    nombre = request.getParameter("nombre") == null ? getNombre() : request.getParameter("nombre");
                    apePat = request.getParameter("paterno") == null ? getApePaterno() : request.getParameter("paterno");
                    apeMat = request.getParameter("materno") == null ? getApeMaterno() : request.getParameter("materno");
                    email = request.getParameter("email") == null ? getEmail() : request.getParameter("email");

                    out.print("Profe");
                } else {
                    out.println("Alto ahí, compadre.");
                }

                pswAdmin = sesion.getAttribute("psw").toString();
                psw = request.getParameter("contra") == null ? "" : request.getParameter("contra");
                psw2 = request.getParameter("ncontra") == null || request.getParameter("ncontra").equals("") ? "" : request.getParameter("ncontra");
                contraConf = request.getParameter("confContra") == null ? "" : request.getParameter("confContra");;;

                if (contraConf.equals(sesion.getAttribute("psw").toString()) && !acepta.isEmpty()) {
                    if (psw.equals(psw2)) {
                        if (request.getParameter("oxq").equals("1")) {
                            error = modificaProfe(xid, nombre, apePat, apeMat, "0", usr, psw, email);

                        } else if (request.getParameter("oxq").equals("2")) {
                            error = modificaProfe(xid, nombre, apePat, apeMat, "1", usr, psw, email);
                        }
                        if (error.equalsIgnoreCase("Usuario actualizado")) {
                            response.sendRedirect("main.jsp");
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
                    out.print("<script>alert('" + elmsj + "');"
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
/*Alumno */
    private String getTodosLosDatosAlumno(java.lang.String usr) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        administrador.Administrador port = serviceAlumno.getAdministradorPort();
        return port.getTodosLosDatosAlumno(usr);
    }

    private String getApeMaternoAlum() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        administrador.Administrador port = serviceAlumno.getAdministradorPort();
        return port.getApeMaterno();
    }

    private String getApePaternoAlum() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        administrador.Administrador port = serviceAlumno.getAdministradorPort();
        return port.getApePaterno();
    }

    private String getGrupoAlum() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        administrador.Administrador port = serviceAlumno.getAdministradorPort();
        return port.getGrupo();
    }

    private String getIdUsrAlum() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        administrador.Administrador port = serviceAlumno.getAdministradorPort();
        return port.getIdUsr();
    }

    private String getNombreAlum() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        administrador.Administrador port = serviceAlumno.getAdministradorPort();
        return port.getNombre();
    }

    /*Fin Alumno*/
 /*Profesor*/
    private String modificaProfe(java.lang.String xid, java.lang.String name, java.lang.String apePat, java.lang.String apeMat, java.lang.String xhuella, java.lang.String xUsr, java.lang.String xPswd, java.lang.String xEmail) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        profesor.DatosProfesor port = serviceProfe.getDatosProfesorPort();
        return port.modificaProfe(xid, name, apePat, apeMat, xhuella, xUsr, xPswd, xEmail);
    }

    private String getTodosLosDatos(java.lang.String usr) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        profesor.DatosProfesor port = serviceProfe.getDatosProfesorPort();
        return port.getTodosLosDatosProfe(usr);
    }

    private String getApeMaterno() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        profesor.DatosProfesor port = serviceProfe.getDatosProfesorPort();
        return port.getApeMaterno();
    }

    private String getApePaterno() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        profesor.DatosProfesor port = serviceProfe.getDatosProfesorPort();
        return port.getApePaterno();
    }

    private String getHuella() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        profesor.DatosProfesor port = serviceProfe.getDatosProfesorPort();
        return port.getHuella();
    }

    private String getNombre() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        profesor.DatosProfesor port = serviceProfe.getDatosProfesorPort();
        return port.getNombre();
    }

    private String getEmail() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        profesor.DatosProfesor port = serviceProfe.getDatosProfesorPort();
        return port.getEmail();
    }
    /*Fin Profesor*/
}
