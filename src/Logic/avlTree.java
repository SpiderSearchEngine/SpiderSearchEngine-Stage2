/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logic;

/**
 *
 * @author jairo
 */
public class avlTree {
    private NodeAVL _root;
    private int _uno=1;
    private int _cero=0;
    
    public avlTree(NodeAVL root){
        this._root=root;
    }
    
    public NodeAVL getRoot(){
        return this._root;
    }
    
    public void setRoot(NodeAVL newRoot){
        this._root=newRoot;
    }
    
    public void insert (int pdata){
        if(_root==null){
            _root=new NodeAVL(pdata, null, null,null);
            _root.setAltura(0);
            _root.setFE(0);
        }
        else
            insertAux(new NodeAVL (pdata,null,null,null), _root);
    }
    private void insertAux(NodeAVL pNode, NodeAVL padre){
        if(pNode.getData()>padre.getData()){
            if(padre.getHijoDer()==null){
                padre.setHijoDer(pNode);
                pNode.setPadre(padre);
                verificarRotaciones(_root);
            }
            else
                insertAux(pNode,padre.getHijoDer());
        }
        else{
            if(padre.getHijoIzq()==null){
                padre.setHijoIzq(pNode);
                pNode.setPadre(padre);                
                verificarRotaciones(_root);
            }
            else
                insertAux(pNode, padre.getHijoIzq());
        }
    }
    
    public void RSD(NodeAVL pNode){
        NodeAVL tmp=pNode.getHijoIzq();
        pNode.setHijoIzq(tmp.getHijoDer());
        tmp.setHijoDer(pNode);
        if(pNode==_root)
            _root=tmp;
        else if (pNode.getData()>pNode.getPadre().getData())
            pNode.getPadre().setHijoDer(tmp);
        else
            pNode.getPadre().setHijoIzq(tmp);
    }
    
    public void RSI(NodeAVL pNode){
        NodeAVL tmp=pNode.getHijoDer();
        pNode.setHijoDer(tmp.getHijoIzq());
        tmp.setHijoIzq(pNode);
        if(pNode==_root)
            _root=tmp;
        else if (pNode.getData()>pNode.getPadre().getData())
            pNode.getPadre().setHijoDer(tmp);
        else
            pNode.getPadre().setHijoIzq(tmp);
    }
    
    public void RDD(NodeAVL pNode){
        NodeAVL tmp=pNode.getHijoIzq();
        NodeAVL tmp2=tmp.getHijoDer();
        tmp.setHijoDer(tmp2.getHijoIzq());
        pNode.setHijoIzq(tmp2);
        tmp2.setHijoIzq(tmp);
        pNode.setHijoIzq(tmp2.getHijoDer());
        tmp2.setHijoDer(pNode);
        if(pNode==_root)
            _root=tmp;
        else if (pNode.getData()>pNode.getPadre().getData())
            pNode.getPadre().setHijoDer(tmp2);
        else
            pNode.getPadre().setHijoIzq(tmp2);        
    }
    
    public void RDI(NodeAVL pNode){
        NodeAVL tmp=pNode.getHijoDer();
        NodeAVL tmp2=tmp.getHijoIzq();
        tmp.setHijoIzq(tmp2.getHijoDer());
        pNode.setHijoDer(tmp2);
        tmp2.setHijoDer(tmp);
        pNode.setHijoDer(tmp2.getHijoIzq());
        tmp2.setHijoIzq(pNode);
        if(pNode==_root)
            _root=tmp;
        else if (pNode.getData()>pNode.getPadre().getData())
            pNode.getPadre().setHijoDer(tmp2);
        else
            pNode.getPadre().setHijoIzq(tmp2); 
    }
    
