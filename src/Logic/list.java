package Logic;

/**
 * Clase para crear las listas doblemente enlazadas.
 * @author Gerald M, Jairo O.
 */
public class list <G>{
    private node _head;
    private node _tail;
    /**
     * Constructor de la clase.
     * @param _head. Primer elemento de la lista.
     * @param _tail. Ultimo elemento de la lista.
     */
    public list (node phead, node ptail){
        this._head=phead;
        this._tail=ptail;
    }
    /**
     * Metodo para obtener el head de la lista.
     * @return el nodo head.
     */
    public node getHead (){
        return this._head;
    }
    /**
     * Metodo para obtener el tail de la lista.
     * @return el nodo tail
     */
    public node getTail (){
        return this._tail;
    }
    /**
     * Metodo para modificar el head de la lista.
     * @param head. Nuevo valor del head.
     */
    public void setHead(node phead){
        this._head=phead;
    }
    /**
     * Metodo para modificar el tail de la lista.
     * @param tail. Nuevo valor del tail.
     */
    public void setTail(node ptail){
        this._tail=ptail;
    }
    /**
     * Metodo para insertar por el head en la lista.
     * @param pData. Dato a insertar.
     */
    public void insertHead(G pData){
        if (_head==null){
            _head=(new node (pData, _head, _tail));
            _tail=_head;
        }
        else{
            _head=(new node (pData, _head, null));
            _head.getNextNode().setPrevNode(_head);
        }       
    }
    /**
     * Metodo para insertar por el tail en la lista.
     * @param pData. Dato a insertar.
     */
    public void insertTail (G pData){
        if(_head==null){
            _head= new node(pData, _head, _tail);
            _tail=_head;
        }
        else{
            node tmp = _head;
            while(tmp.getNextNode()!=null)
                tmp=tmp.getNextNode();
            tmp.setNextNode(new node(pData, null, tmp));
            _tail=tmp.getNextNode();
        }
    }
    /**
     * Metodo para insertar en orden en la lista.
     * @param pData. Dato a insertar.
     */
    public void insertInOrder(G pData){
        if (_head==null){
            _head=new node(pData, _head, _tail);
            _tail=_head;
        }
        else if ((Integer)pData<(Integer)_head.getData()){
            _head=(new node(pData, _head,null));
            _head.getNextNode().setPrevNode(_head);
        }
        else{
            node tmp = _head;
            while(tmp.getNextNode()!=null && ((Integer)tmp.getNextNode().getData()<(Integer)pData))
                tmp=tmp.getNextNode();
            if(tmp.getNextNode()==null){
                tmp.setNextNode(new node(pData,null,tmp));
                _tail=tmp.getNextNode();
            }
            else{
                tmp.setNextNode(new node(pData, tmp.getNextNode(),tmp));
                tmp.getNextNode().getNextNode().setPrevNode(tmp.getNextNode());
            }
        }
    }/**
     * Metodo para eliminar un dato de la lista.
     * @param pData. Dato a eliminar.
     * @return nodo eliminado.
     */
    public node delete (G pData){
        node tmp = null;
        if (_head == null)
            return _head;
        else if ((Integer)_head.getData()==(Integer)pData){
            tmp=_head;
            if (_head.getNextNode()==null){
                _head=null;
            }
            else{ 
                tmp.getNextNode().setPrevNode(null);
                _head=_head.getNextNode();
                tmp.setNextNode(null);
            }
        }
        else{
            tmp = _head.getNextNode();
            while(tmp!=null && (Integer)tmp.getData()!=(Integer)pData)
                tmp=tmp.getNextNode();
            if (tmp==null)
                return null;
            else{
                if (tmp.getNextNode()==null){
                    tmp.getPrevNode().setNextNode(null);
                    _tail=tmp.getPrevNode();
                    tmp.setPrevNode(null);
                }
                else {
                    tmp.getPrevNode().setNextNode(tmp.getNextNode());
                    tmp.getNextNode().setPrevNode(tmp.getPrevNode());
                    tmp.setNextNode(null);
                    tmp.setPrevNode(null);
                }
            }
        }
        return tmp;
    }
    /**
     * Metodo para verificar si esta un elemento especifico en la lista.
     * @param pData. Dato a verificar.
     * @return valor booleano (true, si esta; false, en caso contrario).
     */
    public boolean find (G pData){
        node tmp = _head;
        boolean condition = false;
        while(tmp!=null){
            if (((String)tmp.getData())!=((String)pData))
                tmp=tmp.getNextNode();
            else{
                condition=true;
                break;
            }
        }
        return condition;        
    }
    /**
     * Este metodo encuentra las palabras en la lista de keywords
     * @param pData
     * @return 
     */
    public boolean findSpecial (G pData){
        node tmp = _head;
        boolean condition = false;
        while(tmp!=null){
            if (!(((String)((palabra)tmp.getData()).getName()).equals((String)pData)))
                tmp=tmp.getNextNode();            
            else{
                condition=true;
                break;
            }
        }
        return condition;        
    }
    /**
     * Metodo para imprimir la lista.
     */
    public void print (){
        node tmp=_head;
        int i=0;
        while(tmp!=null){
            System.out.println("pos= "+(i++)+" dato = "+tmp.getData());
            tmp=tmp.getNextNode();
        }
    }
}