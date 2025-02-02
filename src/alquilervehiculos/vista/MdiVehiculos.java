/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.vista;

import alquilervehiculos.controlador.GestionUsuario;
import alquilervehiculos.controlador.GestionVehiculo;
import alquilervehiculos.modelo.AbstractVehiculo;
import alquilervehiculos.modelo.AlquilarVehiculo;
import alquilervehiculos.modelo.Cliente;
import alquilervehiculos.modelo.Coche;
import alquilervehiculos.modelo.Furgoneta;
import alquilervehiculos.modelo.Moto;
import alquilervehiculos.modelo.TipoUsuario;
import alquilervehiculos.modelo.Usuario;
import alquilervehiculos.modelo.VehiculoAble;

import alquilervehiculos.utilidades.EnviarCorreo;

import alquilervehiculos.utilidades.EscribirArchivoPlano;
import alquilervehiculos.utilidades.ExpotarPdf;
import alquilervehiculos.utilidades.LeerCsv;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.toedter.calendar.JDateChooser;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.beans.PropertyVetoException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.input.DataFormat;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ButtonModel;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.apache.commons.codec.digest.DigestUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Jhonathan_G
 */
public class MdiVehiculos extends javax.swing.JFrame {

    private GestionUsuario gestionUsuario;
    private Usuario usuarioAutenticado;
    private GestionVehiculo gestionVehiculo;
    private AlquilarVehiculo alquilarvehiculo;
    private boolean extras;
    private boolean estado;
    private boolean casco;
    private boolean estadoMoto;
    private boolean furgoneta;
    private int tipoUsuario;
    TableRowSorter trs;

    /**
     * Creates new form MdiVehiculos
     */
    public MdiVehiculos() {
        initComponents();

    }

    private void iniciarMenus(boolean estado) {

        mnuCrearUsuario.setVisible(estado);
        mnuVehiculos.setVisible(estado);
        mnuListarCoches.setVisible(estado);
        mnuListarMotos.setVisible(estado);
        mnuListarfurgonetas.setVisible(estado);
        mnuInformeVehiculos.setVisible(estado);
        mnuRegistrarCliente.setVisible(estado);
        mnuVehiculosEnAlquiler.setVisible(estado);

    }

    private void gestionPersmisosMenus() {

        iniciarMenus(false);
        switch (usuarioAutenticado.getTipoUsuario().getCodigo()) {
            //Administrador
            case "1":
                iniciarMenus(true);
                mnuVehiculos.setVisible(true);
                mnuListarCoches.setVisible(true);
                mnuListarMotos.setVisible(true);
                mnuListarfurgonetas.setVisible(true);
                mnuCrearUsuario.setVisible(true);
                mnuInformeVehiculos.setVisible(true);
                mnuRegistrarCliente.setVisible(true);
                mnuVehiculosEnAlquiler.setVisible(true);

                break;
            //Consulta
            case "2":
                iniciarMenus(false);
                mnuVehiculos.setVisible(true);
                mnuListarCoches.setVisible(true);
                mnuListarMotos.setVisible(true);
                mnuListarfurgonetas.setVisible(true);
                mnuRegistrarCliente.setVisible(true);
                mnuInformeVehiculos.setVisible(true);
                mnuVehiculosEnAlquiler.setVisible(true);

                break;
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnExtras = new javax.swing.ButtonGroup();
        btnEstado = new javax.swing.ButtonGroup();
        btnCasco = new javax.swing.ButtonGroup();
        btnEstadoMoto = new javax.swing.ButtonGroup();
        btnEstadoFurgoneta = new javax.swing.ButtonGroup();
        btnGestiosCobro = new javax.swing.ButtonGroup();
        btnEstadoRecepcionMoto = new javax.swing.ButtonGroup();
        btnGestionCobroCoche = new javax.swing.ButtonGroup();
        btnGestionCobroFurgoneta = new javax.swing.ButtonGroup();
        desktopPane = new javax.swing.JDesktopPane();
        jifLogin = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtUsuario = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jifVehiculosEnAlquiler = new javax.swing.JInternalFrame();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblVehiculosEnAlquiler = new javax.swing.JTable();
        jifCoches = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCoches = new javax.swing.JTable();
        lblMatricula = new javax.swing.JLabel();
        lblValorAlquiler = new javax.swing.JLabel();
        lblKmCarro = new javax.swing.JLabel();
        lblExtrasCarro = new javax.swing.JLabel();
        lblEstadoCarro = new javax.swing.JLabel();
        txtMatriculaCarro = new javax.swing.JTextField();
        txtValorAlquilerCarro = new javax.swing.JTextField();
        txtKmCarro = new javax.swing.JTextField();
        btnGuardarCoche = new javax.swing.JButton();
        btnSi = new javax.swing.JRadioButton();
        btnNo = new javax.swing.JRadioButton();
        btnDisponible = new javax.swing.JRadioButton();
        btnNoDisponible = new javax.swing.JRadioButton();
        btnModificarCoche = new javax.swing.JButton();
        btnElimicarCoche = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jInternalFrame4 = new javax.swing.JInternalFrame();
        jcFechaInicioCoche = new com.toedter.calendar.JDateChooser();
        jLabel25 = new javax.swing.JLabel();
        jcFechaFinCoche = new com.toedter.calendar.JDateChooser();
        jLabel26 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        cbxRestriccionesCoche = new javax.swing.JComboBox<>();
        btnAlquilarCoche = new javax.swing.JToggleButton();
        jInternalFrame5 = new javax.swing.JInternalFrame();
        btnCobroKmsCoche = new javax.swing.JRadioButton();
        btnCobroDiasCoche = new javax.swing.JRadioButton();
        jLabel27 = new javax.swing.JLabel();
        btnDevolveCoche = new javax.swing.JToggleButton();
        txtKmRecorridoCoche = new javax.swing.JTextField();
        txtValorCancelarCoche = new javax.swing.JTextField();
        btnCocheCancelado = new javax.swing.JButton();
        btnPinturaCoche = new javax.swing.JRadioButton();
        btnKitCarreteraCoche = new javax.swing.JRadioButton();
        btnEspejosCoche = new javax.swing.JRadioButton();
        jLabel28 = new javax.swing.JLabel();
        btnTacometroReiniciado = new javax.swing.JRadioButton();
        btnAbrirDocumentoCoche = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        jifMotos = new javax.swing.JInternalFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMotos = new javax.swing.JTable();
        txtMatriculaMoto = new javax.swing.JTextField();
        txtValorAlquilerMoto = new javax.swing.JTextField();
        btnSiCasco = new javax.swing.JRadioButton();
        txtKmMoto = new javax.swing.JTextField();
        btnNoCasco = new javax.swing.JRadioButton();
        btnGuardarMoto = new javax.swing.JButton();
        lblMatricula1 = new javax.swing.JLabel();
        btnMotoNoDisponible = new javax.swing.JRadioButton();
        btnMotoDisponible = new javax.swing.JRadioButton();
        lblValorAlquiler1 = new javax.swing.JLabel();
        lblKmCarro1 = new javax.swing.JLabel();
        lblExtrasCarro1 = new javax.swing.JLabel();
        lblEstadoCarro1 = new javax.swing.JLabel();
        btnEliminarMoto = new javax.swing.JButton();
        btnModificarMotos = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jcFechaInicioMoto = new com.toedter.calendar.JDateChooser();
        jLabel22 = new javax.swing.JLabel();
        jcFechaFinMoto = new com.toedter.calendar.JDateChooser();
        jLabel23 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cbxRestricciones = new javax.swing.JComboBox<>();
        btnAlquilarMoto = new javax.swing.JToggleButton();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        btnCobroKmsMoto = new javax.swing.JRadioButton();
        btnCobroDiasMoto = new javax.swing.JRadioButton();
        jLabel24 = new javax.swing.JLabel();
        btnDevolver = new javax.swing.JToggleButton();
        txtKmRecorrido = new javax.swing.JTextField();
        txtValorCancelar = new javax.swing.JTextField();
        btnMotoCancelado = new javax.swing.JButton();
        btnPinturaMoto = new javax.swing.JRadioButton();
        btnHerramientaMoto = new javax.swing.JRadioButton();
        btnEspejosMoto = new javax.swing.JRadioButton();
        jLabel29 = new javax.swing.JLabel();
        btnTacometroReinicioMoto = new javax.swing.JRadioButton();
        btnAbrirDocumento = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jifCrearUsuario = new javax.swing.JInternalFrame();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtClaveCrearUsuario = new javax.swing.JPasswordField();
        jLabel17 = new javax.swing.JLabel();
        txtConfirmarClave = new javax.swing.JPasswordField();
        cboTipoUsuario = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btnCrearUsuario = new javax.swing.JToggleButton();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        btnModificarUsuario = new javax.swing.JButton();
        btnEliminarUsuario = new javax.swing.JButton();
        jifFurgonetas = new javax.swing.JInternalFrame();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblFurgonetas = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtCapacidad = new javax.swing.JTextField();
        txtMatriculaFurgon = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtKmFurgoneta = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtValorAlquilerFurgoneta = new javax.swing.JTextField();
        btnFurgonDisponible = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        btnAgregarFurgonta = new javax.swing.JButton();
        btnFurgonNoDisponible = new javax.swing.JRadioButton();
        btnEliminarFurgon = new javax.swing.JToggleButton();
        btnModificarFuron = new javax.swing.JToggleButton();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jInternalFrame6 = new javax.swing.JInternalFrame();
        jcFechaInicioFurgoneta = new com.toedter.calendar.JDateChooser();
        jLabel30 = new javax.swing.JLabel();
        jcFechaFinFurgoneta = new com.toedter.calendar.JDateChooser();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        cbxRestriccionesFurgoneta = new javax.swing.JComboBox<>();
        btnAlquilarFurgoneta = new javax.swing.JToggleButton();
        jInternalFrame7 = new javax.swing.JInternalFrame();
        btnCobroKmsFurgoneta = new javax.swing.JRadioButton();
        btnCobroDiasFurgoneta = new javax.swing.JRadioButton();
        jLabel33 = new javax.swing.JLabel();
        btnDevolverFurgoneta = new javax.swing.JToggleButton();
        txtKmRecorridoFurgoneta = new javax.swing.JTextField();
        txtValorCancelarFurgoneta = new javax.swing.JTextField();
        btnFurgonetaCancelado = new javax.swing.JButton();
        btnPinturaFurgon = new javax.swing.JRadioButton();
        btnKitFurgon = new javax.swing.JRadioButton();
        btnEspejosFurgon = new javax.swing.JRadioButton();
        jLabel34 = new javax.swing.JLabel();
        btnTacometroReinicioFurgon = new javax.swing.JRadioButton();
        btnCargaMasivaFurgoneta = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        jifRegistrarCliente = new javax.swing.JInternalFrame();
        jLabel18 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtCedulaCliente = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblClintes = new javax.swing.JTable();
        btnRegistrarCliente = new javax.swing.JToggleButton();
        btnModificarCliente = new javax.swing.JButton();
        btnEliminarCliente = new javax.swing.JButton();
        txtCantidadUsuarios = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jifInformeVehiculos = new javax.swing.JInternalFrame();
        pnlPestañas = new javax.swing.JTabbedPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblVehiculosDisponibles = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblVehiculosNoDisponibles = new javax.swing.JTable();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblTodosLosVehiculos = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        txtFiltro = new javax.swing.JTextField();
        btnInforme = new javax.swing.JToggleButton();
        menuBar = new javax.swing.JMenuBar();
        mnuMenuAlquiler = new javax.swing.JMenu();
        mnuVehiculos = new javax.swing.JMenu();
        mnuListarfurgonetas = new javax.swing.JMenuItem();
        mnuListarMotos = new javax.swing.JMenuItem();
        mnuListarCoches = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        mnuRegistrarCliente = new javax.swing.JMenuItem();
        mnuCrearUsuario = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuInformeVehiculos = new javax.swing.JMenuItem();
        mnuVehiculosEnAlquiler = new javax.swing.JMenuItem();
        mnuCerrarSesion = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 550));

        desktopPane.setBackground(new java.awt.Color(153, 153, 153));

        jifLogin.setTitle("Iniciar Sesión");
        jifLogin.setToolTipText("");
        jifLogin.setVisible(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Usuario* :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Contraseña* :");

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        btnIngresar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnIngresar.setText("INGRESAR");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InisiarSesionLogo.png"))); // NOI18N
        jLabel10.setText("jLabel10");

        javax.swing.GroupLayout jifLoginLayout = new javax.swing.GroupLayout(jifLogin.getContentPane());
        jifLogin.getContentPane().setLayout(jifLoginLayout);
        jifLoginLayout.setHorizontalGroup(
            jifLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifLoginLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jifLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jifLoginLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(jifLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnIngresar)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jifLoginLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(jifLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jifLoginLayout.setVerticalGroup(
            jifLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifLoginLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jifLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(29, 29, 29)
                .addGroup(jifLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(26, 26, 26)
                .addComponent(btnIngresar)
                .addGap(74, 74, 74))
        );

        desktopPane.add(jifLogin);
        jifLogin.setBounds(360, 120, 390, 310);

        jifVehiculosEnAlquiler.setClosable(true);
        jifVehiculosEnAlquiler.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jifVehiculosEnAlquiler.setIconifiable(true);
        jifVehiculosEnAlquiler.setMaximizable(true);
        jifVehiculosEnAlquiler.setResizable(true);
        jifVehiculosEnAlquiler.setTitle("Vehiculos en alquiler");
        jifVehiculosEnAlquiler.setPreferredSize(new java.awt.Dimension(600, 400));
        jifVehiculosEnAlquiler.setVisible(false);

        tblVehiculosEnAlquiler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula Vehiculo", "ID Cliente", "Restricciones Cliente", "Usuario de alquiler", "Fecha Alquiler", "Fecha Entrega", "Dias de Alquiler"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVehiculosEnAlquiler.setToolTipText("");
        jScrollPane9.setViewportView(tblVehiculosEnAlquiler);

        javax.swing.GroupLayout jifVehiculosEnAlquilerLayout = new javax.swing.GroupLayout(jifVehiculosEnAlquiler.getContentPane());
        jifVehiculosEnAlquiler.getContentPane().setLayout(jifVehiculosEnAlquilerLayout);
        jifVehiculosEnAlquilerLayout.setHorizontalGroup(
            jifVehiculosEnAlquilerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifVehiculosEnAlquilerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                .addContainerGap())
        );
        jifVehiculosEnAlquilerLayout.setVerticalGroup(
            jifVehiculosEnAlquilerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifVehiculosEnAlquilerLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        desktopPane.add(jifVehiculosEnAlquiler);
        jifVehiculosEnAlquiler.setBounds(30, 0, 745, 400);

        jifCoches.setClosable(true);
        jifCoches.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jifCoches.setIconifiable(true);
        jifCoches.setMaximizable(true);
        jifCoches.setResizable(true);
        jifCoches.setTitle("Listado de Coches");
        jifCoches.setVisible(false);

        tblCoches.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Extras", "Matricula", "Km", "Estado", "Valor Alquiler"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCoches);

        lblMatricula.setText("Matricula* :");

        lblValorAlquiler.setText("Valor Alquiler* : ");

        lblKmCarro.setText("Km* : ");

        lblExtrasCarro.setText("Extras * : ");

        lblEstadoCarro.setText("Estado * : ");

        txtMatriculaCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatriculaCarroActionPerformed(evt);
            }
        });

