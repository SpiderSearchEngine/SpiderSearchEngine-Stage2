/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
     * @return the _Data
     */
    public int getData() {
        return _Data;
    }

    /**
     * @param _Data the _Data to set
     */
    public void setData(int _Data) {
        this._Data = _Data;
    }
    
    
}
