
package Logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * Clase para realizar el spiderBot.
 * @author Gerald M, Jairo O.
 */
public class spiderBot {
    
    private queueList cola = new queueList(null, null);
    private list l = new list(null, null);
    private boolean permiso = false;
    private boolean parar = true;
    private String _url; 
    private int _maxthreads;
    private int _maxprofundidad;
    private int _reindex;
    private Heap _heap;
    private redBlackTree arbolDirecciones;
    private avlTree arbolPalabras;
    
    /**
     * Constructor de la clase
     */
    public spiderBot(){
        arbolDirecciones=new redBlackTree(null);
        arbolPalabras= new avlTree(null);
    }
    /**
     * Metodo para generar las colas
     * @param url, direccion del xml de url
     * @param indice, numero de indice para el documento
     * @param numAsoc numero de recursividad
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException 
     */
    public synchronized void generarHeap (String url) throws ParserConfigurationException, SAXException, IOException{
        while(permiso==true){
            try{
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        indiceprincipalReader1 leerxml =new indiceprincipalReader1();
        _heap=leerxml.lectura(url);
        permiso=true;
        notify();
    }
    /**
     * Metodo para obtener todos los datos del url
     * @throws IOException 
     */
    public synchronized void obtenerDatos() throws IOException, Exception{
        int cont=0;
        while(permiso==false){
            try{
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        permiso=false;                
        stackList pilaTexto = new stackList (null);
        stackList pilaUrl = new stackList (null);
        procesarURLS procUrl = new procesarURLS(); 
        formatoTexto ft = new formatoTexto();
        _heap.eliminar();
        nodeArray tmp=_heap.getRaiz();
        url URL=new url(tmp.getDocumentos(),tmp.getPeso(), tmp.getNumAsoc());
        nodeTree nodeUrl;
        if(URL.getNumAsoc()<2 && URL.getNumAsoc()!=-1 && URL.getDireccion().startsWith("/")){
            arbolDirecciones.find(URL.getDireccion());
            if(arbolDirecciones.getCondicion()==false){
                if((URL.getDireccion().endsWith(".pdf") || URL.getDireccion().endsWith(".docx")
                        || URL.getDireccion().endsWith(".doc") || URL.getDireccion().endsWith(".txt") 
                        || URL.getDireccion().endsWith(".odt"))){
                    arbolDirecciones.insert(new urlProcesado(URL.getDireccion(),1));
                    arbolDirecciones.findSpecial(URL.getDireccion());
                    nodeUrl=arbolDirecciones.getUrlNode();
                    TextExtractor text=new TextExtractor();
                    text.process(URL.getDireccion());
                    String texto= text.getString();
                    tokenizer token=new tokenizer(texto);
                    pilaTexto=token.procesar();
                    while(pilaTexto.top()!=null){
                        String var=(String)pilaTexto.top().getData();
                        pilaTexto.pop();
                        procesarPalabras(var, nodeUrl);
                    }
                }
                else{
                    pilaUrl=procUrl.procesar(URL);
                    while(pilaUrl.top()!=null){
                        _heap.Insertar(((url)pilaUrl.top().getData()).getDireccion(),
                                ((url)pilaUrl.top().getData()).getPesoAsoc(), ((url)pilaUrl.top().getData()).getNumAsoc());
                        pilaUrl.pop();
                    }
                }
            }
            permiso=true;
            notify();
        }
        else if(URL.getNumAsoc()<2 && URL.getNumAsoc()!=-1 && URL.getDireccion().startsWith("http")){
            arbolDirecciones.find(URL.getDireccion());
            if(arbolDirecciones.getCondicion()==false){
                if((URL.getDireccion().endsWith(".pdf") || URL.getDireccion().endsWith(".docx")
                        || URL.getDireccion().endsWith(".doc") || URL.getDireccion().endsWith(".txt")
                        || URL.getDireccion().endsWith(".odt"))){
                    arbolDirecciones.insert(new urlProcesado(URL.getDireccion(),1));
                    arbolDirecciones.findSpecial(URL.getDireccion());
                    nodeUrl=arbolDirecciones.getUrlNode();
                    pilaTexto=ft.formato(URL.getDireccion());
                    while(pilaTexto.top()!=null){
                        String var=(String)pilaTexto.top().getData();
                        pilaTexto.pop();
                        procesarPalabras(var, nodeUrl);
                    }
                }
            }
            permiso=true;
            notify();
        }
        else if (URL.getNumAsoc()>=2){
            parar=false;
            permiso=true;
            notify();
        }
        else{
            permiso=true;
            notify();            
        }
    }
        
    private void procesarPalabras(String pal, nodeTree pNodeUrl){
        if(arbolPalabras.getRoot()!=null){
            arbolPalabras.findSpecial(pal);
            if(arbolPalabras.getCondicion()==false){
                arbolPalabras.insert(new nodeTree(new palabra(pal, 1, new list(null, null)),null,null,null,null));
                arbolPalabras.insertardireccion(pal, arbolPalabras.getRoot(), pNodeUrl);
            }
            /*else{
                arbolPalabras.actualizarArbol(arbolPalabras.getRoot(), pal);
            }*/
            
        }
        else{
            arbolPalabras.insert(new nodeTree(new palabra(pal, 1, new list(null, null)),null,null,null,null));
            arbolPalabras.insertardireccion(pal, arbolPalabras.getRoot(), pNodeUrl);
        }
    }
    /**
     * Metodo para generar los indices
     * @throws Exception 
     */
    public void generarIndice() throws Exception{
        hacerXmlIndice1(arbolDirecciones);
        //hacerXmlIndice2(arbolPalabras);
    }
    /**
     * Metodo para generar el indice1 (urls procesados)
     * @param urlList, lista circulas de urls
     * @throws Exception 
     */
    private void hacerXmlIndice1(redBlackTree arbol) throws Exception{
        createXmlForUrlProcess cfup=new createXmlForUrlProcess();
        ArrayList key = new ArrayList();
        ArrayList UrlsProcesadas = new ArrayList();
        nodeTree tmp= arbol.getRoot();
        if (arbol.getRoot()==null)
            return;
        else{
            hacerXmlIndice1Aux(tmp, cfup, key, UrlsProcesadas);
        }
    }
    private void hacerXmlIndice1Aux(nodeTree pNode, createXmlForUrlProcess cfup,
            ArrayList key, ArrayList UrlsProcesadas) throws Exception{
        
        if(pNode.getHijoDer()==null && pNode.getHijoIzq()==null){
            key.add(" ");
            UrlsProcesadas.add(((urlProcesado)pNode.getData()).getDireccion());
            cfup.generate("indice1", key,UrlsProcesadas);
        }
        else if(pNode.getHijoDer()==null){
                hacerXmlIndice1Aux(pNode.getHijoIzq(), cfup, key, UrlsProcesadas);
                key.add(" ");
                UrlsProcesadas.add(((urlProcesado)pNode.getData()).getDireccion());
                cfup.generate("indice1", key,UrlsProcesadas);
        }
        else if(pNode.getHijoIzq()==null){
                hacerXmlIndice1Aux(pNode.getHijoDer(), cfup, key, UrlsProcesadas);
                key.add(" ");
                UrlsProcesadas.add(((urlProcesado)pNode.getData()).getDireccion());
                cfup.generate("indice1", key,UrlsProcesadas);
        }
        else{
            hacerXmlIndice1Aux(pNode.getHijoIzq(), cfup, key, UrlsProcesadas);
            hacerXmlIndice1Aux(pNode.getHijoDer(), cfup, key, UrlsProcesadas);
            key.add(" ");
            UrlsProcesadas.add(((urlProcesado)pNode.getData()).getDireccion());
            cfup.generate("indice1", key,UrlsProcesadas);
        }
    }
    /**
     * Metodo para generar el indice2 (keywords procesados)
     * @param KeywordList, lista doble de keywords procesados
     * @throws Exception 
     */
    private void hacerXmlIndice2(avlTree arbol) throws Exception{
        createXmlForKeywords cfkw=new createXmlForKeywords();
        nodeTree tmp= arbol.getRoot();
        nodeTree tmp2= (nodeTree)((palabra)tmp.getData()).getListaReferencia().getHead().getData();
        ArrayList links = new ArrayList();
        ArrayList palabras = new ArrayList();
        ArrayList apariciones = new ArrayList();
        if (arbol.getRoot()==null)
            return;
        else{
            hacerXmlIndice2Aux(tmp, tmp2, cfkw, links, palabras, apariciones);
        }
    }
    private void hacerXmlIndice2Aux(nodeTree tmp,nodeTree tmp2,createXmlForKeywords cfkw,
            ArrayList links, ArrayList palabras, ArrayList apariciones) throws Exception{
        if(tmp.getHijoDer()==null && tmp.getHijoIzq()==null){
            palabras.add(((palabra)tmp.getData()).getName());
            links.add(((urlProcesado)tmp2.getData()).getDireccion());
            apariciones.add(String.valueOf(((palabra)tmp.getData()).getApariciones()));
            cfkw.generate("indice2",palabras,links, apariciones);
        }
        if(tmp.getHijoDer()==null){
            hacerXmlIndice2Aux(tmp.getHijoIzq(),(nodeTree)((palabra)tmp.getHijoIzq().getData()).getListaReferencia().getHead().getData(),
                    cfkw, links, palabras, apariciones);
            palabras.add(((palabra)tmp.getData()).getName());
            links.add(((urlProcesado)tmp2.getData()).getDireccion());
            apariciones.add(String.valueOf(((palabra)tmp.getData()).getApariciones()));
            cfkw.generate("indice2",palabras,links, apariciones);
        }
        if(tmp.getHijoIzq()==null){
            hacerXmlIndice2Aux(tmp.getHijoDer(),(nodeTree)((palabra)tmp.getHijoDer().getData()).getListaReferencia().getHead().getData(),
                    cfkw, links, palabras, apariciones);
            palabras.add(((palabra)tmp.getData()).getName());
            links.add(((urlProcesado)tmp2.getData()).getDireccion());
            apariciones.add(String.valueOf(((palabra)tmp.getData()).getApariciones()));
            cfkw.generate("indice2",palabras,links, apariciones);
        }
        else{
            hacerXmlIndice2Aux(tmp.getHijoIzq(),(nodeTree)((palabra)tmp.getHijoIzq().getData()).getListaReferencia().getHead().getData(),
                    cfkw, links, palabras, apariciones);
            hacerXmlIndice2Aux(tmp.getHijoDer(),(nodeTree)((palabra)tmp.getHijoDer().getData()).getListaReferencia().getHead().getData(),
                    cfkw, links, palabras, apariciones);
            palabras.add(((palabra)tmp.getData()).getName());
            links.add(((urlProcesado)tmp2.getData()).getDireccion());
            apariciones.add(String.valueOf(((palabra)tmp.getData()).getApariciones()));
            cfkw.generate("indice2",palabras,links, apariciones);
        }
    }
    /**
     * Metodo obtener la condicion de entrafa
     * @return condicion de entrada
     */
    public boolean getParar(){
        return this.parar;
    }
}