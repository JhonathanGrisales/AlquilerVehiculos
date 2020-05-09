/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.modelo;

import java.io.Serializable;

/**
 *
 * @author Jhonathan_G
 */
public class Usuario implements Serializable{
    
    public String cedula;
    public String nombre;
    public String login;
    public String passwd;
    private TipoUsuario tipoUsuario;

    public Usuario(String cedula, String nombre, String login, String passwd, TipoUsuario tipoUsuario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.login = login;
        this.passwd = passwd;
        this.tipoUsuario = tipoUsuario;
    } 
    
    
    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return this.nombre.toUpperCase();
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    public String [] getArray(){
        
        String[] datos = {String.valueOf(cedula), String.valueOf(nombre), String.valueOf(login),String.valueOf(passwd), String.valueOf(tipoUsuario.getCodigo())};
      
        return datos;
    }
    
    
 public Object[] obtenerArregloObjeto(){
        Object[] data={getCedula(),getNombre(),getLogin(),getPasswd(),getTipoUsuario().getCodigo()};
        return data;
     
     }
    
}
