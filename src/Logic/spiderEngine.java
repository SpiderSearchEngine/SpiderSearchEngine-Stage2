
package Logic;

/**
 * Clase para crear el spiderEngine
 * @author Gerald M, Jairo o
 */

public class spiderEngine {
    
    private avlTree arbolPalabras;
    private redBlackTree arbolDirecciones;
    private binaryTree arbolResultados;
    private nodeTree _nT;
    /**
     * Clase para optimizar las estructuras
     */
    public void optimizarEstructuras(){
        indice1Reader i1R=new indice1Reader();
        arbolDirecciones=i1R.lectura();
        arbolDirecciones.postOrden(arbolDirecciones.getRoot());
        indice2Reader i2R= new indice2Reader();
        i2R.lectura();
        
    }
    /**
     * Metodo para buscar en el arbol avl
     * @param ingresado 
     */
    public void buscarAVL(String ingresado){
        buscarAvlAux(ingresado, arbolPalabras.getRoot());
        arbolPalabras.findSpecial(ingresado);
    }
    /**
     * Metodo auxiliar en el arbol avl
     * @param pData
     * @param pNode 
     */
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
    /**
     * Metodo para obtener la direccion asociada a la palabra
     * @return direccion de la palabra
     */
    public String getNT(){
        return ((urlProcesado)_nT.getData()).getDireccion();
    }
    
}
