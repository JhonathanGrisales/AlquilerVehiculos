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
public class Furgoneta extends AbstractVehiculo implements Serializable{
    
    public short capacidad;

    public Furgoneta(short capacidad, String matricula, int km, boolean estado, double valorAlquiler) {
        super(matricula, km, estado, valorAlquiler);
        this.capacidad = capacidad;
    }

    public short getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(short capacidad) {
        this.capacidad = capacidad;
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
    public double calcularAlquiler(int km) {
       
        return calcularAlquiler(km);
    }

    @Override
    public Object[] obtenerArregloObjeto() {
        Object[] data={ getCapacidad(), getMatricula(),getKm(), isEstado(), getValorAlquiler()};
                 return data;
                }
    

    
    //MODIFICAR
   public String [] getArray(){
        
        String[] datos = {String.valueOf(capacidad), matricula,String.valueOf(km),String.valueOf(estado), String.valueOf(valorAlquiler)};
      
        return datos;
    }

    @Override
    public Object[] obtenerArregloObjetoDos() {
        Object[] data={getMatricula(),getKm(),getValorAlquiler(),getClass().getSimpleName(), isEstado()};
        return data;
    }
    
    
    
}
