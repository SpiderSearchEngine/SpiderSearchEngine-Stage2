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
import GUI.*;
import sun.net.www.content.image.png;
public class spiderEngine {
    
    private avlTree arbolPalabras;
    private redBlackTree arbolDirecciones;
    private binaryTree arbolResultados;
    private Buscador Ingreso=new Buscador();
    private nodeTree _nT;
    
    public void optimizarEstructuras(){
        indice1Reader i1R=new indice1Reader();
        arbolDirecciones=i1R.lectura();
        arbolDirecciones.postOrden(arbolDirecciones.getRoot());
        indice2Reader i2R= new indice2Reader();
        i2R.lectura();
        
    }
    public void buscarAVL(String ingresado){
        buscarAvlAux(ingresado, arbolPalabras.getRoot());
        arbolPalabras.findSpecial(ingresado);
    }
    private void buscarAvlAux(String pData, nodeTree pNode){
        if(pNode.getHijoIzq()== null && pNode.getHijoDer()==null){
            if(((palabra)pNode.getData()).getName().equals(pData)){
                _nT=(nodeTree)((palabra)pNode.getData()).getListaReferencia().getHead().getData();
            }
        }
        else if(pNode.getHijoDer()==null){
            buscarAvlAux(pData, pNode.getHijoIzq());
            if(((palabra)pNode.getData()).getName().equals(pData)){
                 _nT=(nodeTree)((palabra)pNode.getData()).getListaReferencia().getHead().getData();
            }
        }
        else if(pNode.getHijoIzq()==null){
            buscarAvlAux(pData, pNode.getHijoDer());
            if(((palabra)pNode.getData()).getName().equals(pData)){
                 _nT=(nodeTree)((palabra)pNode.getData()).getListaReferencia().getHead().getData();
            }
        }
        else{
            buscarAvlAux(pData, pNode.getHijoIzq());
            buscarAvlAux(pData, pNode.getHijoDer());
            if(((palabra)pNode.getData()).getName().equals(pData)){
                 _nT=(nodeTree)((palabra)pNode.getData()).getListaReferencia().getHead().getData();
            }
        } 
    }
    public String getNT(){
        System.out.println("222222234567892345678902345678 "+((urlProcesado)_nT.getData()).getDireccion());
        return ((urlProcesado)_nT.getData()).getDireccion();
    }
    
}
