/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.io.File;

/**
 * Clase para acceder a un directorio y formar una lista con todo lo que se encuentre este buscador.
 * @author Gerald M, Jairo O.
 */
public class extraerUrlsDirectorio {
    
    public stackList busquedaArchivos(String pDireccion) {
        stackList pila = new stackList(null);
        File directorio = new File(pDireccion);
        String[] ficheros = directorio.list();
        if (ficheros == null)
            System.out.println("No hay ficheros en este directorio");
        else {
            for (int x=0;x<ficheros.length;x++){
                pila.push(pDireccion+ficheros[x]);
            }
        }
        return pila;
    }
}