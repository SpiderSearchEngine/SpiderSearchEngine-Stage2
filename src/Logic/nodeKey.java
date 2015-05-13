
package Logic;

/**
* Clase para la lista de referencias de las palabras.
* @author Gerald M, Jairo O.
*/
public class nodeKey <G> {
    
    private G _data;
    private nodeKey _next;
    private nodeKey _prev;
    private node _num;
    
    /**
     * Constructor de la clase
     * @param pdata, dato de la lista
     * @param pnext, siguiente nodo
     * @param pprev, anterior nodo
     * @param pnum, nodo con el numero de veces que aparece la palabra en la url
     */
    public nodeKey(G pdata, nodeKey pnext, nodeKey pprev, node pnum){
        this._data=pdata;
        this._next=pnext;
        this._prev=pprev;
        this._num=pnum;
    }
    /**
    * Metodo para modificar el nodo que contiene las veces que aparece la palabra
    * @param _num, numero de veces que aparece la palabra
    */
    public void setNumNode(node _num){
        this._num=_num;
    }
    /**
     * Metodo para obtener  el nodo con el numero de veces que aparece la palabra
     * @return numero de veces que aparece la palabra
     */
    public node getNumNode() {
        return _num;
    }
    /**
     * Metodo para obtener el dato
     * @return el dato
     */
    public G getData() {
        return _data;
    }
    /**
     * Metodo para modificar el dato
     * @param pdata
     */
    public void setData(G pdata) {
        this._data = pdata;
    }
    /**
     * Metodo para obtener el siguiente nodo
     * @return siguiente nodo
     */
    public nodeKey getNextNode() {
        return _next;
    }
    /**
     * Metodo para modificar el siguiente nodo
     * @param pnext, siguiente nodo
     */
    public void setNextNode(nodeKey pnext) {
        this._next = pnext;
    }
    /**
     * Metodo para obtener el anterior nodo
     * @return nodo anterior
     */
    public nodeKey getPrevNode() {
        return _prev;
    }
    /**
     * Metodo para modificar el anterior nodo
     * @param pprev, anterior nodo
     */
    public void setPrevNode(nodeKey pprev) {
        this._prev = pprev;
    }
}