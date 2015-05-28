
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
    }
    
}
