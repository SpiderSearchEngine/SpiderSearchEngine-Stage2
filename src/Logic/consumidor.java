
package Logic;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase del hilo consumidor
 * @author Gerald M, Jairo O.
 */
public class consumidor extends Thread{
    private spiderBot _spiderBot;
    
    /**
     * Constructor de la clase
     * @param pspiderBot, elemento que se utilizara 
     */
    public consumidor(spiderBot pspiderBot){
        this._spiderBot=pspiderBot;
    }
    /**
     * Metodo para correr el hilo
     */
    public void run (){
        try {
            _spiderBot.obtenerDatos();
        } catch (IOException ex) {
            Logger.getLogger(consumidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
