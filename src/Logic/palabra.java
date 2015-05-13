
package Logic;

/**
 * Clase para los objetos de las palabras
 * @author Gerald M, Jairo O.
 */
public class palabra <G>{
    
    private String name;
    private listKey listaReferencia;
    
    /**
     * Constructor de la clase
     * @param ppalabra, palabra
     * @param plistaReferencias, lista con los urls que la incluyen. 
     */
    public palabra(String ppalabra, listKey plistaReferencias){
       this.name=ppalabra;
       this.listaReferencia=plistaReferencias;
    }
    /**
     * Metodo para modificar nombre de la palabra.
     * @param ppalabra, palabra que se quiere modificar
     */
    public void setname(String ppalabra){
        this.name=ppalabra;
    }
    /**
     * Metodo para obtener la palabra
     * @return nombre de la palabra.
     */
    public String getName(){
        return name;
    }
    /**
     * Metodo para la obtencion de la lista de referencias.
     * @return lista con los links que contienen la palabra
     */
    public listKey getListaReferencia(){
        return listaReferencia;
    }
    /**
     * Metodo para insertar un url relacionado con la palabra.
     * @param purl, url a insertar
     */
    public void insertar (node purl){
        listaReferencia.insertHead(purl);
    }
}
