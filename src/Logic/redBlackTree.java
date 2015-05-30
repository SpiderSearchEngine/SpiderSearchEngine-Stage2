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
public class redBlackTree <G> {
    
    private nodeTree _root;
    private int _cero=0;
    private int _uno=1;
    private int _dos=2;
    private nodeTree _urlNode;
    public redBlackTree(nodeTree pRoot){
        this._root=pRoot;
    }
    
    public nodeTree getRoot(){
        return this._root;
    }
    
    public void insert (G pdata){
        if (_root==null){
            _root=new nodeTree(pdata, null, null, null , "negro");
            _root.setAltNeg(_uno);
        }        
        else
            insertAux(new nodeTree(pdata, null, null, null, "rojo"), _root);
    }
    private void insertAux(nodeTree pNode, nodeTree pPadre){
        if(((urlProcesado)pNode.getData()).getDireccion().compareTo(((urlProcesado)pPadre.getData()).getDireccion())==_uno){
            if(pPadre.getHijoDer()==null){
                if(pPadre.getColor()=="negro"){
                    pPadre.setHijoDer(pNode);
                    pNode.setPadre(pPadre);
                    pNode.setAltNeg(_cero);
                }
                else{
                    pPadre.setHijoDer(pNode);
                    pNode.setPadre(pPadre);
                    pNode.setAltNeg(_cero);
                    verificaValidez(pNode);                    
                }
            }
            else
                insertAux(pNode, pPadre.getHijoDer());
        }
        else{
            if(pPadre.getHijoIzq()==null){
                if(pPadre.getColor()=="negro"){
                    pPadre.setHijoIzq(pNode);
                    pNode.setPadre(pPadre);
                    pNode.setAltNeg(_cero);
                }
                else{
                    pPadre.setHijoIzq(pNode);
                    pNode.setPadre(pPadre);
                    pNode.setAltNeg(_cero);
                    verificaValidez(pNode);
                }
            }            
            else
                insertAux(pNode, pPadre.getHijoIzq());
        }
    }
    
    private void verificaValidez(nodeTree pNode){
        if(_root==pNode){
            if(pNode.getColor()=="negro")
                return;
            else
                pNode.setColor("negro");
        }
        else if (pNode.getPadre()==_root){
            if(pNode.getPadre().getColor()=="negro")
                return;
            else
                pNode.getPadre().setColor("negro");
        }
        else if(pNode.getColor()=="negro")
            return;
        else if (pNode.getPadre().getPadre()!=null){
            if(((urlProcesado)pNode.getPadre().getData()).getDireccion().compareTo(((urlProcesado)pNode.getPadre().getPadre().getData()).getDireccion())==-_uno && 
                    pNode.getPadre().getPadre().getHijoDer()!=null && 
                    pNode.getPadre().getPadre().getHijoDer().getColor()=="rojo"){
                caso1Izq(pNode);}
            else if (((urlProcesado)pNode.getPadre().getData()).getDireccion().compareTo(((urlProcesado)pNode.getPadre().getPadre().getData()).getDireccion())==_uno &&
                    pNode.getPadre().getPadre().getHijoIzq()!=null && 
                    pNode.getPadre().getPadre().getHijoIzq().getColor()=="rojo"){
                caso1Der(pNode);}
            else if(((urlProcesado)pNode.getData()).getDireccion().compareTo(((urlProcesado)pNode.getPadre().getData()).getDireccion())==_uno && 
                    ((urlProcesado)pNode.getPadre().getData()).getDireccion().compareTo(((urlProcesado)pNode.getPadre().getPadre().getData()).getDireccion())==-_uno
                    && (pNode.getPadre().getPadre().getHijoDer() == null || 
                    pNode.getPadre().getPadre().getHijoDer().getColor()=="negro"))
                caso2Izq(pNode);
            else if(((urlProcesado)pNode.getData()).getDireccion().compareTo(((urlProcesado)pNode.getPadre().getData()).getDireccion())==-_uno && 
                    ((urlProcesado)pNode.getPadre().getData()).getDireccion().compareTo(((urlProcesado)pNode.getPadre().getPadre().getData()).getDireccion())==_uno
                    && (pNode.getPadre().getPadre().getHijoIzq() == null || 
                    pNode.getPadre().getPadre().getHijoIzq().getColor()=="negro"))
                caso2Der(pNode);
            else if (((urlProcesado)pNode.getData()).getDireccion().compareTo(((urlProcesado)pNode.getPadre().getData()).getDireccion())==-_uno && 
                    ((urlProcesado)pNode.getPadre().getData()).getDireccion().compareTo(((urlProcesado)pNode.getPadre().getPadre().getData()).getDireccion())==-_uno
                    && (pNode.getPadre().getPadre().getHijoDer() == null || 
                    pNode.getPadre().getPadre().getHijoDer().getColor()=="negro"))
                caso3Izq(pNode);
            else if (((urlProcesado)pNode.getData()).getDireccion().compareTo(((urlProcesado)pNode.getPadre().getData()).getDireccion())==_uno && 
                    ((urlProcesado)pNode.getPadre().getData()).getDireccion().compareTo(((urlProcesado)pNode.getPadre().getPadre().getData()).getDireccion())==_uno
                    && (pNode.getPadre().getPadre().getHijoIzq() == null || 
                    pNode.getPadre().getPadre().getHijoIzq().getColor()=="negro"))
                caso3Der(pNode);
        }
        else return;        
    }
    
