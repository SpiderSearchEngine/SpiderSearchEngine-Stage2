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
public class spiderEngine {
    
    private avlTree arbolPalabras;
    private redBlackTree arbolDirecciones;
    
    public void optimizarEstructuras(){
        indice1Reader i1R=new indice1Reader();
        arbolDirecciones=i1R.lectura();
        arbolDirecciones.postOrden(arbolDirecciones.getRoot());
        
    }
    
}
