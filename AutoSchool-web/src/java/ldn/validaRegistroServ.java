/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldn;

import acceso.Registro_Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Alumno
 */
public class validaRegistroServ extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/wsAutoSchool/registro.wsdl")
    private Registro_Service service;

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
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            String resultado;
            String tipoUsr;
            String nombre;
            String paterno;
            String materno;
            String semestre;
            String turno;
            String grupo;
            String grupoCompleto;
            String usr;
            String contra;
            String nContra;
            String xEmail;
            String huella;
            String registro;
            String msg = "Profesor";
            tipoUsr = request.getParameter("tipoUser");
            nombre = request.getParameter("nombre");
            paterno = request.getParameter("paterno");
            materno = request.getParameter("materno");
            semestre = request.getParameter("semestre");
            turno = request.getParameter("turno");
            grupo = request.getParameter("grupo");
            usr = request.getParameter("gametag");
            contra = request.getParameter("contra");
            nContra = request.getParameter("ncontra");
            huella = request.getParameter("huella");
            xEmail = request.getParameter("email");
            registro = request.getParameter("registro");

            if (registro == null) {
                response.sendRedirect("index.jsp");
            } else if (!tipoUsr.equals("1") && nombre != "" && paterno != "" && materno != ""
                    && semestre != "0" && semestre != "" && turno != "" && turno != "0" && grupo != ""
                    && grupo != "0" && usr != "" && contra != "" && nContra != "" && huella != "" && xEmail != "") {
                try {
                    grupoCompleto = semestre + "I" + turno + grupo;
                    if (tipoUsr.equals("2")) {
                        resultado = registroUsr(nombre, paterno, materno, huella, usr, contra, tipoUsr, "PROF", xEmail);
                    } else {
                        resultado = registroUsr(nombre, paterno, materno, huella, usr, contra, tipoUsr, grupoCompleto, xEmail);
                    }
                    if (resultado.equalsIgnoreCase("Maestro registrado con exito") || resultado.equalsIgnoreCase("Alumno registrado con exito")) {
                        out.print("<script>alert('"+resultado+"');"
                                + "</script>");
                        ldn.cMail mail = new ldn.cMail();
                        if (mail.enviarCorreo(xEmail, mail.mensajito(getxId()), "Confirmación")) {
                            out.print("<script>alert('Correo de confirmación enviado.');"
                                    + "document.location.href='registro.jsp';"
                                    + "</script>");
                        } else {
                            out.print("<script>alert('Falló el envío del correo');"
                                    + "document.location.href='registro.jsp';"
                                    + "</script>");
                        }
                    } else {
                        out.print("<script>alert('" + resultado + "');"
                                + "var pagina = 'javascript:history.go(-1)'; "
                                + "document.location.href=pagina;"
                                + "</script>");
                    }
                } catch (Exception e) {
                    out.print("<script>alert('" + e.getMessage() + "');"
                                + "var pagina = 'javascript:history.go(-1)'; "
                                + "document.location.href=pagina;"
                                + "</script>");
                }
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

    private String registroUsr(java.lang.String nombre, java.lang.String paterno, java.lang.String materno, java.lang.String huella, java.lang.String usr, java.lang.String pswd, java.lang.String tipoUsr, java.lang.String grupo, java.lang.String email) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        acceso.Registro port = service.getRegistroPort();
        return port.registroUsr(nombre, paterno, materno, huella, usr, pswd, tipoUsr, grupo, email);
    }

    private String getxId() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        acceso.Registro port = service.getRegistroPort();
        return port.getxId();
    }

}
