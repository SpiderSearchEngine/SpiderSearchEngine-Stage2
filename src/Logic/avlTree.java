
package Logic;

/**
 * Clase para crear el arbol avl
 * @author Gerald M, Jairo O
 */
public class avlTree <G>{
    private nodeTree _root;
    private int _uno=1;
    private int _cero=0;
    /**
     * Constructor de la clase
     * @param root. Elemento raiz
     */
    public avlTree(nodeTree root){
        this._root=root;
    }
    /**
     * Metodo para obtener la raiz
     * @return _root
     */
    public nodeTree getRoot(){
        return this._root;
    }
    /**
     * Metodo para modificar la raiz
     * @param newRoot. Nueva raiz
     */
    public void setRoot(nodeTree newRoot){
        this._root=newRoot;
    }
    /**
     * Metodo para insertar un dato en el arbol
     * @param pData
     */
    public void insert (G pData){
        if(_root==null){
            _root=new nodeTree(pData, null, null,null, null);
            _root.setAltura(_uno);
            _root.setFE(_cero);
        }
        else
            insertAux(new nodeTree (pData,null,null,null, null), _root);
    }
    /**
     * Metodo auxiliar para insertar
     * @param pNode
     * @param padre 
     */
    private void insertAux(nodeTree pNode, nodeTree padre){
        if((Integer)pNode.getData()>(Integer)padre.getData()){
            if(padre.getHijoDer()==null){
                padre.setHijoDer(pNode);
                pNode.setPadre(padre);
                modificarAltura(_root);
            }
            else
                insertAux(pNode,padre.getHijoDer());
        }
        else{
            if(padre.getHijoIzq()==null){
                padre.setHijoIzq(pNode);
                pNode.setPadre(padre);
                modificarAltura(_root);
            }
            else
                insertAux(pNode, padre.getHijoIzq());
        }
    }
    /**
     * Metodo que realiza la rotacion simple a la derecha
     * @param pNode 
     */
    public void RSD(nodeTree pNode){
        nodeTree tmp=pNode.getHijoIzq();
        if(tmp.getHijoDer()==null){
            tmp.setHijoDer(pNode);
            pNode.setHijoIzq(null);
            if(pNode==_root){
                _root=tmp;
                tmp.setPadre(null);
            }
            else if ((Integer)pNode.getData()>(Integer)pNode.getPadre().getData()){
                pNode.getPadre().setHijoDer(tmp);
                tmp.setPadre(pNode.getPadre());
            }
            else{
                pNode.getPadre().setHijoIzq(tmp);
                tmp.setPadre(pNode.getPadre());
            }
            pNode.setPadre(tmp);
            
        }
        else{
            pNode.setHijoIzq(tmp.getHijoDer());
            pNode.getHijoIzq().setPadre(pNode);
            tmp.setHijoDer(pNode);
            if(pNode==_root)
                _root=tmp;
            else if ((Integer)pNode.getData()>(Integer)pNode.getPadre().getData())
                pNode.getPadre().setHijoDer(tmp);
            else
                pNode.getPadre().setHijoIzq(tmp);
            pNode.setPadre(tmp);
        }
        modificarAltura(tmp);
    }
    /**
     * Metodo que realiza la rotacion simple a la izquierda
     * @param pNode 
     */
    public void RSI(nodeTree pNode){
        nodeTree tmp=pNode.getHijoDer();
        if(tmp.getHijoIzq()==null){
            tmp.setHijoIzq(pNode);
            pNode.setHijoDer(null);
            if(pNode==_root){
                _root=tmp;
                tmp.setPadre(null);
            }
            else if ((Integer)pNode.getData()>(Integer)pNode.getPadre().getData()){
                pNode.getPadre().setHijoDer(tmp);
                tmp.setPadre(pNode.getPadre());
            }
            else{
                pNode.getPadre().setHijoIzq(tmp);
                tmp.setPadre(pNode.getPadre());
            }
            pNode.setPadre(tmp);
            
        }
        else{
            pNode.setHijoDer(tmp.getHijoIzq());
            pNode.getHijoDer().setPadre(pNode);
            tmp.setHijoIzq(pNode);
            if(pNode==_root){
                _root=tmp;
                tmp.setPadre(null);
            }
            else if ((Integer)pNode.getData()>(Integer)pNode.getPadre().getData())
                pNode.getPadre().setHijoDer(tmp);
            else
                pNode.getPadre().setHijoIzq(tmp);
            tmp.setPadre(pNode.getPadre());
            pNode.setPadre(tmp);
        }
        modificarAltura(tmp);
    }
    /**
     * Metodo que realiza la rotacion doble a la derecha
     * @param pNode 
     */
    public void RDD(nodeTree pNode){
        nodeTree tmp=pNode.getHijoIzq();
        nodeTree tmp2=tmp.getHijoDer();
        nodeTree tmp3=pNode.getPadre();
        if(tmp2.getHijoIzq()!=null){
            tmp.setHijoDer(tmp2.getHijoIzq());
            tmp2.getHijoIzq().setPadre(tmp);
            pNode.setHijoIzq(tmp2);
            tmp2.setPadre(pNode);
            tmp2.setHijoIzq(tmp);
            tmp.setPadre(tmp2);
        }
        else{
            pNode.setHijoIzq(tmp2);
            tmp2.setPadre(pNode);
            tmp2.setHijoIzq(tmp);
            tmp.setPadre(tmp2);
            tmp.setHijoDer(null);
        }
        if(tmp2.getHijoDer()==null){
            tmp2.setHijoDer(pNode);
            pNode.setHijoIzq(null);
        }
        else{
            pNode.setHijoIzq(tmp2.getHijoDer());
            tmp2.getHijoDer().setPadre(pNode);
            tmp2.setHijoDer(pNode);
        }
        if(pNode==_root){
            _root=tmp2;
            pNode.setPadre(tmp2);
        }
        else if ((Integer)pNode.getData()>(Integer)pNode.getPadre().getData()){
            tmp2.setPadre(tmp3);
            tmp3.setHijoDer(tmp2);
            pNode.setPadre(tmp2);
        }
        else{
            tmp2.setPadre(tmp3);
            tmp3.setHijoIzq(tmp2);
            pNode.setPadre(tmp2);
        }
        modificarAltura(tmp2);
    }
    /**
     * Metodo que realiza la rotacion doble a la izquierda
     * @param pNode 
     */
    public void RDI(nodeTree pNode){
        nodeTree tmp=pNode.getHijoDer();
        nodeTree tmp2=tmp.getHijoIzq();
        nodeTree tmp3=pNode.getPadre();
        if(tmp2.getHijoDer()!=null){
            tmp.setHijoIzq(tmp2.getHijoDer());
            tmp2.getHijoDer().setPadre(tmp);
            pNode.setHijoDer(tmp2);
            tmp2.setPadre(pNode);
            tmp2.setHijoDer(tmp);
            tmp.setPadre(tmp2);
        }
        else{
            pNode.setHijoDer(tmp2);
            tmp2.setPadre(pNode);
            tmp2.setHijoDer(tmp);
            tmp.setPadre(tmp2);
            tmp.setHijoIzq(null);
        }
        if(tmp2.getHijoIzq()==null){
            tmp2.setHijoIzq(pNode);
            pNode.setHijoDer(null);
        }
        else{
            pNode.setHijoDer(tmp2.getHijoIzq());
            tmp2.getHijoIzq().setPadre(pNode);
            tmp2.setHijoIzq(pNode);
        }
        if(pNode==_root){
            _root=tmp2;
            pNode.setPadre(tmp2);
        }
        else if ((Integer)pNode.getData()>(Integer)pNode.getPadre().getData()){
            tmp2.setPadre(tmp3);
            tmp3.setHijoIzq(tmp2);
            pNode.setPadre(tmp2);
        }
        else{
            tmp2.setPadre(tmp3);
            tmp3.setHijoDer(tmp2);
            pNode.setPadre(tmp2);
        }
        modificarAltura(tmp2);
    }
    /**
     * Metodo para buscar en el arbol
     * @param Data
     * @return 
     */
    public boolean find(G pData){
        if(_root==null)
            return false;
        else
            return findAux(pData, _root);
    }
    /**
     * Metodo auxiliar para buscar en la estructura
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
     * Metodo para modificar la altura
     * @param pNode 
     */
    public void modificarAltura(nodeTree pNode){
        if(pNode.getHijoIzq()== null && pNode.getHijoDer()==null){
            pNode.setAltura(_uno);
            modificarFactorEquilibrio(pNode);
        }
        else if(pNode.getHijoDer()==null){
            modificarAltura(pNode.getHijoIzq());
            pNode.setAltura(pNode.getHijoIzq().getAltura()+1);
            modificarFactorEquilibrio(pNode);
            verificarRotaciones(pNode);
        }
        else if(pNode.getHijoIzq()==null){
            modificarAltura(pNode.getHijoDer());
            pNode.setAltura(pNode.getHijoDer().getAltura()+1);
            modificarFactorEquilibrio(pNode);
            verificarRotaciones(pNode);
        }
        else{
            modificarAltura(pNode.getHijoIzq());
            modificarAltura(pNode.getHijoDer());
            if(pNode.getHijoIzq().getAltura()>pNode.getHijoDer().getAltura()){
                pNode.setAltura(pNode.getHijoIzq().getAltura()+1);
                modificarFactorEquilibrio(pNode);
                verificarRotaciones(pNode);
            }
            else{
                pNode.setAltura(pNode.getHijoDer().getAltura()+1);
                modificarFactorEquilibrio(pNode);
                verificarRotaciones(pNode);
            }
        }            
    }
    /**
     * Metodo para modificar el factor de equilibrio
     * @param pNode 
     */
    private void modificarFactorEquilibrio (nodeTree pNode){
        if (pNode.getHijoDer()==null && pNode.getHijoIzq()==null)
            pNode.setFE(0);
        else if (pNode.getHijoDer()==null && pNode.getHijoIzq().getAltura()==1)
            pNode.setFE(-_uno);
        else if (pNode.getHijoIzq()==null && pNode.getHijoDer().getAltura()==1)
             pNode.setFE(_uno);
        else if(pNode.getHijoDer()==null)
            pNode.setFE(-pNode.getHijoIzq().getAltura());
        else if(pNode.getHijoIzq()==null)
            pNode.setFE(pNode.getHijoDer().getAltura());
        else
            pNode.setFE(pNode.getHijoDer().getAltura()-pNode.getHijoIzq().getAltura());
    }
    
