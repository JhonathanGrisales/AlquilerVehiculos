/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.modelo;

import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhonathan_G
 */
public class AlquilaVehiculo implements Serializable {

    public AbstractVehiculo vehiculo;
    public Usuario usuario;
    public Cliente cliente;
    public int kmFinales;
    public String matricula;
    public String cedulaCliente;
    public String nombreUsuario;

    public AlquilaVehiculo(AbstractVehiculo vehiculo, Usuario usuario, int kmFinales) {
        this.vehiculo = vehiculo;
        this.usuario = usuario;
        
        this.kmFinales = kmFinales;
    }

    public AlquilaVehiculo(String matricula, String cedulaCliente, String nombreUsuario) {
        this.matricula = matricula;
        this.cedulaCliente = cedulaCliente;
        this.nombreUsuario = nombreUsuario;
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

    public void AlquilarVehiculo() {

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getKmFinales() {
        return kmFinales;
    }

    public void setKmFinales(int kmFinales) {
        this.kmFinales = kmFinales;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    
    

    public double calcularAlquiler(AbstractVehiculo vehiculo, Usuario usuario, int kmRecorridos) {

        if (vehiculo instanceof Moto) {

            double valorAlquiler;

            if (((Moto) vehiculo).isCasco()) {

                valorAlquiler = vehiculo.calcularAlquiler(kmRecorridos) + 5000;

            } else {

                valorAlquiler = vehiculo.calcularAlquiler(kmRecorridos);
            }
            return valorAlquiler;

        } else if (vehiculo instanceof Coche) {

        }
        return 0;

    }
    
    
    
    
    public String[] getArray() {

        String[] datos = {String.valueOf(matricula), String.valueOf(cedulaCliente), String.valueOf(nombreUsuario)};

        return datos;
    }
    
    public Object[] obtenerArregloObjeto(){
        Object[] data={ getMatricula(),getCedulaCliente(),getNombreUsuario()};
        return data;
    }
}
