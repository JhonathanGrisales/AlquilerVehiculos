/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.utilidades;

import alquilervehiculos.controlador.GestionVehiculo;
import alquilervehiculos.modelo.AbstractVehiculo;
import alquilervehiculos.modelo.Coche;
import alquilervehiculos.modelo.Furgoneta;
import alquilervehiculos.modelo.Moto;
import com.csvreader.CsvWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jhonathan_G
 */
public class EscribirArchivoPlano {
    
    


    public static void ExportarCoches(List<AbstractVehiculo> Coche) {

        CsvWriter csvWriter = new CsvWriter("src/coches.txt");

        for (AbstractVehiculo vehiculo : Coche) {

            if (vehiculo instanceof Coche) {

                String[] datos = vehiculo.getArray();

                try {
                    csvWriter.writeRecord(datos);
                } catch (IOException ex) {
                    Logger.getLogger(EscribirArchivoPlano.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        csvWriter.close();

    }
    
     public static void ExportarMotos(List<AbstractVehiculo> moto) {

        CsvWriter csvWriter = new CsvWriter("src/motos.txt");

        for (AbstractVehiculo vehiculo : moto) {

            if (vehiculo instanceof Moto) {

                String[] datos = vehiculo.getArray();

                try {
                    csvWriter.writeRecord(datos);
                } catch (IOException ex) {
                    Logger.getLogger(EscribirArchivoPlano.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        csvWriter.close();

    }
     
     public static void ExportarFurgon(List<AbstractVehiculo> furgon) {
         
         
        CsvWriter csvWriter = new CsvWriter("src/furgonetas.txt");

        for (AbstractVehiculo vehiculo : furgon) {

            if (vehiculo instanceof Furgoneta) {

                String[] datos = vehiculo.getArray();

                try {
                    csvWriter.writeRecord(datos);
                } catch (IOException ex) {
                    Logger.getLogger(EscribirArchivoPlano.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        csvWriter.close();

    }

    

}