
package Logic;

/**
 * Clase para los objetos de las palabras
 * @author Gerald M, Jairo O.
 */
public class palabra <G>{
    
    private String _name;
    private int _apariciones;
    private list _listaReferencia;
    
    /**
     * Constructor de la clase
     * @param ppalabra, palabra
     * @param plistaReferencias, lista con los urls que la incluyen. 
     */
    public palabra(String ppalabra, list plistaReferencias){
       this._name=ppalabra;
       this._listaReferencia=plistaReferencias;
    }
    /**
     * Metodo para modificar nombre de la palabra.
     * @param ppalabra, palabra que se quiere modificar
     */
    public void setName(String ppalabra){
        this._name=ppalabra;
    }
    /**
     * Metodo para obtener la palabra
     * @return nombre de la palabra.
     */
    public String getName(){
        return _name;
    }
    /**
     * Metodo para la obtencion de la lista de referencias.
     * @return lista con los links que contienen la palabra
     */
    public list getListaReferencia(){
        return _listaReferencia;
    }
    
    public void setApariciones(int pApariciones){
        this._apariciones=pApariciones;
    }
    
    public int getApariciones(){
        return _apariciones;
    }
    /**
     * Metodo para insertar un url relacionado con la palabra.
     * @param purl, url a insertar
     */
    public void insertar (nodeTree purl){
        _listaReferencia.insertHead(purl);
    }
    
}
