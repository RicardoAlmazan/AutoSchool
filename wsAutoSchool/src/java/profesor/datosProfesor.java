/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profesor;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Personal
 */
@WebService(serviceName = "datosProfesor")
public class datosProfesor {

    private String _nombre;
    private String _apePaterno;
    private String _apeMaterno;
    private String _usr;
    private String _id;
    private String _psw;
    private String _huella;
    private String _email;
    private String _error;

    @WebMethod(operationName = "getTodosLosDatosProfe")
    public String getTodosLosDatosProfe(@WebParam(name = "usr") String usr) {
        //call autoschool.spConsultaMaestro('richie4')
        BD.cDatos sql = new BD.cDatos();
        try {
            sql.conectar();
            ResultSet spConsulta = sql.consulta("call autoschool.spConsultaMaestro('" + usr + "');");
            if (spConsulta.next()) {
                _id = spConsulta.getString("idPersona");
                _nombre = spConsulta.getString("Nombre");
                _apePaterno = spConsulta.getString("ApellidoPaterno");
                _apeMaterno = spConsulta.getString("ApellidoMaterno");
                _usr = usr;
                _psw = spConsulta.getString("Contraseña");
                _huella = spConsulta.getBinaryStream("Huella").toString();
                _email = spConsulta.getString("Email");
                _error = "No hay error";
            }
            sql.cierraConexion();
        } catch (Exception e) {
            _error = e.toString();
        }
        return _error;
    }

    @WebMethod(operationName = "modificaProfe")
    public String modificaProfe(@WebParam(name = "xid") String xid, @WebParam(name = "name") String name, @WebParam(name = "apePat") String apePat,
            @WebParam(name = "apeMat") String apeMat, @WebParam(name = "xhuella") String xhuella, @WebParam(name = "xUsr") String xUsr,
            @WebParam(name = "xPswd") String xPswd, @WebParam(name = "xEmail") String xEmail) {
        BD.cDatos sql = new BD.cDatos();
        try {
            sql.conectar();
            ResultSet consulta = sql.consulta("call autoschool.spModificaUsr(" + xid + ", '" + name + "', ' " + apePat + "', '" + apeMat + "', "
                    + "'" + xhuella + "', '" + xUsr + "', '" + xPswd + "', '" + xEmail + "');");
            if (consulta.next()) {
                _error = consulta.getString("xMsj");
            }
            sql.cierraConexion();
        } catch (Exception e) {
            _error = e.toString();
        }
        return _error;
    }

    @WebMethod(operationName = "consultaAlumnos")
    public String consultaAlumnos(@WebParam(name = "usr") String usr) {
        BD.cDatos sql = new BD.cDatos();
        ResultSet rsProfes = null;
        ResultSet rsgrupos = null;
        String html = "";
        try {
            sql.conectar();

            rsgrupos = sql.consulta("call spMuestraGruposProfe('" + usr + "');");
            int i = 0;
            ArrayList<String> ide = new ArrayList<String>();
            while (rsgrupos.next()) {
                i++;
                String ides = rsgrupos.getString("idgrupo");
                int sise = ide.size();
                int com = 0;
                if (sise == 0) {
                    ide.add(ides);
                    com = 1;
                } else {
                    for (int o = 0; o < sise; o++) {
                        if (ide.get(o).equals(ides)) {
                            com = 0;
                            break;
                        } else {
                            com = 1;
                        }
                    }
                }
                if (com == 1) {
                    ide.add(ides);
                    String ide2 = rsgrupos.getString("grupo");
                    html += "                        <div class=\"accordion\" id=\"toggleArea\">\n"
                            + "\n"
                            + "                            <div class=\"accordion-group\">\n"
                            + "                                <div class=\"accordion-heading togglize\">\n"
                            + "                                    <a class=\"accordion-toggle\" data-toggle=\"collapse\" data-parent=\"#\" href=\"#collapse" + i + "\">\n"
                            + "                                         " + ide2 + "\n"//El título
                            + "                                        <span class=\"font-icon-plus\"></span>\n"
                            + "                                        <span class=\"font-icon-minus\"></span>\n"
                            + "                                    </a>\n"
                            + "                                </div>\n"
                            + "                                <div id=\"collapse" + i + "\" class=\"accordion-body collapse\">\n"
                            + "                                    <div class=\"accordion-inner\" charset=UTF-8>"
                            //aqui comienza la tabla
                            + "<table class=\"table  table-bordered\">"
                            + "<thead>\n"
                            + "        <tr style='background-color: rgba(66, 113, 139, 0.6); color: white;'>\n"
                            + "            <th>Nombre</th>\n"
                            + "            <th>A.Paterno</th>\n"
                            + "            <th>A.Materno</th>\n"
                            + "        </tr>\n"
                            + "    </thead>";

                    rsProfes = sql.consulta("call spMuestraAlumnosGrupo(" + ides + ");");

                    while (rsProfes.next()) {
                        html += "<tr>";
                        html += "<td>";
                        html += rsProfes.getString("Nombre");
                        html += "</td>";
                        html += "<td>";
                        html += rsProfes.getString("apePat");
                        html += "</td>";
                        html += "<td>";
                        html += rsProfes.getString("apeMat");
                        html += "</td>";
                        html += "</tr>";
                    }
                    html += "</table>"
                            + "                                    </div>\n"
                            + "                                </div>\n"
                            + "                            </div>\n"
                            + "                        </div>";
                }

            }
            sql.cierraConexion();
        } catch (Exception xxxxD) {
            //this._error = "<script>alert('"+xxxxD.getMessage()+"');</script>";
            html = "<script>alert('" + xxxxD.getMessage().replace("'", "") + "');</script>";
        }
        return html;

    }

