
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
 * @author Gerald M, Jairo O.
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
            impresionCompleta(doc, xpath);
            
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
            XPathExpression expr2 = xpath.compile("/indice2/KeyWords/KeyWord/Palabra/text()");
            NodeList nodes2 = (NodeList) expr2.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodes2.getLength(); i++)
                list.add(nodes2.item(i).getNodeValue());    
        }
        catch (XPathExpressionException e) { 
            e.printStackTrace();
        }return list;
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
            XPathExpression expr1 = xpath.compile("/indice2/KeyWords/KeyWord/Link/text()");
            NodeList nodes1 = (NodeList) expr1.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodes1.getLength(); i++)
                list.add(nodes1.item(i).getNodeValue());
        }
        catch (XPathExpressionException e) { 
            e.printStackTrace();
        }return list;
    }
    /**
     * Este metodo resive una palabra, y lo que hara es buscar una palabra en
     * especifica y encontrar todos los urls asociados, estos desde esta misma 
     * funcion se podrán tomar uno a uno para ser utilizados o manipulados
     * @param doc
     * @param xpath
     * @return 
     */
    private List getAllUrlsForOneWord(Document doc, XPath xpath, String word) { 
        List list = new ArrayList<>();
        try {
            XPathExpression expr = xpath.compile("/indice2/KeyWords/KeyWord[Palabra='"+word+"']/Link/text()");
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodes.getLength(); i++){
                System.out.println((String)nodes.item(i).getNodeValue());
                list.add(nodes.item(i).getNodeValue());}
        }
        catch (XPathExpressionException e) { 
            e.printStackTrace();
        }return list;
    }
    /**
     * Este metodo lee el indice numero 2, toma cada palabra y la inserta en un 
     * arbol AVL, del mismo XML toma una lista con los urls relacionados y los 
     * agrega a cada palabra.
     * @param doc
     * @param xpath
     * @return 
     */
    private List impresionCompleta(Document doc, XPath xpath) { 
        List list = new ArrayList<>();
        palabra palabron=new palabra(null, 0, null);
        avlTree avl=new avlTree(null);
        redBlackTree RyN= new redBlackTree(null);
        try {
            XPathExpression expra = xpath.compile("/indice2/KeyWords/KeyWord/Palabra/text()");
            XPathExpression exprb = xpath.compile("/indice2/KeyWords/KeyWord/Link/text()");
            XPathExpression exprc = xpath.compile("/indice2/KeyWords/KeyWord/Apariciones/text()");
            NodeList nodesa = (NodeList) expra.evaluate(doc, XPathConstants.NODESET);
            NodeList nodesb = (NodeList) exprb.evaluate(doc, XPathConstants.NODESET);
            NodeList nodesc = (NodeList) exprc.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodesa.getLength(); i++){
                palabron=new palabra(nodesa.item(i).getNodeValue(), Integer.parseInt(nodesc.item(i).getNodeValue()), new list(null, null));
                avl.findSpecial(nodesa.item(i).getNodeValue());
                if (avl.getCondicion()==false){
                    try {
                        XPathExpression expr = xpath.compile("/indice2/KeyWords/KeyWord[Palabra='"+nodesa.item(i).getNodeValue()+"']/Link/text()");
                        NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
                        for (int j = 0; j < nodes.getLength(); j++){
                            RyN.findSpecial(nodesb.item(i).getNodeValue());
                            palabron.getListaReferencia().insertHead(RyN.getUrlNode());;}
                    }catch (XPathExpressionException e) { 
                        e.printStackTrace();}
                    avl.insert(new nodeTree(palabron,null,null,null,null));
                } 
            }avl.postOrden(avl.getRoot());
        }
        catch (XPathExpressionException e) { 
            e.printStackTrace();
        }return list;
    }
    
    
    
}
