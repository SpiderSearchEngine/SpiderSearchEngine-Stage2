
package Logic;

import java.io.IOException;

/**
 *
 * @author jairo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
       leerPDF pdfManager = new leerPDF();
	       pdfManager.getArchivo("/home/gerald/NetBeansProjects/SpiderSearchEngine/SpiderSearchEngine-Stage2/2014064955-CE1103-2015-01-R9.pdf");
	       System.out.println(pdfManager.ToText()); 
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
