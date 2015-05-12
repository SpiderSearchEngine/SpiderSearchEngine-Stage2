/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;
/**
 *Clase para manipular el arbol Splay , ademas de realizar operaciones como la insercion.
 * @author gerald
 */
public class arbolSplay <G>{
    private nodoParaArbolSplay _raiz;
    private nodoParaArbolSplay _padre;
    private nodoParaArbolSplay _Hder;
    private nodoParaArbolSplay _Hizq;
    private int _indice;
    private G _valor;
    /**
     * Constructor de la clase
    */
    public arbolSplay(){
        this._raiz=null;
    }
    /**
     * Metodo el cual realiza la insercion de cada elemento en el arbol
     * @param pindice
     * @param pvalor 
     */
    public void insert(int pindice,String pvalor){
        nodoParaArbolSplay n= new nodoParaArbolSplay(pindice);
        n.setValor(pvalor);
        if(getRaiz()==null){
            _raiz=n;
        }
        else{
            nodoParaArbolSplay tmp=getRaiz();
            nodoParaArbolSplay tmp2=tmp;
            while(tmp!=null){
                n.setPadre(tmp2);
                if (n.getIndice()>=tmp.getIndice()){
                    if (tmp.getHder()==null){
                        tmp2=tmp;
                        tmp=tmp.getHder();
                        n.setProfundidad(n.getProfundidad()+1);
                    }else{
                        tmp=tmp.getHder();
                        tmp2=tmp;
                        n.setProfundidad(n.getProfundidad()+1);
                    } 
                }
                else{
                    if (tmp.getHizq()==null){
                        tmp2=tmp;
                        tmp=tmp.getHizq();
                        n.setProfundidad(n.getProfundidad()+1);
                    }
                    else{
                        tmp=tmp.getHizq();
                        tmp2=tmp;
                        n.setProfundidad(n.getProfundidad()+1);
                    }
                }
            }
            
            if(n.getPadre().getIndice()>n.getIndice()){
                n.getPadre().setHizq(n);
                Splay(n.getPadre().getHizq());
            }
            else{
                n.getPadre().setHder(n);
                Splay(n.getPadre().getHder());
            }
        }
    }
    /**
     * Metodo que ejecuta los diferentes cambios en los elementos, interactua con los
     * metodos Zig y Zag, para así obtener el nuevo elemento ubicado en la posicion 
     * que le corresponde
     * @param pH, corresponde al nodo el cual se requiere reacomodar
     * @return 
     */
    public nodoParaArbolSplay Splay(nodoParaArbolSplay pH){
        if (pH==null){
        }
        else{
            while(pH.getProfundidad()!=0){
                if (pH.getIndice()>pH.getPadre().getIndice()){
                    pH.setProfundidad(pH.getProfundidad()-1);
                    
                    return Splay(zig(pH));
                }else{
                    pH.setProfundidad(pH.getProfundidad()-1);
                    
                    return Splay(zig(pH));
                }
            }
        }
        return pH;
    }
    /**
     * Realiza el intercambio entre nodos hijo y padre. Este movimiento se da hacia la izquierda
     * @param pH, corresponde al nodo el cual se requiere reacomodar
     * @return 
     */
    public nodoParaArbolSplay zig(nodoParaArbolSplay pH){
        nodoParaArbolSplay tmp=null;
        nodoParaArbolSplay tmp2=null;
        tmp=pH;
        tmp2=pH.getPadre();
        tmp2.setHder(pH.getHizq());
        tmp.setHizq(tmp2);
        return tmp;
    }
    /**
     * Realiza el intercambio entre nodos hijo y padre. Este movimiento se da hacia la derecha
     * @param pH, corresponde al nodo el cual se requiere reacomodar
     * @return 
     */
    public nodoParaArbolSplay zag(nodoParaArbolSplay pH){
        nodoParaArbolSplay tmp=null;
        nodoParaArbolSplay tmp2=null;
        tmp=pH;
        tmp2=pH.getPadre();
        tmp2.setHizq(pH.getHder());
        tmp.setHder(tmp2);
        return tmp;
    }
    /**
     * Metodo que solo realiza la lectura del datos que se encuentre adentro de un nodo
     * @param pH, corresponde al nodo el cual se requiere investigar
     */
    public void print(nodoParaArbolSplay pH){
        System.out.println(pH.getValor());
    }
    /**
     * Metodo para recorrer el arbol, primero hacia la izquierda y luego hacia la derecha.
     * @param proot, raiz del arbol 
     */
    public void recorrerlo(nodoParaArbolSplay proot){
        if (proot!=null){
            recorrerlo(proot.getHizq());
            recorrerlo(proot.getHder());
        }
    }
    /**
     * Metodo para obtener la raiz del arbol
     * @return La raiz del Arbol
     */
    public nodoParaArbolSplay getRaiz() {
        return _raiz;
    }
}
