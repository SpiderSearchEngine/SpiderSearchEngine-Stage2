
package Logic;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * Clase del hilo productor
 * @author Gerald M, Jairo O.
 */
public class productor extends Thread{
    
    private spiderBot _sb;
    private String _direccion;
    private int _indice;
    private int _numAsoc;
    
    /**
     * Constructor de la clase
     * @param pspiderBot, elemento que se utilizara
     * @param pdireccion, archivo xmlpara extraer los urls iniciales
     * @param pindice, numero en el que se comienza a leer
     * @param pnumAsoc, numero asociado del url
     */
    public productor(spiderBot pspiderBot, String pdireccion, int pindice, int pnumAsoc){
        this._sb=pspiderBot;
        this._direccion=pdireccion;
        this._indice=pindice;
        this._numAsoc=pnumAsoc;
    }
    /**
     * Metodo para correr el hilo
     */
    public void run () {
        try {
            _sb.generarCola(_direccion, _indice, _numAsoc);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(productor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(productor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(productor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}