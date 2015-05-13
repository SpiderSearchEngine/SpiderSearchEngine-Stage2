package Logic;

/**
 * Clase para crear las listas circulares.
 * @author Gerald M, Jairo O.
 */
public class circularList <G>{
    private node _head;
    /**
     * Constructor de la clase.
     * @param _head. Referencia de insercion en la lista.
     */
    public circularList (node phead){
        this._head=phead;
    }
    
    /**
     * Metodo para obtener el head de la lista.
     * @return el nodo head.
     */    
    public node getHead (){
        return this._head;
    }
    /**
     * Metodo para modificar el head de la lista.
     * @param head. Nuevo valor del head.
     */
    public void setHead(node phead){
        this._head=phead;
    }
    /**
     * Metodo para insertar por el head en la lista.
     * @param pData. Dato a insertar.
     */
    public void insertHead (G pData){
        if (_head==null){
            _head=new node (pData, _head,_head );
            _head.setNextNode(_head);
            _head.setPrevNode(_head);
        }
        else {
            _head=(new node (pData, _head, _head.getPrevNode()));
            _head.getNextNode().setPrevNode(_head);
            _head.getPrevNode().setNextNode(_head);
        }
    }
    /**
     * Metodo para insertar por el tail en la lista.
     * @param pData. Dato a insertar.
     */
    public void insertTail(G pData){
        if (_head==null){
            _head=new node (pData, _head,_head );
            _head.setNextNode(_head);
            _head.setPrevNode(_head);
        }
        else{
            node tmp=_head;
            while (tmp.getNextNode()!=_head)
                tmp=tmp.getNextNode();
            tmp.setNextNode(new node (pData, tmp.getNextNode(), tmp));
            tmp.getPrevNode().setPrevNode(tmp.getNextNode());
        }
    }
    /**
     * Metodo para insertar en orden a la lista.
     * @param pData. Dato a insertar.
     */
    public void insertInOrder(G pData){
        if (_head==null){
            _head=new node (pData, _head, _head);
            _head.setNextNode(_head);
            _head.setPrevNode(_head);
        }
        else if ((Integer)pData<(Integer)_head.getData()){            
            _head=(new node(pData, _head,_head.getPrevNode()));
            _head.getNextNode().setPrevNode(_head);
            _head.getPrevNode().setNextNode(_head);            
        }
        else{
            node tmp=_head;
            while(tmp.getNextNode()!=_head && (Integer)tmp.getNextNode().getData()<(Integer)pData)
                tmp=tmp.getNextNode();
            tmp.setNextNode(new node (pData, tmp.getNextNode(), tmp));
            tmp.getNextNode().getNextNode().setPrevNode(tmp.getNextNode());
        }
    }
    /**
     * Metodo para eliminar un dato de la lista.
     * @param pData. Dato a eliminar.
     * @return nodo eliminado.
     */
    public node delete (G pData){
        node tmp=null;
        if (_head==null)
            return null;
        else if ((Integer)_head.getData()==(Integer)pData && _head.getNextNode()==_head){
            tmp=_head;
            _head=null;
        }
        else{
            tmp=_head;
            _head=_head.getNextNode();
            while(tmp!=_head &&(Integer) _head.getData()!=(Integer)pData)
                _head=_head.getNextNode();
            if (tmp==_head && (Integer)_head.getData()!=(Integer)pData)
                tmp=null;
            else{
                tmp=_head;
                tmp.getPrevNode().setNextNode(tmp.getNextNode());
                tmp.getNextNode().setPrevNode(tmp.getPrevNode());
                _head=tmp.getNextNode();
                tmp.setNextNode(null);
                tmp.setPrevNode(null);
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
        while(tmp.getNextNode()!=_head){
            if (!((urlProcesado)(tmp.getData())).getDireccion().equals((String)pData))
                tmp=tmp.getNextNode() ;
            else{
                condition=true;
                break;
            }
        }
        if (((urlProcesado)(tmp.getData())).getDireccion().equals((String)pData))
            condition=true;
        return condition;        
    }
    /**
     * Metodo para imprimir la lista.
     */
    public void print (){
        node tmp=_head;
        int i=0;
        while(tmp.getNextNode()!=_head){
            System.out.println("pos= "+(i++)+" dato = "+tmp.getData());
            tmp=tmp.getNextNode();
        }
        System.out.println("pos= "+(i++)+" dato = "+tmp.getData());
    }   
}