
package Logic;

/**
 * Clase para tener los urls procesados
 * @author Gerald M, Jairo O.
 */
public class urlProcesado {
    private int _cantPalabras;
    private String _direccion;
    /**
     * Constructor de la clase
     * @param pdireccion, url procesada
     * @param pcantPalabras, veces que se ha procesado 
     */
    public urlProcesado (String pdireccion, int pcantPalabras){
        this._cantPalabras=pcantPalabras;
        this._direccion=pdireccion;
    }
    /**
     * Metodo para modificar el numero asociado a un url.
     * @param pnumAsoc, numero de veces procesado el url.
     */
    public void setcantPalabras (int pnumAsoc){
        this._cantPalabras=pnumAsoc;
    }
    /**
     * Metodo para obtener la cantPalabras del url.
     * @return _cantPalabras
     */
    public int getcantPalabras(){
        return _cantPalabras;
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
