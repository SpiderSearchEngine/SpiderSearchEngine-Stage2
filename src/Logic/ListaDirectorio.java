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
public class ListaDirectorio {

    /**
     * @param args the command line arguments
     */
    public void busquedaArchivos() {
        File directorio = new File("/home/gerald/Imágenes");
		   
		String[] ficheros = directorio.list();
		   
		   
		if (ficheros == null)
			System.out.println("No hay ficheros en este directorio");
		else { 
			for (int x=0;x<ficheros.length;x++){
				System.out.println(ficheros[x]);
			}
		}
    }
    
}
