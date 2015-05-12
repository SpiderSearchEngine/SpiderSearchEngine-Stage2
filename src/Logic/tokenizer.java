
package Logic;

import java.util.StringTokenizer;

/**
 * Clase para separar las palabras
 * @author Gerald M, Jairo O.
 */
public class tokenizer <G>{
    private String _dato;
    private String _url;
    private int _contador=0;
    
    /**
     * Constructor de la clase
     * @param paProcesar, palabra a procesar
     * @param purl, url que se esta procesando 
     */
    public tokenizer(String paProcesar, String purl){
         this._dato=paProcesar;
         this._url=purl;
    }
    /**
     * Metodo que genera la pila de las palabras validas
     * @return pilaPalabras, pila con todas las palabras validas
     */
    public stackList procesar(){
        stackList pilaPalabras = new stackList (null);
        StringTokenizer cadenaTokenizer = new StringTokenizer(_dato);
        while (cadenaTokenizer.hasMoreTokens()) {
            _dato = (String)cadenaTokenizer.nextToken();
            if (_dato.length()>=3 && _dato.compareTo("ante")!=0 
                    && _dato.compareTo("bajo")!=0 && _dato.compareTo("cabe")!=0 
                    && _dato.compareTo("con")!=0 && _dato.compareTo("contra")!=0 
                    && _dato.compareTo("desde")!=0 && _dato.compareTo("entre")!=0 
                    && _dato.compareTo("hacia")!=0 && _dato.compareTo("hasta")!=0 
                    && _dato.compareTo("para")!=0 && _dato.compareTo("por")!=0 
                    && _dato.compareTo("según")!=0 && _dato.compareTo("sin")!=0 
                    && _dato.compareTo("sobre")!=0 && _dato.compareTo("tras")!=0 
                    && _dato.compareTo("que")!=0 && _dato.compareTo("del")!=0 
                    && _dato.compareTo("los")!=0 && _dato.compareTo("las")!=0 
                    && _dato.compareTo("Ante")!=0 && _dato.compareTo("Bajo")!=0 
                    && _dato.compareTo("Cabe")!=0 && _dato.compareTo("Con")!=0 
                    && _dato.compareTo("Contra")!=0 && _dato.compareTo("Desde")!=0 
                    && _dato.compareTo("Entre")!=0 && _dato.compareTo("Hacia")!=0 
                    && _dato.compareTo("Hasta")!=0 && _dato.compareTo("Para")!=0
                    && _dato.compareTo("Por")!=0 && _dato.compareTo("Según")!=0
                    && _dato.compareTo("Sin")!=0 && _dato.compareTo("Sobre")!=0 
                    && _dato.compareTo("Tras")!=0 && _dato.compareTo("Que")!=0 
                    && _dato.compareTo("Del")!=0 && _dato.compareTo("Los")!=0
                    && _dato.compareTo("Las")!=0){
                pilaPalabras.push(_dato);
            }
        }
        return pilaPalabras;
    }
}
