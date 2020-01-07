/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldn;

import javax.swing.JLabel;

/**
 *
 * @author Alumno
 */
public class Equipos {
    public JLabel icono = new JLabel();
    private String ip;
    private String mac;
    private int pocision;
    private int State = 0;

    public int getState() {
        return State;
    }

    public void setState(int State) {
        this.State = State;
    }

    public Equipos(String ip, String mac) {
        this.mac = mac;
        this.ip = ip;
    }

    public int getPocision() {
        return pocision;
    }

    public void setPocision(int pocision) {
        this.pocision = pocision;
    }

    
    public JLabel getIcono() {
        return icono;
    }

    public void setIcono(JLabel icono) {
        this.icono = icono;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }
    
 }
