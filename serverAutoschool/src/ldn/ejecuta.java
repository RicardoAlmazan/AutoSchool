package ldn;

import java.io.DataOutputStream;
import java.net.Socket;

public class ejecuta {
    public ejecuta() {
    }
    public String comando(Socket socket_cli, String mensaje){
        String log;
        try{
        DataOutputStream out = new DataOutputStream(socket_cli.getOutputStream());
        out.writeUTF(mensaje);
        log = "codigo ejecutado correctamente";
        }
        catch(Exception e){
            log = "codigo no ejecutado";
        }
        return log;
    }
    
}
