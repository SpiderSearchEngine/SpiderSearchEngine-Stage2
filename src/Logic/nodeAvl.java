
package Logic;

/**
 *
 * @author jairo
 */
public class nodeAvl <G> {
    
    private G _data;
    private int _nombre;
    private nodeAvl _hDer;
    private nodeAvl _hIzq;
    private nodeAvl _padre;
    private int _altura;
    private int _FE;
    private list _palabras;
    
    public nodeAvl (int pNombre, nodeAvl pPadre, nodeAvl pHDer,  nodeAvl pHIzq, list pPalabras){
        this._nombre=pNombre;
        this._padre=pPadre;
        this._hDer=pHDer;
        this._hIzq=pHIzq;
    }

    /**
     * @return the _data
     */
    public G getData() {
        return _data;
    }

    /**
     * @param _data the _data to set
     */
    public void setData(G pData) {
        this._data = pData;
    }

    /**
     * @return the _nombre
     */
    public int getNombre() {
        return _nombre;
    }

    /**
     * @param _nombre the _nombre to set
     */
    public void setNombre(int pNombre) {
        this._nombre = pNombre;
    }

    /**
     * @return the _hDer
     */
    public nodeAvl getHijoDer() {
        return _hDer;
    }

    /**
     * @param _hDer the _hDer to set
     */
    public void setHijoDer(nodeAvl pHDer) {
        this._hDer = pHDer;
    }

    /**
     * @return the _hIzq
     */
    public nodeAvl getHijoIzq() {
        return _hIzq;
    }

    /**
     * @param _hIzq the _hIzq to set
     */
    public void setHijoIzq(nodeAvl pHIzq) {
        this._hIzq = pHIzq;
    }

    /**
     * @return the _padre
     */
    public nodeAvl getPadre() {
        return _padre;
    }

    /**
     * @param _padre the _padre to set
     */
    public void setPadre(nodeAvl _padre) {
        this._padre = _padre;
    }

    /**
     * @return the _altura
     */
    public int getAltura() {
        return _altura;
    }

    /**
     * @param _altura the _altura to set
     */
    public void setAltura(int pAltura) {
        this._altura = pAltura;
    }

    /**
     * @return the _FE
     */
    public int getFE() {
        return _FE;
    }

    /**
     * @param _FE the _FE to set
     */
    public void setFE(int pFE) {
        this._FE = pFE;
    }
    
    public void insertPalabra(G pData){
        _palabras.insertHead(pData);
    }
}
