/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author gerald
 */
public class indiceprincipalReader1 {
    XPath xpath;
    public Heap lectura(String pDireccion){
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc=null;
        try{
            builder = factory.newDocumentBuilder(); 
            try {
                doc = builder.parse(pDireccion);
            } catch (SAXException ex) {
                Logger.getLogger(indiceprincipalReader1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(indiceprincipalReader1.class.getName()).log(Level.SEVERE, null, ex);
            }
            XPathFactory xpathFactory = XPathFactory.newInstance();
            xpath = xpathFactory.newXPath();
          
            /**
             * Muestra un arreglo con los Uls que estan adentro del archivo XML de indice 1
             */
            //
            
        }catch (ParserConfigurationException e) { 
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
    private  Heap getAllUrls(Document doc, XPath xpath) { 
        Heap H=new Heap();
        try {
            XPathExpression expr = xpath.compile("/indice/UrlsProcesadas/URL/text()");
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodes.getLength(); i++){
                //System.out.println(nodes.item(i).getNodeValue());
                H.Insertar(nodes.item(i).getNodeValue(),45,1);
                
            }
        }
        catch (XPathExpressionException e) { 
            e.printStackTrace();
        }
        return H;
    }
    
    
    
}