    public void caso1Izq (nodeTree pNode){
        pNode.getPadre().setColor("negro");
        pNode.getPadre().getPadre().setColor("rojo");
        pNode.getPadre().getPadre().getHijoDer().setColor("negro");
        verificaValidez(pNode.getPadre().getPadre());
    }
    public void caso1Der (nodeTree pNode){
        pNode.getPadre().setColor("negro");
        pNode.getPadre().getPadre().setColor("rojo");
        pNode.getPadre().getPadre().getHijoIzq().setColor("negro");
        verificaValidez(pNode.getPadre().getPadre());
    }
    
    public void caso2Izq (nodeTree pNode){
        nodeTree tmp=pNode.getPadre();
        if(pNode.getHijoIzq()==null){
            tmp.getPadre().setHijoIzq(pNode);
            pNode.setPadre(tmp.getPadre());
            pNode.setHijoIzq(tmp);
            tmp.setHijoDer(null);
            tmp.setPadre(pNode);
            caso3Izq(tmp);
        }
        else{
            tmp.getPadre().setHijoIzq(pNode);
            pNode.setPadre(tmp.getPadre());
            tmp.setPadre(pNode);
            tmp.setHijoDer(pNode.getHijoIzq());
            tmp.getHijoDer().setPadre(tmp);
            pNode.setHijoIzq(tmp);
            caso3Izq(tmp);
        }        
    }
    public void caso2Der (nodeTree pNode){
        nodeTree tmp=pNode.getPadre();
        if(pNode.getHijoDer()==null){
            tmp.getPadre().setHijoDer(pNode);
            pNode.setPadre(tmp.getPadre());
            pNode.setHijoDer(tmp);
            tmp.setHijoIzq(null);
            tmp.setPadre(pNode);
            caso3Der(tmp);
        }
        else{
            tmp.getPadre().setHijoDer(pNode);
            pNode.setPadre(tmp.getPadre());
            tmp.setPadre(pNode);
            tmp.setHijoIzq(pNode.getHijoDer());
            tmp.getHijoIzq().setPadre(tmp);
            pNode.setHijoDer(tmp);
            caso3Der(tmp);
        }        
    }
    
    public void caso3Izq (nodeTree pNode){
        nodeTree tmp=pNode.getPadre();
        if(tmp.getHijoDer()!=null){
            tmp.getPadre().setHijoIzq(tmp.getHijoDer());
            tmp.getHijoDer().setPadre(tmp.getPadre());
            tmp.setHijoDer(tmp.getPadre());
        }
        else{
            tmp.setHijoDer(tmp.getPadre());
            tmp.getPadre().setHijoIzq(null);
        }
        if(_root==tmp.getPadre()){
            _root=tmp;
            tmp.setPadre(null);
            tmp.getHijoDer().setPadre(tmp);
            tmp.getHijoDer().setColor("rojo");
        }
        else if ((((urlProcesado)tmp.getPadre().getData()).getDireccion()).compareTo(((urlProcesado)tmp.getPadre().getPadre().getData()).getDireccion())==_uno){
            tmp.setPadre(tmp.getPadre().getPadre());
            tmp.getHijoDer().setPadre(tmp);
            tmp.getPadre().setHijoDer(tmp);
            tmp.getHijoDer().setColor("rojo");
        }
        else{
            tmp.setPadre(tmp.getPadre().getPadre());
            tmp.getHijoDer().setPadre(tmp);
            tmp.getPadre().setHijoIzq(tmp);
            tmp.getHijoDer().setColor("rojo");
        }
        tmp.setColor("negro");
        verificaValidez(tmp);
    }
    
    public void caso3Der (nodeTree pNode){
        nodeTree tmp=pNode.getPadre();
        if(tmp.getHijoIzq()!=null){
            tmp.getPadre().setHijoDer(tmp.getHijoIzq());
            tmp.getHijoIzq().setPadre(tmp.getPadre());
            tmp.setHijoIzq(tmp.getPadre());
        }
        else{
            tmp.setHijoIzq(tmp.getPadre());
            tmp.getPadre().setHijoDer(null);
        }
        if(_root==tmp.getPadre()){
            _root=tmp;
            tmp.setPadre(null);
            tmp.getHijoIzq().setPadre(tmp);
            tmp.getHijoIzq().setColor("rojo");
        }
        else if ((((urlProcesado)tmp.getPadre().getData()).getDireccion()).compareTo(((urlProcesado)tmp.getPadre().getPadre().getData()).getDireccion())==_uno){
            tmp.setPadre(tmp.getPadre().getPadre());
            tmp.getHijoIzq().setPadre(tmp);
            tmp.getPadre().setHijoDer(tmp);
            tmp.getHijoIzq().setColor("rojo");            
        }
        else{
            tmp.setPadre(tmp.getPadre().getPadre());
            tmp.getHijoIzq().setPadre(tmp);
            tmp.getPadre().setHijoIzq(tmp);
            tmp.getHijoIzq().setColor("rojo");
        }
        tmp.setColor("negro");
        verificaValidez(tmp);
    }
    
