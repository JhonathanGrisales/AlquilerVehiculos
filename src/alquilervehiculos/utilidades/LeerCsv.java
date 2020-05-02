/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.utilidades;

import alquilervehiculos.modelo.AbstractVehiculo;
import alquilervehiculos.modelo.Coche;
import alquilervehiculos.modelo.Furgoneta;
import alquilervehiculos.modelo.Moto;
import alquilervehiculos.modelo.TipoUsuario;
import alquilervehiculos.modelo.Usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jhonathan_G
 */
public class LeerCsv {

    public static List<Usuario> cargarUsuarios(TipoUsuario[] tipos) {
        List<Usuario> listado = new ArrayList<>(); //Declarando listado de usuarios inicia vacio
        File archivo = null; //Objeto de tipo archivos
        FileReader fr = null; //Objeto filereader permite leer archivos de disco 
        BufferedReader br = null; //Objeto que permite llevar esos datos a la memoria ram 

        try {
            archivo = new File("src/usuarios.csv"); //Carpeta Raiz de proyecto 
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            // Lectura del fichero
            String linea;
            br.readLine(); //Leo una linea (Omitir encabezado)
            while ((linea = br.readLine()) != null) { //Mientras alla una linea para leer

                String[] datos = linea.split(";"); //La linea que se lea que se separe por ;

                Usuario usuario = new Usuario(
                        datos[0],
                        datos[1],
                        datos[2],
                        datos[3],
                        tipos[Integer.parseInt(datos[4]) - 1]);

                listado.add(usuario);

            }
        } catch (Exception e) {
            System.out.println("El archivo no existe = " + e.getMessage());
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return listado;
    }

//    public static List<AbstractVehiculo> cargarCoches() {
//        List<AbstractVehiculo> listado = new ArrayList<>(); //Declarando listado de usuarios inicia vacio
//        File archivo = null; //Objeto de tipo archivos
//        FileReader fr = null; //Objeto filereader permite leer archivos de disco 
//        BufferedReader br = null; //Objeto que permite llevar esos datos a la memoria ram 
//
//        try {
//            archivo = new File("src/coches.txt"); //Carpeta Raiz de proyecto 
//            fr = new FileReader(archivo);
//            br = new BufferedReader(fr);
//            // Lectura del fichero
//            String linea;
//
//            while ((linea = br.readLine()) != null) { //Mientras alla una linea para leer
//
//                String[] datos = linea.split(","); //La linea que se lea que se separe por ;
//
//                Coche coche = new Coche(Boolean.parseBoolean(datos[0]),
//                        datos[1],
//                        Integer.parseInt(datos[2]),
//                        Boolean.parseBoolean(datos[3]),
//                        Double.parseDouble(datos[4]));
//
//                listado.add(coche);
//
//            }
//        } catch (Exception e) {
//            //System.out.println("El archivo coches no existe = " + e.getMessage());
//        } finally {
//            try {
//                if (null != fr) {
//                    fr.close();
//                }
//            } catch (Exception e2) {
//                e2.printStackTrace();
//            }
//        }
//
//        return listado;
//    }

//     public static List<AbstractVehiculo> cargarMotos() {
//        List<AbstractVehiculo> listado = new ArrayList<>(); //Declarando listado de usuarios inicia vacio
//        File archivo = null; //Objeto de tipo archivos
//        FileReader fr = null; //Objeto filereader permite leer archivos de disco 
//        BufferedReader br = null; //Objeto que permite llevar esos datos a la memoria ram 
//
//        try {
//            archivo = new File("src/motos.txt"); //Carpeta Raiz de proyecto 
//            fr = new FileReader(archivo);
//            br = new BufferedReader(fr);
//            // Lectura del fichero
//            String linea;
//
//            while ((linea = br.readLine()) != null) { //Mientras alla una linea para leer
//
//                String[] datos = linea.split(","); //La linea que se lea que se separe por ;
//
//                Moto moto = new Moto(Boolean.parseBoolean(datos[0]),
//                        datos[1],
//                        Integer.parseInt(datos[2]),
//                        Boolean.parseBoolean(datos[3]),
//                        Double.parseDouble(datos[4]));
//
//                listado.add(moto);
//
//            }
//        } catch (Exception e) {
//            //System.out.println("El archivo coches no existe = " + e.getMessage());
//        } finally {
//            try {
//                if (null != fr) {
//                    fr.close();
//                }
//            } catch (Exception e2) {
//                e2.printStackTrace();
//            }
//        }
//
//        return listado;
//    }

    public static List<AbstractVehiculo> cargarCoches() {
        List<AbstractVehiculo> listado = new ArrayList<>(); //Declarando listado de usuarios inicia vacio
        File archivo = null; //Objeto de tipo archivos
        FileReader fr = null; //Objeto filereader permite leer archivos de disco 
        BufferedReader br = null; //Objeto que permite llevar esos datos a la memoria ram 

        try {
            archivo = new File("src/coches.txt"); //Carpeta Raiz de proyecto 
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

            }
        } catch (Exception e) {
            //System.out.println("El archivo coches no existe = " + e.getMessage());
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        
        try {
            archivo = new File("src/motos.txt"); //Carpeta Raiz de proyecto 
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

            }
        } catch (Exception e) {
            //System.out.println("El archivo coches no existe = " + e.getMessage());
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        
        try {
            archivo = new File("src/furgonetas.txt"); //Carpeta Raiz de proyecto 
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

            }
        } catch (Exception e) {
            //System.out.println("El archivo coches no existe = " + e.getMessage());
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        

        return listado;
    }
    
}
