
package Logic;

/**
 * Clase nodo exclusiva para ser utilizada con el arbol Heap
 * @author Gerald M, Jairo O.
 */
public class nodoParaArbolSplay <G>{
    private nodoParaArbolSplay raiz;
    private nodoParaArbolSplay padre;
    private nodoParaArbolSplay Hder;
    private nodoParaArbolSplay Hizq;
    private int indice;
    private int profundidad;
    private String valor;
    /**
     * Constructor de la clase
     * @param indice, numero de indice en el array
     */
    public nodoParaArbolSplay(int indice){
        this.raiz=null;
        this.padre=null;
        this.Hder=null;
        this.Hizq=null;
        this.valor=null;
        this.profundidad=0;
        this.indice=indice;
    }

    /**
     * Metodo para obtener el dato del nodo Padre.
     * @return the padre
     */
    public nodoParaArbolSplay getPadre() {
        return padre;
    }

    /**
     * Metodo para setear el dato del nodo Padre.
     * @param padre the padre to set
     */
    public void setPadre(nodoParaArbolSplay padre) {
        this.padre = padre;
    }

    /**
     * Metodo para obtener el dato del nodo Hijo derecho
     * @return the Hder
     */
    public nodoParaArbolSplay getHder() {
        return Hder;
    }

    /**
     * Metodo para setear el dato del nodo Hijo derecho
     * @param Hder the Hder to set
     */
    public void setHder(nodoParaArbolSplay Hder) {
        this.Hder = Hder;
    }

    /**
     * Metodo para obtener el dato del nodo hijo izquierdo.
     * @return the Hizq
     */
    public nodoParaArbolSplay getHizq() {
        return Hizq;
    }

    /**
     * Metodo para setear el dato del nodo hijo izquierdo.
     * @param Hizq the Hizq to set
     */
    public void setHizq(nodoParaArbolSplay Hizq) {
        this.Hizq = Hizq;
    }

    /**
     * Metodo para obtener el dato del indice.
     * @return the indice
     */
    public int getIndice() {
        return indice;
    }

    /**
     * Metodo para setear el dato del indice.
     * @param indice the indice to set
     */
    public void setIndice(int indice) {
        this.indice = indice;
    }

    /**
     * Metodo para obtener el dato de valor.
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * Metodo para setear el dato de valor.
     * @param valor the valor to set
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * Metodo para obtener el dato de la profundidad.
     * @return the profundidad
     */
    public int getProfundidad() {
        return profundidad;
    }

    /**
     *  Metodo para setear el dato de la profundidad.
     * @param profundidad the profundidad to set
     */
    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }
}
