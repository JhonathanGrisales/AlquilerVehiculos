/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.modelo;

import java.util.List;

/**
 *
 * @author Jhonathan_G
 */
public abstract class AbstractVehiculo {

    //Atributos normales para esta clase 
    public String matricula;
    public int km;
    public boolean estado;
    public double valorAlquiler;

    public AbstractVehiculo(String matricula, int km, boolean estado, double valorAlquiler) {
        this.matricula = matricula;
        this.km = km;
        this.estado = estado;
        this.valorAlquiler = valorAlquiler;
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
    

    public void alquilar() {

    }
    
    public void devolver (int kmFinal){
        
    }
    
    public abstract double calcularAlquiler (int km);

    public void mostrarDatos(){
        
    }
    
    public abstract Object[] obtenerArregloObjeto();
    
    public abstract Object[] obtenerArregloObjetoDos();
    
     public abstract String [] getArray();
     
     

    
   
    

}
