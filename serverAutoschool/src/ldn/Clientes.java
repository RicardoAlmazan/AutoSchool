package ldn;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Clientes {

    boolean mas = true;
    String ip = "";
    ServerSocket socket;
    public Socket socket_cli;

    public Socket getSocket_cli() {
        return socket_cli;
    }

    public String getIp() {
        return ip;
    }

    public Clientes() {
        try {
            socket = new ServerSocket(1234);
            socket.setSoTimeout(1000);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public boolean Trying() {
        boolean exito = false;
        try {

            System.out.println("esperando...");
            socket_cli = socket.accept();
            ip = socket_cli.getInetAddress() + "";
            ip = ip.substring(1, ip.length());
            DataInputStream msg = new DataInputStream(socket_cli.getInputStream());
            System.out.println(msg.readUTF() + "");
            exito = true;
            socket.close();

        } catch (Exception e) {
            exito = false;
            try {
                socket.close();
            } catch (Exception x) {
                System.out.println(x.toString());
            }

        }
        return exito;
    }
}
