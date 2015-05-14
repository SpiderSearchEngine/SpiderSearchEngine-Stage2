
package Logic;

/**
 * Clase que crea el arbol binario busqueda
 * @author Gerald M, Jairo O
 */
public class binaryTree <G>{
    private nodeTree _root;
    /**
     * Constructor de la clase
     * @param root 
     */
    public binaryTree(nodeTree root){
        this._root=root;
    }
    /**
     * Metodo para obtener la raiz del arbol
     * @return _root
     */
    public nodeTree getRoot(){
        return this._root;
    }
    /**
     * Metodo para modificar la raiz del arbol 
     * @param newRoot 
     */
    public void setRoot(nodeTree newRoot){
        this._root=newRoot;
    }
    /**
     * Metodo para insertar datos al arbol
     * @param pData 
     */
    public void insert (G pData){
        if (_root==null)
            _root=new nodeTree(pData, null, null, null, null);
        else
            insertAux(_root, new nodeTree(pData, null, null, null, null));
    }
    /**
     * Metodo auxiliar para insertar datos
     * @param pPadre
     * @param pData 
     */
    private void insertAux(nodeTree pPadre, nodeTree pData){
        if((Integer)pPadre.getData()>(Integer)pData.getData()){
            if(pPadre.getHijoIzq()==null)
                pPadre.setHijoIzq(pData);
            else
                insertAux(pPadre.getHijoIzq(), pData);
        }
        else{
            if(pPadre.getHijoDer()==null)
                pPadre.setHijoDer(pData);
            else
                insertAux(pPadre.getHijoDer(), pData);
        }
    }
    /**
     * Metodo para buscar si un dato esta en la estructura
     * @param pData
     * @return 
     */
    public boolean find(G pData){
        if(_root==null)
            return false;
        else
            return findAux(pData, _root);
    }
    /**
     * Metodo auxiliar para buscar un dato en la estructura
     * @param pData
     * @param pNode
     * @return 
     */
    private boolean findAux(G pData, nodeTree pNode){
        if((Integer)pData!=(Integer)pNode.getData() && pNode.getHijoDer()==null && pNode.getHijoIzq()==null)
            return false;
        else if((Integer)pNode.getData()==(Integer)pData)
            return true;
        else if ((Integer)pData<(Integer)pNode.getData())
            return findAux(pData, pNode.getHijoIzq());
        else
            return findAux(pData, pNode.getHijoDer());
    }
    /**
     * Metodo para borrar un dato de la estructura
     * @param pData
     * @return nodo eliminado
     */
    public nodeTree delete (G pData){
        if (_root == null)
            return null;
        else if ((Integer)_root.getData()==(Integer)pData && _root.getHijoDer()==null && _root.getHijoIzq()==null){
            nodeTree tmp = _root;
            _root=null;
            return tmp;
        }
        else if ((Integer)_root.getData()!=(Integer)pData && _root.getHijoDer()==null && _root.getHijoIzq()==null)
            return null;
        else if ((Integer)_root.getData()==(Integer)pData)
            return deleteRoot(_root);
        else
            return deleteAux(pData, _root, null);            
    }
    /**
     * Metodo auxilar para eliminar el dato
     * @param pData
     * @param pNode
     * @param parent
     * @return nodo eliminado
     */
    private nodeTree deleteAux(G pData, nodeTree pNode, nodeTree parent){
        if ((Integer)pData==(Integer)pNode.getData()){
            return deleteAux2(pData, pNode, parent);
        }
        else if ((Integer)pData<(Integer)pNode.getData())
            return deleteAux(pData, pNode.getHijoIzq(),pNode);
        else
            return deleteAux(pData, pNode.getHijoDer(),pNode);
    }
    /**
     * Metodo auxilar para eliminar el dato
     * @param pData
     * @param pNode
     * @param parent
     * @return nodo eliminado
     */
    private nodeTree deleteAux2(G pData, nodeTree pNode, nodeTree parent){
        if(pNode.getHijoDer()==null && pNode.getHijoIzq()==null){
                if ((Integer)pNode.getData()<(Integer)parent.getData()){
                    parent.setHijoIzq(null);
                    return pNode;
                }
                else{
                    parent.setHijoDer(null);
                    return pNode;
                }
            }
            else if(pNode.getHijoIzq()==null){
                if ((Integer)pNode.getData()<(Integer)parent.getData()){
                    parent.setHijoIzq(pNode.getHijoDer());
                    pNode.setHijoDer(null);
                    return pNode;
                }
                else{
                    parent.setHijoDer(pNode.getHijoDer());
                    pNode.setHijoDer(null);
                    return pNode;
                }
            }
            else if(pNode.getHijoDer()==null){
                if ((Integer)pNode.getData()<(Integer)parent.getData()){
                    parent.setHijoIzq(pNode.getHijoIzq());
                    pNode.setHijoIzq(null);
                    return pNode;
                }
                else{
                    parent.setHijoDer(pNode.getHijoIzq());
                    pNode.setHijoIzq(null);
                    return pNode;
                }
            }
            else{
                nodeTree aux = menorMayores(pNode.getHijoDer());
                nodeTree aux2 = aux.getPadre();
                if ((Integer)pNode.getData()<(Integer)parent.getData()){
                    if((Integer)aux.getData()<(Integer)aux2.getData())
                        aux2.setHijoIzq(null);
                    else
                        aux2.setHijoDer(null);
                    aux.setHijoIzq(pNode.getHijoIzq());
                    aux.setHijoDer(pNode.getHijoDer());
                    parent.setHijoIzq(aux);
                    pNode.setHijoIzq(null);
                    pNode.setHijoDer(null);
                    return aux2;
                }
                else{                    
                    if((Integer)aux.getData()<(Integer)aux2.getData())
                        aux2.setHijoIzq(null);
                    else
                        aux2.setHijoDer(null);
                    aux.setHijoIzq(pNode.getHijoIzq());
                    aux.setHijoDer(pNode.getHijoDer());
                    parent.setHijoDer(aux);
                    pNode.setHijoIzq(null);
                    pNode.setHijoDer(null);
                    return pNode;
                }
            }
    }
    /**
     * Metodo auxiliar para eliminar la raiz
     * @param pNode
     * @return nodo eliminado
     */
    private nodeTree deleteRoot(nodeTree pNode){
        if(pNode.getHijoIzq()==null){
            _root=pNode.getHijoDer();
            return pNode;
        }
        else if(pNode.getHijoDer()==null){
            _root=pNode.getHijoDer();
            return pNode;
        }
        else{
            nodeTree aux=menorMayores(pNode.getHijoDer());
            nodeTree aux2=aux.getPadre();
            if(aux==pNode.getHijoDer()){
                aux.setHijoIzq(pNode.getHijoIzq());
                pNode.setHijoIzq(null);
                pNode.setHijoDer(null);
            }
            else if (aux.getHijoDer()!=null){
                aux2.setHijoIzq(aux.getHijoDer());
                aux.setHijoDer(null);
                aux.setHijoIzq(pNode.getHijoIzq());
                aux.setHijoDer(aux2);
                pNode.setHijoDer(null);
                pNode.setHijoIzq(null);
            }
            else{
                aux.setHijoIzq(pNode.getHijoIzq());
                aux.setHijoDer(pNode.getHijoDer());
                aux2.setHijoIzq(null);
                pNode.setHijoDer(null);
                pNode.setHijoIzq(null);
            }
            _root=aux;
            return pNode;
        }
    }
    /**
     * Metodo para obtener el nodo menor de los mayores
     * @param pNode
     * @return 
     */
    private nodeTree menorMayores(nodeTree pNode){
        if (pNode.getHijoIzq()==null)
            return pNode;
        else
            return menorMayores(pNode.getHijoIzq());        
    }
    /**
     * Metodo para hacer el recorrido en preorden
     * @param pNode 
     */    
    public void preOrden(nodeTree pNode){
        if(pNode.getHijoIzq()== null && pNode.getHijoDer()==null)
            System.out.println(pNode.getData());
        else if(pNode.getHijoDer()==null){
            System.out.println(pNode.getData());
            preOrden(pNode.getHijoIzq());
        }
        else if (pNode.getHijoIzq()==null){
            System.out.println(pNode.getData());
            preOrden(pNode.getHijoDer());
        }
        else{
            System.out.println(pNode.getData());
            preOrden(pNode.getHijoIzq());
            preOrden(pNode.getHijoDer());
        }
    }
    /**
     * Metodo para hacer el recorrido en postOrden
     * @param pNode 
     */
    public void postOrden(nodeTree pNode){
        if(pNode.getHijoIzq()== null && pNode.getHijoDer()==null)
            System.out.println(pNode.getData());
        else if(pNode.getHijoDer()==null){
            postOrden(pNode.getHijoIzq());
            System.out.println(pNode.getData());
        }
        else if(pNode.getHijoIzq()==null){
            postOrden(pNode.getHijoDer());
            System.out.println(pNode.getData());
        }
        else{
            postOrden(pNode.getHijoIzq());
            postOrden(pNode.getHijoDer());
            System.out.println(pNode.getData());
        }            
    }
    /**
     * Metodo para hacer el recorrido en orden
     * @param pNode 
     */
    public void orden(nodeTree pNode){
        if(pNode.getHijoIzq()== null && pNode.getHijoDer()==null)
            System.out.println(pNode.getData());
        else if(pNode.getHijoDer()==null){
            orden(pNode.getHijoIzq());
            System.out.println(pNode.getData());
        }
        else if(pNode.getHijoIzq()==null){
            System.out.println(pNode.getData());
            orden(pNode.getHijoDer());
        }
        else{
            orden(pNode.getHijoIzq());
            System.out.println(pNode.getData());
            orden(pNode.getHijoDer());
        } 
    }
}