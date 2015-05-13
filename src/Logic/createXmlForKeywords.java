
package Logic;

import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *Clase para realizar la creacion del archivo XML que contendra los datos del indice.
 * @author Gerald M, Jairo O.
 */
public class createXmlForKeywords<G> {
    /**
     * Constructor de la clase
     */
    public createXmlForKeywords(){ 
    }
    /**
     * Este metodo funciona para crear el cuerpo del archivo XML que contendrá 
     * el indice.
     * @param pname, Nombre que resive el nuevo archivo XML
     * @param ppalabras, Palabras extraidas de la lista de Keywords
     * @param lpinks, links extraidos de la lista de URL's
     * @throws Exception 
     */
    public void generate(String pname, ArrayList<String> ppalabras,ArrayList<String>plinks) throws Exception{
        if(ppalabras.isEmpty() ){
            System.out.println("ERROR empty ArrayList");
            return;
        }else{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, pname, null);
            document.setXmlVersion("1.0");
            Element raizDelDocumento = document.getDocumentElement();
            Element etiquetaPrincipal = document.createElement("KeyWords");
            raizDelDocumento.appendChild(etiquetaPrincipal);
            for(int i=0; i<ppalabras.size();i++){
                Element etiquetaSegundaria = document.createElement("KeyWord");
                Element nodoPalabra = document.createElement("Palabra"); 
                Text valorDeLaPalabra = document.createTextNode(ppalabras.get(i));
                nodoPalabra.appendChild(valorDeLaPalabra);  
                Element nodoLinks = document.createElement("Link"); 
                Text valorDeLink = document.createTextNode(plinks.get(i));
                nodoLinks.appendChild(valorDeLink); 
                etiquetaPrincipal.appendChild(etiquetaSegundaria);
                etiquetaSegundaria.appendChild(nodoPalabra);
                etiquetaSegundaria.appendChild(nodoLinks);
            }                
            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File(pname+".xml")); 
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
        }
    }
    
}
