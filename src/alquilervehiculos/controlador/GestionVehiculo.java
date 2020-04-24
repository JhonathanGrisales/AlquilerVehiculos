/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.controlador;

import alquilervehiculos.modelo.AbstractVehiculo;
import alquilervehiculos.modelo.Coche;
import alquilervehiculos.modelo.Moto;
import alquilervehiculos.utilidades.EscribirArchivoPlano;
import alquilervehiculos.utilidades.LeerCsv;
import static alquilervehiculos.utilidades.LeerCsv.cargarCoches;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhonathan_G
 */
public class GestionVehiculo implements Serializable {

    private List<AbstractVehiculo> vehiculos;

    public GestionVehiculo() {

        llenarVehiculos();

    }

    public void llenarVehiculos() {
        vehiculos = new ArrayList<>();

        vehiculos = LeerCsv.cargarCoches();

//        if (vehiculos == null || vehiculos.isEmpty()) {
//            vehiculos = LeerCsv.cargarCoches();
//        }
    }

    public List<AbstractVehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<AbstractVehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public List<AbstractVehiculo> obtenerVehiculos(String tipo) {

        List<AbstractVehiculo> listaTemporal = new ArrayList<>();

        //Ciclo para recorrer todos los vehiculos y extraer lo neceario 
        for (AbstractVehiculo vehiculo : vehiculos) {

            switch (tipo) {
                case "Coche":
                    if (vehiculo instanceof Coche) {
                        listaTemporal.add(vehiculo);

                    }
                    break;

                case "Moto":
                    if (vehiculo instanceof Moto) {
                        listaTemporal.add(vehiculo);
                    }
                    break;

            }

        }
        return listaTemporal;

    }
}

/// Adicionar Coches 
//public void adicionarCoches(Coche coche) {
//
//        if (ValidarExitenciaCarro(coche)) {
//
//            JOptionPane.showMessageDialog(null, "El vehiculo ya existe " + coche.getMatricula());
//
//        } else {
//
//            //        coches = LeerCsv.cargarCoches();
//            coches.add(coche);
//            //Agregar a el archivo original 
//            EscribirArchivoPlano.ExportarCoches(coches);
//        }
//
//    }
//
//    private boolean ValidarExitenciaCarro(Coche coche) {
//
//        for (Coche co : this.coches) {
//
//            if (co.getMatricula().compareTo(coche.getMatricula()) == 0) {
//
//                return true;
//            }
//        }
//        return false;
//
//    }
//
//    ///Adicionar motos
//    public void adicionarMotos(Moto moto) {
//
//        if (ValidarExitenciaMoto(moto)) {
//
//            JOptionPane.showMessageDialog(null, "El vehiculo ya existe " + moto.getMatricula());
//
//        } else {
//
//            //        coches = LeerCsv.cargarCoches();
//            motos.add(moto);
//            //Agregar a el archivo original 
//
//        }
//
//    }
//
//    private boolean ValidarExitenciaMoto(Moto moto) {
//
//        for (Moto mot : this.motos) {
//
//            if (mot.getMatricula().compareTo(moto.getMatricula()) == 0) {
//
//                return true;
//            }
//        }
//        return false;
//
//  }
//}
