
package Logic;

import java.io.IOException;

/**
 * Clase para procesar los urls
 *  @author Gerald M, Jairo O.
 */
public class procesarURLS {
    
    /**
     * Constructor de la clase
     */
    public procesarURLS(){
    }
    
    /**
     * Metodo que procesa los urls
     * @param url,link a procesar
     * @throws IOException 
     * @return pila con los links obtenidos
     */
    public stackList procesar (url purl) throws IOException{
        String pag = purl.getDireccion();
        int numAsoc = purl.getNumAsoc();
        int pesoAsoc= purl.getPesoAsoc();
        stackList pilaUrls = new stackList(null);
        if(validar(pag)==true){
            extraerUrlsDirectorio eU= new extraerUrlsDirectorio();  
            pilaUrls=eU.busquedaArchivos(pag);
        }
        else if (pag.startsWith("smb")){
            System.out.println("carpetaCompartida");
        }
        return pilaUrls;
    }
    /**
     * Metodo que valida si la direccion es valida
     * @param direccion
     * @return valor booleano (true si la direccion es valida)
     */
    private boolean validar(String direccion){
        boolean cond=true;
        int ind=0;
        while(direccion!=null){
            if(direccion.length()>1){
                if(direccion.substring(ind, ind+1).compareTo(".")==0){
                    cond=false;
                    break;
                }
                else
                    direccion=direccion.substring(ind+1);
            }
            else
                break;
        }
        return cond;
    }
    
}
