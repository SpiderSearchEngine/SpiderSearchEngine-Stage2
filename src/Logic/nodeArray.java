
package Logic;

/**
 *Esta clase corresponde al array que es la representacion del arbol Heap
 * @author Gerald M, Jairo O.
 */
public class nodeArray <G>{
    private int _peso;
    private String _documentos="";
    private int _numAsoc;
    /**
     * Constructor de la clse
     */
    public nodeArray(int ppeso,String pdocuments,int pnumAsoc){
        this._peso=ppeso;
        this._documentos=pdocuments;
        this._numAsoc=pnumAsoc;
    }

    /**
     * Metodo para obtener el peso del documento.
     * @return the _peso
     */
    public int getPeso() {
        return _peso;
    }

    /**
     * Metodo para setear el peso del documento.
     * @param _Data the _peso to set
     */
    public void setPeso(int _Data) {
        this._peso = _Data;
    }

    /**
     * Metodo pra obtener el documento.
     * @return the _documentos
     */
    public String getDocumentos() {
        return _documentos;
    }

    /**
     * Metodo para setear el documento.
     * @param pdocumentos the pdocumentos to set
     */
    public void setDocumentos(String pdocumentos) {
        this._documentos = pdocumentos;
    }

    /**
     * @return the _numAsoc
     */
    public int getNumAsoc() {
        return _numAsoc;
    }

    /**
     * @param _numAsoc the _numAsoc to set
     */
    public void setNumAsoc(int _numAsoc) {
        this._numAsoc = _numAsoc;
    }
}
