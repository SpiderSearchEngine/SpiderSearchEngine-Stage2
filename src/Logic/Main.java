
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
        
        spiderBot sb = new spiderBot();
        productor p = new productor (sb, "indicePrincipal.xml");
        
    }
    
}
