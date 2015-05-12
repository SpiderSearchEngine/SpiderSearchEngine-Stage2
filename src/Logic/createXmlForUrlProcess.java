
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
 * Clase para crear el archivo XML que contendra los URL's procesados
 * @author Gerald M, Jairo O.
 */
public class createXmlForUrlProcess<G> {
    /**
     * Constructor de la clase
     */
    public createXmlForUrlProcess(){
    }
    /**
     * Metodo para crear el cuerpo del archivo XML que posee los url's procesados para el indice
     * @param pname, nombre que tomara el archivo XML
     * @param pkey, dentro se creara las etiquetas de URL's
     * @param purlsProcesadas, Url's procesadas que son extraidas de la lista de Url's
     * @throws Exception 
     */
    public void generate(String pname, ArrayList<String> pkey,ArrayList<String> purlsProcesadas) throws Exception{
        if(pkey.isEmpty() ){
            System.out.println("ERROR empty ArrayList");
            return;
        }else{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, pname, null);
            document.setXmlVersion("1.0");
            Element etiquetaRaiz = document.getDocumentElement();
            Element etiquetaPrincipal = document.createElement("UrlsProcesadas"); 
            etiquetaRaiz.appendChild(etiquetaPrincipal);
            for(int i=0; i<pkey.size();i++){
                Element nodoUrlProcesadas = document.createElement("URL"); 
                Text valorDeUrlsProcesadas = document.createTextNode(purlsProcesadas.get(i));
                nodoUrlProcesadas.appendChild(valorDeUrlsProcesadas); 
                etiquetaPrincipal.appendChild(nodoUrlProcesadas);
            }               
            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File(pname+".xml")); //nombre del archivo
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
        }
    }
    
}
