
package Logic;

/**
 *
 * @author jairo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        heapClass hc= new heapClass(6);
        hc.insertar(623);
        hc.insertar(96);
        hc.insertar(346);
        hc.insertar(3);
        hc.insertar(66);
        hc.insertar(6);
        /**hc.insertar(5);
        hc.insertar(4);
        hc.insertar(3);
        hc.insertar(2);
        hc.insertar(1);*/
        
        
        hc.mostrar(4);
    }
    
}
