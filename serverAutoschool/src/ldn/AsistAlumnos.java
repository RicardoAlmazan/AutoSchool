/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldn;

/**
 *
 * @author CECyT9
 */
public class AsistAlumnos {
    String _nom;
    int _id;
    boolean _asistencia;

    public AsistAlumnos() {
        this._asistencia = false;
    }

    
    public String getNom() {
        return _nom;
    }

    public void setNom(String _nom) {
        this._nom = _nom;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }


    public boolean isAsistencia() {
        return _asistencia;
    }

    public void setAsistencia(boolean _asistencia) {
        this._asistencia = _asistencia;
    }
    
}
