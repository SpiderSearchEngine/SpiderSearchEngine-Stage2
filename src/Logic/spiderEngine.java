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
public class spiderEngine {
    
    private avlTree arbolPalabras;
    private redBlackTree arbolDirecciones;
    private binaryTree arbolResultados;
    private Buscador Ingreso;
    
    
    public void optimizarEstructuras(){
        indice1Reader i1R=new indice1Reader();
        arbolDirecciones=i1R.lectura();
        arbolDirecciones.postOrden(arbolDirecciones.getRoot());
        indice2Reader i2R= new indice2Reader();
        i2R.lectura();
        
    }
    public void buscarAVL(){
        Ingreso=new Buscador();
        arbolPalabras.findSpecial(Ingreso.getTexto());
        if (arbolPalabras.getCondicion()){
            arbolPalabras.findResult(Ingreso.getTexto());
            arbolResultados.insert(arbolPalabras.getResultado());
        }
    }
}
