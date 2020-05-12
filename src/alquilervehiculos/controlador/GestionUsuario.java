/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.controlador;

import alquilervehiculos.modelo.Cliente;
import alquilervehiculos.modelo.TipoUsuario;
import alquilervehiculos.modelo.Usuario;
import alquilervehiculos.utilidades.EscribirArchivoPlano;
import alquilervehiculos.utilidades.LeerCsv;
import com.sun.security.ntlm.Client;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhonathan_G
 */
public class GestionUsuario {
    
    private TipoUsuario[] tipoUsuarios;
    private List<Usuario> usuarios;
    private List<Cliente> clientes;
    
    
    public GestionUsuario() {
        llenarTiposUsuario();
        llenarUsuarios();
        
    }
    
    public void llenarTiposUsuario() {
        tipoUsuarios = new TipoUsuario[3];
        tipoUsuarios[0] = new TipoUsuario("1", "Administrador");
        tipoUsuarios[1] = new TipoUsuario("2", "Consulta");
        tipoUsuarios[2] = new TipoUsuario("3", "Cliente");
    }
    
    public void llenarUsuarios() {
        
        usuarios = LeerCsv.cargarUsuarios(tipoUsuarios);
    }
    
    public void llenarClientes() {
        
        clientes = LeerCsv.cargarClientes(tipoUsuarios);
    }
    
    public Usuario validarUsuario(String login, String passwd) {
        
        for (Usuario usuarioEncontrado : usuarios) {
            
            if (usuarioEncontrado.getLogin().compareTo(login) == 0
                    && usuarioEncontrado.getPasswd().compareTo(passwd) == 0) {
                return usuarioEncontrado;
            }
        }
        
        return null;
    }
    
    private boolean ValidarExixtenciaCliete(Cliente cliente) {
        
        for (Cliente cli : this.clientes) {
            
            if (cli.getCedula().compareTo(cliente.getCedula()) == 0) {
                
                return true;
            }
        }
        
        return false;
    }
    
    public void adicionarCliente(Cliente cliente) {
        
        if (ValidarExixtenciaCliete(cliente)) {
            
            JOptionPane.showMessageDialog(null, "EL CLIENTE YA EXISTE  " + cliente.getCedula());
            
        } else {
            
            clientes.add(cliente);

            //Agregar a el archivo original
            EscribirArchivoPlano.ExportarCliente(clientes);
            JOptionPane.showMessageDialog(null, "CLIENTE CREADO EXITOSAMENTE ");
        }
    }
    
    
   
        
        
    
    
    private boolean ValidarExitenciaUsuario(Usuario usuario) {
        
        for (Usuario usu : this.usuarios) {
            
            if (usu.getCedula().compareTo(usuario.getCedula()) == 0 || usu.getLogin().compareTo(usuario.getLogin()) == 0) {
                
                return true;
            }
        }
        return false;
        
    }
    
    public void adicionarUsuario(Usuario usuario) {
        
        if (ValidarExitenciaUsuario(usuario)) {
            
            JOptionPane.showMessageDialog(null, "EL USUARIO YA EXISTE  " + usuario.getCedula() + " | " + usuario.getLogin());
            
        } else {
            
            usuarios.add(usuario);

            //Agregar a el archivo original
            EscribirArchivoPlano.ExportarUsuario(usuarios);
            JOptionPane.showMessageDialog(null, "USUARIO CREADO EXITOSAMENTE ");
        }
        
    }
    
    public TipoUsuario[] getTipoUsuarios() {
        return tipoUsuarios;
    }
    
    public void setTipoUsuarios(TipoUsuario[] tipoUsuarios) {
        this.tipoUsuarios = tipoUsuarios;
    }
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public List<Cliente> getClientes() {
        return clientes;
    }
    
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
}
