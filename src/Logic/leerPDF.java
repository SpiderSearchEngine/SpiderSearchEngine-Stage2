package Logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
/**
 * Esta clase hace la lectura de los documentos PDF
 * @author Gerald M, Jairo O. 
 *
 */
public class leerPDF {
		private PDFParser _parser;
		private PDFTextStripper _pdfStripper;
	    private PDDocument _pdDoc ;
	    private COSDocument _cosDoc ;
	    private String _Text ;
	    private String _Archivo;
	    private File _file;
	    /**
	     * Constructor de la clase leerPDF
	     */
	    public leerPDF() {
	    }
	    /**
	     * Este metodo toma el contenido de un archivo PDF (especificamente su texto) el cual
	     * será manipulado en otros metodos de diferentes clase 
	     * @return
	     * @throws IOException
	     */
		  public String ToText() throws IOException
		  {
		       this._pdfStripper = null;
		       this._pdDoc = null;
		       this._cosDoc = null;
		       
		       _file = new File(_Archivo);
		       _parser = new PDFParser(new FileInputStream(_file));
		       _parser.parse();
		       _cosDoc = _parser.getDocument();
		       _pdfStripper = new PDFTextStripper();
		       _pdDoc = new PDDocument(_cosDoc);
		       _pdDoc.getNumberOfPages();
		       _pdfStripper.setStartPage(1);
		       _pdfStripper.setEndPage(_pdDoc.getNumberOfPages());
		       _Text = _pdfStripper.getText(_pdDoc);
		       return _Text;
		  }
		/**
		 * Este metodo resive por parametro el archivo PDF a leer y lo almacena en una variable local.
		 * @param filePath
		 */
	    public void getArchivo(String pArchivo) {
	        this._Archivo = pArchivo;
	    }
	}


