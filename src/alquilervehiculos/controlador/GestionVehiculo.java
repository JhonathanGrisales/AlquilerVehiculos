/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.controlador;

import alquilervehiculos.modelo.AbstractVehiculo;
import alquilervehiculos.modelo.Coche;
import alquilervehiculos.modelo.Furgoneta;
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

        if (vehiculos == null || vehiculos.isEmpty()) {
            vehiculos = LeerCsv.cargarCoches();
        }
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
                    
                    case "Furgoneta":
                    if (vehiculo instanceof Furgoneta) {
                        listaTemporal.add(vehiculo);
                    }
                    break;

            }

        }
        return listaTemporal;

    }
    
    
//    public boolean eliminarCoche(AbstractVehiculo vehiculo){
//        
//       for (AbstractVehiculo coche : vehiculos) {
//           
//           if (vehiculo.getMatricula() == )
//       }
//
//            
//        
//        
//    }

/// Adicionar Coches 
    public void adicionarCoches(AbstractVehiculo coche) {

        if (ValidarExitenciaCarro(coche)) {

            JOptionPane.showMessageDialog(null, "El vehiculo ya existe " + coche.getMatricula());

        } else {

            vehiculos.add(coche);

            //Agregar a el archivo original
            EscribirArchivoPlano.ExportarCoches(vehiculos);

        }

    }

    private boolean ValidarExitenciaCarro(AbstractVehiculo vehiculo) {

        for (AbstractVehiculo coche : this.vehiculos) {

            if (coche.getMatricula().compareTo(vehiculo.getMatricula()) == 0) {

                return true;
            }
        }
        return false;

    }

/// Adicionar Motos
    public void adicionarMotos(AbstractVehiculo moto) {

        if (ValidarExitenciaMoto(moto)) {

            JOptionPane.showMessageDialog(null, "El vehiculo ya existe " + moto.getMatricula());

        } else {

            vehiculos.add(moto);

            //Agregar a el archivo original
            EscribirArchivoPlano.ExportarMotos(vehiculos);

        }

    }

    private boolean ValidarExitenciaMoto(AbstractVehiculo vehiculo) {

        for (AbstractVehiculo moto : this.vehiculos) {

            if (moto.getMatricula().compareTo(vehiculo.getMatricula()) == 0) {

                return true;
            }
        }
        return false;

    } 
    
    
    /// Adicionar Motos
    public void adicionarFurgon(AbstractVehiculo furgon) {

        if (ValidarExitenciaMoto(furgon)) {

            JOptionPane.showMessageDialog(null, "El vehiculo ya existe " + furgon.getMatricula());

        } else {

            vehiculos.add(furgon);

            //Agregar a el archivo original
            EscribirArchivoPlano.ExportarFurgon(vehiculos);

        }

    }

    private boolean ValidarExitenciaFurgon(AbstractVehiculo vehiculo) {

        for (AbstractVehiculo furgon : this.vehiculos) {

            if (furgon.getMatricula().compareTo(vehiculo.getMatricula()) == 0) {

                return true;
            }
        }
        return false;

    }   
}
