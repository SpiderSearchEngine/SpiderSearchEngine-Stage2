package Logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Clase para obtener los links de las paginas web
 * @author Gerald M, Jairo O.
 */
public class extraerLinks {
    private String _url;
    /**
     * Constructor de la clase
     * @param url 
     */
    public extraerLinks(String purl){
        this._url=purl;
    }
    /**
     * Metodo que extrae el HTML de la pagina web
     * @param pstring_url. Pagina solicitada
     * @throws MalformedURLException
     * @throws IOException 
     */
    public stackList extraerTexto(String pstring_url, int pnumAsoc) throws MalformedURLException, IOException{
        URL url = new URL(pstring_url);
        URLConnection conexion=url.openConnection();
        InputStream entrada =conexion.getInputStream();
        BufferedReader br= new BufferedReader(new InputStreamReader(entrada)); 
        String contenido="";
        String linea=br.readLine();
        while (linea!=null){
                contenido+=linea;
                linea=br.readLine();
        }
        return extraerURL(contenido, pnumAsoc);
    }
    /**
     * Metodo para obtener solamente los links
     * @param pcontenido. HTML de la pagina web
     */
    private stackList extraerURL(String pcontenido, int pnumAsoc) {
        Pattern patron=Pattern.compile("(?i)HREF\\s*=\\s*\"(.*?)\"");
        Matcher matcher=patron.matcher(pcontenido);
        stackList sl = new stackList (null);
        while(matcher.find())
            sl.push(matcher.group(1));
        return verificar(sl, _url, pnumAsoc);
    }

    
    
    /**
     * Metodo para dar el formato a los links
     * @param pdato. link a analizar
     * @param purl. Pagina solicitada
     */
    private stackList verificar(stackList ppila, String purl, int pnumAsoc){
        stackList sl = new stackList (null);
        while (ppila.top()!=null){
            String dato = (String)ppila.top().getData();
            if (dato.endsWith(".css")||dato.startsWith("//")|| dato.startsWith("#") || dato.startsWith("https"))
                ppila.pop();
            else if (dato.startsWith("http")){
                String str ="";
                int i=0;
                str=dato.substring(i,dato.length());
                sl.push(new url(str, pnumAsoc+1));
                ppila.pop();
            }
            else if (dato.length()>1 && dato.startsWith("/") ){
                sl.push(new url(_url+dato, pnumAsoc+1));
                ppila.pop();
            }
            else{
                ppila.pop();
            }
        }
        return sl;
    }
}