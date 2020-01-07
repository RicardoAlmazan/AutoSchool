/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador;

import java.sql.ResultSet;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "administrador")
public class administrador {

    String tipoUsr;
    String idUsr;
    private String _nombre;
    private String _apePaterno;
    private String _apeMaterno;
    private String _usr;
    private String _grupo;
    private String _error;

    @WebMethod(operationName = "buscarUsr")
    public String buscarUsr(@WebParam(name = "usr") String usr) {
        BD.cDatos sql = new BD.cDatos();
        String msj = "";
        try {
            sql.conectar();
            ResultSet rs = sql.consulta("call spBuscaUsr('" + usr + "');");
            if (rs.next()) {
                msj = rs.getString("Msj");
                idUsr = rs.getString("idUsr");
                tipoUsr = rs.getString("tipoUsr");
            }
            sql.cierraConexion();

        } catch (Exception e) {
            msj = e.getMessage();
        }
        return msj;
    }

    @WebMethod(operationName = "consultaEquipos")
    public String consultaEquipos() {
        String html = "";
        int i = 0;
        ResultSet res = null;
        BD.cDatos sql = new BD.cDatos();
        try {
            sql.conectar();
            res = sql.consulta("call sp_consultaEquipos();");
            html += "<table class=\"table  table-bordered\" style='background-color: #2E9BDB; color: white;'>"
                    + "<thead>\n"
                    + "        <tr style='background-color: #02588B; color: white;'>\n"
                    + "            <th>#</th>\n"
                    + "            <th>Dirección IP</th>\n"
                    + "            <th>Estado</th>\n"
                    + "        </tr>\n"
                    + "    </thead>";

            while (res.next()) {
                html += "<tr>";
                html += "<td>";
                html += res.getString("idEquipo");
                html += "</td>";
                html += "<td>";
                html += res.getString("ip");
                html += "</td>";
                if (res.getString("estatus").equals("1")) {
                    html += "<td bgcolor=\"#348B5C\">";
                    html += "Encendido";
                } else {
                    html += "<td bgcolor=\"#F56060\">";
                    html += "Apagado";
                }
                html += "</td>";
                html += "</tr>";
            }
            html += "</table>";

            sql.cierraConexion();
        } catch (Exception e) {
            html = e.getMessage();
        }
        return html;
    }

    @WebMethod(operationName = "getTipoUsr")
    public String getTipoUsr() {
        return tipoUsr;
    }

    @WebMethod(operationName = "getIdUsr")
    public String getIdUsr() {
        return idUsr;
    }

    @WebMethod(operationName = "getTodosLosDatosAlumno")
    public String getTodosLosDatosAlumno(@WebParam(name = "usr") String usr) {
        BD.cDatos sql = new BD.cDatos();
        try {
            sql.conectar();
            ResultSet spConsulta = sql.consulta("call autoschool.spConsultaAlumno('" + usr + "');");
            if (spConsulta.next()) {
                _nombre = spConsulta.getString("Nombre");
                _apePaterno = spConsulta.getString("ApellidoPaterno");
                _apeMaterno = spConsulta.getString("ApellidoMaterno");
                _usr = usr;
                _grupo = spConsulta.getString("Grupo");
                _error = "No hay error";
            }
            sql.cierraConexion();
        } catch (Exception e) {
            _error = e.toString();
        }
        return _error;
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

    
    @WebMethod(operationName = "getGrupo")
    public String getGrupo() {
        return _grupo;
    }
}
