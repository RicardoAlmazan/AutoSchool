package acceso;

import java.sql.ResultSet;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "registro")
public class registro {

    String _xid;

    @WebMethod(operationName = "registroUsr")
    public String registroUsr(@WebParam(name = "nombre") String nombre, @WebParam(name = "paterno") String paterno,
            @WebParam(name = "materno") String materno, @WebParam(name = "huella") String huella,
            @WebParam(name = "usr") String usr, @WebParam(name = "pswd") String pswd,
            @WebParam(name = "tipoUsr") String tipoUsr, @WebParam(name = "grupo") String grupo, @WebParam(name = "email") String email) {
        String regreso = "";

        BD.cDatos sql = new BD.cDatos();

        try {
            sql.conectar();
            ResultSet consulta = sql.consulta("call autoschool.sp_RegistraUsr('" + nombre + "', '" + paterno + "', "
                    + "'" + materno + "', '" + huella + "', '" + usr + "', '" + pswd + "', " + tipoUsr + ", '" + grupo + "', '"+email+"');");
            if (consulta.next()) {
                regreso = consulta.getString("Msj");
                _xid = consulta.getString("idUsr");
            }
            sql.cierraConexion();
        } catch (Exception e) {
            regreso = e.toString();
        }

        return regreso;
    }

    @WebMethod(operationName = "getxId")
    public String getxId() {
        return _xid;
    }
}
