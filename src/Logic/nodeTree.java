
package Logic;

/**
 * Clase para los nodos de los arboles
 * @author Gerald M, Jairo O
 */
public class nodeTree <G>{    
    private G _data;
    private nodeTree _hDer;
    private nodeTree _hIzq;
    private nodeTree _padre;
    private int _altura;
    private int _FE;
    private String _color;
    /**
     * Constructor de la clase
     * @param pData, dato del nodo
     * @param pPadre, nodo padre
     * @param pHDer, nodo hijo derecho
     * @param pHIzq, nodo hijo izquierdo
     */
    public nodeTree (G pData, nodeTree pPadre, nodeTree pHDer,  nodeTree pHIzq, String pColor){
        this._data=pData;
        this._hDer=pHDer;
        this._hIzq=pHIzq;
        this._padre=pPadre;
        this._color=pColor;
    }
    /**
     * Metodo para obtener el dato del nodo
     * @return _data
     */
    public G getData (){
        return this._data;
    }
    /**
     * Metodo para obtener el padre del nodo
     * @return _padre
     */
    public nodeTree getPadre (){
        return this._padre;
    }
    /**
     * Metodo para obtener el hijo derecho
     * @return _hDer
     */
    public nodeTree getHijoDer (){
        return this._hDer;
    }
    /**
     * Metodo para obtener el hijo izquierdo
     * @return _hIzq
     */
    public nodeTree getHijoIzq (){
        return this._hIzq;
    }
    /**
     * Metodo para obtener la altura del arbol (Arbol AVL)
     * @return _altura
     */
    public int getAltura(){
        return this._altura;
    }
    /**
     * Metodo para obtener el factor de equilibrio (Arbol AVL)
     * @return _FE
     */
    public int getFE(){
        return this._FE;
    }
    /**
     * Metodo para obtener el color de un nodo (Arbol RN)
     * @return _color
     */
    public String getColor(){
        return this._color;
    }
    /**
     * Metodo para modificar el dato del nodo
     * @param pData 
     */
    public void setData (G pData){
        this._data=pData;
    }
    /**
     * Metodo para modificar el padre del nodo
     * @param pPadre 
     */
    public void setPadre (nodeTree pPadre){
        this._padre=pPadre;
    }
    /**
     * Metodo para modificar el hijo derecho
     * @param pHDer 
     */
    public void setHijoDer (nodeTree pHDer){
        this._hDer=pHDer;
    }
    /**
     * Metodo para modificar el hijo izquierdo
     * @param pHIzq 
     */
    public void setHijoIzq (nodeTree pHIzq){
        this._hIzq=pHIzq;
    }
    /**
     * Metodo para modificar la altura (Arbol AVL)
     * @param newAlt 
     */
    public void setAltura(int newAlt){
        this._altura=newAlt;
    }
    /**
     * Metodo para modificar el factor de equilibrio (Arbol AVL)
     * @param newFE 
     */
    public void setFE(int newFE){
        this._FE=newFE;
    }
    /**
     * Metodo para modificar el color del nodo (Arbol RN)
     * @param pColor 
     */
    public void setColor(String pColor){
        this._color=pColor;
    }
}