    @WebMethod(operationName = "getNombre")
    public String getNombre() {
        return _nombre;
    }

    @WebMethod(operationName = "getApePaterno")
    public String getApePaterno() {
        return _apePaterno;
    }

    @WebMethod(operationName = "getApeMaterno")
    public String getApeMaterno() {
        return _apeMaterno;
    }

    @WebMethod(operationName = "getUsr")
    public String getUsr() {
        return _usr;
    }

    @WebMethod(operationName = "getContra")
    public String getContra() {
        return _psw;
    }

    @WebMethod(operationName = "getId")
    public String getId() {
        return _id;
    }

    @WebMethod(operationName = "getHuella")
    public String getHuella() {
        return _huella;
    }

    @WebMethod(operationName = "getEmail")
    public String getEmail() {
        return _email;
    }

    @WebMethod(operationName = "getGrupos")
    public ArrayList<String> getGrupos(@WebParam(name = "usr") String usr) {
        ArrayList<String> obj;
        obj = new ArrayList<String>();
        BD.cDatos sql = new BD.cDatos();
        try {
            int i = 0;
            int com = 0;
            sql.conectar();
            ResultSet rs = sql.consulta("call spMuestraGruposProfe('" + usr + "');");
            while (rs.next()) {
                if (i == 0) {
                    obj.add(rs.getString("grupo"));
                }
                for (int j = 0; j < obj.size(); j++) {
                    if (obj.get(j).equals(rs.getString("grupo"))) {
                        com = 1;
                    }
                }
                if (com != 1) {
                    obj.add(rs.getString("grupo"));
                }
                com = 0;
                i++;
            }
        } catch (Exception e) {
            obj.set(0, e.getMessage());
        }
        return obj;
    }

    @WebMethod(operationName = "asistencia")
    public ArrayList<asistAlumnos> asistencia(@WebParam(name = "usr") String usr) {
        ArrayList<asistAlumnos> obj;
        obj = new ArrayList<asistAlumnos>();
        ArrayList<String> obj2;
        obj2 = new ArrayList<String>();
        obj2 = getGrupos(usr);
        String nom, id;
        BD.cDatos sql = new BD.cDatos();
        try {
            sql.conectar();
            for (int j = 0; j < obj2.size(); j++) {

                ResultSet rs = sql.consulta("call spMuestraAlumnosGrupo2('" + obj2.get(j) + "');");
                while (rs.next()) {
                    asistAlumnos temp = new asistAlumnos();
                    nom = rs.getString("Nombre") + " " + rs.getString("ApePat") + " "
                            + rs.getString("ApeMat");
                    id = rs.getString("idPersona");
                    temp.setNom(nom);
                    temp.setId(id);
                    obj.add(temp);
                }
                int tam = obj.size();
                ResultSet rsDos = sql.consulta("call spMuestraAsisGrupo('" + obj2.get(j) + "');");
                while (rsDos.next()) {
                    id = rsDos.getString("idPersona");
                    for (int i = 0; i < tam; i++) {
                        if (id.equalsIgnoreCase(obj.get(i).getId())) {
                            obj.get(i).setAsistencia(true);
                        }
                    }
                }

            }
            sql.cierraConexion();
        } catch (Exception e) {
            obj.get(0).setNom(e.getMessage());
        }
        return obj;
    }
}