    public void calcularAlturaNegra (nodeTree pNode) {
        if(pNode.getHijoIzq()== null && pNode.getHijoDer()==null){
            if(pNode.getColor().equals("negro"))
                pNode.setAltNeg(_dos);
            else
                pNode.setAltNeg(_uno);
        }
        else if(pNode.getHijoDer()==null){
            calcularAlturaNegra(pNode.getHijoIzq());
            if(pNode.getColor().equals("negro"))
                pNode.setAltNeg(pNode.getHijoIzq().getAltNeg()+_uno);
            else
                pNode.setAltNeg(pNode.getAltNeg());
        }
        else if(pNode.getHijoIzq()==null){
            calcularAlturaNegra(pNode.getHijoDer());
            if(pNode.getColor().equals("negro"))
                pNode.setAltNeg(pNode.getHijoDer().getAltNeg()+_uno);
            else
                pNode.setAltNeg(pNode.getAltNeg());
        }
        else{
            calcularAlturaNegra(pNode.getHijoIzq());
            calcularAlturaNegra(pNode.getHijoDer());
            if(pNode.getColor().equals("negro")){
                if(pNode.getHijoDer().getAltNeg()>pNode.getHijoIzq().getAltNeg())
                    pNode.setAltNeg(pNode.getHijoDer().getAltNeg()+_uno);
                else
                    pNode.setAltNeg(pNode.getHijoIzq().getAltNeg());
            }
                
            else{
                if(pNode.getHijoDer().getAltNeg()>pNode.getHijoIzq().getAltNeg())
                    pNode.setAltNeg(pNode.getHijoDer().getAltNeg());
                else
                    pNode.setAltNeg(pNode.getHijoIzq().getAltNeg());
            }
        }        
    }
    
    private nodeTree menorMayores(nodeTree pNode){
        if (pNode.getHijoIzq()==null)
            return pNode;
        else
            return menorMayores(pNode.getHijoIzq());        
    }
    
    public void postOrden(nodeTree pNode){
        if(pNode.getHijoIzq()== null && pNode.getHijoDer()==null)
            System.out.println(pNode.getData()+"++++" +pNode.getColor());
        else if(pNode.getHijoDer()==null){
            postOrden(pNode.getHijoIzq());
            System.out.println(pNode.getData()+"++++" +pNode.getColor());
        }
        else if(pNode.getHijoIzq()==null){
            postOrden(pNode.getHijoDer());
            System.out.println(pNode.getData()+"++++" +pNode.getColor());
        }
        else{
            postOrden(pNode.getHijoIzq());
            postOrden(pNode.getHijoDer());
            System.out.println(pNode.getData()+"++++" +pNode.getColor());
        }            
    }
    
    public boolean find(G Data){
        if(_root==null)
            return false;
        else
            return findAux(Data, _root);
    }    
    private boolean findAux(G pData, nodeTree pNode){
        if((String)pData!=((urlProcesado)pNode.getData()).getDireccion() && pNode.getHijoDer()==null && pNode.getHijoIzq()==null)
            return false;
        else if(((urlProcesado)pNode.getData()).getDireccion() ==(String)pData)
            return true;
        else if (((String)pData).compareTo(((urlProcesado)pNode.getData()).getDireccion() )==-_uno)
            return findAux(pData, pNode.getHijoIzq());
        else
            return findAux(pData, pNode.getHijoDer());
    }
    
    public void findSpecial(String pData){
        _urlNode=null;
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
            if(((urlProcesado)pNode.getData()).getDireccion().compareTo((pData))==0)
                _urlNode=pNode;
        }
        else if(pNode.getHijoDer()==null){
            findSpecialAux(pData, pNode.getHijoIzq());
            if(((urlProcesado)pNode.getData()).getDireccion().compareTo((pData))==0)
                _urlNode=pNode;
        }
        else if(pNode.getHijoIzq()==null){
            findSpecialAux(pData, pNode.getHijoDer());
            if(((urlProcesado)pNode.getData()).getDireccion().compareTo((pData))==0)
                _urlNode=pNode;
        }
        else{
            findSpecialAux(pData, pNode.getHijoIzq());
            findSpecialAux (pData, pNode.getHijoDer());
            if(((urlProcesado)pNode.getData()).getDireccion().compareTo((pData))==0)
                _urlNode=pNode;
        } 
    }
    
    public nodeTree getUrlNode(){
        return _urlNode;
    }
    
}
