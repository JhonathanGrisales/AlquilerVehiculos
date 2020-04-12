/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.controlador;

import alquilervehiculos.modelo.Coche;
import alquilervehiculos.modelo.Moto;
import alquilervehiculos.utilidades.LeerCsv;
import static alquilervehiculos.utilidades.LeerCsv.cargarCoches;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Jhonathan_G
 */
public class GestionCoche implements Serializable {
    
    private List<Coche> coches;
    private List<Moto> motos;
    
 
    
    
    public  GestionCoche(){
    
        llenarCoches();
        llenarMotos();
 } 

    public List<Coche> getCoches() {
        return coches;
    }

    public void setCoches(List<Coche> coches) {
        this.coches = coches;
    }

    public void setMotos(List<Moto> motos) {
        this.motos = motos;
    }

    public List<Moto> getMotos() {
        return motos;
    }
    
    
     
    public void llenarCoches() {
        
        coches = LeerCsv.cargarCoches();
    
}
    public void llenarMotos(){
        
        motos = LeerCsv.cargarMotos();
    }
    
}
