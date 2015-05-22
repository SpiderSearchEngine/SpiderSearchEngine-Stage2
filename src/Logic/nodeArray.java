
package Logic;

/**
 *Esta clase corresponde al array que es la representacion del arbol Heap
 * @author gerald
 */
public class nodeArray {
    private int _Data;
    /**
     * Constructor de la clse
     */
    public nodeArray(int pData){
        this._Data=pData;
    }

    /**
     * Metodo para obtener el dato de un elemento.
     * @return the _Data
     */
    public int getData() {
        return _Data;
    }

    /**
     * Metodo para modificar el dato.
     * @param _Data the _Data to set
     */
    public void setData(int _Data) {
        this._Data = _Data;
    }
    
    
}
