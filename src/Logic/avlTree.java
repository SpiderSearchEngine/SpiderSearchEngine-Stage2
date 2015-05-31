
package Logic;

/**mod
 * Clase para crear el arbol avl
 * @author Gerald M, Jairo O
 */
public class avlTree <G>{
    private nodeTree _root;
    private int _uno=1;
    private int _cero=0;
    private boolean cond;
    private nodeTree _nT;
    /**
     * Constructor de la clase
     * @param root. Elemento raiz
     */
    public avlTree(nodeTree pRoot){
        this._root=pRoot;
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
    public void insert (nodeTree pData){
        if(_root==null){
            _root=pData;
            _root.setAltura(_uno);
            _root.setFE(_cero);
        }
        else
            insertAux(pData, _root);
    }
    /**
     * Metodo auxiliar para insertar
     * @param pNode
     * @param padre 
     */
    private void insertAux(nodeTree pNode, nodeTree padre){
        if(((palabra)pNode.getData()).getApariciones()>=((palabra)padre.getData()).getApariciones()){
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
    
    public void actualizarArbol(nodeTree pNode, String pPalabra){
        if(pNode.getHijoIzq()== null && pNode.getHijoDer()==null){
            if(((palabra)pNode.getData()).getName().equals(pPalabra)){
                delete(pNode);
                System.out.println(((palabra)pNode.getData()).getName()+"  "+((palabra)pNode.getData()).getApariciones());
                ((palabra)pNode.getData()).setApariciones(((palabra)pNode.getData()).getApariciones()+1);
                System.out.println(((palabra)pNode.getData()).getName()+"  "+((palabra)pNode.getData()).getApariciones());
                insert(pNode);
            }
        }
        else if(pNode.getHijoDer()==null){
            actualizarArbol(pNode.getHijoIzq(), pPalabra);
            if(((palabra)pNode.getData()).getName().equals(pPalabra)){
                delete(pNode);
                System.out.println(((palabra)pNode.getData()).getName()+"  "+((palabra)pNode.getData()).getApariciones());
                ((palabra)pNode.getData()).setApariciones(((palabra)pNode.getData()).getApariciones()+1);
                System.out.println(((palabra)pNode.getData()).getName()+"  "+((palabra)pNode.getData()).getApariciones());
                insert(pNode);
            }
            
        }
        else if(pNode.getHijoIzq()==null){
            actualizarArbol(pNode.getHijoDer(), pPalabra);
            if(((palabra)pNode.getData()).getName().equals(pPalabra)){
                delete(pNode);
                System.out.println(((palabra)pNode.getData()).getName()+"  "+((palabra)pNode.getData()).getApariciones());
                ((palabra)pNode.getData()).setApariciones(((palabra)pNode.getData()).getApariciones()+1);
                System.out.println(((palabra)pNode.getData()).getName()+"  "+((palabra)pNode.getData()).getApariciones());
                insert(pNode);
            }
        }
        else{
            actualizarArbol(pNode.getHijoIzq(), pPalabra);
            actualizarArbol(pNode.getHijoDer(), pPalabra);
            if(((palabra)pNode.getData()).getName().equals(pPalabra)){
                delete(pNode);
                System.out.println(((palabra)pNode.getData()).getName()+"  "+((palabra)pNode.getData()).getApariciones());
                ((palabra)pNode.getData()).setApariciones(((palabra)pNode.getData()).getApariciones()+1);
                System.out.println(((palabra)pNode.getData()).getName()+"  "+((palabra)pNode.getData()).getApariciones());
                insert(pNode);
            }
        }  
    }
    
    /**
     * Metodo que realiza la rotacion simple a la derecha
     * @param pNode 
     */
    private void RSD(nodeTree pNode){
        nodeTree tmp=pNode.getHijoIzq();
        if(tmp.getHijoDer()==null){
            tmp.setHijoDer(pNode);
            pNode.setHijoIzq(null);
            if(pNode==_root){
                _root=tmp;
                tmp.setPadre(null);
            }
            else if (((palabra)pNode.getData()).getApariciones()>=((palabra)pNode.getPadre().getData()).getApariciones()){
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
            else if (((palabra)pNode.getData()).getApariciones()>=((palabra)pNode.getPadre().getData()).getApariciones())
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
    private void RSI(nodeTree pNode){
        nodeTree tmp=pNode.getHijoDer();
        if(tmp.getHijoIzq()==null){
            tmp.setHijoIzq(pNode);
            pNode.setHijoDer(null);
            if(pNode==_root){
                _root=tmp;
                tmp.setPadre(null);
            }
            else if (((palabra)pNode.getData()).getApariciones()>=((palabra)pNode.getPadre().getData()).getApariciones()){
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
            else if (((palabra)pNode.getData()).getApariciones()>=((palabra)pNode.getPadre().getData()).getApariciones())
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
    private void RDD(nodeTree pNode){
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
        else if (((palabra)pNode.getData()).getApariciones()>=((palabra)pNode.getPadre().getData()).getApariciones()){
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
    private void RDI(nodeTree pNode){
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
        else if (((palabra)pNode.getData()).getApariciones()>=((palabra)pNode.getPadre().getData()).getApariciones()){
            tmp2.setPadre(tmp3);
            tmp3.setHijoIzq(tmp2);
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
     * Metodo para buscar en el arbol
     * @param Data
     * @return 
     */
    public void findSpecial(String pData){
        cond=false;
        if(_root==null)
            return;
        else
            findSpecialAux(pData, _root);
    }
    /**
     * Metodo auxiliar para buscar en la estructura
     * @param pData
     * @param pNode
     * @return 
     */
    private void findSpecialAux(String pData, nodeTree pNode){
        if(pNode.getHijoIzq()== null && pNode.getHijoDer()==null){
            if(((palabra)pNode.getData()).getName().equals(pData))
                cond=true;
        }
        else if(pNode.getHijoDer()==null){
            findSpecialAux(pData, pNode.getHijoIzq());
            if(((palabra)pNode.getData()).getName().equals(pData))
                cond=true;
        }
        else if(pNode.getHijoIzq()==null){
            findSpecialAux(pData, pNode.getHijoDer());
            if(((palabra)pNode.getData()).getName().equals(pData))
                cond=true;
        }
        else{
            findSpecialAux(pData, pNode.getHijoIzq());
            findSpecialAux (pData, pNode.getHijoDer());
            if(((palabra)pNode.getData()).getName().equals(pData))
                cond=true;
        } 
    }
    
    public boolean getCondicion(){
        return cond;
    }
    /**
     * Metodo para modificar la altura
     * @param pNode 
     */
    private void modificarAltura(nodeTree pNode){
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
            pNode.setFE(_cero);
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
        else if (pNode.getFE()==2 && pNode.getHijoDer().getFE()==-1)
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
            System.out.println(((palabra)pNode.getData()).getName()+ " veces: "+((palabra)pNode.getData()).getApariciones());
        else if(pNode.getHijoDer()==null){
            postOrden(pNode.getHijoIzq());
            System.out.println(((palabra)pNode.getData()).getName()+ " veces: "+((palabra)pNode.getData()).getApariciones());
        }
        else if(pNode.getHijoIzq()==null){
            postOrden(pNode.getHijoDer());
            System.out.println(((palabra)pNode.getData()).getName()+ " veces: "+((palabra)pNode.getData()).getApariciones());
        }
        else{
            postOrden(pNode.getHijoIzq());
            postOrden(pNode.getHijoDer());
            System.out.println(((palabra)pNode.getData()).getName()+ " veces: "+((palabra)pNode.getData()).getApariciones());
        }            
    }
    /**
     * Metodo para borrar un elemento del arbol
     * @param Data
     * @return nodo eliminado
     */
    public nodeTree delete (nodeTree pData){
        if (_root == null)
            return null;
        else if (((palabra)_root.getData()).getName().equals(((palabra)pData.getData()).getName()) &&
                _root.getHijoDer()==null && _root.getHijoIzq()==null){
            nodeTree tmp = _root;
            _root=null;
            return tmp;
        }
        else if (!(((palabra)_root.getData()).getName().equals(((palabra)pData.getData()).getName())) &&
                _root.getHijoDer()==null && _root.getHijoIzq()==null)
            return null;
        else if (((palabra)_root.getData()).getName().equals(((palabra)pData.getData()).getName()))
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
    private nodeTree deleteAux(nodeTree pData, nodeTree pNode, nodeTree parent){
        if ((((palabra)pNode.getData()).equals((palabra)pData.getData())))
            return deleteAux2(pData, pNode, parent);
        else if (((palabra)pData.getData()).getApariciones()<((palabra)pNode.getData()).getApariciones())
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
    private nodeTree deleteAux2(nodeTree pData, nodeTree pNode, nodeTree padre){
        if(pNode.getHijoDer()==null && pNode.getHijoIzq()==null){
            if (((palabra)pNode.getData()).getApariciones()<((palabra)padre.getData()).getApariciones()){
                padre.setHijoIzq(null);
                modificarAltura(_root);
                return pNode;
            }
            else{
                padre.setHijoDer(null);
                modificarAltura(_root);
                return pNode;
            }
        }
        else if(pNode.getHijoIzq()==null){
            if (((palabra)pNode.getData()).getApariciones()<((palabra)padre.getData()).getApariciones()){
                padre.setHijoIzq(pNode.getHijoDer());
                pNode.setHijoDer(null);
                modificarAltura(_root);
                return pNode;
            }
            else{
                padre.setHijoDer(pNode.getHijoDer());
                pNode.setHijoDer(null);
                modificarAltura(_root);
                return pNode;
            }
        }
        else if(pNode.getHijoDer()==null){
            if (((palabra)pNode.getData()).getApariciones()<((palabra)padre.getData()).getApariciones()){
                padre.setHijoIzq(pNode.getHijoIzq());
                pNode.setHijoIzq(null);
                modificarAltura(_root);
                return pNode;
            }
            else{
                padre.setHijoDer(pNode.getHijoIzq());
                pNode.setHijoIzq(null);
                modificarAltura(_root);
                return pNode;
            }
        }
        else{
            nodeTree aux = menorMayores(pNode.getHijoDer());
            nodeTree aux2 = aux.getPadre();
            if (((palabra)pNode.getData()).getApariciones()<((palabra)padre.getData()).getApariciones()){
                if(((palabra)aux.getData()).getApariciones()<((palabra)aux2.getData()).getApariciones())
                    aux2.setHijoIzq(null);
                else
                    aux2.setHijoDer(null);
                aux.setHijoIzq(pNode.getHijoIzq());
                aux.setHijoDer(pNode.getHijoDer());
                padre.setHijoIzq(aux);
                pNode.setHijoIzq(null);
                pNode.setHijoDer(null);                    
                modificarAltura(_root);
                return aux2;
            }
            else{                    
                if(((palabra)aux.getData()).getApariciones()<((palabra)aux2.getData()).getApariciones())
                    aux2.setHijoIzq(null);
                else
                    aux2.setHijoDer(null);
                aux.setHijoIzq(pNode.getHijoIzq());
                aux.setHijoDer(pNode.getHijoDer());
                padre.setHijoDer(aux);
                pNode.setHijoIzq(null);
                pNode.setHijoDer(null);
                modificarAltura(_root);
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
            modificarAltura(_root);
            return pNode;
        }
        else if(pNode.getHijoDer()==null){
            _root=pNode.getHijoDer();
            modificarAltura(_root);
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
            modificarAltura(_root);
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
    
    public void insertardireccion(String pData, nodeTree pNode, nodeTree nodeRB){
        if(pNode.getHijoIzq()== null && pNode.getHijoDer()==null){
            if(((palabra)pNode.getData()).getName().equals(pData))
                if(((palabra)pNode.getData()).getListaReferencia().findRB(nodeRB)==false)
                    ((palabra)pNode.getData()).getListaReferencia().insertHead(nodeRB);
        }
        else if(pNode.getHijoDer()==null){
            insertardireccion(pData, pNode.getHijoIzq(), nodeRB);
            if(((palabra)pNode.getData()).getName().equals(pData))
                if(((palabra)pNode.getData()).getListaReferencia().findRB(nodeRB)==false)
                    ((palabra)pNode.getData()).getListaReferencia().insertHead(nodeRB);
        }
        else if(pNode.getHijoIzq()==null){
            insertardireccion(pData, pNode.getHijoDer(), nodeRB);
            if(((palabra)pNode.getData()).getName().equals(pData))
                if(((palabra)pNode.getData()).getListaReferencia().findRB(nodeRB)==false)
                    ((palabra)pNode.getData()).getListaReferencia().insertHead(nodeRB);
        }
        else{
            insertardireccion(pData, pNode.getHijoIzq(), nodeRB);
            insertardireccion(pData, pNode.getHijoDer(), nodeRB);
            if(((palabra)pNode.getData()).getName().equals(pData))
                if(((palabra)pNode.getData()).getListaReferencia().findRB(nodeRB)==false)
                    ((palabra)pNode.getData()).getListaReferencia().insertHead(nodeRB);
        }             
    }
    
    /**
     * Metodo para buscar en el arbol
     * @param Data
     * @return 
     */
    public void findResult(String pData){
        _nT=null;
        if(_root==null)
            return;
        else
            findResultado(pData, _root);
    }
    /**
     * Metodo auxiliar para buscar en la estructura
     * @param pData
     * @param pNode
     * @return 
     */
    private void findResultado(String pData, nodeTree pNode){
        if(pNode.getHijoIzq()== null && pNode.getHijoDer()==null){
            if(((palabra)pNode.getData()).getName().equals(pData)){
                _nT=pNode;
            }
        }
        else if(pNode.getHijoDer()==null){
            findResultado(pData, pNode.getHijoIzq());
            if(((palabra)pNode.getData()).getName().equals(pData)){
                _nT=pNode;
            }
        }
        else if(pNode.getHijoIzq()==null){
            findResultado(pData, pNode.getHijoDer());
            if(((palabra)pNode.getData()).getName().equals(pData)){
                _nT=pNode;
            }
        }
        else{
            findResultado(pData, pNode.getHijoIzq());
            findResultado(pData, pNode.getHijoDer());
            if(((palabra)pNode.getData()).getName().equals(pData)){
                _nT=pNode;
            }
        } 
    }
    public nodeTree getResultado(){
        return _nT;
    }    
}