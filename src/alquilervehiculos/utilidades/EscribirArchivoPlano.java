/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.utilidades;

import alquilervehiculos.modelo.Coche;
import com.csvreader.CsvWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jhonathan_G
 */
public class EscribirArchivoPlano {
    
    
    public static void ExportarCoches(List<Coche> coches){

        CsvWriter csvWriter = new CsvWriter("src/coches.txt");

        for (Coche co : coches) {

            String[] datos = co.getArray();

            try {
                csvWriter.writeRecord(datos);
            } catch (IOException ex) {
                Logger.getLogger(EscribirArchivoPlano.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        csvWriter.close();

    }
    
}
