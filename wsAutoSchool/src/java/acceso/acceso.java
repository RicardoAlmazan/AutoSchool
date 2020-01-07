/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acceso;

import java.sql.ResultSet;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Alumno
 */
@WebService(serviceName = "acceso")
public class acceso {

    /**
     * This is a sample web service operation
     */
    private String _id;

    @WebMethod(operationName = "accesoProfesor")
    public String accesoProfesor(@WebParam(name = "usr") String usr, @WebParam(name = "psw") String psw) {
        String regreso = "";

        BD.cDatos sql = new BD.cDatos();

        try {
            sql.conectar();
            ResultSet consulta = sql.consulta("call sp_ValidaUsr('" + usr + "','" + psw + "');");
            if (consulta.next()) {
                regreso = consulta.getString("Msj");
                _id = consulta.getString("idUsr");
            }
            sql.cierraConexion();
        } catch (Exception e) {
        }

        return regreso;
    }

    @WebMethod(operationName = "getDatosProfesor")
    public String getDatosProfesor() {
        return _id;
    }

    @WebMethod(operationName = "activaUsr")
    public String activaUsr(@WebParam(name = "usr") String usr) {
        String regreso = "";

        BD.cDatos sql = new BD.cDatos();

        try {
            sql.conectar();
            ResultSet consulta = sql.consulta("call spModificaEstatus(" + usr + ");");
            if (consulta.next()) {
                regreso = consulta.getString("Msj");

            }
            sql.cierraConexion();
        } catch (Exception e) {
            regreso = e.toString();
        }

        return regreso;
    }
}
