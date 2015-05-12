
package Logic;

/**
 * Clase para generar las pilas de datos
 * @author Gerald M, Jairo O.
 */
public class stackList <G>{
    
    private node _head;
    /**
     * Constructor de la clase
     * @param phead, elemento inicial
     */
    public stackList (node phead){
        this._head=phead;
    }
    /**
     * Metodo para insertar elementos.
     * @param pData, elemento a insertar.
     */
    public void push (G pData){
        _head=new node (pData, _head, null);
    }
    /**
     * Metodo para sacar elementos.
     * @return elemento borrado.
     */
    public node pop (){
        node tmp = _head;
        _head = _head.getNextNode();
        tmp.setNextNode(null);
        return tmp;
    }
    /**
     * Metedo para obtener el primer elemento.
     * @return primer elemento.
     */
    public node top (){
        return _head;
    }
    public void print (){
        node tmp=_head;
        int i=0;
        while(tmp!=null){
            System.out.println(tmp.getData());
            tmp=tmp.getNextNode();
        }
    }
}