    public boolean find(int Data){
        if(_root==null)
            return false;
        else
            return findAux(Data, _root);
    }    
    private boolean findAux(int pData, NodeAVL pNode){
        if(pData!=pNode.getData() && pNode.getHijoDer()==null && pNode.getHijoIzq()==null)
            return false;
        else if(pNode.getData()==pData)
            return true;
        else if (pData<pNode.getData())
            return findAux(pData, pNode.getHijoIzq());
        else
            return findAux(pData, pNode.getHijoDer());
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
    private void printHijos(NodeAVL hijo){
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

    public void modificarAltura(NodeAVL pNode){
        if(pNode.getHijoIzq()== null && pNode.getHijoDer()==null)
            pNode.setAltura(0);
        else if(pNode.getHijoDer()==null){
            modificarAltura(pNode.getHijoIzq());
            pNode.setAltura(pNode.getHijoIzq().getAltura()+1);
        }
        else if(pNode.getHijoIzq()==null){
            modificarAltura(pNode.getHijoDer());
            pNode.setAltura(pNode.getHijoDer().getAltura()+1);
        }
        else{
            modificarAltura(pNode.getHijoIzq());
            modificarAltura(pNode.getHijoDer());
            if(pNode.getHijoIzq().getAltura()>pNode.getHijoDer().getAltura())
                pNode.setAltura(pNode.getHijoIzq().getAltura()+1);
            else
                pNode.setAltura(pNode.getHijoDer().getAltura()+1);
        }            
    }
    
    public void modificarFactorEquilibrio(NodeAVL pNode){
        if(pNode.getHijoIzq()== null && pNode.getHijoDer()==null)
            factorEquilibrioAux(pNode);
        else if(pNode.getHijoDer()==null){
            modificarFactorEquilibrio(pNode.getHijoIzq());
            factorEquilibrioAux(pNode);
        }
        else if(pNode.getHijoIzq()==null){
            modificarFactorEquilibrio(pNode.getHijoDer());
            factorEquilibrioAux(pNode);
        }
        else{
            modificarFactorEquilibrio(pNode.getHijoIzq());            
            modificarFactorEquilibrio(pNode.getHijoDer());
            factorEquilibrioAux(pNode);
        }
    }
    private void factorEquilibrioAux(NodeAVL pNode){
        if (pNode.getHijoDer()==null && pNode.getHijoIzq()==null)
            pNode.setFE(0);
        else if (pNode.getHijoDer()==null && pNode.getHijoIzq().getAltura()==0)
            pNode.setFE(-_uno);
        else if (pNode.getHijoIzq()==null && pNode.getHijoDer().getAltura()==0)
             pNode.setFE(_uno);
        else if(pNode.getHijoDer()==null)
            pNode.setFE(-pNode.getHijoIzq().getAltura());
        else if(pNode.getHijoIzq()==null)
            pNode.setFE(pNode.getHijoDer().getAltura());
        else
            pNode.setFE(pNode.getHijoDer().getAltura()-pNode.getHijoIzq().getAltura());
    }
    
    public void verificarRotaciones(NodeAVL pNode){
        if(pNode.getHijoIzq()== null && pNode.getHijoDer()==null)
            verificarRotacionesAux(pNode);
        else if(pNode.getHijoDer()==null){
            verificarRotaciones(pNode.getHijoIzq());            
            verificarRotacionesAux(pNode);
        }
        else if(pNode.getHijoIzq()==null){ 
            verificarRotaciones(pNode.getHijoDer());           
            verificarRotacionesAux(pNode);
        }
        else{
            verificarRotaciones(pNode.getHijoIzq());            
            verificarRotaciones(pNode.getHijoDer());            
            verificarRotacionesAux(pNode);
        }            
    }    
    private void verificarRotacionesAux(NodeAVL pNode){
        if(pNode.getFE()==-2 && (pNode.getHijoIzq().getFE()==-1
                || pNode.getHijoIzq().getFE()==0 || pNode.getHijoIzq()==null)){
            RSD(pNode);
            modificarAltura(this.getRoot());
            modificarFactorEquilibrio(this.getRoot());
            }
        else if (pNode.getFE()==2 && (pNode.getHijoDer().getFE()==1 
                || pNode.getHijoDer().getFE()==0 || pNode.getHijoDer()==null)){
            RSI(pNode);
            modificarAltura(this._root);
            modificarFactorEquilibrio(this._root);
        }
        else if (pNode.getFE()==-2 && pNode.getHijoIzq().getFE()==1){
            RDD(pNode);
            modificarAltura(this._root);
            modificarFactorEquilibrio(this._root);
        }
        else if (pNode.getFE()==2 && pNode.getHijoIzq().getFE()==-1){
            RDI(pNode);
            modificarAltura(this.getRoot());
            modificarFactorEquilibrio(this.getRoot());
        }
        else{
            modificarAltura(this.getRoot());
            modificarFactorEquilibrio(this.getRoot());
        }
    }
    
    public void postOrden(NodeAVL pNode){
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
    
    
    public NodeAVL delete (int Data){
        if (_root == null)
            return null;
        else if (_root.getData()==Data && _root.getHijoDer()==null && _root.getHijoIzq()==null){
            NodeAVL tmp = _root;
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
    private NodeAVL deleteAux(int pData, NodeAVL pNode, NodeAVL parent){
        if (pData==pNode.getData()){
            return deleteAux2(pData, pNode, parent);
        }
        else if (pData<pNode.getData())
            return deleteAux(pData, pNode.getHijoIzq(),pNode);
        else
            return deleteAux(pData, pNode.getHijoDer(),pNode);
    }    
    private NodeAVL deleteAux2(int pData, NodeAVL pNode, NodeAVL parent){
        if(pNode.getHijoDer()==null && pNode.getHijoIzq()==null){
                if (pNode.getData()<parent.getData()){
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
                if (pNode.getData()<parent.getData()){
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
                if (pNode.getData()<parent.getData()){
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
                NodeAVL aux = menorMayores(pNode.getHijoDer());
                NodeAVL aux2 = aux.getPadre();
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
                    verificarRotaciones(_root);
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
                    verificarRotaciones(_root);
                    return pNode;
                }
            }
    }
    private NodeAVL deleteRoot(NodeAVL pNode){
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
            NodeAVL aux=menorMayores(pNode.getHijoDer());
            NodeAVL aux2=aux.getPadre();
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
    
    private NodeAVL menorMayores(NodeAVL pNode){
        if (pNode.getHijoIzq()==null)
            return pNode;
        else
            return menorMayores(pNode.getHijoIzq());        
    }
        
}