    /**
     * Metodo que valida si hay que hacer rotaciones
     * @param pNode 
     */
    private void verificarRotaciones(nodeTree pNode){
        if(pNode.getFE()==-2 && (pNode.getHijoIzq().getFE()==-1
                || pNode.getHijoIzq().getFE()==0 || pNode.getHijoIzq()==null))
            RSD(pNode);
        else if (pNode.getFE()==2 && (pNode.getHijoDer().getFE()==1 
                || pNode.getHijoDer().getFE()==0 || pNode.getHijoDer()==null))
            RSI(pNode);
        else if (pNode.getFE()==-2 && pNode.getHijoIzq().getFE()==1 )
            RDD(pNode);
        else if (pNode.getFE()==2 && pNode.getHijoIzq().getFE()==-1)
            RDI(pNode);
        else
            return;
    }
    /**
     * Metodo que realiza recorrido en postOrden
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
     * Metodo para borrar un elemento del arbol
     * @param Data
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
     * Metodo auxiliar para eliminar un dato
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
     * Metodo auxiliar para eliminar el dato
     * @param pData
     * @param pNode
     * @param parent
     * @return nodo eliminado
     */
    private nodeTree deleteAux2(G pData, nodeTree pNode, nodeTree parent){
        if(pNode.getHijoDer()==null && pNode.getHijoIzq()==null){
                if ((Integer)pNode.getData()<(Integer)parent.getData()){
                    parent.setHijoIzq(null);
                    verificarRotaciones(_root);
                    return pNode;
                }
                else{
                    parent.setHijoDer(null);
                    verificarRotaciones(_root);
                    return pNode;
                }
            }
            else if(pNode.getHijoIzq()==null){
                if ((Integer)pNode.getData()<(Integer)parent.getData()){
                    parent.setHijoIzq(pNode.getHijoDer());
                    pNode.setHijoDer(null);
                    verificarRotaciones(_root);
                    return pNode;
                }
                else{
                    parent.setHijoDer(pNode.getHijoDer());
                    pNode.setHijoDer(null);
                    verificarRotaciones(_root);
                    return pNode;
                }
            }
            else if(pNode.getHijoDer()==null){
                if ((Integer)pNode.getData()<(Integer)parent.getData()){
                    parent.setHijoIzq(pNode.getHijoIzq());
                    pNode.setHijoIzq(null);
                    verificarRotaciones(_root);
                    return pNode;
                }
                else{
                    parent.setHijoDer(pNode.getHijoIzq());
                    pNode.setHijoIzq(null);
                    verificarRotaciones(_root);
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
                    verificarRotaciones(_root);
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
                    verificarRotaciones(_root);
                    return pNode;
                }
            }
    }
    /**
     * Metodo auxiliar para borrar la raiz
     * @param pNode
     * @return nodo eliminado
     */
    private nodeTree deleteRoot(nodeTree pNode){
        if(pNode.getHijoIzq()==null){
            _root=pNode.getHijoDer();
            verificarRotaciones(_root);
            return pNode;
        }
        else if(pNode.getHijoDer()==null){
            _root=pNode.getHijoDer();
            verificarRotaciones(_root);
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
            verificarRotaciones(_root);
            return pNode;
        }
    }
    /**
     * Metodo que obtiene el menor de los mayores
     * @param pNode
     * @return 
     */
    private nodeTree menorMayores(nodeTree pNode){
        if (pNode.getHijoIzq()==null)
            return pNode;
        else
            return menorMayores(pNode.getHijoIzq());        
    }
}