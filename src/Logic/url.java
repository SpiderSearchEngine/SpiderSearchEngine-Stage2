
package Logic;

/**
 * Clase del objeto url
 * @author Gerald M, Jairo O.
 */
public class url {
    
    private int _pesoAsoc;
    private int _numAsoc;
    private String _direccion;
    /**
     * Constructor de la clase
     * @param pnumAsoc, grado de recursividad
     * @param pdireccion, url a procesar
     */
    public url (String pdireccion, int pPesoAsoc, int pnumAsoc){
        this._direccion=pdireccion;
        this._pesoAsoc=pPesoAsoc;
        this._numAsoc=pnumAsoc;
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
    /**
     * Metodo para modificar el peso de la direccion
     * @param pPeso 
     */
    public void setPesoAsoc(int pPeso){
        this._pesoAsoc=pPeso;        
    }
    /**
     * Metodo para obtener el peso de la direccion
     * @return peso asociado
     */
    public int getPesoAsoc(){
        return this._pesoAsoc;
    }
    /**
     * Metodo para modificar el numero asociado (recursividad)
     * @param pNum 
     */
    public void setNumAsoc(int pNum){
        this._numAsoc= pNum;        
    }
    /**
     * Metodo para obtener el numero Asociado (recursividad)
     * @return numero asociado
     */
    public int getNumAsoc(){
        return this._numAsoc;
    }
}
