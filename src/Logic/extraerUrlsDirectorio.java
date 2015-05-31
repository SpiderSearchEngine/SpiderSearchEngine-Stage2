
package Logic;

import java.io.File;

/**
 * Clase para acceder a un directorio y formar una lista con todo lo que se encuentre este buscador.
 * @author Gerald M, Jairo O.
 */
public class extraerUrlsDirectorio {
    
    /**
     * Clase para buscar los archivos que estan en un directorio
     * @param pDireccion
     * @return pila con las direcciones encontradas en los directorios
     */
    public stackList busquedaArchivos(String pDireccion) {
        stackList pila = new stackList(null);
        File directorio = new File(pDireccion);
        String[] ficheros = directorio.list();
        if (ficheros == null)
            System.out.println("No hay ficheros en este directorio");
        else {
            for (int x=0;x<ficheros.length;x++){
                pila.push(new url(pDireccion+ficheros[x]+"/", 43, 2));
            }
        }
        return pila;
    }
}