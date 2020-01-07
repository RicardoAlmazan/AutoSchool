/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profesor;

/**
 *
 * @author CECyT9
 */
public class asistAlumnos {
    String _nom;
    String _id;
    boolean _asistencia;

    public asistAlumnos() {
        this._asistencia = false;
    }

    
    public String getNom() {
        return _nom;
    }

    public void setNom(String _nom) {
        this._nom = _nom;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }


    public boolean isAsistencia() {
        return _asistencia;
    }

    public void setAsistencia(boolean _asistencia) {
        this._asistencia = _asistencia;
    }
    
}
