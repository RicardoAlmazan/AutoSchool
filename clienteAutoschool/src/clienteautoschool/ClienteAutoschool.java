package clienteautoschool;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JOptionPane;

public class ClienteAutoschool {
    public static void main(String[] args) {
       Socket socket;
       String ip = JOptionPane.showInputDialog("Ingrese la ip a la que se intenta conectar: ");
       while (1==1){
        try {
            
            System.out.println("conectando");
            
            //"192.168.43.208"
            socket = new Socket(ip,1234);
            
            System.out.println("conectado");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(InetAddress.getLocalHost() + "conectado");
            while (1==1)
            {
                String mensaje = in.readUTF();
                if (mensaje != null && mensaje != "")
                {
                    String salida = null;
                    String regreso = "";
                    String comand = "cmd /c " + mensaje;//start cmd.exe logoff";

                    try {

                        // Ejecucion Basica del Comando
                        Process proceso = Runtime.getRuntime().exec(comand);

                        InputStreamReader entrada = new InputStreamReader(proceso.getInputStream());
                        BufferedReader stdInput = new BufferedReader(entrada);

                        //Si el comando tiene una salida la mostramos
                        if ((salida = stdInput.readLine()) != null) {
                            System.out.println("Comando ejecutado Correctamente");
                            while ((salida = stdInput.readLine()) != null) {
                                System.out.println(salida);
                            }
                        } else {
                        }
                    } catch (IOException e) {
                        System.out.println("Excepción: ");
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("reconectando...");
        }
       }
    }
    
}