        btnGuardarCoche.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnGuardarCoche.setText("Agregar Coche");
        btnGuardarCoche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCocheActionPerformed(evt);
            }
        });

        btnExtras.add(btnSi);
        btnSi.setText("Si");

        btnExtras.add(btnNo);
        btnNo.setText("No");

        btnEstado.add(btnDisponible);
        btnDisponible.setText("Disponible ");

        btnEstado.add(btnNoDisponible);
        btnNoDisponible.setText("No Disponible");
        btnNoDisponible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoDisponibleActionPerformed(evt);
            }
        });

        btnModificarCoche.setText("Modificar");
        btnModificarCoche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarCocheActionPerformed(evt);
            }
        });

        btnElimicarCoche.setText("Eliminar");
        btnElimicarCoche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElimicarCocheActionPerformed(evt);
            }
        });

        jInternalFrame4.setVisible(true);

        jLabel25.setText("Fecha Alquiler*:");

        jLabel26.setText("Fecha Entrega*:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Restricciones Cliente");

        cbxRestriccionesCoche.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "N/A", "Vision", "Auditiva", "Edad" }));

        btnAlquilarCoche.setText("ALQUILAR");
        btnAlquilarCoche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlquilarCocheActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame4Layout = new javax.swing.GroupLayout(jInternalFrame4.getContentPane());
        jInternalFrame4.getContentPane().setLayout(jInternalFrame4Layout);
        jInternalFrame4Layout.setHorizontalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame4Layout.createSequentialGroup()
                        .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jcFechaInicioCoche, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcFechaFinCoche, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jInternalFrame4Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(26, 26, 26)
                        .addComponent(cbxRestriccionesCoche, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAlquilarCoche, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );
        jInternalFrame4Layout.setVerticalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jcFechaInicioCoche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jcFechaFinCoche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxRestriccionesCoche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btnAlquilarCoche, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Alquilar", jInternalFrame4);

        jInternalFrame5.setVisible(true);

        btnGestionCobroCoche.add(btnCobroKmsCoche);
        btnCobroKmsCoche.setText("Por Km");

        btnGestionCobroCoche.add(btnCobroDiasCoche);
        btnCobroDiasCoche.setText("Por días");

        jLabel27.setText("Gestion Cobro");

        btnDevolveCoche.setText("DEVOLVER");
        btnDevolveCoche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolveCocheActionPerformed(evt);
            }
        });

        btnCocheCancelado.setText("CANCELADO");
        btnCocheCancelado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCocheCanceladoActionPerformed(evt);
            }
        });

        btnPinturaCoche.setText("PINTURA");

        btnKitCarreteraCoche.setText("KIT CARRETERA");

        btnEspejosCoche.setText("ESPEJOS");

        jLabel28.setText("Check list * :");

        btnGestionCobroCoche.add(btnTacometroReiniciado);
        btnTacometroReiniciado.setText("Marque si el tacometro se reinicio");

        javax.swing.GroupLayout jInternalFrame5Layout = new javax.swing.GroupLayout(jInternalFrame5.getContentPane());
        jInternalFrame5.getContentPane().setLayout(jInternalFrame5Layout);
        jInternalFrame5Layout.setHorizontalGroup(
            jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame5Layout.createSequentialGroup()
                        .addComponent(btnTacometroReiniciado)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jInternalFrame5Layout.createSequentialGroup()
                        .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame5Layout.createSequentialGroup()
                                .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(txtValorCancelarCoche, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                    .addComponent(txtKmRecorridoCoche))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCocheCancelado))
                            .addGroup(jInternalFrame5Layout.createSequentialGroup()
                                .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jInternalFrame5Layout.createSequentialGroup()
                                        .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel28)
                                            .addComponent(btnPinturaCoche))
                                        .addGap(18, 18, 18)
                                        .addComponent(btnKitCarreteraCoche)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEspejosCoche))
                                    .addComponent(btnCobroDiasCoche))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(jInternalFrame5Layout.createSequentialGroup()
                        .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCobroKmsCoche)
                            .addComponent(jLabel27))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDevolveCoche, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );
        jInternalFrame5Layout.setVerticalGroup(
            jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame5Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCobroKmsCoche))
                    .addComponent(btnDevolveCoche, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCobroDiasCoche)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTacometroReiniciado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCocheCancelado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtKmRecorridoCoche))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtValorCancelarCoche, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel28)
                .addGap(7, 7, 7)
                .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPinturaCoche)
                    .addComponent(btnKitCarreteraCoche)
                    .addComponent(btnEspejosCoche))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Devolver", jInternalFrame5);

        btnAbrirDocumentoCoche.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAbrirDocumentoCoche.setText("CARGA MASIVA ");
        btnAbrirDocumentoCoche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirDocumentoCocheActionPerformed(evt);
            }
        });

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Carro.png"))); // NOI18N

        javax.swing.GroupLayout jifCochesLayout = new javax.swing.GroupLayout(jifCoches.getContentPane());
        jifCoches.getContentPane().setLayout(jifCochesLayout);
        jifCochesLayout.setHorizontalGroup(
            jifCochesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifCochesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jifCochesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jifCochesLayout.createSequentialGroup()
                        .addGroup(jifCochesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jifCochesLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jifCochesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblKmCarro, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblMatricula, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(lblValorAlquiler))
                        .addGap(18, 18, 18)
                        .addGroup(jifCochesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMatriculaCarro)
                            .addComponent(txtKmCarro)
                            .addComponent(txtValorAlquilerCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jifCochesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jifCochesLayout.createSequentialGroup()
                                .addComponent(lblExtrasCarro)
                                .addGap(36, 36, 36)
                                .addComponent(lblEstadoCarro))
                            .addGroup(jifCochesLayout.createSequentialGroup()
                                .addGroup(jifCochesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnNo)
                                    .addComponent(btnSi))
                                .addGap(47, 47, 47)
                                .addGroup(jifCochesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnDisponible)
                                    .addComponent(btnNoDisponible)))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jifCochesLayout.createSequentialGroup()
                        .addComponent(btnGuardarCoche, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificarCoche, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnElimicarCoche, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jifCochesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jifCochesLayout.createSequentialGroup()
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                        .addComponent(btnAbrirDocumentoCoche, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jifCochesLayout.setVerticalGroup(
            jifCochesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifCochesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jifCochesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jifCochesLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jifCochesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lblMatricula)
                            .addComponent(txtMatriculaCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblExtrasCarro)
                            .addComponent(lblEstadoCarro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jifCochesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lblKmCarro)
                            .addComponent(txtKmCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSi)
                            .addComponent(btnDisponible))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jifCochesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lblValorAlquiler)
                            .addComponent(txtValorAlquilerCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNo)
                            .addComponent(btnNoDisponible))
                        .addGap(31, 31, 31)
                        .addGroup(jifCochesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(btnGuardarCoche, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificarCoche, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnElimicarCoche, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jifCochesLayout.createSequentialGroup()
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAbrirDocumentoCoche)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jifCochesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        desktopPane.add(jifCoches);
        jifCoches.setBounds(30, 10, 935, 450);

        jifMotos.setClosable(true);
        jifMotos.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jifMotos.setIconifiable(true);
        jifMotos.setMaximizable(true);
        jifMotos.setResizable(true);
        jifMotos.setTitle("Lista de Motos");
        jifMotos.setVisible(false);

        tblMotos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Casco", "Matricula", "Km", "Estado", "Valor Alquiler"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblMotos);

        txtValorAlquilerMoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorAlquilerMotoActionPerformed(evt);
            }
        });

        btnCasco.add(btnSiCasco);
        btnSiCasco.setText("Si");

        btnCasco.add(btnNoCasco);
        btnNoCasco.setText("No");

        btnGuardarMoto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnGuardarMoto.setText("Agregar Moto");
        btnGuardarMoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarMotoActionPerformed(evt);
            }
        });

        lblMatricula1.setText("Matricula* :");

        btnEstadoMoto.add(btnMotoNoDisponible);
        btnMotoNoDisponible.setText("No Disponible");

        btnEstadoMoto.add(btnMotoDisponible);
        btnMotoDisponible.setText("Disponible ");

        lblValorAlquiler1.setText("Valor Alquiler* : ");

        lblKmCarro1.setText("Km* : ");

        lblExtrasCarro1.setText("Casco * : ");

        lblEstadoCarro1.setText("Estado * : ");

        btnEliminarMoto.setText("Eliminar");
        btnEliminarMoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarMotoActionPerformed(evt);
            }
        });

        btnModificarMotos.setText("Modificar");
        btnModificarMotos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarMotosActionPerformed(evt);
            }
        });

        jInternalFrame2.setVisible(true);

        jLabel22.setText("Fecha Alquiler*:");

        jLabel23.setText("Fecha Entrega*:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Restricciones Cliente");

        cbxRestricciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "N/A", "Vision", "Auditiva", "Edad" }));

        btnAlquilarMoto.setText("ALQUILAR");
        btnAlquilarMoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlquilarMotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jcFechaInicioMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcFechaFinMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(26, 26, 26)
                        .addComponent(cbxRestricciones, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAlquilarMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jcFechaInicioMoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jcFechaFinMoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxRestricciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btnAlquilarMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Alquilar", jInternalFrame2);

        jInternalFrame3.setVisible(true);

        btnGestiosCobro.add(btnCobroKmsMoto);
        btnCobroKmsMoto.setText("Por Km");

        btnGestiosCobro.add(btnCobroDiasMoto);
        btnCobroDiasMoto.setText("Por días");

        jLabel24.setText("Gestion Cobro");

        btnDevolver.setText("DEVOLVER");
        btnDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolverActionPerformed(evt);
            }
        });

        btnMotoCancelado.setText("CANCELADO");
        btnMotoCancelado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMotoCanceladoActionPerformed(evt);
            }
        });

        btnPinturaMoto.setText("PINTURA");

        btnHerramientaMoto.setText("HERRAMIENTA");

        btnEspejosMoto.setText("ESPEJOS");

        jLabel29.setText("Check list * :");

        btnGestiosCobro.add(btnTacometroReinicioMoto);
        btnTacometroReinicioMoto.setText("Marque si el tacometro se reinicio");

        javax.swing.GroupLayout jInternalFrame3Layout = new javax.swing.GroupLayout(jInternalFrame3.getContentPane());
        jInternalFrame3.getContentPane().setLayout(jInternalFrame3Layout);
        jInternalFrame3Layout.setHorizontalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame3Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                        .addComponent(btnPinturaMoto)
                        .addGap(18, 18, 18)
                        .addComponent(btnHerramientaMoto)
                        .addGap(18, 18, 18)
                        .addComponent(btnEspejosMoto))
                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                        .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtValorCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(txtKmRecorrido, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMotoCancelado))
                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel29)))
                .addContainerGap())
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                        .addComponent(btnTacometroReinicioMoto)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                        .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(btnCobroKmsMoto)
                            .addComponent(btnCobroDiasMoto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
        );
        jInternalFrame3Layout.setVerticalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCobroKmsMoto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCobroDiasMoto)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTacometroReinicioMoto)
                .addGap(5, 5, 5)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMotoCancelado)
                    .addComponent(txtKmRecorrido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtValorCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPinturaMoto)
                    .addComponent(btnHerramientaMoto)
                    .addComponent(btnEspejosMoto))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Devolver", jInternalFrame3);

        btnAbrirDocumento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAbrirDocumento.setText("CARGA MASIVA ");
        btnAbrirDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirDocumentoActionPerformed(evt);
            }
        });

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moto.png"))); // NOI18N

        javax.swing.GroupLayout jifMotosLayout = new javax.swing.GroupLayout(jifMotos.getContentPane());
        jifMotos.getContentPane().setLayout(jifMotosLayout);
        jifMotosLayout.setHorizontalGroup(
            jifMotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifMotosLayout.createSequentialGroup()
                .addGroup(jifMotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jifMotosLayout.createSequentialGroup()
                        .addGroup(jifMotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jifMotosLayout.createSequentialGroup()
                                .addComponent(lblValorAlquiler1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtValorAlquilerMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jifMotosLayout.createSequentialGroup()
                                .addComponent(lblKmCarro1)
                                .addGap(18, 18, 18)
                                .addComponent(txtKmMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jifMotosLayout.createSequentialGroup()
                                .addComponent(lblMatricula1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMatriculaMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addGroup(jifMotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblExtrasCarro1)
                            .addComponent(btnSiCasco)
                            .addComponent(btnNoCasco))
                        .addGap(18, 18, 18)
                        .addGroup(jifMotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jifMotosLayout.createSequentialGroup()
                                .addGroup(jifMotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnMotoDisponible)
                                    .addComponent(lblEstadoCarro1))
                                .addGap(131, 131, 131)
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jifMotosLayout.createSequentialGroup()
                                .addComponent(btnMotoNoDisponible)
                                .addGap(105, 105, 105)
                                .addComponent(jLabel37))))
                    .addGroup(jifMotosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel35))
                .addContainerGap(115, Short.MAX_VALUE))
            .addGroup(jifMotosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardarMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnModificarMotos, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAbrirDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jifMotosLayout.setVerticalGroup(
            jifMotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifMotosLayout.createSequentialGroup()
                .addComponent(jLabel35)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jifMotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtMatriculaMoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMatricula1)
                    .addComponent(lblExtrasCarro1)
                    .addComponent(lblEstadoCarro1))
                .addGap(13, 13, 13)
                .addGroup(jifMotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jifMotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jifMotosLayout.createSequentialGroup()
                            .addComponent(btnSiCasco)
                            .addGap(4, 4, 4)
                            .addGroup(jifMotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnNoCasco)
                                .addComponent(btnMotoNoDisponible)))
                        .addGroup(jifMotosLayout.createSequentialGroup()
                            .addComponent(btnMotoDisponible)
                            .addGap(27, 27, 27)))
                    .addGroup(jifMotosLayout.createSequentialGroup()
                        .addGroup(jifMotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtKmMoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblKmCarro1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jifMotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtValorAlquilerMoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblValorAlquiler1))))
                .addGroup(jifMotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jifMotosLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jifMotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(btnGuardarMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificarMotos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jifMotosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAbrirDocumento)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jifMotosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        desktopPane.add(jifMotos);
        jifMotos.setBounds(20, 10, 872, 450);

        jifCrearUsuario.setClosable(true);
        jifCrearUsuario.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jifCrearUsuario.setIconifiable(true);
        jifCrearUsuario.setMaximizable(true);
        jifCrearUsuario.setResizable(true);
        jifCrearUsuario.setTitle("Crear Usuario");
        jifCrearUsuario.setVisible(false);

        jLabel5.setText("Correo* :");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Crear.png"))); // NOI18N

        jLabel6.setText("Clave* :");

        jLabel7.setText("Tipo Usuario* :");

        jLabel17.setText("Confirmar clave*:");

        cboTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Consulta" }));

        jLabel3.setText("Cedula* :");

        btnCrearUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCrearUsuario.setText("Crear Usuario");
        btnCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearUsuarioActionPerformed(evt);
            }
        });

        jLabel4.setText("Nombre* :");

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cedula", "Nombre", "Correo", "Clave", "Tipo Usuarios"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(tblUsuarios);

        btnModificarUsuario.setText("Modificar");
        btnModificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarUsuarioActionPerformed(evt);
            }
        });

        btnEliminarUsuario.setText("Eliminar");
        btnEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jifCrearUsuarioLayout = new javax.swing.GroupLayout(jifCrearUsuario.getContentPane());
        jifCrearUsuario.getContentPane().setLayout(jifCrearUsuarioLayout);
        jifCrearUsuarioLayout.setHorizontalGroup(
            jifCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifCrearUsuarioLayout.createSequentialGroup()
                .addGroup(jifCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jifCrearUsuarioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jifCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jifCrearUsuarioLayout.createSequentialGroup()
                                .addGroup(jifCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel7))
                                .addGap(27, 27, 27)
                                .addGroup(jifCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtClaveCrearUsuario)
                                    .addComponent(txtCorreo)
                                    .addComponent(txtNombre)
                                    .addComponent(txtCedula)
                                    .addComponent(txtConfirmarClave)
                                    .addComponent(cboTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jifCrearUsuarioLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(btnEliminarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jifCrearUsuarioLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(btnCrearUsuario))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jifCrearUsuarioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnModificarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jifCrearUsuarioLayout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel9)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(120, Short.MAX_VALUE))
        );
        jifCrearUsuarioLayout.setVerticalGroup(
            jifCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifCrearUsuarioLayout.createSequentialGroup()
                .addGroup(jifCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jifCrearUsuarioLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jifCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jifCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jifCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jifCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtClaveCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jifCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtConfirmarClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jifCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cboTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jifCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jifCrearUsuarioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        desktopPane.add(jifCrearUsuario);
        jifCrearUsuario.setBounds(50, 10, 816, 487);

        jifFurgonetas.setClosable(true);
        jifFurgonetas.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jifFurgonetas.setIconifiable(true);
        jifFurgonetas.setMaximizable(true);
        jifFurgonetas.setTitle("Lista de Furgonetas");
        jifFurgonetas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jifFurgonetas.setVisible(false);

        tblFurgonetas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Capacidad", "Matricula", "Km", "Estado", "Valor Alquiler"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Short.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblFurgonetas);

        jLabel11.setText("Capacidad (Tm)* :");

        jLabel12.setText("Matricula* :");

        jLabel13.setText("Km* :");

        jLabel14.setText("Valor Alquiler* :");

        btnEstadoFurgoneta.add(btnFurgonDisponible);
        btnFurgonDisponible.setText("Disponble");
        btnFurgonDisponible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFurgonDisponibleActionPerformed(evt);
            }
        });

        jLabel15.setText("Estado* :");

        btnAgregarFurgonta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAgregarFurgonta.setText("Agregar Furgon");
        btnAgregarFurgonta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarFurgontaActionPerformed(evt);
            }
        });

        btnEstadoFurgoneta.add(btnFurgonNoDisponible);
        btnFurgonNoDisponible.setText("No Disponble");
        btnFurgonNoDisponible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFurgonNoDisponibleActionPerformed(evt);
            }
        });

        btnEliminarFurgon.setText("Eliminar");
        btnEliminarFurgon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarFurgonActionPerformed(evt);
            }
        });

        btnModificarFuron.setText("Modificar");
        btnModificarFuron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarFuronActionPerformed(evt);
            }
        });

        jInternalFrame6.setVisible(true);

        jLabel30.setText("Fecha Alquiler*:");

        jLabel31.setText("Fecha Entrega*:");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setText("Restricciones Cliente");

        cbxRestriccionesFurgoneta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "N/A", "Vision", "Auditiva", "Edad" }));

        btnAlquilarFurgoneta.setText("ALQUILAR");
        btnAlquilarFurgoneta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlquilarFurgonetaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame6Layout = new javax.swing.GroupLayout(jInternalFrame6.getContentPane());
        jInternalFrame6.getContentPane().setLayout(jInternalFrame6Layout);
        jInternalFrame6Layout.setHorizontalGroup(
            jInternalFrame6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame6Layout.createSequentialGroup()
                        .addGroup(jInternalFrame6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jInternalFrame6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jcFechaInicioFurgoneta, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcFechaFinFurgoneta, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jInternalFrame6Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(26, 26, 26)
                        .addComponent(cbxRestriccionesFurgoneta, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAlquilarFurgoneta, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );
        jInternalFrame6Layout.setVerticalGroup(
            jInternalFrame6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jcFechaInicioFurgoneta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jcFechaFinFurgoneta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxRestriccionesFurgoneta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btnAlquilarFurgoneta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Alquilar", jInternalFrame6);

        jInternalFrame7.setVisible(true);

        btnGestionCobroFurgoneta.add(btnCobroKmsFurgoneta);
        btnCobroKmsFurgoneta.setText("Por Km");

        btnGestionCobroFurgoneta.add(btnCobroDiasFurgoneta);
        btnCobroDiasFurgoneta.setText("Por días");

        jLabel33.setText("Gestion Cobro");

        btnDevolverFurgoneta.setText("DEVOLVER");
        btnDevolverFurgoneta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolverFurgonetaActionPerformed(evt);
            }
        });

        btnFurgonetaCancelado.setText("CANCELADO");
        btnFurgonetaCancelado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFurgonetaCanceladoActionPerformed(evt);
            }
        });

        btnPinturaFurgon.setText("PINTURA");

        btnKitFurgon.setText("KIT CARRETERA");

        btnEspejosFurgon.setText("ESPEJOS");

        jLabel34.setText("Check list * :");

        btnGestionCobroFurgoneta.add(btnTacometroReinicioFurgon);
        btnTacometroReinicioFurgon.setText("Marque si el tacometro se reinicio");

        javax.swing.GroupLayout jInternalFrame7Layout = new javax.swing.GroupLayout(jInternalFrame7.getContentPane());
        jInternalFrame7.getContentPane().setLayout(jInternalFrame7Layout);
        jInternalFrame7Layout.setHorizontalGroup(
            jInternalFrame7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame7Layout.createSequentialGroup()
                        .addComponent(btnPinturaFurgon)
                        .addGap(18, 18, 18)
                        .addComponent(btnKitFurgon)
                        .addGap(18, 18, 18)
                        .addComponent(btnEspejosFurgon))
                    .addGroup(jInternalFrame7Layout.createSequentialGroup()
                        .addGroup(jInternalFrame7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtValorCancelarFurgoneta, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtKmRecorridoFurgoneta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFurgonetaCancelado))
                    .addGroup(jInternalFrame7Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel34)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jInternalFrame7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jInternalFrame7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame7Layout.createSequentialGroup()
                        .addComponent(btnTacometroReinicioFurgon)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jInternalFrame7Layout.createSequentialGroup()
                        .addComponent(btnCobroDiasFurgoneta)
                        .addContainerGap(249, Short.MAX_VALUE))
                    .addGroup(jInternalFrame7Layout.createSequentialGroup()
                        .addGroup(jInternalFrame7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(btnCobroKmsFurgoneta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDevolverFurgoneta, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))))
        );
        jInternalFrame7Layout.setVerticalGroup(
            jInternalFrame7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame7Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCobroKmsFurgoneta))
                    .addComponent(btnDevolverFurgoneta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCobroDiasFurgoneta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTacometroReinicioFurgon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFurgonetaCancelado)
                    .addComponent(txtKmRecorridoFurgoneta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtValorCancelarFurgoneta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPinturaFurgon)
                    .addComponent(btnKitFurgon)
                    .addComponent(btnEspejosFurgon))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Devolver", jInternalFrame7);

        btnCargaMasivaFurgoneta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCargaMasivaFurgoneta.setText("CARGA MASIVA ");
        btnCargaMasivaFurgoneta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargaMasivaFurgonetaActionPerformed(evt);
            }
        });

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Furgon.png"))); // NOI18N

        javax.swing.GroupLayout jifFurgonetasLayout = new javax.swing.GroupLayout(jifFurgonetas.getContentPane());
        jifFurgonetas.getContentPane().setLayout(jifFurgonetasLayout);
        jifFurgonetasLayout.setHorizontalGroup(
            jifFurgonetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifFurgonetasLayout.createSequentialGroup()
                .addGroup(jifFurgonetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jifFurgonetasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jifFurgonetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jifFurgonetasLayout.createSequentialGroup()
                                .addGroup(jifFurgonetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jifFurgonetasLayout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtKmFurgoneta, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jifFurgonetasLayout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtMatriculaFurgon, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jifFurgonetasLayout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtValorAlquilerFurgoneta, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jifFurgonetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jifFurgonetasLayout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jifFurgonetasLayout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(18, 18, 18)
                                        .addGroup(jifFurgonetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnFurgonNoDisponible)
                                            .addComponent(btnFurgonDisponible))))))
                        .addGap(18, 18, 18)
                        .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jifFurgonetasLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnAgregarFurgonta)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarFurgon, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificarFuron, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCargaMasivaFurgoneta, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jifFurgonetasLayout.setVerticalGroup(
            jifFurgonetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifFurgonetasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jifFurgonetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jifFurgonetasLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jifFurgonetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtMatriculaFurgon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jifFurgonetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jifFurgonetasLayout.createSequentialGroup()
                                .addGroup(jifFurgonetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtKmFurgoneta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jifFurgonetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(txtValorAlquilerFurgoneta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jifFurgonetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnCargaMasivaFurgoneta)
                                .addGroup(jifFurgonetasLayout.createSequentialGroup()
                                    .addGroup(jifFurgonetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnFurgonDisponible)
                                        .addComponent(jLabel15))
                                    .addGap(3, 3, 3)
                                    .addGroup(jifFurgonetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jifFurgonetasLayout.createSequentialGroup()
                                            .addComponent(btnFurgonNoDisponible)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jifFurgonetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(btnAgregarFurgonta, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnEliminarFurgon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnModificarFuron, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        desktopPane.add(jifFurgonetas);
        jifFurgonetas.setBounds(20, 10, 850, 450);

        jifRegistrarCliente.setClosable(true);
        jifRegistrarCliente.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jifRegistrarCliente.setIconifiable(true);
        jifRegistrarCliente.setMaximizable(true);
        jifRegistrarCliente.setResizable(true);
        jifRegistrarCliente.setTitle("Registrar Cliente");
        jifRegistrarCliente.setVisible(false);

        jLabel18.setText("Cedula* :");

        jLabel19.setText("Nombre* :");

        tblClintes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cedula", "Nombre", "Tipo Usuario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClintes.setToolTipText("");
        jScrollPane8.setViewportView(tblClintes);

        btnRegistrarCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRegistrarCliente.setText("Crear Usuario");
        btnRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarClienteActionPerformed(evt);
            }
        });

        btnModificarCliente.setText("Modificar");
        btnModificarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarClienteActionPerformed(evt);
            }
        });

        btnEliminarCliente.setText("Eliminar");
        btnEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarClienteActionPerformed(evt);
            }
        });

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Crear.png"))); // NOI18N

        javax.swing.GroupLayout jifRegistrarClienteLayout = new javax.swing.GroupLayout(jifRegistrarCliente.getContentPane());
        jifRegistrarCliente.getContentPane().setLayout(jifRegistrarClienteLayout);
        jifRegistrarClienteLayout.setHorizontalGroup(
            jifRegistrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifRegistrarClienteLayout.createSequentialGroup()
                .addGroup(jifRegistrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jifRegistrarClienteLayout.createSequentialGroup()
                        .addGroup(jifRegistrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jifRegistrarClienteLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jifRegistrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel18))
                                .addGap(27, 27, 27)
                                .addGroup(jifRegistrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCedulaCliente)
                                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jifRegistrarClienteLayout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(btnRegistrarCliente))
                            .addGroup(jifRegistrarClienteLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnEliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jifRegistrarClienteLayout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addGap(80, 80, 80)))
                .addGroup(jifRegistrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCantidadUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jifRegistrarClienteLayout.setVerticalGroup(
            jifRegistrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifRegistrarClienteLayout.createSequentialGroup()
                .addGroup(jifRegistrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jifRegistrarClienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jifRegistrarClienteLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jifRegistrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCedulaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jifRegistrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addGap(33, 33, 33)
                        .addComponent(btnRegistrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jifRegistrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(txtCantidadUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        desktopPane.add(jifRegistrarCliente);
        jifRegistrarCliente.setBounds(60, 30, 565, 451);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Portada.png"))); // NOI18N
        desktopPane.add(jLabel8);
        jLabel8.setBounds(0, 0, 1200, 470);

        jifInformeVehiculos.setBackground(new java.awt.Color(204, 204, 204));
        jifInformeVehiculos.setClosable(true);
        jifInformeVehiculos.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jifInformeVehiculos.setIconifiable(true);
        jifInformeVehiculos.setMaximizable(true);
        jifInformeVehiculos.setTitle("Informe Vehiculos");
        jifInformeVehiculos.setToolTipText("");
        jifInformeVehiculos.setVisible(false);

        pnlPestañas.setBackground(new java.awt.Color(0, 0, 0));

        tblVehiculosDisponibles.setAutoCreateRowSorter(true);
        tblVehiculosDisponibles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "Km", "Valor Alquiler", "Tipo Vehiculo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblVehiculosDisponibles);

        pnlPestañas.addTab("Vehiculos Disponibles", jScrollPane4);

        tblVehiculosNoDisponibles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "Km", "Valor Alquiler", "Tipo Vehiculo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblVehiculosNoDisponibles);

        pnlPestañas.addTab("Vehiculos Alquilados", jScrollPane5);

        jInternalFrame1.setVisible(true);

        tblTodosLosVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "Km", "Valor alquiler", "Tipo Vehiculo", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tblTodosLosVehiculos);

        jLabel16.setText("Buscar Vehiculio:");

        txtFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltroActionPerformed(evt);
            }
        });
        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFiltroKeyTyped(evt);
            }
        });

        btnInforme.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnInforme.setText("GENERAR INFORME");
        btnInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnInforme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(187, 187, 187))
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInforme))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        pnlPestañas.addTab("Todos Los vehiculos", jInternalFrame1);

        javax.swing.GroupLayout jifInformeVehiculosLayout = new javax.swing.GroupLayout(jifInformeVehiculos.getContentPane());
        jifInformeVehiculos.getContentPane().setLayout(jifInformeVehiculosLayout);
        jifInformeVehiculosLayout.setHorizontalGroup(
            jifInformeVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifInformeVehiculosLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(pnlPestañas, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jifInformeVehiculosLayout.setVerticalGroup(
            jifInformeVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifInformeVehiculosLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(pnlPestañas, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        desktopPane.add(jifInformeVehiculos);
        jifInformeVehiculos.setBounds(0, 0, 672, 460);

        mnuMenuAlquiler.setMnemonic('f');
        mnuMenuAlquiler.setText("Archivo");
        mnuMenuAlquiler.setEnabled(false);

        mnuVehiculos.setText("Vehiculos");

        mnuListarfurgonetas.setText("Listar Furgonetas");
        mnuListarfurgonetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuListarfurgonetasActionPerformed(evt);
            }
        });
        mnuVehiculos.add(mnuListarfurgonetas);

        mnuListarMotos.setText("Listar Motos");
        mnuListarMotos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuListarMotosActionPerformed(evt);
            }
        });
        mnuVehiculos.add(mnuListarMotos);

        mnuListarCoches.setText("Listar Coches");
        mnuListarCoches.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuListarCochesActionPerformed(evt);
            }
        });
        mnuVehiculos.add(mnuListarCoches);

        mnuMenuAlquiler.add(mnuVehiculos);

        jMenu1.setText("Gestion Usuarios");

        mnuRegistrarCliente.setText("Registrar Cliente ");
        mnuRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRegistrarClienteActionPerformed(evt);
            }
        });
        jMenu1.add(mnuRegistrarCliente);

        mnuCrearUsuario.setText("Crear Usuario");
        mnuCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCrearUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(mnuCrearUsuario);

        mnuMenuAlquiler.add(jMenu1);

        jMenu2.setText("Informes");

        mnuInformeVehiculos.setText("Informe Vehiculos");
        mnuInformeVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuInformeVehiculosActionPerformed(evt);
            }
        });
        jMenu2.add(mnuInformeVehiculos);

        mnuVehiculosEnAlquiler.setText("Vehiculos Alquilados");
        mnuVehiculosEnAlquiler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuVehiculosEnAlquilerActionPerformed(evt);
            }
        });
        jMenu2.add(mnuVehiculosEnAlquiler);

        mnuMenuAlquiler.add(jMenu2);

        mnuCerrarSesion.setMnemonic('a');
        mnuCerrarSesion.setText("Cerrar Sesión");
        mnuCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCerrarSesionActionPerformed(evt);
            }
        });
        mnuMenuAlquiler.add(mnuCerrarSesion);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        mnuMenuAlquiler.add(exitMenuItem);

        menuBar.add(mnuMenuAlquiler);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    public String MD5(String clave) throws NoSuchAlgorithmException {
        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(clave.getBytes("UTF-8"), 0, clave.length());
            byte[] bt = md.digest();
            BigInteger bi = new BigInteger(1, bt);
            String md5 = bi.toString(16);
            return md5;
        } catch (UnsupportedEncodingException ex) {
            System.out.println("No Encripta" + ex);
        }
        return null;

    }


    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed

        if (txtUsuario.getText() == null || txtUsuario.getText().compareTo("") == 0) {

            JOptionPane.showMessageDialog(this, "Debe diligenciar el usuario ", "Datos Faltantes", 2);
        } else if (txtPassword.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Debe diligenciar la contraseña", "Datos Faltantes", 2);
        } else {
            gestionUsuario = new GestionUsuario();
            //El correo y passwd que se ingreso esta bueno 
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
            Matcher matcher = pattern.matcher(txtUsuario.getText());

            if (matcher.find() == true) {

                try {
                    usuarioAutenticado = gestionUsuario.
                            validarUsuario(txtUsuario.getText(), MD5(txtPassword.getText()));
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(MdiVehiculos.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (usuarioAutenticado == null) {
                    JOptionPane.showMessageDialog(this, "El usuario encontrado no existe", "Datos Erroneos", 0);
                } else {
                    gestionVehiculo = new GestionVehiculo();

                    JOptionPane.showMessageDialog(this, "Bienvenido " + usuarioAutenticado, "Bienvenido ", 1);
                    mnuMenuAlquiler.setEnabled(true);
                    gestionPersmisosMenus();
                    jifLogin.hide();

                }

            } else {
                JOptionPane.showMessageDialog(this, "El correo no tiene el formato valido", "Datos erroneos", 0);
            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void mnuCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCerrarSesionActionPerformed

        mnuMenuAlquiler.setEnabled(false);
        txtUsuario.setText("");
        txtPassword.setText("");
        usuarioAutenticado = null;
        iniciarMenus(false);
        jifLogin.show();
        jifCoches.setVisible(false);
        jifMotos.setVisible(false);
        jifFurgonetas.setVisible(false);
        jifCrearUsuario.setVisible(false);
        jifInformeVehiculos.setVisible(false);
        jifRegistrarCliente.setVisible(false);


    }//GEN-LAST:event_mnuCerrarSesionActionPerformed

    private void pintarCliente() {

        DefaultTableModel modeloCliente = (DefaultTableModel) tblClintes.getModel();
        modeloCliente.getDataVector().removeAllElements();

        for (Cliente cliente : gestionUsuario.getClientes()) {

            modeloCliente.addRow(cliente.obtenerArregloObjeto());
            tblClintes.getColumnModel().getColumn(2).setMaxWidth(0);
            tblClintes.getColumnModel().getColumn(2).setMinWidth(0);
            tblClintes.getColumnModel().getColumn(2).setPreferredWidth(0);
        }
        tblClintes.setModel(modeloCliente);
        int cantidadUsuarios = modeloCliente.getRowCount();
        txtCantidadUsuarios.setText("Usuarios registrados:  " + cantidadUsuarios);

    }

    private void pintarVehiculosEnAlquiler() {

        DefaultTableModel modelo = (DefaultTableModel) tblVehiculosEnAlquiler.getModel();
        modelo.getDataVector().removeAllElements();

        for (AlquilarVehiculo alquila : gestionVehiculo.getAlquilaVehiculos()) {

            modelo.addRow(alquila.obtenerArregloObjeto());

        }
        tblVehiculosEnAlquiler.setModel(modelo);
    }

    private void pintarUsuario() {

        DefaultTableModel modeloUsuarios = (DefaultTableModel) tblUsuarios.getModel();
        modeloUsuarios.getDataVector().removeAllElements();

        for (Usuario usuario : gestionUsuario.getUsuarios()) {

            modeloUsuarios.addRow(usuario.obtenerArregloObjeto());
            tblUsuarios.getColumnModel().getColumn(4).setMaxWidth(0);
            tblUsuarios.getColumnModel().getColumn(4).setMinWidth(0);
            tblUsuarios.getColumnModel().getColumn(4).setPreferredWidth(0);

            tblUsuarios.getColumnModel().getColumn(3).setMaxWidth(0);
            tblUsuarios.getColumnModel().getColumn(3).setMinWidth(0);
            tblUsuarios.getColumnModel().getColumn(3).setPreferredWidth(0);

        }
        tblUsuarios.setModel(modeloUsuarios);

    }

    private void pintarVehiculosDisponibles() {

        DefaultTableModel modeloDisponibles = (DefaultTableModel) tblVehiculosDisponibles.getModel();
        modeloDisponibles.getDataVector().removeAllElements();

        for (AbstractVehiculo vehiculo : gestionVehiculo.obtenerVehiculos("Vehiculos")) {

            if (vehiculo.estado == true) {

                modeloDisponibles.addRow(vehiculo.obtenerArregloObjetoDos());
            }
            tblVehiculosDisponibles.setModel(modeloDisponibles);
        }
    }

    private void pintarVehiculosNoDisponibles() {

        DefaultTableModel modeloNoDisponibles = (DefaultTableModel) tblVehiculosNoDisponibles.getModel();
        modeloNoDisponibles.getDataVector().removeAllElements();

        for (AbstractVehiculo vehiculo : gestionVehiculo.obtenerVehiculos("Vehiculos")) {

            if (vehiculo.estado == false) {

                modeloNoDisponibles.addRow(vehiculo.obtenerArregloObjetoDos());
            }
            tblVehiculosNoDisponibles.setModel(modeloNoDisponibles);
        }
    }

    private void pintarTodosLosVehiculos() {

        DefaultTableModel modeloNoDisponibles = (DefaultTableModel) tblTodosLosVehiculos.getModel();
        modeloNoDisponibles.getDataVector().removeAllElements();

        for (AbstractVehiculo vehiculo : gestionVehiculo.obtenerVehiculos("Vehiculos")) {

            modeloNoDisponibles.addRow(vehiculo.obtenerArregloObjetoDos());

            tblTodosLosVehiculos.setModel(modeloNoDisponibles);
        }
    }

    private void pintarCoches() {

        DefaultTableModel model = (DefaultTableModel) tblCoches.getModel();
        model.getDataVector().removeAllElements();

        for (AbstractVehiculo coche : gestionVehiculo.obtenerVehiculos("Coche")) {

            model.addRow(coche.obtenerArregloObjeto());
        }
        tblCoches.setModel(model);
    }

    private void pintarMotos() {

        DefaultTableModel model = (DefaultTableModel) tblMotos.getModel();
        model.getDataVector().removeAllElements();

        for (AbstractVehiculo moto : gestionVehiculo.obtenerVehiculos("Moto")) {

            model.addRow(moto.obtenerArregloObjeto());
        }
        tblMotos.setModel(model);
    }

    private void pintarFurgonetas() {

        DefaultTableModel modelFurgoneta = (DefaultTableModel) tblFurgonetas.getModel();
        modelFurgoneta.getDataVector().removeAllElements();

        for (AbstractVehiculo furgon : gestionVehiculo.obtenerVehiculos("Furgoneta")) {

            modelFurgoneta.addRow(furgon.obtenerArregloObjeto());
        }
        tblFurgonetas.setModel(modelFurgoneta);
    }

    private void mnuListarCochesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuListarCochesActionPerformed

//LLENAR VEHICULOS
        jcFechaInicioCoche.setDate(new Date());
        gestionVehiculo.llenarVehiculos();
        //LLENAR TABLA CARROS
        pintarCoches();
        jifCoches.repaint();
        jifCoches.show();
        //Maximizar el listado   
        if (jifCoches.isIcon()) {

            try {
                jifCoches.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(MdiVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_mnuListarCochesActionPerformed

    private void mnuListarMotosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuListarMotosActionPerformed

//LLENAR VEHICULOS
        jcFechaInicioMoto.setDate(new Date());
        gestionVehiculo.llenarVehiculos();
        //LLENAR TABLA MOTOS
        pintarMotos();
        jifMotos.repaint();
        jifMotos.show();
        //Maximizar el listado s  
        if (jifMotos.isIcon()) {

            try {
                jifMotos.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(MdiVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_mnuListarMotosActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void mnuCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCrearUsuarioActionPerformed

        pintarUsuario();
        jifCrearUsuario.repaint();
        jifCrearUsuario.show();

        //Maximizar el listado de materias  
        if (jifCrearUsuario.isIcon()) {

            try {
                jifCrearUsuario.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(MdiVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_mnuCrearUsuarioActionPerformed

    private void mnuListarfurgonetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuListarfurgonetasActionPerformed

        jcFechaInicioFurgoneta.setDate(new Date());
        gestionVehiculo.llenarVehiculos();
        //LLENAR TABLA FURGONETAS
        pintarFurgonetas();
        jifFurgonetas.repaint();
        jifFurgonetas.show();
        //Maximizar el listado  
        if (jifFurgonetas.isIcon()) {

            try {
                jifFurgonetas.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(MdiVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_mnuListarfurgonetasActionPerformed

    private void btnFurgonDisponibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFurgonDisponibleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFurgonDisponibleActionPerformed

    private void btnAgregarFurgontaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarFurgontaActionPerformed

        if (btnFurgonDisponible.isSelected()) {

            furgoneta = true;

        } else if (btnFurgonNoDisponible.isSelected()) {

            furgoneta = false;
        }

        if (txtCapacidad.getText() == null || txtCapacidad.getText().compareTo("") == 0) {

            JOptionPane.showMessageDialog(this, "Debe diligenciar la capacidad de la furgoneta ", "Datos Faltantes", 2);

        } else if (txtMatriculaFurgon.getText() == null || txtMatriculaFurgon.getText().compareTo("") == 0) {

            JOptionPane.showMessageDialog(this, "Debe diligenciar la matricula de la furgoneta ", "Datos Faltantes", 2);
        } else if (txtKmFurgoneta.getText() == null || txtKmFurgoneta.getText().compareTo("") == 0) {

            JOptionPane.showMessageDialog(this, "Debe diligenciar los Km de la furgoneta ", "Datos Faltantes", 2);

        } else if(Integer.parseInt(txtKmFurgoneta.getText()) > 999999){
        
        JOptionPane.showMessageDialog(this, "Los km no pueden ser mayores a 999.999 ", "ERROR", 2);
        
        }else if (txtValorAlquilerFurgoneta.getText() == null || txtValorAlquilerFurgoneta.getText().compareTo("") == 0) {

            JOptionPane.showMessageDialog(this, "Debe diligenciar el valor  alquiler de la furgoneta ", "Datos Faltantes", 2);
        } else if (btnEstadoFurgoneta.getSelection() == null) {

            JOptionPane.showMessageDialog(this, "Debe diligenciar el estado de la furgoneta ", "Datos Faltantes", 2);
        } else {

            AbstractVehiculo furgon = new Furgoneta(Short.parseShort(txtCapacidad.getText()), txtMatriculaFurgon.getText().toUpperCase(), Integer.parseInt(txtKmFurgoneta.getText()), furgoneta,
                    Double.parseDouble(txtValorAlquilerFurgoneta.getText()));

            gestionVehiculo.adicionarFurgon(furgon);
            pintarFurgonetas();

            txtMatriculaFurgon.setText("");
            txtKmFurgoneta.setText("");
            txtValorAlquilerFurgoneta.setText("");
            txtCapacidad.setText("");
            btnEstado.clearSelection();

        }


    }//GEN-LAST:event_btnAgregarFurgontaActionPerformed

    private void btnFurgonNoDisponibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFurgonNoDisponibleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFurgonNoDisponibleActionPerformed

    private void mnuInformeVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuInformeVehiculosActionPerformed
        // INFORME VEHICULOS 

        gestionVehiculo.llenarVehiculos();
        pintarVehiculosDisponibles();
        pintarVehiculosNoDisponibles();
        pintarTodosLosVehiculos();
        jifInformeVehiculos.show();
        jifInformeVehiculos.repaint();

        //Maximizar 
        if (jifInformeVehiculos.isIcon()) {

            try {
                jifInformeVehiculos.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(MdiVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_mnuInformeVehiculosActionPerformed

    private void txtFiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyTyped
        // FILTRO POR PLACA
        DefaultTableModel modeloDisponibles = (DefaultTableModel) tblTodosLosVehiculos.getModel();

        txtFiltro.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {
                trs.setRowFilter(RowFilter.regexFilter("(?i)" + txtFiltro.getText(), 0));

            }

        });

        trs = new TableRowSorter(modeloDisponibles);
        tblTodosLosVehiculos.setRowSorter(trs);


    }//GEN-LAST:event_txtFiltroKeyTyped

    TipoUsuario[] tipoUsuarios = new TipoUsuario[3];

    private void llenarTiposUsuario() {

        tipoUsuarios[0] = new TipoUsuario("1", "Administrador");
        tipoUsuarios[1] = new TipoUsuario("2", "Usuario");
        tipoUsuarios[2] = new TipoUsuario("2", "Cliente");
    }


    private void btnCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearUsuarioActionPerformed
        // CREAR USUARIO

        if (cboTipoUsuario.getSelectedItem().equals("Administrador")) {

            int tipoUsuario = 0;

        } else if (cboTipoUsuario.getSelectedItem().equals("Consulta")) {

            tipoUsuario = 1;
        }

        if (txtCedula.getText() == null || txtCedula.getText().compareTo("") == 0) {

            JOptionPane.showMessageDialog(this, "Debe diligenciar el campo de cedula ", "Datos Faltantes", 2);

        } else if (txtNombre.getText() == null || txtNombre.getText().compareTo("") == 0) {

            JOptionPane.showMessageDialog(this, "Debe diligenciar el campo de nombre ", "Datos Faltantes", 2);

        } else if (txtCorreo.getText() == null || txtCorreo.getText().compareTo("") == 0) {

            JOptionPane.showMessageDialog(this, "Debe diligenciar el campo de correo ", "Datos Faltantes", 2);

        } else if (txtClaveCrearUsuario.getText() == null || txtClaveCrearUsuario.getText().compareTo("") == 0) {

            JOptionPane.showMessageDialog(this, "Debe diligenciar el campo de clave ", "Datos Faltantes", 2);

        } else if (txtClaveCrearUsuario.getText().equals(txtConfirmarClave.getText())) {

            Pattern pattern = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
            Matcher matcher = pattern.matcher(txtCorreo.getText());

            if (matcher.find() == true) {

                llenarTiposUsuario();

                String ClaveEncriptadaConMD5 = DigestUtils.md5Hex(txtClaveCrearUsuario.getText());

                Usuario usuarioNuevo = new Usuario(txtCedula.getText(), txtNombre.getText(), txtCorreo.getText(), ClaveEncriptadaConMD5, tipoUsuarios[tipoUsuario]);

                gestionUsuario.adicionarUsuario(usuarioNuevo);
                llenarTiposUsuario();
                pintarUsuario();

                txtCedula.setText("");
                txtNombre.setText("");
                txtCorreo.setText("");
                txtClaveCrearUsuario.setText("");
                txtConfirmarClave.setText("");

            } else {

                JOptionPane.showMessageDialog(this, "El correo no tiene el formato adecuado", "ERROR", 2);
            }

        } else {

            JOptionPane.showMessageDialog(this, "Las claves no coinciden ", "Inconsistencia", 2);
        }
    }//GEN-LAST:event_btnCrearUsuarioActionPerformed

    private void btnEliminarFurgonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarFurgonActionPerformed
        // ELIMINAR FURGON

        DefaultTableModel modelFurgon = (DefaultTableModel) tblFurgonetas.getModel();
        int filaFurgon = tblFurgonetas.getSelectedRow();
        if (filaFurgon >= 0) {

            modelFurgon.removeRow(filaFurgon);

            JOptionPane.showMessageDialog(null, "Registro eliminado");

        } else {
            JOptionPane.showMessageDialog(null, "No se selecciono ningun elemento");

        }
        try {
            SobreescribirListaFurgonestas();
            gestionVehiculo.llenarVehiculos();
            pintarFurgonetas();

        } catch (IOException ex) {

            System.out.println("ERROR: Ocurrio un problema al salvar el archivo!" + ex.getMessage());
        }


    }//GEN-LAST:event_btnEliminarFurgonActionPerformed

    private void btnModificarFuronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarFuronActionPerformed
        //MODIFICAR FURGONETA

        DefaultTableModel modelFurgon = (DefaultTableModel) tblFurgonetas.getModel();
        int filaSeleccionada = tblFurgonetas.getSelectedRow();

        if (filaSeleccionada >= 0) {

            txtMatriculaFurgon.setText(tblFurgonetas.getValueAt(filaSeleccionada, 1).toString());
            txtValorAlquilerFurgoneta.setText(tblFurgonetas.getValueAt(filaSeleccionada, 4).toString());
            txtKmFurgoneta.setText(tblFurgonetas.getValueAt(filaSeleccionada, 2).toString());
            txtCapacidad.setText(tblFurgonetas.getValueAt(filaSeleccionada, 0).toString());

            modelFurgon.removeRow(filaSeleccionada);
            try {
                SobreescribirListaFurgonestas();
                gestionVehiculo.llenarVehiculos();
                pintarFurgonetas();
            } catch (IOException ex) {

                System.out.println("ERROR: Ocurrio un problema al salvar el archivo!" + ex.getMessage());
            }
        } else {

            JOptionPane.showMessageDialog(null, "No se selecciono ningun elemento");
        }

    }//GEN-LAST:event_btnModificarFuronActionPerformed

    public void SobreescribirListaUsuario() throws IOException {

        DefaultTableModel modeloUsuario = (DefaultTableModel) tblUsuarios.getModel();
        try {
            String sucursalesCSVFile = "src/usuarios.csv";
            BufferedWriter fichero = new BufferedWriter(new FileWriter(sucursalesCSVFile));

            for (int i = 0; i < tblUsuarios.getRowCount(); i++) {//realiza un barrido por filas.
                for (int j = 0; j < tblUsuarios.getColumnCount(); j++) //realiza un barrido por columnas.
                {
                    fichero.write(tblUsuarios.getValueAt(i, j).toString());
                    if (j < tblUsuarios.getColumnCount() - 1) { //agrega separador "," si no es el ultimo elemento de la fila.
                        fichero.write(",");
                    }

                }
                fichero.newLine(); //inserta nueva linea.
            }
            fichero.close();//Cierra el archivo

        } catch (IOException e) {
            System.out.println("ERROR: Ocurrio un problema al salvar el archivo!" + e.getMessage());
        }
    }


    private void btnEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioActionPerformed
        // ELIMINAR USUARIO

        DefaultTableModel modelousuario = (DefaultTableModel) tblUsuarios.getModel();

        int filaSeleccionada = tblUsuarios.getSelectedRow();
        if (filaSeleccionada >= 0) {

            modelousuario.removeRow(filaSeleccionada);
            try {
                SobreescribirListaUsuario();
                llenarTiposUsuario();
                pintarCoches();
            } catch (IOException ex) {
                Logger.getLogger(MdiVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }

            JOptionPane.showMessageDialog(null, "Registro eliminado");

        } else {

            JOptionPane.showMessageDialog(null, "No se selecciono ningun elemento");
        }
    }//GEN-LAST:event_btnEliminarUsuarioActionPerformed

    private void btnModificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarUsuarioActionPerformed
        // MODIFICAR USUARIO

        DefaultTableModel modelUsuario = (DefaultTableModel) tblUsuarios.getModel();
        int filaSeleccionada = tblUsuarios.getSelectedRow();

        if (filaSeleccionada >= 0) {

            txtNombre.setText(tblUsuarios.getValueAt(filaSeleccionada, 1).toString());
            txtCedula.setText(tblUsuarios.getValueAt(filaSeleccionada, 0).toString());
            txtCorreo.setText(tblUsuarios.getValueAt(filaSeleccionada, 2).toString());

            modelUsuario.removeRow(filaSeleccionada);

            try {
                SobreescribirListaUsuario();
                gestionUsuario.llenarUsuarios();
                pintarUsuario();
            } catch (IOException ex) {

                System.out.println("ERROR: Ocurrio un problema al salvar el archivo!" + ex.getMessage());
            }
        } else {

            JOptionPane.showMessageDialog(null, "No se selecciono ningun elemento");
        }

    }//GEN-LAST:event_btnModificarUsuarioActionPerformed

    private void btnRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarClienteActionPerformed
        // REGISTRAR CLIENTE 

        if (txtCedulaCliente.getText() == null || txtCedulaCliente.getText().compareTo("") == 0) {

            JOptionPane.showMessageDialog(this, "Debe Ingresar una cedula ", "Datos Faltantes", 2);

        } else if (txtNombreCliente.getText() == null || txtNombreCliente.getText().compareTo("") == 0) {

            JOptionPane.showMessageDialog(this, "Debe Ingresar una nombre ", "Datos Faltantes", 2);
        } else {

            llenarTiposUsuario();

            Cliente clienteNuevo = new Cliente(txtCedulaCliente.getText(), txtNombreCliente.getText(), tipoUsuarios[2]);

            gestionUsuario.adicionarCliente(clienteNuevo);
            pintarCliente();

            txtCedulaCliente.setText("");
            txtNombreCliente.setText("");
        }


    }//GEN-LAST:event_btnRegistrarClienteActionPerformed

    private void btnModificarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarClienteActionPerformed
        // Modificar Cliente

        DefaultTableModel modelCliente = (DefaultTableModel) tblClintes.getModel();
        int filaSeleccionada = tblClintes.getSelectedRow();

        if (filaSeleccionada >= 0) {

            txtCedulaCliente.setText(tblClintes.getValueAt(filaSeleccionada, 0).toString());
            txtNombreCliente.setText(tblClintes.getValueAt(filaSeleccionada, 1).toString());

            modelCliente.removeRow(filaSeleccionada);
            try {
                SobreescribirListaClientes();
                gestionUsuario.llenarClientes();
                pintarCliente();
            } catch (IOException ex) {

                System.out.println("ERROR: Ocurrio un problema al salvar el archivo!" + ex.getMessage());
            }
        } else {

            JOptionPane.showMessageDialog(null, "No se selecciono ningun elemento");
        }
    }//GEN-LAST:event_btnModificarClienteActionPerformed

    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
        // Eliminar Cliente 

        DefaultTableModel modelCliente = (DefaultTableModel) tblClintes.getModel();
        int filaCliente = tblClintes.getSelectedRow();

        if (filaCliente >= 0) {

            modelCliente.removeRow(filaCliente);

            JOptionPane.showMessageDialog(null, "Registro eliminado");

        } else {
            JOptionPane.showMessageDialog(null, "No se selecciono ningun elemento");

        }
        try {
            SobreescribirListaClientes();
            gestionUsuario.llenarClientes();
            pintarCliente();

        } catch (IOException ex) {

            System.out.println("ERROR: Ocurrio un problema al salvar el archivo!" + ex.getMessage());
        }


    }//GEN-LAST:event_btnEliminarClienteActionPerformed

    public void SobreescribirListaClientes() throws IOException {

        DefaultTableModel modeloCliente = (DefaultTableModel) tblClintes.getModel();
        try {
            String sucursalesCSVFile = "src/clientes.txt";
            BufferedWriter fichero = new BufferedWriter(new FileWriter(sucursalesCSVFile));

            for (int i = 0; i < tblClintes.getRowCount(); i++) {//realiza un barrido por filas.
                for (int j = 0; j < tblClintes.getColumnCount(); j++) //realiza un barrido por columnas.
                {
                    fichero.write(tblClintes.getValueAt(i, j).toString());
                    if (j < tblClintes.getColumnCount() - 1) { //agrega separador "," si no es el ultimo elemento de la fila.
                        fichero.write(",");
                    }

                }
                fichero.newLine(); //inserta nueva linea.
            }
            fichero.close();//Cierra el archivo

        } catch (IOException e) {
            System.out.println("ERROR: Ocurrio un problema al salvar el archivo!" + e.getMessage());
        }
    }


    private void mnuRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRegistrarClienteActionPerformed
        // MENU REGISTRAR CLIENTE 

        DefaultTableModel modeloCliente = (DefaultTableModel) tblClintes.getModel();
        modeloCliente.getDataVector().removeAllElements();

        gestionUsuario.llenarClientes();
        //LLENAR TABLA CLIENTES
        pintarCliente();
        jifRegistrarCliente.repaint();
        jifRegistrarCliente.show();

        int cantidadUsuarios = modeloCliente.getRowCount();
        txtCantidadUsuarios.setText("Usuarios registrados:  " + cantidadUsuarios);

        //Maximizar el listado   
        if (jifRegistrarCliente.isIcon()) {

            try {
                jifRegistrarCliente.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(MdiVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_mnuRegistrarClienteActionPerformed


    private void mnuVehiculosEnAlquilerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuVehiculosEnAlquilerActionPerformed
        // MENU VEHICULOS EN ALQUILER 

        gestionVehiculo.llenarAlquilerArchivoPlano();
        pintarVehiculosEnAlquiler();
        jifVehiculosEnAlquiler.show();
        jifVehiculosEnAlquiler.repaint();

        //Maximizar 
        if (jifVehiculosEnAlquiler.isIcon()) {

            try {
                jifVehiculosEnAlquiler.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(MdiVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_mnuVehiculosEnAlquilerActionPerformed

    private void txtFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroActionPerformed

    private void btnMotoCanceladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMotoCanceladoActionPerformed
        //SETEAR VALOTRES MOTO

        txtKmRecorrido.setText("");
        txtValorCancelar.setText("");
        btnGestiosCobro.clearSelection();
        btnPinturaMoto.setSelected(false);
        btnHerramientaMoto.setSelected(false);
        btnEspejosMoto.setSelected(false);
    }//GEN-LAST:event_btnMotoCanceladoActionPerformed

    private void btnDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverActionPerformed
        // DEVOLVER MOTO

        DefaultTableModel modelMoto = (DefaultTableModel) tblMotos.getModel();
        int filaSeleccionada = tblMotos.getSelectedRow();

        if (filaSeleccionada >= 0) {

            if (btnEspejosMoto.isSelected() & btnHerramientaMoto.isSelected() & btnPinturaMoto.isSelected()) {

                if (btnCobroKmsMoto.isSelected()) {

                    if (modelMoto.getValueAt(filaSeleccionada, 3).toString() == "false") {

                        for (AbstractVehiculo vehiculoAlquilado : gestionVehiculo.getVehiculos()) {

                            if (vehiculoAlquilado.getMatricula() == modelMoto.getValueAt(filaSeleccionada, 1)) {

                                alquilarvehiculo = new AlquilarVehiculo(vehiculoAlquilado, usuarioAutenticado, vehiculoAlquilado.getKm());

                                try {

                                    int kmFinales = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese los Kms finales"));

                                    if (kmFinales < vehiculoAlquilado.getKm()) {

                                        JOptionPane.showMessageDialog(null, "Erros en los Kms");
                                    } else {

                                        int kmRecorridos = kmFinales - vehiculoAlquilado.getKm();

                                        double valorAlquilrer = alquilarvehiculo.calcularAlquiler(vehiculoAlquilado, usuarioAutenticado, kmRecorridos);
                                        txtKmRecorrido.setText("Kms Recorridos : " + kmRecorridos);
                                        txtValorCancelar.setText("Factura por : " + valorAlquilrer);

                                        modelMoto.setValueAt(kmFinales, filaSeleccionada, 2);

                                        modelMoto.setValueAt(true, filaSeleccionada, 3);

                                        try {
                                            SobreescribirListaMotos();
                                            gestionVehiculo.llenarVehiculos();
                                            pintarMotos();

                                        } catch (IOException ex) {
                                            Logger.getLogger(MdiVehiculos.class
                                                    .getName()).log(Level.SEVERE, null, ex);

                                        }

                                    }
                                } catch (NumberFormatException e) {

                                    JOptionPane.showMessageDialog(this, "NO INGRESO NINGUN VALOR ", "ERROR", 2);

                                }

                            }

                        }

                    } else {

                        JOptionPane.showMessageDialog(null, "El vehiculo no esta alquilado");
                    }
                } else if (btnCobroDiasMoto.isSelected()) {

                    try {

                        int dias = Integer.parseInt(JOptionPane.showInputDialog("Ingrese dias de alquilquiler"));

                        int kmFinales = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese los Kms finales"));

                        double valorAlquiler = dias * 15000;

                        txtValorCancelar.setText("Factura por : " + valorAlquiler);
                        txtKmRecorrido.setText("Dias Alquiler : " + dias);

                        modelMoto.setValueAt(kmFinales, filaSeleccionada, 2);

                        modelMoto.setValueAt(true, filaSeleccionada, 3);

                        try {
                            SobreescribirListaMotos();
                            gestionVehiculo.llenarVehiculos();
                            pintarMotos();

                        } catch (IOException ex) {
                            Logger.getLogger(MdiVehiculos.class
                                    .getName()).log(Level.SEVERE, null, ex);

                        }
                    } catch (NumberFormatException ex) {

                        JOptionPane.showMessageDialog(this, "NO INGRESO NINGUN VALOR ", "ERROR", 2);
                    }

                }else if (btnTacometroReinicioMoto.isSelected()){
                
                
                 if (modelMoto.getValueAt(filaSeleccionada, 3).toString() == "false") {

                        for (AbstractVehiculo vehiculoAlquilado : gestionVehiculo.getVehiculos()) {

                            if (vehiculoAlquilado.getMatricula() == modelMoto.getValueAt(filaSeleccionada, 1)) {

                                alquilarvehiculo = new AlquilarVehiculo(vehiculoAlquilado, usuarioAutenticado, vehiculoAlquilado.getKm());

                                try {

                                    int kmFinales = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese los Kms finales"));

                                    if (kmFinales > 999999) {

                                        JOptionPane.showMessageDialog(null, "Erros en los Kms");
                                    } else {

                                        int kmRecorridos = ((vehiculoAlquilado.getKm() - 999999) * -1) + kmFinales;

                                        double valorAlquilrer = alquilarvehiculo.calcularAlquiler(vehiculoAlquilado, usuarioAutenticado, kmRecorridos);
                                        txtKmRecorrido.setText("Kms Recorridos : " + kmRecorridos);
                                        txtValorCancelar.setText("Factura por : " + valorAlquilrer);

                                        modelMoto.setValueAt(kmFinales, filaSeleccionada, 2);

                                        modelMoto.setValueAt(true, filaSeleccionada, 3);

                                        try {
                                            SobreescribirListaMotos();
                                            gestionVehiculo.llenarVehiculos();
                                            pintarMotos();

                                        } catch (IOException ex) {
                                            Logger.getLogger(MdiVehiculos.class
                                                    .getName()).log(Level.SEVERE, null, ex);

                                        }

                                    }
                                } catch (NumberFormatException e) {

                                    JOptionPane.showMessageDialog(this, "NO INGRESO NINGUN VALOR ", "ERROR", 2);

                                }

                            }

                        }

                    } else {

                        JOptionPane.showMessageDialog(null, "El vehiculo no esta alquilado");
                    }
                
                
                }else {

                    JOptionPane.showMessageDialog(null, "Dede seleccionar gestion de cobro");

                }

            } else {
                JOptionPane.showMessageDialog(null, "Diligenciar Cheklist");
            }

        } else {

            JOptionPane.showMessageDialog(null, "No ha seleccionado nada");
        }

    }//GEN-LAST:event_btnDevolverActionPerformed


    private void btnAlquilarMotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlquilarMotoActionPerformed
        // ALQUILAR MOTO

        gestionUsuario.llenarClientes();

        DefaultTableModel modelMoto = (DefaultTableModel) tblMotos.getModel();
        int filaSeleccionada = tblMotos.getSelectedRow();

        if (filaSeleccionada >= 0) {

            if (modelMoto.getValueAt(filaSeleccionada, 3).toString() == "true") {

                if (jcFechaInicioMoto.getDate() != null && jcFechaFinMoto.getDate() != null) {
                    DateFormat dato = new SimpleDateFormat("dd-MM-yyy");
                    String datoInicio = dato.format(jcFechaInicioMoto.getDate());

                    DateFormat datoDos = new SimpleDateFormat("dd-MM-yyy");
                    String datoFIn = datoDos.format(jcFechaFinMoto.getDate());

                    String cliente = JOptionPane.showInputDialog("Ingrese cedula del cliente");

                    for (Cliente cli : gestionUsuario.getClientes()) {

                        if (cli.getCedula().equals(cliente) == true) {

                            int dias = calcularDias(jcFechaInicioMoto, jcFechaFinMoto);

                            AlquilarVehiculo alquila = new AlquilarVehiculo((String) tblMotos.getValueAt(filaSeleccionada, 1), cli.getCedula(),
                                    cbxRestricciones.getSelectedItem().toString(), usuarioAutenticado.getNombre(), datoInicio, datoFIn, dias);

                            gestionVehiculo.llenarAlquiler(alquila);

                            JOptionPane.showMessageDialog(null, "Vehiculo de placa:" + "  " + (String) tblMotos.getValueAt(filaSeleccionada, 1) + "  Alquilado al señor: " + "  " + cli.getNombre());

                            try {

                                String correoCliente = JOptionPane.showInputDialog("Ingrese correo del cliente");
                                String correoRemite = "jgrisalesg@gmail.com";
                                String mensaje = "El vehiculo de placas : " + tblMotos.getValueAt(filaSeleccionada, 1) + "  tipo: " + "Motocicleta "
                                        + " Fue alquilado con exito gracias por utilizar nuestros servicios.";
                                EnviarCorreo.enviarMail(correoRemite, correoCliente, "Renta-car te informa", mensaje);

                            } catch (NullPointerException e) {

                                JOptionPane.showMessageDialog(this, "NO INGRESO NINGUN CORREO", "ERROR", 2);
                            }

                            modelMoto.setValueAt(false, filaSeleccionada, 3);

                            try {

                                SobreescribirListaMotos();
                                gestionVehiculo.llenarVehiculos();
                                pintarMotos();

                                jcFechaFinMoto.setDate(null);
                            } catch (IOException ex) {
                                Logger.getLogger(MdiVehiculos.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }

                    }

                } else {

                    JOptionPane.showMessageDialog(null, "Debe registrar la fecha");
                }

            } else {

                JOptionPane.showMessageDialog(null, "El vehiculo ya esta alquilado");
            }

        }
    }//GEN-LAST:event_btnAlquilarMotoActionPerformed

    public int calcularDias(JDateChooser jcFechaInicio, JDateChooser jcFechaFin) {

        Calendar inicio = jcFechaInicio.getCalendar();
        Calendar fin = jcFechaFin.getCalendar();
        int dias = -1;

        while (inicio.before(fin) || inicio.equals(fin)) {

            dias++;
            inicio.add(Calendar.DATE, 1);
        }
        return dias;

    }

    private void btnModificarMotosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarMotosActionPerformed
        // MODIFICAR MOTO

        DefaultTableModel modeloMoto = (DefaultTableModel) tblMotos.getModel();
        int filaSleccionada = tblMotos.getSelectedRow();
        if (filaSleccionada >= 0) {

            txtMatriculaMoto.setText(tblMotos.getValueAt(filaSleccionada, 1).toString());
            txtValorAlquilerMoto.setText(tblMotos.getValueAt(filaSleccionada, 4).toString());
            txtKmMoto.setText(tblMotos.getValueAt(filaSleccionada, 2).toString());

            modeloMoto.removeRow(filaSleccionada);

            try {
                SobreescribirListaMotos();
                gestionVehiculo.llenarVehiculos();
                pintarMotos();

            } catch (IOException ex) {
                System.out.println("ERROR: Ocurrio un problema al modificar el archivo!" + ex.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(this, "No se seleciono nigun elemento");
        }

    }//GEN-LAST:event_btnModificarMotosActionPerformed

    private void btnEliminarMotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMotoActionPerformed
        // ELIMINAR MOTO

        DefaultTableModel modelMoto = (DefaultTableModel) tblMotos.getModel();

        int fila = tblMotos.getSelectedRow();
        if (fila >= 0) {

            modelMoto.removeRow(fila);

            JOptionPane.showMessageDialog(this, "Registro eliminado");

        } else {
            JOptionPane.showMessageDialog(this, "No se seleciono nigun elemento");
        }

        try {
            SobreescribirListaMotos();
            gestionVehiculo.llenarVehiculos();
            pintarMotos();

            //
        } catch (IOException ex) {
            System.out.println("ERROR: Ocurrio un problema al eliminar el archivo!" + ex.getMessage());
        }

    }//GEN-LAST:event_btnEliminarMotoActionPerformed

    private void btnGuardarMotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarMotoActionPerformed

        if (btnSiCasco.isSelected()) {
            casco = true;
        } else if (btnNoCasco.isSelected()) {
            casco = false;
        }

        if (btnMotoDisponible.isSelected()) {
            estadoMoto = true;
        } else if (btnMotoNoDisponible.isSelected()) {
            estadoMoto = false;

        }

        if (txtMatriculaMoto.getText() == null || txtMatriculaMoto.getText().compareTo("") == 0) {

            JOptionPane.showMessageDialog(this, "Debe diligenciar la matricula de la moto ", "Datos Faltantes", 2);

        } else if (txtKmMoto.getText() == null || txtKmMoto.getText().compareTo("") == 0) {
            JOptionPane.showMessageDialog(this, "Debe diligenciar  los Kms de la Moto ", "Datos Faltantes", 2);
        } else if (Integer.parseInt(txtKmMoto.getText()) > 999999){
        
             JOptionPane.showMessageDialog(this, "Los kms no deben ser mayores a 999.999 ", "ERROR", 2);
        
        }else if(txtValorAlquilerMoto.getText() == null || txtValorAlquilerMoto.getText().compareTo("") == 0) {
            JOptionPane.showMessageDialog(this, "Debe diligenciar el valor del alquiler ", "Datos Faltantes", 2);

        } else if (btnEstadoMoto.getSelection() == null || btnCasco.getSelection() == null) {

            JOptionPane.showMessageDialog(this, "Debe marcar la casilla de estado y casco ", "Datos Faltantes", 2);
        } else {
            AbstractVehiculo moto = new Moto(casco, txtMatriculaMoto.getText().toUpperCase(), Integer.parseInt(txtKmMoto.getText()),
                    estadoMoto, Double.parseDouble(txtValorAlquilerMoto.getText()));

            gestionVehiculo.adicionarMotos(moto);
            pintarMotos();
            //LIMPIAR PANTALLA DESPUES DE AGREGAR MOTO

            txtMatriculaMoto.setText("");
            txtKmMoto.setText("");
            txtValorAlquilerMoto.setText("");
            btnEstadoMoto.clearSelection();
            btnCasco.clearSelection();

        }
    }//GEN-LAST:event_btnGuardarMotoActionPerformed

    private void txtValorAlquilerMotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorAlquilerMotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorAlquilerMotoActionPerformed

    private void btnInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformeActionPerformed
        // INFORME

        try {
            // TODO add your handling code here:
            ExpotarPdf ejemplo = new ExpotarPdf();
            ejemplo.crearDocumentoPdf("src/informes.pdf",
                    gestionVehiculo.obtenerVehiculos("Vehiculos"));
            ejemplo.abrirDocumento("src/informes.pdf");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }


    }//GEN-LAST:event_btnInformeActionPerformed


    private void btnAbrirDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirDocumentoActionPerformed
        // ABRIR DOCUMENTO

        JFileChooser seleccionar = new JFileChooser();
        List<AbstractVehiculo> listado = new ArrayList<>();
        DefaultTableModel modelo = (DefaultTableModel) tblMotos.getModel();

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        if (seleccionar.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION) {

            archivo = seleccionar.getSelectedFile();
            if (archivo.canRead()) {
                if (archivo.getName().endsWith("txt")) {

                    try {

                        fr = new FileReader(archivo);
                        br = new BufferedReader(fr);
                        // Lectura del fichero
                        String linea;

                        while ((linea = br.readLine()) != null) { //Mientras alla una linea para leer

                            String[] datos = linea.split(","); //La linea que se lea que se separe por ;

                            Moto moto = new Moto(Boolean.parseBoolean(datos[0]),
                                    datos[1],
                                    Integer.parseInt(datos[2]),
                                    Boolean.parseBoolean(datos[3]),
                                    Double.parseDouble(datos[4]));

                            listado.add(moto);

                            modelo.addRow(moto.obtenerArregloObjeto());
                            tblMotos.setModel(modelo);
                        }
                        tblMotos.setModel(modelo);
                        SobreescribirListaMotos();
                        gestionVehiculo.llenarVehiculos();

                    } catch (IOException e) {
                    } finally {
                        try {
                            if (null != fr) {
                                fr.close();
                            }
                        } catch (IOException e2) {
                        }
                    }

                } else {

                    JOptionPane.showMessageDialog(null, "Archivo no compatible");
                }

            }
        }
    }//GEN-LAST:event_btnAbrirDocumentoActionPerformed

    private void btnElimicarCocheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElimicarCocheActionPerformed

        DefaultTableModel model = (DefaultTableModel) tblCoches.getModel();

        int fila = tblCoches.getSelectedRow();
        if (fila >= 0) {

            model.removeRow(fila);

            JOptionPane.showMessageDialog(this, "Registro eliminado");

        } else {
            JOptionPane.showMessageDialog(this, "No se seleciono nigun elemento");
        }

        try {
            SobreescribirListaCoches();
            gestionVehiculo.llenarVehiculos();
            pintarCoches();

            //
        } catch (IOException ex) {
            System.out.println("ERROR: Ocurrio un problema al eliminar el archivo!" + ex.getMessage());
        }

    }//GEN-LAST:event_btnElimicarCocheActionPerformed

    private void btnModificarCocheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarCocheActionPerformed

        DefaultTableModel modeloCoche = (DefaultTableModel) tblCoches.getModel();
        int filaSleccionada = tblCoches.getSelectedRow();
        if (filaSleccionada >= 0) {

            txtMatriculaCarro.setText(tblCoches.getValueAt(filaSleccionada, 1).toString());
            txtValorAlquilerCarro.setText(tblCoches.getValueAt(filaSleccionada, 4).toString());
            txtKmCarro.setText(tblCoches.getValueAt(filaSleccionada, 2).toString());

            modeloCoche.removeRow(filaSleccionada);

            try {
                SobreescribirListaCoches();
                gestionVehiculo.llenarVehiculos();
                pintarCoches();

            } catch (IOException ex) {
                System.out.println("ERROR: Ocurrio un problema al modificar el archivo!" + ex.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(this, "No se seleciono nigun elemento");
        }
    }//GEN-LAST:event_btnModificarCocheActionPerformed

    private void btnNoDisponibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoDisponibleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNoDisponibleActionPerformed

    private void btnGuardarCocheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCocheActionPerformed

        if (btnSi.isSelected()) {
            extras = true;
        } else if (btnNo.isSelected()) {
            extras = false;
        }

        if (btnDisponible.isSelected()) {
            estado = true;
        } else if (btnNoDisponible.isSelected()) {
            estado = false;
        }

        if (txtMatriculaCarro.getText() == null || txtMatriculaCarro.getText().compareTo("") == 0) {

            JOptionPane.showMessageDialog(this, "Debe diligenciar la matricula del carro ", "Datos Faltantes", 2);
        } else if (txtKmCarro.getText() == null || txtKmCarro.getText().compareTo("") == 0) {
            JOptionPane.showMessageDialog(this, "Debe diligenciar  los Kms del carro ", "Datos Faltantes", 2);
        } else if (Integer.parseInt(txtKmCarro.getText()) > 999999) {

            JOptionPane.showMessageDialog(this, "los kms no deben ser mayor a 999.999 ", "ERROR", 2);

        } else if (txtValorAlquilerCarro.getText() == null || txtValorAlquilerCarro.getText().compareTo("") == 0) {
            JOptionPane.showMessageDialog(this, "Debe diligenciar el valor del alquiler", "Datos Faltantes", 2);

        } else if (btnExtras.getSelection() == null || btnEstado.getSelection() == null) {

            JOptionPane.showMessageDialog(this, "Debe marcar las casillas de estado y extras ", "Datos Faltantes", 2);
        } else {

            AbstractVehiculo vehiculo = new Coche(extras, txtMatriculaCarro.getText().toUpperCase(), Integer.parseInt(txtKmCarro.getText()),
                    estado, Double.parseDouble(txtValorAlquilerCarro.getText()));

            gestionVehiculo.adicionarCoches(vehiculo);
            pintarCoches();

            //LIMPIAR PANTALLA DESPUES DE AGREGAR MOTO
            txtMatriculaCarro.setText("");
            txtKmCarro.setText("");
            txtValorAlquilerCarro.setText("");
            btnExtras.clearSelection();
            btnEstado.clearSelection();
        }

    }//GEN-LAST:event_btnGuardarCocheActionPerformed

    private void txtMatriculaCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatriculaCarroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatriculaCarroActionPerformed

    private void btnAlquilarCocheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlquilarCocheActionPerformed
        // ALQUILAR MOTO

        gestionUsuario.llenarClientes();

        DefaultTableModel modelCoche = (DefaultTableModel) tblCoches.getModel();
        int filaSeleccionada = tblCoches.getSelectedRow();

        if (filaSeleccionada >= 0) {

            if (modelCoche.getValueAt(filaSeleccionada, 3).toString() == "true") {

                if (jcFechaInicioCoche.getDate() != null && jcFechaFinCoche.getDate() != null) {
                    DateFormat dato = new SimpleDateFormat("dd-MM-yyy");
                    String datoInicio = dato.format(jcFechaInicioCoche.getDate());

                    DateFormat datoDos = new SimpleDateFormat("dd-MM-yyy");
                    String datoFIn = datoDos.format(jcFechaFinCoche.getDate());

                    String cliente = JOptionPane.showInputDialog("Ingrese cedula del cliente");

                    for (Cliente cli : gestionUsuario.getClientes()) {

                        if (cli.getCedula().equals(cliente) == true) {

                            int dias = calcularDias(jcFechaInicioCoche, jcFechaFinCoche);

                            AlquilarVehiculo alquila = new AlquilarVehiculo((String) tblCoches.getValueAt(filaSeleccionada, 1), cli.getCedula(),
                                    cbxRestriccionesCoche.getSelectedItem().toString(), usuarioAutenticado.getNombre(), datoInicio, datoFIn, dias);

                            gestionVehiculo.llenarAlquiler(alquila);

                            try {

                                String correoCliente = JOptionPane.showInputDialog("Ingrese correo del cliente");
                                String correoRemite = "jgrisalesg@gmail.com";
                                String mensaje = "El vehiculo de placas : " + tblCoches.getValueAt(filaSeleccionada, 1) + "  tipo: Coche "
                                        + " Fue alquilado con exito gracias por utilizar nuestros servicios.";
                                EnviarCorreo.enviarMail(correoRemite, correoCliente, "Renta-car te informa", mensaje);

                            } catch (NullPointerException e) {

                                JOptionPane.showMessageDialog(this, "NO INGRESO NINGUN CORREO ", "ERROR", 2);
                            }

                            JOptionPane.showMessageDialog(null, "Vehiculo de placa:" + "  " + (String) tblCoches.getValueAt(filaSeleccionada, 1) + "  Alquilado al señor: " + "  " + cli.getNombre());

                            modelCoche.setValueAt(false, filaSeleccionada, 3);

                            try {

                                SobreescribirListaCoches();
                                gestionVehiculo.llenarVehiculos();
                                pintarCoches();
                                jcFechaFinCoche.setDate(null);
                            } catch (IOException ex) {
                                Logger.getLogger(MdiVehiculos.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }
                    }

                } else {

                    JOptionPane.showMessageDialog(null, "Debe registrar la fecha");
                }

            } else {

                JOptionPane.showMessageDialog(null, "El vehiculo ya esta alquilado");
            }

        } else {
            JOptionPane.showMessageDialog(null, "No ha seleccionado nada");

        }


    }//GEN-LAST:event_btnAlquilarCocheActionPerformed

    private void btnDevolveCocheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolveCocheActionPerformed
        //DEVOLVER COCHE

        DefaultTableModel modelCoche = (DefaultTableModel) tblCoches.getModel();
        int filaSeleccionada = tblCoches.getSelectedRow();

        if (filaSeleccionada >= 0) {

            if (btnEspejosCoche.isSelected() & btnKitCarreteraCoche.isSelected() & btnPinturaCoche.isSelected()) {

                if (btnCobroKmsCoche.isSelected()) {

                    if (modelCoche.getValueAt(filaSeleccionada, 3).toString() == "false") {

                        for (AbstractVehiculo vehiculoAlquilado : gestionVehiculo.getVehiculos()) {

                            if (vehiculoAlquilado.getMatricula() == modelCoche.getValueAt(filaSeleccionada, 1)) {

                                alquilarvehiculo = new AlquilarVehiculo(vehiculoAlquilado, usuarioAutenticado, vehiculoAlquilado.getKm());

                                try {

                                    int kmFinales = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese los Kms finales"));

                                    if (kmFinales < vehiculoAlquilado.getKm()) {

                                        JOptionPane.showMessageDialog(null, "Erros en los Kms");
                                    } else {

                                        int kmRecorridos = kmFinales - vehiculoAlquilado.getKm();

                                        double valorAlquilrer = alquilarvehiculo.calcularAlquiler(vehiculoAlquilado, usuarioAutenticado, kmRecorridos);
                                        txtKmRecorridoCoche.setText("Kms Recorridos : " + kmRecorridos);
                                        txtValorCancelarCoche.setText("Factura por : " + valorAlquilrer);

                                        modelCoche.setValueAt(kmFinales, filaSeleccionada, 2);

                                        modelCoche.setValueAt(true, filaSeleccionada, 3);

                                        try {
                                            SobreescribirListaCoches();
                                            gestionVehiculo.llenarVehiculos();
                                            pintarCoches();

                                        } catch (IOException ex) {
                                            Logger.getLogger(MdiVehiculos.class
                                                    .getName()).log(Level.SEVERE, null, ex);

                                        }

                                    }

                                } catch (NumberFormatException e) {

                                    JOptionPane.showMessageDialog(this, "NO INGRESO NINGUN VALOR ", "ERROR", 2);

                                }

                            }

                        }

                    } else {

                        JOptionPane.showMessageDialog(null, "El vehiculo no esta alquilado");
                    }
                } else if (btnCobroDiasCoche.isSelected()) {

                    try {

                        int dias = Integer.parseInt(JOptionPane.showInputDialog("Ingrese dias de alquilquiler"));

                        int kmFinales = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese los Kms finales"));

                        double valorAlquiler = dias * 15000;

                        txtValorCancelarCoche.setText("Factura por : " + valorAlquiler);
                        txtKmRecorridoCoche.setText("Dias Alquiler : " + dias);

                        modelCoche.setValueAt(kmFinales, filaSeleccionada, 2);

                        modelCoche.setValueAt(true, filaSeleccionada, 3);

                        try {
                            SobreescribirListaCoches();
                            gestionVehiculo.llenarVehiculos();
                            pintarCoches();

                        } catch (IOException ex) {
                            Logger.getLogger(MdiVehiculos.class
                                    .getName()).log(Level.SEVERE, null, ex);

                        }
                    } catch (NumberFormatException ex) {

                        JOptionPane.showMessageDialog(this, "NO INGRESO NINGUN VALOR ", "ERROR", 2);

                    }

                } else if(btnTacometroReiniciado.isSelected()){
                    
                    if (modelCoche.getValueAt(filaSeleccionada, 3).toString() == "false") {

                        for (AbstractVehiculo vehiculoAlquilado : gestionVehiculo.getVehiculos()) {

                            if (vehiculoAlquilado.getMatricula() == modelCoche.getValueAt(filaSeleccionada, 1)) {

                                alquilarvehiculo = new AlquilarVehiculo(vehiculoAlquilado, usuarioAutenticado, vehiculoAlquilado.getKm());

                                try {

                                    int kmFinales = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese los Kms finales"));

                                    if (kmFinales > 999999) {

                                        JOptionPane.showMessageDialog(null, "Erros en los Kms");
                                        
                                    } else {

                                        int kmRecorridos = ((vehiculoAlquilado.getKm() - 999999) *-1) + kmFinales;
                                        

                                        double valorAlquilrer = alquilarvehiculo.calcularAlquiler(vehiculoAlquilado, usuarioAutenticado, kmRecorridos);
                                        txtKmRecorridoCoche.setText("Kms Recorridos : " + kmRecorridos);
                                        txtValorCancelarCoche.setText("Factura por : " + valorAlquilrer);

                                        modelCoche.setValueAt(kmFinales, filaSeleccionada, 2);

                                        modelCoche.setValueAt(true, filaSeleccionada, 3);

                                        try {
                                            SobreescribirListaCoches();
                                            gestionVehiculo.llenarVehiculos();
                                            pintarCoches();

                                        } catch (IOException ex) {
                                            Logger.getLogger(MdiVehiculos.class
                                                    .getName()).log(Level.SEVERE, null, ex);

                                        }

                                    }

                                } catch (NumberFormatException e) {

                                    JOptionPane.showMessageDialog(this, "NO INGRESO NINGUN VALOR ", "ERROR", 2);

                                }

                            }

                        }

                    } else {

                        JOptionPane.showMessageDialog(null, "El vehiculo no esta alquilado");
                    }

                    

                }else {
                        
                       JOptionPane.showMessageDialog(null, "Dede seleccionar gestion de cobro"); 
                        
                        }

            } else {
                JOptionPane.showMessageDialog(null, "Diligenciar Cheklist");
            }

        } else {

            JOptionPane.showMessageDialog(null, "No ha seleccionado nada");
        }


    }//GEN-LAST:event_btnDevolveCocheActionPerformed

    private void btnCocheCanceladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCocheCanceladoActionPerformed
        //SETEAR VALOTRES MOTO

        txtKmRecorridoCoche.setText("");
        txtValorCancelarCoche.setText("");
        btnGestionCobroCoche.clearSelection();
        btnPinturaCoche.setSelected(false);
        btnKitCarreteraCoche.setSelected(false);
        btnEspejosCoche.setSelected(false);
    }//GEN-LAST:event_btnCocheCanceladoActionPerformed

    private void btnAbrirDocumentoCocheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirDocumentoCocheActionPerformed
        // ABRIR DOCUMENTO

        JFileChooser seleccionar = new JFileChooser();
        List<AbstractVehiculo> listado = new ArrayList<>();
        DefaultTableModel modelo = (DefaultTableModel) tblCoches.getModel();

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        if (seleccionar.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION) {

            archivo = seleccionar.getSelectedFile();
            if (archivo.canRead()) {
                if (archivo.getName().endsWith("txt")) {

                    try {

                        fr = new FileReader(archivo);
                        br = new BufferedReader(fr);
                        // Lectura del fichero
                        String linea;

                        while ((linea = br.readLine()) != null) { //Mientras alla una linea para leer

                            String[] datos = linea.split(","); //La linea que se lea que se separe por ;

                            Coche coche = new Coche(Boolean.parseBoolean(datos[0]),
                                    datos[1],
                                    Integer.parseInt(datos[2]),
                                    Boolean.parseBoolean(datos[3]),
                                    Double.parseDouble(datos[4]));

                            listado.add(coche);

                            modelo.addRow(coche.obtenerArregloObjeto());
                            tblCoches.setModel(modelo);
                        }
                        tblCoches.setModel(modelo);
                        SobreescribirListaCoches();
                        gestionVehiculo.llenarVehiculos();

                    } catch (IOException e) {
                    } finally {
                        try {
                            if (null != fr) {
                                fr.close();
                            }
                        } catch (IOException e2) {
                        }
                    }

                } else {

                    JOptionPane.showMessageDialog(null, "Archivo no compatible");
                }

            }
        }
    }//GEN-LAST:event_btnAbrirDocumentoCocheActionPerformed

    private void btnAlquilarFurgonetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlquilarFurgonetaActionPerformed
        // ALQUILAR FURGONETA

        gestionUsuario.llenarClientes();

        DefaultTableModel modelFurgon = (DefaultTableModel) tblFurgonetas.getModel();
        int filaSeleccionada = tblFurgonetas.getSelectedRow();

        if (filaSeleccionada >= 0) {

            if (modelFurgon.getValueAt(filaSeleccionada, 3).toString() == "true") {

                if (jcFechaInicioFurgoneta.getDate() != null && jcFechaFinFurgoneta.getDate() != null) {
                    DateFormat dato = new SimpleDateFormat("dd-MM-yyy");
                    String datoInicio = dato.format(jcFechaInicioFurgoneta.getDate());

                    DateFormat datoDos = new SimpleDateFormat("dd-MM-yyy");
                    String datoFIn = datoDos.format(jcFechaFinFurgoneta.getDate());

                    String cliente = JOptionPane.showInputDialog("Ingrese cedula del cliente");

                    for (Cliente cli : gestionUsuario.getClientes()) {

                        if (cli.getCedula().equals(cliente) == true) {

                            int dias = calcularDias(jcFechaInicioFurgoneta, jcFechaFinFurgoneta);

                            AlquilarVehiculo alquila = new AlquilarVehiculo((String) tblFurgonetas.getValueAt(filaSeleccionada, 1), cli.getCedula(),
                                    cbxRestriccionesFurgoneta.getSelectedItem().toString(), usuarioAutenticado.getNombre(), datoInicio, datoFIn, dias);

                            gestionVehiculo.llenarAlquiler(alquila);

                            try {

                                String correoCliente = JOptionPane.showInputDialog("Ingrese correo del cliente");
                                String correoRemite = "jgrisalesg@gmail.com";
                                String mensaje = "El vehiculo de placas : " + tblFurgonetas.getValueAt(filaSeleccionada, 1) + "  tipo: Furgon "
                                        + " Fue alquilado con exito gracias por utilizar nuestros servicios.";
                                EnviarCorreo.enviarMail(correoRemite, correoCliente, "Renta-car te informa", mensaje);

                            } catch (NullPointerException e) {

                                JOptionPane.showMessageDialog(this, "NO INGRESO NINGUN CORREO ", "ERROR", 2);

                            }

                            JOptionPane.showMessageDialog(null, "Vehiculo de placa:" + "  " + (String) tblFurgonetas.getValueAt(filaSeleccionada, 1) + "  Alquilado al señor: " + "  " + cli.getNombre());

                            modelFurgon.setValueAt(false, filaSeleccionada, 3);

                            try {

                                SobreescribirListaFurgonestas();
                                gestionVehiculo.llenarVehiculos();
                                pintarFurgonetas();

                                jcFechaFinFurgoneta.setDate(null);
                            } catch (IOException ex) {
                                Logger.getLogger(MdiVehiculos.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }
                    }

                } else {

                    JOptionPane.showMessageDialog(null, "Debe registrar la fecha");
                }

            } else {

                JOptionPane.showMessageDialog(null, "El vehiculo ya esta alquilado");
            }

        }

    }//GEN-LAST:event_btnAlquilarFurgonetaActionPerformed

    private void btnDevolverFurgonetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverFurgonetaActionPerformed
        // DEVOLVER FURGONETA

        DefaultTableModel modelFurgon = (DefaultTableModel) tblFurgonetas.getModel();
        int filaSeleccionada = tblFurgonetas.getSelectedRow();

        if (filaSeleccionada >= 0) {

            if (btnEspejosFurgon.isSelected() & btnKitFurgon.isSelected() & btnPinturaFurgon.isSelected()) {

                if (btnCobroKmsFurgoneta.isSelected()) {

                    if (modelFurgon.getValueAt(filaSeleccionada, 3).toString() == "false") {

                        for (AbstractVehiculo vehiculoAlquilado : gestionVehiculo.getVehiculos()) {

                            if (vehiculoAlquilado.getMatricula() == modelFurgon.getValueAt(filaSeleccionada, 1)) {

                                alquilarvehiculo = new AlquilarVehiculo(vehiculoAlquilado, usuarioAutenticado, vehiculoAlquilado.getKm());

                                try {

                                    int kmFinales = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese los Kms finales"));

                                    if (kmFinales < vehiculoAlquilado.getKm()) {

                                        JOptionPane.showMessageDialog(null, "Erros en los Kms");
                                    } else {

                                        int kmRecorridos = kmFinales - vehiculoAlquilado.getKm();

                                        double valorAlquilrer = alquilarvehiculo.calcularAlquiler(vehiculoAlquilado, usuarioAutenticado, kmRecorridos);
                                        txtKmRecorridoFurgoneta.setText("Kms Recorridos : " + kmRecorridos);
                                        txtValorCancelarFurgoneta.setText("Factura por : " + valorAlquilrer);

                                        modelFurgon.setValueAt(kmFinales, filaSeleccionada, 2);

                                        modelFurgon.setValueAt(true, filaSeleccionada, 3);

                                        try {
                                            SobreescribirListaFurgonestas();
                                            gestionVehiculo.llenarVehiculos();
                                            pintarFurgonetas();

                                        } catch (IOException ex) {
                                            Logger.getLogger(MdiVehiculos.class
                                                    .getName()).log(Level.SEVERE, null, ex);

                                        }

                                    }

                                } catch (NumberFormatException e) {

                                    JOptionPane.showMessageDialog(this, "NO INGRESO NINGUN VALOR ", "ERROR", 2);

                                }

                            }

                        }

                    } else {

                        JOptionPane.showMessageDialog(null, "El vehiculo no esta alquilado");
                    }
                } else if (btnCobroDiasFurgoneta.isSelected()) {

                    try {

                        int dias = Integer.parseInt(JOptionPane.showInputDialog("Ingrese dias de alquilquiler"));

                        int kmFinales = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese los Kms finales"));

                        double valorAlquiler = dias * 25000;

                        txtValorCancelarFurgoneta.setText("Factura por : " + valorAlquiler);
                        txtKmRecorridoFurgoneta.setText("Dias Alquiler : " + dias);

                        modelFurgon.setValueAt(kmFinales, filaSeleccionada, 2);

                        modelFurgon.setValueAt(true, filaSeleccionada, 3);

                        try {
                            SobreescribirListaFurgonestas();
                            gestionVehiculo.llenarVehiculos();
                            pintarFurgonetas();

                        } catch (IOException ex) {
                            Logger.getLogger(MdiVehiculos.class
                                    .getName()).log(Level.SEVERE, null, ex);

                        }

                    } catch (NumberFormatException ex) {

                        JOptionPane.showMessageDialog(this, "NO INGRESO NINGUN VALOR ", "ERROR", 2);

                    }

                } else if (btnTacometroReinicioFurgon.isSelected()){
                    
                    
                     if (modelFurgon.getValueAt(filaSeleccionada, 3).toString() == "false") {

                        for (AbstractVehiculo vehiculoAlquilado : gestionVehiculo.getVehiculos()) {

                            if (vehiculoAlquilado.getMatricula() == modelFurgon.getValueAt(filaSeleccionada, 1)) {

                                alquilarvehiculo = new AlquilarVehiculo(vehiculoAlquilado, usuarioAutenticado, vehiculoAlquilado.getKm());

                                try {

                                    int kmFinales = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese los Kms finales"));

                                    if (kmFinales > 999999) {

                                        JOptionPane.showMessageDialog(null, "Erros en los Kms");
                                    } else {

                                        int kmRecorridos = ((vehiculoAlquilado.getKm()-999999) * -1) + kmFinales;

                                        double valorAlquilrer = alquilarvehiculo.calcularAlquiler(vehiculoAlquilado, usuarioAutenticado, kmRecorridos);
                                        txtKmRecorridoFurgoneta.setText("Kms Recorridos : " + kmRecorridos);
                                        txtValorCancelarFurgoneta.setText("Factura por : " + valorAlquilrer);

                                        modelFurgon.setValueAt(kmFinales, filaSeleccionada, 2);

                                        modelFurgon.setValueAt(true, filaSeleccionada, 3);

                                        try {
                                            SobreescribirListaFurgonestas();
                                            gestionVehiculo.llenarVehiculos();
                                            pintarFurgonetas();

                                        } catch (IOException ex) {
                                            Logger.getLogger(MdiVehiculos.class
                                                    .getName()).log(Level.SEVERE, null, ex);

                                        }

                                    }

                                } catch (NumberFormatException e) {

                                    JOptionPane.showMessageDialog(this, "NO INGRESO NINGUN VALOR ", "ERROR", 2);

                                }

                            }

                        }

                    } else {

                        JOptionPane.showMessageDialog(null, "El vehiculo no esta alquilado");
                    }
                    
                    
                }else {

                    JOptionPane.showMessageDialog(null, "Dede seleccionar gestion de cobro");

                }

            } else {
                JOptionPane.showMessageDialog(null, "Diligenciar Cheklist");
            }

        } else {

            JOptionPane.showMessageDialog(null, "No ha seleccionado nada");
        }


    }//GEN-LAST:event_btnDevolverFurgonetaActionPerformed

    private void btnFurgonetaCanceladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFurgonetaCanceladoActionPerformed
        //SETEAR VALOTRES FURGON

        txtKmRecorridoFurgoneta.setText("");
        txtValorCancelarFurgoneta.setText("");
        btnGestionCobroFurgoneta.clearSelection();
        btnPinturaFurgon.setSelected(false);
        btnKitFurgon.setSelected(false);
        btnEspejosFurgon.setSelected(false);
    }//GEN-LAST:event_btnFurgonetaCanceladoActionPerformed

    private void btnCargaMasivaFurgonetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargaMasivaFurgonetaActionPerformed
        //CARGA MASIVA VEHICULO

        JFileChooser seleccionar = new JFileChooser();
        List<AbstractVehiculo> listado = new ArrayList<>();
        DefaultTableModel modeloFurgon = (DefaultTableModel) tblFurgonetas.getModel();

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        if (seleccionar.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION) {

            archivo = seleccionar.getSelectedFile();
            if (archivo.canRead()) {
                if (archivo.getName().endsWith("txt")) {

                    try {

                        fr = new FileReader(archivo);
                        br = new BufferedReader(fr);
                        // Lectura del fichero
                        String linea;

                        while ((linea = br.readLine()) != null) { //Mientras alla una linea para leer

                            String[] datos = linea.split(","); //La linea que se lea que se separe por ;

                            Furgoneta furgon = new Furgoneta(Short.parseShort(datos[0]),
                                    datos[1],
                                    Integer.parseInt(datos[2]),
                                    Boolean.parseBoolean(datos[3]),
                                    Double.parseDouble(datos[4]));

                            listado.add(furgon);

                            modeloFurgon.addRow(furgon.obtenerArregloObjeto());
                            tblFurgonetas.setModel(modeloFurgon);
                        }
                        tblFurgonetas.setModel(modeloFurgon);
                        SobreescribirListaFurgonestas();
                        gestionVehiculo.llenarVehiculos();

                    } catch (IOException e) {
                    } finally {
                        try {
                            if (null != fr) {
                                fr.close();
                            }
                        } catch (IOException e2) {
                        }
                    }

                } else {

                    JOptionPane.showMessageDialog(null, "Archivo no compatible");
                }

            }
        }
    }//GEN-LAST:event_btnCargaMasivaFurgonetaActionPerformed

    public void SobreescribirListaFurgonestas() throws IOException {

        DefaultTableModel modeloFurgon = (DefaultTableModel) tblFurgonetas.getModel();
        try {
            String sucursalesCSVFile = "src/furgonetas.txt";
            BufferedWriter fichero = new BufferedWriter(new FileWriter(sucursalesCSVFile));

            for (int i = 0; i < tblFurgonetas.getRowCount(); i++) {//realiza un barrido por filas.
                for (int j = 0; j < tblFurgonetas.getColumnCount(); j++) //realiza un barrido por columnas.
                {
                    fichero.write(tblFurgonetas.getValueAt(i, j).toString());
                    if (j < tblFurgonetas.getColumnCount() - 1) { //agrega separador "," si no es el ultimo elemento de la fila.
                        fichero.write(",");
                    }

                }
                fichero.newLine(); //inserta nueva linea.
            }
            fichero.close();//Cierra el archivo

        } catch (IOException e) {
            System.out.println("ERROR: Ocurrio un problema al salvar el archivo!" + e.getMessage());
        }
    }

    public void SobreescribirListaCoches() throws IOException {

        DefaultTableModel modeloCoche = (DefaultTableModel) tblCoches.getModel();
        try {
            String sucursalesCSVFile = "src/coches.txt";
            BufferedWriter fichero = new BufferedWriter(new FileWriter(sucursalesCSVFile));

            for (int i = 0; i < tblCoches.getRowCount(); i++) {//realiza un barrido por filas.
                for (int j = 0; j < tblCoches.getColumnCount(); j++) //realiza un barrido por columnas.
                {
                    fichero.write(tblCoches.getValueAt(i, j).toString());
                    if (j < tblCoches.getColumnCount() - 1) { //agrega separador "," si no es el ultimo elemento de la fila.
                        fichero.write(",");
                    }

                }
                fichero.newLine(); //inserta nueva linea.
            }
            fichero.close();//Cierra el archivo

        } catch (IOException e) {
            System.out.println("ERROR: Ocurrio un problema al salvar el archivo!" + e.getMessage());
        }
    }

    public void SobreescribirListaMotos() throws IOException {

        DefaultTableModel modeloMoto = (DefaultTableModel) tblMotos.getModel();
        try {
            String sucursalesCSVFile = "src/motos.txt";
            BufferedWriter fichero = new BufferedWriter(new FileWriter(sucursalesCSVFile));

            for (int i = 0; i < tblMotos.getRowCount(); i++) {//realiza un barrido por filas.
                for (int j = 0; j < tblMotos.getColumnCount(); j++) //realiza un barrido por columnas.
                {
                    fichero.write(tblMotos.getValueAt(i, j).toString());
                    if (j < tblMotos.getColumnCount() - 1) { //agrega separador "," si no es el ultimo elemento de la fila.
                        fichero.write(",");
                    }

                }
                fichero.newLine(); //inserta nueva linea.
            }
            fichero.close();//Cierra el archivo

        } catch (IOException e) {
            System.out.println("ERROR: Ocurrio un problema al salvar el archivo!" + e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MdiVehiculos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MdiVehiculos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MdiVehiculos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MdiVehiculos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MdiVehiculos().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirDocumento;
    private javax.swing.JButton btnAbrirDocumentoCoche;
    private javax.swing.JButton btnAgregarFurgonta;
    private javax.swing.JToggleButton btnAlquilarCoche;
    private javax.swing.JToggleButton btnAlquilarFurgoneta;
    private javax.swing.JToggleButton btnAlquilarMoto;
    private javax.swing.JButton btnCargaMasivaFurgoneta;
    private static javax.swing.ButtonGroup btnCasco;
    private javax.swing.JRadioButton btnCobroDiasCoche;
    private javax.swing.JRadioButton btnCobroDiasFurgoneta;
    private javax.swing.JRadioButton btnCobroDiasMoto;
    private javax.swing.JRadioButton btnCobroKmsCoche;
    private javax.swing.JRadioButton btnCobroKmsFurgoneta;
    private javax.swing.JRadioButton btnCobroKmsMoto;
    private javax.swing.JButton btnCocheCancelado;
    private javax.swing.JToggleButton btnCrearUsuario;
    private javax.swing.JToggleButton btnDevolveCoche;
    private javax.swing.JToggleButton btnDevolver;
    private javax.swing.JToggleButton btnDevolverFurgoneta;
    private javax.swing.JRadioButton btnDisponible;
    private javax.swing.JButton btnElimicarCoche;
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.JToggleButton btnEliminarFurgon;
    private javax.swing.JButton btnEliminarMoto;
    private javax.swing.JButton btnEliminarUsuario;
    private javax.swing.JRadioButton btnEspejosCoche;
    private javax.swing.JRadioButton btnEspejosFurgon;
    private javax.swing.JRadioButton btnEspejosMoto;
    private javax.swing.ButtonGroup btnEstado;
    private javax.swing.ButtonGroup btnEstadoFurgoneta;
    private javax.swing.ButtonGroup btnEstadoMoto;
    private javax.swing.ButtonGroup btnEstadoRecepcionMoto;
    private static javax.swing.ButtonGroup btnExtras;
    private javax.swing.JRadioButton btnFurgonDisponible;
    private javax.swing.JRadioButton btnFurgonNoDisponible;
    private javax.swing.JButton btnFurgonetaCancelado;
    private javax.swing.ButtonGroup btnGestionCobroCoche;
    private javax.swing.ButtonGroup btnGestionCobroFurgoneta;
    private javax.swing.ButtonGroup btnGestiosCobro;
    private javax.swing.JButton btnGuardarCoche;
    private javax.swing.JButton btnGuardarMoto;
    private javax.swing.JRadioButton btnHerramientaMoto;
    private javax.swing.JToggleButton btnInforme;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JRadioButton btnKitCarreteraCoche;
    private javax.swing.JRadioButton btnKitFurgon;
    private javax.swing.JButton btnModificarCliente;
    private javax.swing.JButton btnModificarCoche;
    private javax.swing.JToggleButton btnModificarFuron;
    private javax.swing.JButton btnModificarMotos;
    private javax.swing.JButton btnModificarUsuario;
    private javax.swing.JButton btnMotoCancelado;
    private javax.swing.JRadioButton btnMotoDisponible;
    private javax.swing.JRadioButton btnMotoNoDisponible;
    private javax.swing.JRadioButton btnNo;
    private javax.swing.JRadioButton btnNoCasco;
    private javax.swing.JRadioButton btnNoDisponible;
    private javax.swing.JRadioButton btnPinturaCoche;
    private javax.swing.JRadioButton btnPinturaFurgon;
    private javax.swing.JRadioButton btnPinturaMoto;
    private javax.swing.JToggleButton btnRegistrarCliente;
    private javax.swing.JRadioButton btnSi;
    private javax.swing.JRadioButton btnSiCasco;
    private javax.swing.JRadioButton btnTacometroReiniciado;
    private javax.swing.JRadioButton btnTacometroReinicioFurgon;
    private javax.swing.JRadioButton btnTacometroReinicioMoto;
    private javax.swing.JComboBox<String> cboTipoUsuario;
    private javax.swing.JComboBox<String> cbxRestricciones;
    private javax.swing.JComboBox<String> cbxRestriccionesCoche;
    private javax.swing.JComboBox<String> cbxRestriccionesFurgoneta;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JInternalFrame jInternalFrame4;
    private javax.swing.JInternalFrame jInternalFrame5;
    private javax.swing.JInternalFrame jInternalFrame6;
    private javax.swing.JInternalFrame jInternalFrame7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private com.toedter.calendar.JDateChooser jcFechaFinCoche;
    private com.toedter.calendar.JDateChooser jcFechaFinFurgoneta;
    private com.toedter.calendar.JDateChooser jcFechaFinMoto;
    private com.toedter.calendar.JDateChooser jcFechaInicioCoche;
    private com.toedter.calendar.JDateChooser jcFechaInicioFurgoneta;
    private com.toedter.calendar.JDateChooser jcFechaInicioMoto;
    private javax.swing.JInternalFrame jifCoches;
    private javax.swing.JInternalFrame jifCrearUsuario;
    private javax.swing.JInternalFrame jifFurgonetas;
    private javax.swing.JInternalFrame jifInformeVehiculos;
    private javax.swing.JInternalFrame jifLogin;
    private javax.swing.JInternalFrame jifMotos;
    private javax.swing.JInternalFrame jifRegistrarCliente;
    private javax.swing.JInternalFrame jifVehiculosEnAlquiler;
    private javax.swing.JLabel lblEstadoCarro;
    private javax.swing.JLabel lblEstadoCarro1;
    private javax.swing.JLabel lblExtrasCarro;
    private javax.swing.JLabel lblExtrasCarro1;
    private javax.swing.JLabel lblKmCarro;
    private javax.swing.JLabel lblKmCarro1;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblMatricula1;
    private javax.swing.JLabel lblValorAlquiler;
    private javax.swing.JLabel lblValorAlquiler1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem mnuCerrarSesion;
    private javax.swing.JMenuItem mnuCrearUsuario;
    private javax.swing.JMenuItem mnuInformeVehiculos;
    private javax.swing.JMenuItem mnuListarCoches;
    private javax.swing.JMenuItem mnuListarMotos;
    private javax.swing.JMenuItem mnuListarfurgonetas;
    private javax.swing.JMenu mnuMenuAlquiler;
    private javax.swing.JMenuItem mnuRegistrarCliente;
    private javax.swing.JMenu mnuVehiculos;
    private javax.swing.JMenuItem mnuVehiculosEnAlquiler;
    private javax.swing.JTabbedPane pnlPestañas;
    private javax.swing.JTable tblClintes;
    private javax.swing.JTable tblCoches;
    private javax.swing.JTable tblFurgonetas;
    private javax.swing.JTable tblMotos;
    private javax.swing.JTable tblTodosLosVehiculos;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTable tblVehiculosDisponibles;
    private javax.swing.JTable tblVehiculosEnAlquiler;
    private javax.swing.JTable tblVehiculosNoDisponibles;
    private javax.swing.JTextField txtCantidadUsuarios;
    private javax.swing.JTextField txtCapacidad;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCedulaCliente;
    private javax.swing.JPasswordField txtClaveCrearUsuario;
    private javax.swing.JPasswordField txtConfirmarClave;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtFiltro;
    private javax.swing.JTextField txtKmCarro;
    private javax.swing.JTextField txtKmFurgoneta;
    private javax.swing.JTextField txtKmMoto;
    private javax.swing.JTextField txtKmRecorrido;
    private javax.swing.JTextField txtKmRecorridoCoche;
    private javax.swing.JTextField txtKmRecorridoFurgoneta;
    private javax.swing.JTextField txtMatriculaCarro;
    private javax.swing.JTextField txtMatriculaFurgon;
    private javax.swing.JTextField txtMatriculaMoto;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txtValorAlquilerCarro;
    private javax.swing.JTextField txtValorAlquilerFurgoneta;
    private javax.swing.JTextField txtValorAlquilerMoto;
    private javax.swing.JTextField txtValorCancelar;
    private javax.swing.JTextField txtValorCancelarCoche;
    private javax.swing.JTextField txtValorCancelarFurgoneta;
    // End of variables declaration//GEN-END:variables

}
