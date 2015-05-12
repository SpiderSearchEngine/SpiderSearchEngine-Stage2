
package Logic;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

    /**
     * Clase para leer los archivos xml de configuracion
     * @author Gerald M, Jairo O
     */
    public class leerxml {
     /**
      * Constructor de la clase.
      */  
    public leerxml(){
    }
    /**
     * Metodo que lo que hace es traer el texto de un XML por completo 
     * @param pdireccion, es la direccion o ruta en la que ha de encontrarse el archivo XML 
     * @param pindice, indice por el cual se va dezplasando el lector de XML.
     * @return
     * @throws ParserConfigurationException
     * @throws FileNotFoundException
     * @throws SAXException
     * @throws IOException 
     */
    public String leer (String pdireccion, int pindice) throws ParserConfigurationException, FileNotFoundException, SAXException, IOException{
        try {
            DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder DB = DBF.newDocumentBuilder();
            Document documento = DB.parse(pdireccion);
            Element raizDelXml = documento.getDocumentElement();
	    NodeList elemRaiz = raizDelXml.getChildNodes();   
            Node dato = elemRaiz.item(pindice);
            if(dato.getNodeType()==Node.ELEMENT_NODE) {
	            Node datoContenido = dato.getFirstChild(); 
	            if(datoContenido!=null && datoContenido.getNodeType()==Node.TEXT_NODE)
                        return datoContenido.getNodeValue();
	            }
        } catch (SAXException ex) {
            System.out.println("ERROR: El formato XML del fichero no es correcto\n"+ex.getMessage());
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("ERROR: Se ha producido un error el leer el fichero\n"+ex.getMessage());
            ex.printStackTrace();
        } catch (ParserConfigurationException ex) {
            System.out.println("ERROR: No se ha podido crear el generador de documentos XML\n"+ex.getMessage());
            ex.printStackTrace();
        }      
        return null;
    }
}
