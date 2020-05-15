/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.utilidades;

import alquilervehiculos.controlador.GestionVehiculo;
import alquilervehiculos.modelo.AbstractVehiculo;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import static com.itextpdf.kernel.pdf.PdfName.Border;
import static com.itextpdf.kernel.pdf.PdfName.Text;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.pdfa.PdfADocument;
import com.sun.javafx.font.FontFactory;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.Desktop;
import static java.awt.Font.ITALIC;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javafx.scene.text.Font;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhonathan_G
 */
public class ExpotarPdf {

    public static final String DESTINO = "./pdfs/ejemplo.pdf";

    public void crearDocumentoPdf(String destino) throws Exception {

        PdfDocument documento = new PdfDocument(new PdfWriter(destino));
        Document doc = new Document(documento);
        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);

    }

    public void abrirEjemplotabla() {
        try {
            File archivo = new File(DESTINO);
            Desktop.getDesktop().open(archivo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    public void abrirDocumento(String ruta) {
        try {
            File archivo = new File(ruta);
            Desktop.getDesktop().open(archivo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    private Cell obtenerCeldaEncabezado(String texto) throws IOException {
        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
        Cell celda = new Cell().add(new Paragraph(texto)
                .setFont(font)
                .setFontColor(ColorConstants.WHITE));
        celda.setBackgroundColor(ColorConstants.LIGHT_GRAY);
        celda.setTextAlignment(TextAlignment.CENTER);
        return celda;
    }

    public void crearDocumentoPdf(String destino, List<AbstractVehiculo> vehiculos) throws Exception {

        File archivo = new File(destino);
        archivo.getParentFile().mkdirs();
        PdfDocument documento = new PdfDocument(new PdfWriter(destino));
        Document doc = new Document(documento);

        Paragraph titulo = new Paragraph("Informe de vehiculos");
        titulo.setFontSize(20f);
        doc.add(titulo);

        float[] anchos = {120f, 120f, 120f, 120f,120f};
        Table tabla = new Table(anchos);
        Table tablaDos = new Table(anchos);

        tabla.addCell(obtenerCeldaEncabezado("Matricula"));
        tabla.addCell(obtenerCeldaEncabezado("Kms"));
        tabla.addCell(obtenerCeldaEncabezado("Valor Alquiler"));
        tabla.addCell(obtenerCeldaEncabezado("Tipo vehiculo"));
        tabla.addCell(obtenerCeldaEncabezado("Estado"));

        tabla.setFontSize(13f);
        tablaDos.setFontSize(13f);
        
        for (AbstractVehiculo veh : vehiculos) {


            if (veh.isEstado() == true) {

                tabla.addCell(veh.getMatricula());
                tabla.addCell(String.valueOf(veh.getKm()));
                tabla.addCell(String.valueOf(veh.getValorAlquiler())).setBackgroundColor(ColorConstants.GREEN);
                tabla.addCell(String.valueOf(veh.getClass().getSimpleName()));
                tabla.addCell("Libre");

            } else {

                tablaDos.addCell(veh.getMatricula());
                tablaDos.addCell(String.valueOf(veh.getKm()));
                tablaDos.addCell(String.valueOf(veh.getValorAlquiler()));
                tablaDos.addCell(String.valueOf(veh.getClass().getSimpleName())).setBackgroundColor(ColorConstants.RED);
                tablaDos.addCell("Alquilado");
            }

        }

        doc.add(tabla);
        doc.add(tablaDos);
        doc.close();

    }
}
