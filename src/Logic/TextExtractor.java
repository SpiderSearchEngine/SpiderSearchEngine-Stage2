/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;


import java.io.ByteArrayOutputStream;  
import java.io.File;  
import java.io.InputStream;  
import java.io.OutputStream;  
import java.io.OutputStreamWriter;  
import java.net.URL;  
   
import org.apache.tika.detect.DefaultDetector;  
import org.apache.tika.detect.Detector;  
import org.apache.tika.io.TikaInputStream;  
import org.apache.tika.metadata.Metadata;  
import org.apache.tika.parser.AutoDetectParser;  
import org.apache.tika.parser.ParseContext;  
import org.apache.tika.parser.Parser;  
import org.apache.tika.sax.BodyContentHandler;  
   
import org.xml.sax.ContentHandler;  
 /**
  * Clase que se encargara de tomar un documento PDF y tomar para extraer de el todo el texto
  * @author Gerald M, Jairo O
  */  
class TextExtractor {  
  private OutputStream _outputstream;  
  private ParseContext _context;  
  private Detector _detector;  
  private Parser _parser;  
  private Metadata _metadata;  
  private String _extractedText;  
  /**
   * Constructor de la clase
   */ 
  public TextExtractor() {  
    this._context = new ParseContext();  
    this._detector = new DefaultDetector();  
    this._parser = new AutoDetectParser(_detector);  
    this._context.set(Parser.class, _parser);  
    this._outputstream = new ByteArrayOutputStream();  
    this._metadata = new Metadata();  
  }  
  /**
   * Metodo que procesa el documento embebido en la direccion URL
   * @param filename, Direccion Url del documento pdf en internet
   * @throws Exception 
   */ 
  public void process(String pfilename) throws Exception {  
    URL url;  
    File file = new File(pfilename);  
    if (file.isFile()) {  
      url = file.toURI().toURL();  
    } else {  
      url = new URL(pfilename);  
    }  
    InputStream input = TikaInputStream.get(url, _metadata);  
    ContentHandler handler = new BodyContentHandler(_outputstream);  
    _parser.parse(input, handler, _metadata, _context);  
    input.close();  
  }  
   
  /**
   * Este metodo sera el que tome el texto del documento y lo pasara a ser un String para 
   * asi poder ser manipulado.
   */ 
  public String getString() {  
    _extractedText = _outputstream.toString();   
    //System.out.println(_extractedText);  
    return _extractedText;
  }
    
    
  
}