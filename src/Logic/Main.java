
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
    public static void main(String[] args) throws IOException, Exception {
        
        spiderBot sb = new spiderBot();
        productor p = new productor (sb, "indicePrincipal.xml");
                
        consumidor c1 = new consumidor(sb);
        consumidor c2 = new consumidor(sb);
        consumidor c3 = new consumidor(sb);
        
        p.start();
        c1.start();
        c2.start();
        c3.start();
        
        
        while(sb.getParar()==true){
            c1.run();
            c2.run();
            c3.run();
            
            
        }
        //sb.generarIndice();
    }
    
}
