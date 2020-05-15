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
public class AlquilarVehiculo implements Serializable {

    public AbstractVehiculo vehiculo;
    public Usuario usuario;

    public String cedulaCliente;
    public String fechaInicio;
    public String fechaFin;
    public String matricula;
    public String restricciones;
    public String usuarioAlquiler;
    public int diasAlquiler;
    public int kmFinales;

    public AlquilarVehiculo(AbstractVehiculo vehiculo, Usuario usuario, int kmFinales) {
        this.vehiculo = vehiculo;
        this.usuario = usuario;
        this.kmFinales = kmFinales;
    }

    public AlquilarVehiculo(String matricula, String cedulaCliente, String restricciones, String usuarioAlquiler,
            String fechaInicio, String fechaFin, int diasAlquiler) {

        this.usuarioAlquiler = usuarioAlquiler;
        this.cedulaCliente = cedulaCliente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.diasAlquiler = diasAlquiler;
        this.matricula = matricula;
        this.restricciones = restricciones;
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

    public int getKmFinales() {
        return kmFinales;
    }

    public void setKmFinales(int kmFinales) {
        this.kmFinales = kmFinales;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getDiasAlquiler() {
        return diasAlquiler;
    }

    public void setDiasAlquiler(int diasAlquiler) {
        this.diasAlquiler = diasAlquiler;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getRestricciones() {
        return restricciones;
    }

    public void setRestricciones(String restricciones) {
        this.restricciones = restricciones;
    }

    public String getUsuarioAlquiler() {
        return usuarioAlquiler;
    }

    public void setUsuarioAlquiler(String usuarioAlquiler) {
        this.usuarioAlquiler = usuarioAlquiler;
    }

    public double calcularAlquiler(AbstractVehiculo vehiculo, Usuario usuario, int kmRecorridos) {

        double valorAlquiler = 0;

        if (vehiculo instanceof Moto) {

//            double valorAlquiler;
            if (((Moto) vehiculo).isCasco()) {

                valorAlquiler = vehiculo.calcularAlquiler(kmRecorridos) + 5000;

            } else {

                valorAlquiler = vehiculo.calcularAlquiler(kmRecorridos);
            }

            return valorAlquiler;

        } else if (vehiculo instanceof Coche) {

            double valoAlquiler;

            if (((Coche) vehiculo).isExtras()) {

                valoAlquiler = vehiculo.calcularAlquiler(kmRecorridos) + 5000;

            } else {

                valoAlquiler = vehiculo.calcularAlquiler(kmRecorridos);

            }
            return valoAlquiler;

        } else if (vehiculo instanceof Furgoneta) {

            double incrementoCapacidad = (((Furgoneta) vehiculo).getCapacidad() * 10000);
            valorAlquiler = vehiculo.calcularAlquiler(kmRecorridos) + incrementoCapacidad;

            return valorAlquiler;

        }
        return valorAlquiler;

    }

    public Object[] obtenerArregloObjeto() {
        Object[] data = {getMatricula(), getCedulaCliente(), getRestricciones(), getUsuarioAlquiler(),
            getFechaInicio(), getFechaFin(), getDiasAlquiler()};
        return data;
    }

    //MODIFICAR
    public String[] getArray() {

        String[] datos = {String.valueOf(matricula), String.valueOf(cedulaCliente), String.valueOf(restricciones),
            String.valueOf(usuarioAlquiler), String.valueOf(fechaInicio), String.valueOf(fechaFin), String.valueOf(diasAlquiler)};

        return datos;

    }

}
