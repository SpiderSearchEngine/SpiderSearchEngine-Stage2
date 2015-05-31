
package Logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 
 * Clase que hara la lectura y todos los procesos que haya que hacerle al indice1
 *
 * @author Gerald M, Jairo O.
 */
public class indice1Reader {
    XPath xpath;
    public redBlackTree lectura(){
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc=null;
        try{
            builder = factory.newDocumentBuilder(); 
            try {
                doc = builder.parse("indice1.xml");
            } catch (SAXException ex) {
                Logger.getLogger(indice1Reader.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(indice1Reader.class.getName()).log(Level.SEVERE, null, ex);
            }
            XPathFactory xpathFactory = XPathFactory.newInstance();
            xpath = xpathFactory.newXPath();
        }
        catch (ParserConfigurationException e) { 
            e.printStackTrace(); 
        }
        return getAllUrls(doc, xpath);
    }
    /**
     * Metodo que me obtiene todos los urls procesados que se encuentran ya 
     * adentro del Xml llamado indice1
     * @param doc
     * @param xpath
     * @return 
     */
    private  redBlackTree getAllUrls(Document doc, XPath xpath) { 
        redBlackTree RyN=new redBlackTree(null);
        try {
            XPathExpression expr = xpath.compile("/indice1/UrlsProcesadas/URL/text()");
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodes.getLength(); i++)
                RyN.insert(new urlProcesado((nodes.item(i).getNodeValue()),654));
        }
        catch (XPathExpressionException e) { 
            e.printStackTrace();
        }
        return RyN;
    }
    
    
    
}
