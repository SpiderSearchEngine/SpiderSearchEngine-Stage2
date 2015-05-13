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
public class NodeTree {
    private int _pdata;
    private NodeTree _hDer;
    private NodeTree _hIzq;
    
    public NodeTree (int pdata, NodeTree hDer,  NodeTree hIzq){
        this._pdata=pdata;
        this._hDer=hDer;
        this._hIzq=hIzq;        
    }
    public int getData (){
        return this._pdata;
    }
    public NodeTree getHijoDer (){
        return this._hDer;
    }
    public NodeTree getHijoIzq (){
        return this._hIzq;
    }
    public void setData (int pdata){
        this._pdata=pdata;
    }
    public void setHijoDer (NodeTree hDer){
        this._hDer=hDer;
    }
    public void setHijoIzq (NodeTree hIzq){
        this._hIzq=hIzq;
    }
    
}
