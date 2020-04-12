/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.modelo;

/**
 *
 * @author Jhonathan_G
 */
public class Alquilavehiculo {

    public AbstractVehiculo vehiculo;
    public Usuario usuario;

    public Alquilavehiculo(AbstractVehiculo vehiculo, Usuario usuario) {
        this.vehiculo = vehiculo;
        this.usuario = usuario;
    }

    public AbstractVehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(AbstractVehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    

}
