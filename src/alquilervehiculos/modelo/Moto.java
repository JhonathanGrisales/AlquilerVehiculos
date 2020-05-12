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
public class Moto extends AbstractVehiculo implements Serializable{

    public boolean casco;

    public Moto(boolean casco, String matricula, int km, boolean estado, double valorAlquiler) {
        super(matricula, km, estado, valorAlquiler);
        this.casco = casco;
    }

    public boolean isCasco() {
        return casco;
    }

    public void setCasco(boolean casco) {
        this.casco = casco;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getValorAlquiler() {
        return valorAlquiler;
    }

    public void setValorAlquiler(double valorAlquiler) {
        this.valorAlquiler = valorAlquiler;
    }

    @Override
    public double calcularAlquiler(int kmRecorridos) {

       return 5000 *kmRecorridos;
    }

    //Areglo de objetos para meter en la tabla 
    public Object[] obtenerArregloObjeto() {
        Object[] data = {isCasco(), getMatricula(), getKm(), isEstado(), getValorAlquiler()};
        return data;
    }

    //MODIFICAR
    @Override
    public String[] getArray() {

        String[] datos = {String.valueOf(casco), matricula, String.valueOf(km), String.valueOf(estado), String.valueOf(valorAlquiler)};

        return datos;

    }

    @Override
    public Object[] obtenerArregloObjetoDos() {
        Object[] data={getMatricula(),getKm(),getValorAlquiler(),getClass().getSimpleName(), isEstado()};
        return data;
    }

    
    
    
}
