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
 *Clase que hara la lectura y todos los procesos que haya que hacerle al indice2
 * 
 * @author gerald
 */
public class indice2Reader {
    public void lectura(){
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc=null;
        try{
            builder = factory.newDocumentBuilder(); 
            try {
                doc = builder.parse("indice2.xml");
            } catch (SAXException ex) {
                Logger.getLogger(indice2Reader.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(indice2Reader.class.getName()).log(Level.SEVERE, null, ex);
            }
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
          
            /**
             * Muestra un arreglo con palabras que estan adentro del archivo XML de indice 2
             */
            List Keys = getAllWords(doc, xpath); 
            System.out.println("Find All Words's are:" + Arrays.toString(Keys.toArray()));
            /**
             * Muestra un arreglo con todos los Uls que estan adentro del archivo XML de indice 2
             */
            List Urls = getAllUrls(doc, xpath); 
            System.out.println("Find All URL's are:" + Arrays.toString(Urls.toArray()));
            //
            /**
             * Muestra un arreglo con todos los Uls relacionados con una de las 
             * Palbras especificamente, que estan adentro del archivo XML de indice 2
             */
            String word="Gerald";
            List WUrls = getAllUrls1(doc, xpath,word); 
            System.out.println("Find All URL's for specific Word are:" + Arrays.toString(WUrls.toArray()));
            //
            
        }catch (ParserConfigurationException e) { 
            e.printStackTrace(); 
        }
    }
    
    /**
     * Este metodo agarra y toma el indice2 y busca exactamente cada etiqueta que
     * contenga una palabra, luego de eso la toma y la deja disponible para manipularla 
     * 
     * @param doc
     * @param xpath
     * @return 
     */
    private List getAllWords(Document doc, XPath xpath) { 
        List list = new ArrayList<>();
        try {
            XPathExpression expr2 = xpath.compile("/indice2/KeyWords/Keyword/Palabra/text()");
            NodeList nodes2 = (NodeList) expr2.evaluate(doc, XPathConstants.NODESET);
            //System.out.println(nodes.item(0).getNodeValue());
            for (int i = 0; i < nodes2.getLength(); i++){
                System.out.println(nodes2.item(i).getNodeValue());
                list.add(nodes2.item(i).getNodeValue());
            }
        }
        catch (XPathExpressionException e) { 
            e.printStackTrace();
        }
        return list;
    }
    
    /**
     * Este metodo toma cada url que aparesca dentro de las etiquetas links y las
     * toma para dejarlas disponibles para su manipulacion e implementacion
     * @param doc
     * @param xpath
     * @return 
     */
    private List getAllUrls(Document doc, XPath xpath) { 
        List list = new ArrayList<>();
        try {
            XPathExpression expr1 = xpath.compile("/indice2/KeyWords/Keyword/Link/text()");
            NodeList nodes1 = (NodeList) expr1.evaluate(doc, XPathConstants.NODESET);
            //System.out.println(nodes.item(0).getNodeValue());
            for (int i = 0; i < nodes1.getLength(); i++){
                System.out.println(nodes1.item(i).getNodeValue());
                list.add(nodes1.item(i).getNodeValue());
            }
        }
        catch (XPathExpressionException e) { 
            e.printStackTrace();
        }
        return list;
    }
    /**
     * Este metodo resive una palabra, y lo que hara es buscar una palabra en
     * especifica y encontrar todos los urls asociados, estos desde esta misma 
     * funcion se podrán tomar uno a uno para ser utilizados o manipulados
     * @param doc
     * @param xpath
     * @return 
     */
    private List getAllUrls1(Document doc, XPath xpath, String word) { 
        List list = new ArrayList<>();
        //String simple="Jairo";
        try {
            //XPathExpression expr = xpath.compile("/indicegeneral/Keywords[palabra='"+simple+"']/URL/text()");
            XPathExpression expr = xpath.compile("/indice2/KeyWords/Keyword[Palabra='"+word+"']/Link/text()");
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodes.getLength(); i++){
                System.out.println((String)nodes.item(i).getNodeValue());
                list.add(nodes.item(i).getNodeValue());}
        }
        catch (XPathExpressionException e) { 
            e.printStackTrace();
        }
        return list;
    }
    
    
    
}
