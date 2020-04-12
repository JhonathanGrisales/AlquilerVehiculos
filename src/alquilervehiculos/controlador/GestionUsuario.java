/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.controlador;

import alquilervehiculos.modelo.TipoUsuario;
import alquilervehiculos.modelo.Usuario;
import alquilervehiculos.utilidades.LeerCsv;
import java.util.List;

/**
 *
 * @author Jhonathan_G
 */
public class GestionUsuario {

    private TipoUsuario[] tipoUsuarios;
    private List<Usuario> usuarios;

    public GestionUsuario() {
        llenarTiposUsuario();
        llenarUsuarios();
        
    }

    private void llenarTiposUsuario() {
        tipoUsuarios = new TipoUsuario[2];
        tipoUsuarios[0] = new TipoUsuario("1", "Administrador");
        tipoUsuarios[1] = new TipoUsuario("2", "Usuario");
    }
    
    private void llenarUsuarios(){
        
        usuarios= LeerCsv.cargarUsuarios(tipoUsuarios);
    }
    
      public Usuario validarUsuario(String login, String passwd){
       
        for(Usuario usuarioEncontrado: usuarios){
            
            if (usuarioEncontrado.getLogin().compareTo(login)==0 && 
                    usuarioEncontrado.getPasswd().compareTo(passwd)== 0)
                
               return usuarioEncontrado;
        }
        
       return null;  
    }

}
