/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author gerald
 */
public class nodoSplay {
   private String _palabra;
   private Integer _valor;

   private nodoSplay _padre;
   private nodoSplay _hijoIzquierdo;
   private nodoSplay _hijoDerecho;

   public nodoSplay(String k, Integer v)
   {
      _palabra = k;
      _valor = v;
      _padre = null;
      _hijoIzquierdo = null;
      _hijoDerecho = null;
   }

    /**
     * Metodo que captura la palabra que se encuentre adentro de un nodo
     * @return the _palabra
     */
    public String getPalabra() {
        return _palabra;
    }

    /**
     * Metodo que permite setear la palabra introducida en un nodo
     * @param ppalabra the _palabra to set
     */
    public void setPalabra(String ppalabra) {
        this._palabra = ppalabra;
    }

    /**
     * Metodo que permite en esta aplicacion mostrar obtener el numero utilizaciones
     * que se le de a una busqueda
     * @return the _valor
     */
    public Integer getValor() {
        return _valor;
    }

    /**
     * Metodo para setear el numero de utilizaciones que se le da a una busqueda
     * @param pvalor the _valor to set
     */
    public void setValor(Integer pvalor) {
        this._valor = pvalor;
    }

    /**
     * Metodo para obtener el padre de un nodo
     * @return the _padre
     */
    public nodoSplay getPadre() {
        return _padre;
    }

    /**
     * Metodo para setear el padre de un nodo
     * @param ppadre the _padre to set
     */
    public void setPadre(nodoSplay ppadre) {
        this._padre = ppadre;
    }

    /**
     * Metodo para obtener el hijo izquierdo de un nodo
     * @return the _hijoIzquierdo
     */
    public nodoSplay getHijoIzquierdo() {
        return _hijoIzquierdo;
    }

    /**
     * Metodo pra setear el hijo izquierdo de un nodo
     * @param phijoIzquierdo the _hijoIzquierdo to set
     */
    public void setHijoIzquierdo(nodoSplay phijoIzquierdo) {
        this._hijoIzquierdo = phijoIzquierdo;
    }

    /**
     * Metodo para obtener el hijo derecho de un nodo
     * @return the _hijoDerecho
     */
    public nodoSplay getHijoDerecho() {
        return _hijoDerecho;
    }

    /**
     * Metodo para setear el hijo derecho de un nodo
     * @param phijoDerecho the _hijoDerecho to set
     */
    public void setHijoDerecho(nodoSplay phijoDerecho) {
        this._hijoDerecho = phijoDerecho;
    }
   
}
