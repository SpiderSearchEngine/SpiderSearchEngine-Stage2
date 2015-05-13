
package Logic;

/**
 * Clase para tener los urls procesados
 * @author Gerald M, Jairo O.
 */
public class urlProcesado {
    private int _referencia;
    private String _direccion;
    /**
     * Constructor de la clase
     * @param pdireccion, url procesada
     * @param preferencia, veces que se ha procesado 
     */
    public urlProcesado (String pdireccion, int preferencia){
        this._referencia=preferencia;
        this._direccion=pdireccion;
    }
    /**
     * Metodo para modificar el numero asociado a un url.
     * @param pnumAsoc, numero de veces procesado el url.
     */
    public void setReferencia (int pnumAsoc){
        this._referencia=pnumAsoc;
    }
    /**
     * Metodo para obtener la referencia del url.
     * @return _referencia
     */
    public int getReferencia(){
        return _referencia;
    }
    /**
     * Metodo para modificar la direccion
     * @param pdireccion 
     */
    public void setDireccion (String pdireccion){
        this._direccion=pdireccion;
    }
    /**
     * Metodo para obtener direccion url
     * @return _direccion
     */
    public String getDireccion (){
        return _direccion;
    }    
}
