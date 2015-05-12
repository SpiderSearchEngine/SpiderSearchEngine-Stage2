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
public class nodoParaArbolSplay <G>{
    private nodoParaArbolSplay raiz;
    private nodoParaArbolSplay padre;
    private nodoParaArbolSplay Hder;
    private nodoParaArbolSplay Hizq;
    private int indice;
    private int profundidad;
    private String valor;
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
     * @return the padre
     */
    public nodoParaArbolSplay getPadre() {
        return padre;
    }

    /**
     * @param padre the padre to set
     */
    public void setPadre(nodoParaArbolSplay padre) {
        this.padre = padre;
    }

    /**
     * @return the Hder
     */
    public nodoParaArbolSplay getHder() {
        return Hder;
    }

    /**
     * @param Hder the Hder to set
     */
    public void setHder(nodoParaArbolSplay Hder) {
        this.Hder = Hder;
    }

    /**
     * @return the Hizq
     */
    public nodoParaArbolSplay getHizq() {
        return Hizq;
    }

    /**
     * @param Hizq the Hizq to set
     */
    public void setHizq(nodoParaArbolSplay Hizq) {
        this.Hizq = Hizq;
    }

    /**
     * @return the indice
     */
    public int getIndice() {
        return indice;
    }

    /**
     * @param indice the indice to set
     */
    public void setIndice(int indice) {
        this.indice = indice;
    }

    /**
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * @return the profundidad
     */
    public int getProfundidad() {
        return profundidad;
    }

    /**
     * @param profundidad the profundidad to set
     */
    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }
}
