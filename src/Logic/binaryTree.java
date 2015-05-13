
package Logic;

/**
 *
 * @author jairo
 */
public class binaryTree {
    
    private NodeTree _root;
    
    public binaryTree(NodeTree root){
        this._root=root;
    }
    
    public NodeTree getRoot(){
        return this._root;
    }
    
    public void setRoot(NodeTree newRoot){
        this._root=newRoot;
    }
    
    public void insert (int pdata){
        if (_root==null)
            _root=new NodeTree(pdata, null, null);
        else
            insertAux(_root, new NodeTree(pdata, null, null));
    }    
    private void insertAux(NodeTree pRoot, NodeTree pData){
        if(pRoot.getData()>pData.getData()){
            if(pRoot.getHijoIzq()==null)
                pRoot.setHijoIzq(pData);
            else
                insertAux(pRoot.getHijoIzq(), pData);
        }
        else{
            if(pRoot.getHijoDer()==null)
                pRoot.setHijoDer(pData);
            else
                insertAux(pRoot.getHijoDer(), pData);
        }
    }
    
    public boolean find(int Data){
        if(_root==null)
            return false;
        else
            return findAux(Data, _root);
    }    
    private boolean findAux(int pData, NodeTree pNode){
        if(pData!=pNode.getData() && pNode.getHijoDer()==null && pNode.getHijoIzq()==null)
            return false;
        else if(pNode.getData()==pData)
            return true;
        else if (pData<pNode.getData())
            return findAux(pData, pNode.getHijoIzq());
        else
            return findAux(pData, pNode.getHijoDer());
    }
    
    public NodeTree delete (int Data){
        if (_root == null)
            return null;
        else if (_root.getData()==Data && _root.getHijoDer()==null && _root.getHijoIzq()==null){
            NodeTree tmp = _root;
            _root=null;
            return tmp;
        }
        else if (_root.getData()!=Data && _root.getHijoDer()==null && _root.getHijoIzq()==null)
            return null;
        else if (_root.getData()==Data)
            return deleteRoot(_root);
        else
            return deleteAux(Data, _root, null);            
    }    
    private NodeTree deleteAux(int pData, NodeTree pNode, NodeTree parent){
        if (pData==pNode.getData()){
            return deleteAux2(pData, pNode, parent);
        }
        else if (pData<pNode.getData())
            return deleteAux(pData, pNode.getHijoIzq(),pNode);
        else
            return deleteAux(pData, pNode.getHijoDer(),pNode);
    }    
    private NodeTree deleteAux2(int pData, NodeTree pNode, NodeTree parent){
        if(pNode.getHijoDer()==null && pNode.getHijoIzq()==null){
                if (pNode.getData()<parent.getData()){
                    parent.setHijoIzq(null);
                    return pNode;
                }
                else{
                    parent.setHijoDer(null);
                    return pNode;
                }
            }
            else if(pNode.getHijoIzq()==null){
                if (pNode.getData()<parent.getData()){
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
                if (pNode.getData()<parent.getData()){
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
                NodeTree aux = menorMayores(pNode.getHijoDer());
                NodeTree aux2 = getParent(aux);
                if (pNode.getData()<parent.getData()){
                    if(aux.getData()<aux2.getData())
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
                    if(aux.getData()<aux2.getData())
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
    private NodeTree deleteRoot(NodeTree pNode){
        if(pNode.getHijoIzq()==null){
            _root=pNode.getHijoDer();
            return pNode;
        }
        else if(pNode.getHijoDer()==null){
            _root=pNode.getHijoDer();
            return pNode;
        }
        else{
            NodeTree aux=menorMayores(pNode.getHijoDer());
            NodeTree aux2=getParent(aux);
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
    
    private NodeTree menorMayores(NodeTree pNode){
        if (pNode.getHijoIzq()==null)
            return pNode;
        else
            return menorMayores(pNode.getHijoIzq());        
    }
    
    private NodeTree getParent(NodeTree pNode){
        if(_root.getData()==pNode.getData())
            return null;
        else
            return getParentAux(pNode, _root, _root);
    }
    private NodeTree getParentAux(NodeTree pData, NodeTree pNode, NodeTree parent){
        if (pData.getData()==pNode.getData())
            return parent;
        if(pNode.getData()<pData.getData())
            return getParentAux(pData, pNode.getHijoDer(), pNode);
        else
            return getParentAux(pData, pNode.getHijoIzq(), pNode);
    }
    
    public void print(){
        if(_root==null)
            System.out.println("Arbol es nulo");
        else{
            System.out.println("Raiz: "+_root.getData());
            if (_root.getHijoDer()!=null && _root.getHijoIzq()!=null){
                System.out.println(_root.getHijoDer().getData()+" es HD de: "+_root.getData());
                printHijos(_root.getHijoDer());
                System.out.println(_root.getHijoIzq().getData()+" es HI de: "+_root.getData());
                printHijos(_root.getHijoIzq());
            }
            else if (_root.getHijoDer()==null && _root.getHijoIzq()!=null)
                printHijos(_root.getHijoIzq());
            else if (_root.getHijoIzq()==null && _root.getHijoDer()!=null)
                printHijos(_root.getHijoDer());
            else
                return;
        }
    }
    private void printHijos(NodeTree hijo){
        if (hijo.getHijoDer()!=null && hijo.getHijoIzq()!=null){
            System.out.println(hijo.getHijoDer().getData()+" es HD de: "+hijo.getData());
            printHijos(hijo.getHijoDer());
            System.out.println(hijo.getHijoIzq().getData()+" es HI de: "+hijo.getData());
            printHijos(hijo.getHijoIzq());
        }
        else if (hijo.getHijoDer()==null && hijo.getHijoIzq()!=null){
            System.out.println(hijo.getHijoIzq().getData()+" es HI de: "+hijo.getData());            
            printHijos(hijo.getHijoIzq());
        }
        else if (hijo.getHijoIzq()==null && hijo.getHijoDer()!=null){
            System.out.println(hijo.getHijoDer().getData()+" es HD de: "+hijo.getData());
            printHijos(hijo.getHijoDer());
        }
        else
            return;
    }
    
    public void preOrden(NodeTree pNode){
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
    public void postOrden(NodeTree pNode){
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
    public void orden(NodeTree pNode){
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
