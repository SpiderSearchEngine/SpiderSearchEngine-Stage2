
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
        arbolDirecciones.postOrden(arbolDirecciones.getRoot());
        System.out.println("-----------------------------------------------------");
        arbolPalabras.postOrden(arbolPalabras.getRoot());
        //hacerXmlIndice1(arbolDirecciones);
        //hacerXmlIndice2(arbolPalabras);
    }
    /**
     * Metodo para generar el indice1 (urls procesados)
     * @param urlList, lista circulas de urls
     * @throws Exception 
     */
    /*private void hacerXmlIndice1(redBlackTree arbol) throws Exception{
        createXmlForUrlProcess cfup=new createXmlForUrlProcess();
        node tmp= urlList.getHead();
        ArrayList key = new ArrayList();
        ArrayList UrlsProcesadas = new ArrayList();
        if (urlList.getHead()==null)
            return;
        else{
            while(tmp.getNextNode()!=urlList.getHead()){
                key.add(" ");
                UrlsProcesadas.add(((String)(((urlProcesado)tmp.getData()).getDireccion()))+" "+(((urlProcesado)tmp.getData())).getReferencia());
                cfup.generate("indice1", key,UrlsProcesadas);                
                tmp=tmp.getNextNode();
            }
            key.add(" ");
            UrlsProcesadas.add(((String)(((urlProcesado)tmp.getData()).getDireccion()))+" "+(((urlProcesado)tmp.getData())).getReferencia());
            cfup.generate("indice1", key,UrlsProcesadas);
            
        }
    }*/
    /**
     * Metodo para generar el indice2 (keywords procesados)
     * @param KeywordList, lista doble de keywords procesados
     * @throws Exception 
     */
    /*private void hacerXmlIndice2(avlTree arbol) throws Exception{
        createXmlForKeywords cfkw=new createXmlForKeywords();
        node tmp= KeywordList.getHead();
        nodeKey tmp2= ((palabra)(KeywordList.getHead().getData())).getListaReferencia().getHead();
        ArrayList links = new ArrayList();
        ArrayList palabras = new ArrayList();
        node tmp3=tmp;
        nodeKey tmp4=tmp2;
        while (tmp3!=null){
            while (tmp4!=null){
                palabras.add(((palabra)tmp3.getData()).getName()); 
                links.add(((urlProcesado)(((node)(tmp4.getData())).getData())).getDireccion()+" , "+tmp4.getNumNode().getData());
                cfkw.generate("indice2",palabras,links);
                tmp4=tmp4.getNextNode();
            }
            tmp3=tmp3.getNextNode();
            if(tmp3!=null)
                tmp4=((palabra)tmp3.getData()).getListaReferencia().getHead();
        }
    }*/
    /**
     * Metodo obtener la condicion de entrafa
     * @return condicion de entrada
     */
    public boolean getParar(){
        return this.parar;
    }
}