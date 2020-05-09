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
public class Coche extends AbstractVehiculo implements Serializable{
    
    public boolean extras;

    public Coche(boolean extras, String matricula, int km, boolean estado, double valorAlquiler) {
        super(matricula, km, estado, valorAlquiler);
        this.extras = extras;
    }

    public boolean isExtras() {
        return extras;
    }

    public void setExtras(boolean extras) {
        this.extras = extras;
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
    
    //Areglo de objetos para meter en la tabla 
     public Object[] obtenerArregloObjeto(){
        Object[] data={ isExtras(), getMatricula(),getKm(), isEstado(), getValorAlquiler()};
        return data;
    }
     
     public Object[] obtenerArregloObjetoDos(){
        Object[] data={getMatricula(),getKm(),getValorAlquiler(),getClass().getSimpleName(), isEstado()};
        return data;
     
     }
     
      public String [] getArray(){
        
        String[] datos = {String.valueOf(extras), matricula,String.valueOf(km),String.valueOf(estado), String.valueOf(valorAlquiler)};
      
        return datos;
    }
}
