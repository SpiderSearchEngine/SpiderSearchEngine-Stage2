
package Logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Clase para extraer texto plano desde una direccion Url.
 *@author Jairo O, Gerald M.
 */
public class extraeTexto {

    public static String linkfinal;
    /**
    * Funcion para extraer todo el texto de una pagina html.
    * @return
    * @throws MalformedURLException
    * @throws IOException 
    */
    public String extraerTexto(String pstring_url)throws MalformedURLException, IOException, FileNotFoundException {
        String contenido="";
        try{
            URL url= new URL(pstring_url);
            URLConnection conexion=url.openConnection();
            conexion.connect();
            InputStream entradaDeDatos =conexion.getInputStream();
            BufferedReader lecturaDeDatos= new BufferedReader(new InputStreamReader(entradaDeDatos));
            String linea=lecturaDeDatos.readLine();
            while (linea!=null){
                    contenido+=linea;
                    linea=lecturaDeDatos.readLine();
                }
        }
            catch (FileNotFoundException e) {
                e.printStackTrace();
                }
    return contenido;
    }
}