
package Logic;

/**
 * Clase del objeto url
 * @author Gerald M, Jairo O.
 */
public class url {
    
    private int _numAsoc;
    private String _direccion;
    /**
     * Constructor de la clase
     * @param pnumAsoc, grado de recursividad
     * @param pdireccion, url a procesar
     */
    public url (String pdireccion, int pnumAsoc){
        this._numAsoc=pnumAsoc;
        this._direccion=pdireccion;
    }/**
     * Metodo para modificar el numero asociado
     * @param pnumAsoc 
     */
    public void setNumAsoc (int pnumAsoc){
        this._numAsoc=pnumAsoc;
    }
    /**
     * Funcion para obtener el numero asociado
     * @return _numAsoc, el nivel de recursividad
     */
    public int getNumAsoc(){
        return _numAsoc;
    }
    /**
     * Metodo para modificar la direccion
     * @param pdireccion 
     */
    public void setDireccion (String pdireccion){
        this._direccion=pdireccion;
    }
    /**
     * Metodo para obtener la url
     * @return url
     */
    public String getDireccion (){
        return _direccion;
    }
}
