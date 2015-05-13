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
public class NodeAVL {
    private int _pdata;
    private NodeAVL _hDer;
    private NodeAVL _hIzq;
    private NodeAVL _padre;
    private int _altura;
    private int _FE;
    
    public NodeAVL (int pdata, NodeAVL padre, NodeAVL hDer,  NodeAVL hIzq){
        this._pdata=pdata;
        this._hDer=hDer;
        this._hIzq=hIzq;
        this._padre=padre;
    }
    public int getData (){
        return this._pdata;
    }
    public NodeAVL getPadre (){
        return this._padre;
    }
    public NodeAVL getHijoDer (){
        return this._hDer;
    }
    public NodeAVL getHijoIzq (){
        return this._hIzq;
    }
    public int getAltura(){
        return this._altura;
    }
    public int getFE(){
        return this._FE;
    }
    public void setData (int pdata){
        this._pdata=pdata;
    }
    public void setPadre (NodeAVL padre){
        this._padre=padre;
    }
    public void setHijoDer (NodeAVL hDer){
        this._hDer=hDer;
    }
    public void setHijoIzq (NodeAVL hIzq){
        this._hIzq=hIzq;
    }
    
    public void setAltura(int newAlt){
        this._altura=newAlt;
    }
    public void setFE(int newFE){
        this._FE=newFE;
    }
}
