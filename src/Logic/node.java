
package Logic;

/**
 * Clase para crear los nodos.
 * @author Gerald M, Jairo O.
 */
public class node <G>{
    private G _pdata;
    private node _next;
    private node _prev;
    /**
     * Constructor de la clase.
     * @param pdata. dato para  insertar.
     * @param next. Siguiente nodo.
     * @param prev. anterior nodo.
     */
    public node (G pdata, node next,  node prev){
        this._pdata=pdata;
        this._next=next;
        this._prev=prev;        
    }
    /**
     * Metodo para obtener el dato de un elemento.
     * @return elemento deseado.
     */
    public G getData (){
        return _pdata;
    }
    /**
     * Metodo para obtener el siguiente nodo.
     * @return. siguiente nodo.
     */
    public node getNextNode (){
        return _next;
    }
    /**
     * Metodo para obtener el anterior nodo.
     * @return el nodo anterior
     */
    public node getPrevNode (){
        return _prev;
    }
    /**
     * Metodo para modificar el dato.
     * @param pdata. Dato para modificar.
     */
    public void setData (G pdata){
        this._pdata=pdata;
    }
    /**
     * Metodo para modificar el siguiente nodo
     * @param next. Siguiente nodo para modifcar.
     */
    public void setNextNode (node next){
        this._next=next;
    }
    /**
     * Metodo para modificar el nodo previo.
     * @param prev. Nodo previo
     */
    public void setPrevNode (node prev){
        this._prev=prev;
    }
}