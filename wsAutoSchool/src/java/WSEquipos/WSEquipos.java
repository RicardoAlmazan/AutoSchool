/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WSEquipos;

import java.sql.ResultSet;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author CECyT9
 */
@WebService(serviceName = "WSEquipos")
public class WSEquipos {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "consultaEquipos")
    public String[] consultaEquipos() {
        int i = 0;
        String[] datos = new String[26];
        ResultSet res = null;
        BD.cDatos sql = new BD.cDatos();
        try {
            sql.conectar();
            res = sql.consulta("call sp_consultaEquipos();");
            while(res.next()){
                datos[i] = res.getString("ip");
                i++;
            }
            sql.cierraConexion();
        } catch (Exception e) {
        }
        return datos;
    }
    @WebMethod(operationName = "prendeApaga")
    public String prendeApaga(@WebParam(name = "status") int status,@WebParam(name = "posi") int posi) {
        String msj = "";
        ResultSet res = null;
        BD.cDatos sql = new BD.cDatos();
        try {
            sql.conectar();
            res = sql.consulta("call prendeapaga("+status+","+posi+");");
            if(res.next()){
                msj = res.getString("msj");
            }
            sql.cierraConexion();
        } catch (Exception e) {
            msj = e.getMessage();
        }
        return msj;
    }

}
