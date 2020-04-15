/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.controlador;

import alquilervehiculos.modelo.Coche;
import alquilervehiculos.modelo.Moto;
import alquilervehiculos.utilidades.EscribirArchivoPlano;
import alquilervehiculos.utilidades.LeerCsv;
import static alquilervehiculos.utilidades.LeerCsv.cargarCoches;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhonathan_G
 */
public class GestionVehiculo implements Serializable {

    private List<Coche> coches;
    private List<Moto> motos;

    public void GestionVehiculo() {

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

        if (coches == null || coches.isEmpty()) {
            coches = LeerCsv.cargarCoches();
        }

    }

    public void llenarMotos() {

        if (motos == null || motos.isEmpty()) {

            motos = LeerCsv.cargarMotos();
        }

    }

    /// Adicionar Coches 
    public void adicionarCoches(Coche coche) {

        if (ValidarExitenciaCarro(coche)) {

            JOptionPane.showMessageDialog(null, "El vehiculo ya existe " + coche.getMatricula());

        } else {

            //        coches = LeerCsv.cargarCoches();
            coches.add(coche);
            //Agregar a el archivo original 
            EscribirArchivoPlano.ExportarCoches(coches);
        }

    }

    private boolean ValidarExitenciaCarro(Coche coche) {

        for (Coche co : this.coches) {

            if (co.getMatricula().compareTo(coche.getMatricula()) == 0) {

                return true;
            }
        }
        return false;

    }

    ///Adicionar motos
    public void adicionarMotos(Moto moto) {

        if (ValidarExitenciaMoto(moto)) {

            JOptionPane.showMessageDialog(null, "El vehiculo ya existe " + moto.getMatricula());

        } else {

            //        coches = LeerCsv.cargarCoches();
            motos.add(moto);
            //Agregar a el archivo original 
            
        }

    }

    private boolean ValidarExitenciaMoto(Moto moto) {

        for (Moto mot : this.motos) {

            if (mot.getMatricula().compareTo(moto.getMatricula()) == 0) {

                return true;
            }
        }
        return false;

    }
}
