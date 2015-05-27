package Logic;

public class Splay1 {

    public nodoSplay _raiz;

    /**
     * Constructor de la clase
     */
    public Splay1() {
        _raiz = null;
    }
    
    public nodoSplay getRaiz(){
        return _raiz;
    }
    /**
     * Metodo que funciona para para agregar nuevos nodos al arbol
     *
     * @param ppalabra , la palabra a insertar en un nodo adentro del arbol
     * @param pindice , un indice, o el numero de relacionado a la cantidad de
     * veses que aparecio una palabra./** Metodo que funciona para para agregar
     * nuevos nodos al arbol
     * @param ppalabra , la palabra a insertar en un nodo adentro del arbol
     * @param pindice , un indice, o el numero de relacionado a la cantidad de
     * veses que aparecio una palabra.
     */
    /*public void Insertar(String ppalabra, Integer pindice) {
        nodoSplay tmpPadre;
        if (_raiz == null) {
            _raiz = new nodoSplay(ppalabra, pindice);
            return;
        }
        tmpPadre = encontrarNodo(ppalabra);
        if (ppalabra.equals(tmpPadre.getPalabra())) {
            tmpPadre.setValor(pindice);
            return;
        }
        nodoSplay nuevoNodo = new nodoSplay(ppalabra, pindice);
        nuevoNodo.setPadre(tmpPadre);
        if (ppalabra.compareTo(tmpPadre.getPalabra()) < 0) {
            tmpPadre.setHijoIzquierdo(nuevoNodo);
            Splay(nuevoNodo);
        } else {
            tmpPadre.setHijoDerecho(nuevoNodo);
            Splay(nuevoNodo);
        }
    }*/
    public void Insertar (String ppalabra, Integer pindice){
        if(_raiz==null){
            _raiz=new nodoSplay(ppalabra, pindice);
        }
        else
            insertAux(new nodoSplay (ppalabra, pindice), _raiz);
    }
    /**
     * Metodo auxiliar para insertar
     * @param pNode
     * @param padre 
     */
    private void insertAux(nodoSplay pNode, nodoSplay padre){
        if(Integer.valueOf(pNode.getPalabra()).intValue()>Integer.valueOf(padre.getPalabra()).intValue()){
                if(padre.getHijoDerecho()==null){
                padre.setHijoDerecho(pNode);
                pNode.setPadre(padre);
                EveryComplements(pNode);
            }
            else
                insertAux(pNode,padre.getHijoDerecho());
        }
        else{
            if(padre.getHijoIzquierdo()==null){
                padre.setHijoIzquierdo(pNode);
                pNode.setPadre(padre);
                EveryComplements(pNode);
            }
            else
                insertAux(pNode, padre.getHijoIzquierdo());
        }
    }
    

    /**
     * Metodo para buscar un elemento en el arbol, para asi determinar como
     * realizar la insercion.
     *
     * @param pPalabra, palabra a insertar
     * @return
     */
    public nodoSplay encontrarNodo(String pPalabra) {
        nodoSplay nodoTemporal;
        nodoSplay nodoPrevio;
        nodoTemporal = _raiz;
        nodoPrevio = _raiz;
        while (nodoTemporal != null) {
            if (pPalabra.compareTo(nodoTemporal.getPalabra()) < 0) {
                nodoPrevio = nodoTemporal;
                nodoTemporal = nodoTemporal.getHijoIzquierdo();
            } else if (pPalabra.compareTo(nodoTemporal.getPalabra()) > 0) {
                nodoPrevio = nodoTemporal;
                nodoTemporal = nodoTemporal.getHijoDerecho();
            } else {
                return nodoTemporal;
            }
        }
        return nodoPrevio;
    }

    /**
     * Este metodo funciona para que el programa decida que swaps realizar.
     *
     * @param pnuevoNodo, nodo recien creado nodoPadre agregado al arbol binario
     * de busqueda
     */
    public void Splay(nodoSplay pnuevoNodo) {
        while (pnuevoNodo != _raiz) {
            if (pnuevoNodo.getPadre() == _raiz) {
                ZigORZag(pnuevoNodo);
            }
            else 
                EveryComplements(pnuevoNodo);
        }
    }

    /**
     * Metodo para hacer los cambio e intercambios entre los nodos del arbol
     *
     * @param pnuevoNodo, nodo recien creado nodoPadre agregado al arbol binario
     * de busqueda
     */
    public void ZigORZag(nodoSplay pnuevoNodo){
        if (pnuevoNodo == pnuevoNodo.getPadre().getHijoIzquierdo()){
            Zig(pnuevoNodo);
            _raiz=pnuevoNodo;
            pnuevoNodo.setPadre(null);
        }else{
            Zag(pnuevoNodo);
            _raiz=pnuevoNodo;
            pnuevoNodo.setPadre(null);
        }
    }
    public void EveryComplements(nodoSplay pnuevoNodo){
        System.out.println("_______");postOrden(_raiz);System.out.println("_______");
        nodoSplay padre=pnuevoNodo.getPadre();
        nodoSplay abuelo=padre.getPadre();
        
        if (abuelo!=null && padre==abuelo.getHijoIzquierdo() && pnuevoNodo==padre.getHijoIzquierdo()){
            
                ZigAndZig(pnuevoNodo);
                mostrar();
        }
        else if (padre==_raiz && pnuevoNodo==padre.getHijoIzquierdo())
            Zig(pnuevoNodo);
        else if (padre==_raiz && pnuevoNodo==padre.getHijoDerecho())
            Zag(pnuevoNodo);
        else if (abuelo!=null && padre==abuelo.getHijoDerecho() && pnuevoNodo==padre.getHijoDerecho()){
                System.out.println(" 2 ");
                ZagAndZag(pnuevoNodo);
        }
        else if (abuelo!=null && padre==abuelo.getHijoIzquierdo() && pnuevoNodo==padre.getHijoDerecho()){
               ZigAndZag(pnuevoNodo);
                System.out.println(" 3 ");
            }
            else if (abuelo!=null && padre==abuelo.getHijoDerecho() && pnuevoNodo==padre.getHijoIzquierdo()){
               ZagAndZig(pnuevoNodo);
                System.out.println(" 4 ");
            }
            else
                return;
        
            
    }
    
    public nodoSplay ZigAndZig(nodoSplay pnuevoNodo){
        nodoSplay nodoPadre=pnuevoNodo.getPadre(); 
        nodoSplay nodoAbuelo=nodoPadre.getPadre();
        nodoSplay nodoHijoDerDeNuevoNodo=pnuevoNodo.getHijoDerecho();
        nodoSplay nodoHijoDerDePadre=nodoPadre.getHijoDerecho();
        
        if (nodoHijoDerDeNuevoNodo==null)
            nodoPadre.setHijoIzquierdo(null);
        else{
            nodoPadre.setHijoIzquierdo(nodoHijoDerDeNuevoNodo);
            nodoHijoDerDeNuevoNodo.setPadre(nodoPadre);
        }
        nodoPadre.setHijoDerecho(nodoAbuelo);
        if (nodoHijoDerDePadre==null)
            nodoAbuelo.setHijoIzquierdo(null);
        else{
            nodoAbuelo.setHijoIzquierdo(nodoHijoDerDePadre);
            nodoHijoDerDePadre.setPadre(nodoAbuelo);
        }
        pnuevoNodo.setHijoDerecho(nodoPadre);
        nodoPadre.setPadre(pnuevoNodo);
        
        if (_raiz==nodoAbuelo){
            _raiz=pnuevoNodo;
            pnuevoNodo.setPadre(null);
            nodoAbuelo.setPadre(nodoPadre);
        }
        else{
            pnuevoNodo.setPadre(nodoAbuelo.getPadre());
            nodoAbuelo.getPadre().setHijoIzquierdo(pnuevoNodo);
            nodoAbuelo.setPadre(nodoPadre);
            EveryComplements(pnuevoNodo);
        }
        
        return pnuevoNodo;
    }
    public nodoSplay ZagAndZag(nodoSplay pnuevoNodo){
        nodoSplay nodoPadre=pnuevoNodo.getPadre();
        nodoSplay nodoAbuelo=pnuevoNodo.getPadre().getPadre();
        nodoSplay nodobiscaAbuelo=nodoAbuelo.getPadre();
        nodoSplay nodoHijoIzqDeNuevoNodo=pnuevoNodo.getHijoIzquierdo();
        nodoSplay nodoHijoDerDeNuevoNodo=pnuevoNodo.getHijoDerecho();
        nodoSplay nodoHijoIzqDePadre=nodoPadre.getHijoIzquierdo();
        nodoSplay nodoHijoIzqDeAbuelo=nodoAbuelo.getHijoIzquierdo();
        pnuevoNodo.setHijoDerecho(nodoHijoDerDeNuevoNodo);
        if (nodoHijoDerDeNuevoNodo!=null)
            nodoHijoDerDeNuevoNodo.setPadre(pnuevoNodo);
        nodoPadre.setHijoDerecho(nodoHijoIzqDeNuevoNodo);
        if (nodoHijoIzqDeNuevoNodo!=null)
            nodoHijoIzqDeNuevoNodo.setPadre(nodoPadre);
        nodoAbuelo.setHijoDerecho(nodoHijoIzqDePadre);
        if (nodoHijoIzqDePadre!=null)
            nodoHijoIzqDePadre.setPadre(nodoAbuelo);
        nodoAbuelo.setHijoIzquierdo(nodoHijoIzqDeAbuelo);
        if (nodoHijoIzqDeAbuelo!=null)
            nodoHijoIzqDeAbuelo.setPadre(nodoAbuelo);
        nodoPadre.setHijoIzquierdo(nodoAbuelo);
        nodoAbuelo.setPadre(nodoPadre);
        pnuevoNodo.setHijoIzquierdo(nodoPadre);
        nodoPadre.setPadre(pnuevoNodo);
        //pnuevoNodo.setPadre(nodobiscaAbuelo);
        return pnuevoNodo;
    }
    public nodoSplay ZigAndZag(nodoSplay pnuevoNodo){
        nodoSplay nodoPadre=pnuevoNodo.getPadre();
        nodoSplay nodoAbuelo=pnuevoNodo.getPadre().getPadre();
        nodoSplay nodobiscaAbuelo=nodoAbuelo.getPadre();
        nodoSplay nodoHijoIzqDeNuevoNodo=pnuevoNodo.getHijoIzquierdo();
        nodoSplay nodoHijoDerDeNuevoNodo=pnuevoNodo.getHijoDerecho();
        nodoSplay nodoHijoIzqDePadre=nodoPadre.getHijoIzquierdo();
        nodoSplay nodoHijoDerDeAbuelo=nodoAbuelo.getHijoDerecho();
        pnuevoNodo.setHijoIzquierdo(nodoPadre);
        nodoPadre.setPadre(pnuevoNodo);
        pnuevoNodo.setHijoDerecho(nodoAbuelo);
        nodoAbuelo.setPadre(pnuevoNodo);
        nodoPadre.setHijoDerecho(nodoHijoIzqDeNuevoNodo);
        if (nodoHijoIzqDeNuevoNodo!=null)
            nodoHijoIzqDeNuevoNodo.setPadre(nodoPadre);
        nodoPadre.setHijoIzquierdo(nodoHijoIzqDePadre);
        if (nodoHijoIzqDePadre!=null)
            nodoHijoIzqDePadre.setPadre(nodoPadre);
        nodoAbuelo.setHijoDerecho(nodoHijoDerDeAbuelo);
        if (nodoHijoDerDeAbuelo!=null)
            nodoHijoDerDeAbuelo.setPadre(nodoAbuelo);
        nodoAbuelo.setHijoIzquierdo(nodoHijoDerDeNuevoNodo);
        if (nodoHijoDerDeNuevoNodo!=null)
            nodoHijoDerDeNuevoNodo.setPadre(nodoAbuelo);
        //pnuevoNodo.setPadre(nodobiscaAbuelo);
        return pnuevoNodo;
    }
    //
    public nodoSplay ZagAndZig(nodoSplay pnuevoNodo){
        nodoSplay nodoPadre=pnuevoNodo.getPadre();
        nodoSplay nodoAbuelo=pnuevoNodo.getPadre().getPadre();
        nodoSplay nodobiscaAbuelo=nodoAbuelo.getPadre();
        nodoSplay nodoHijoIzqDeNuevoNodo=pnuevoNodo.getHijoIzquierdo();
        nodoSplay nodoHijoDerDeNuevoNodo=pnuevoNodo.getHijoDerecho();
        nodoSplay nodoHijoDerDePadre=nodoPadre.getHijoDerecho();
        nodoSplay nodoHijoIzqDeAbuelo=nodoAbuelo.getHijoIzquierdo();
        pnuevoNodo.setHijoDerecho(nodoPadre);
        nodoPadre.setPadre(pnuevoNodo);
        pnuevoNodo.setHijoIzquierdo(nodoAbuelo);
        nodoAbuelo.setPadre(pnuevoNodo);
        nodoPadre.setHijoDerecho(nodoHijoDerDePadre);
        if (nodoHijoDerDePadre!=null)
            nodoHijoDerDePadre.setPadre(nodoPadre);
        nodoPadre.setHijoIzquierdo(nodoHijoDerDeNuevoNodo);
        if (nodoHijoDerDeNuevoNodo!=null)
            nodoHijoDerDeNuevoNodo.setPadre(nodoPadre);
        nodoAbuelo.setHijoIzquierdo(nodoHijoIzqDeAbuelo);
        if (nodoHijoIzqDeAbuelo!=null)
            nodoHijoIzqDeAbuelo.setPadre(nodoAbuelo);
        nodoAbuelo.setHijoDerecho(nodoHijoIzqDeNuevoNodo);
        if (nodoHijoIzqDeNuevoNodo!=null)
            nodoHijoIzqDeNuevoNodo.setPadre(nodoAbuelo);
        //pnuevoNodo.setPadre(nodobiscaAbuelo);
        return pnuevoNodo;
    }
    
    
    public void Zig(nodoSplay pnuevoNodo){
        nodoSplay nodoPadre = pnuevoNodo.getPadre();
        nodoSplay nodoHijoDerDeNuevoNodo=pnuevoNodo.getHijoDerecho();
        
        if(nodoHijoDerDeNuevoNodo==null)
            nodoPadre.setHijoIzquierdo(null);
        else{
            nodoPadre.setHijoIzquierdo(nodoHijoDerDeNuevoNodo);
            nodoHijoDerDeNuevoNodo.setPadre(nodoPadre);
        }
        pnuevoNodo.setHijoDerecho(nodoPadre);
        pnuevoNodo.setPadre(null);
        _raiz=pnuevoNodo;
    }
    public void Zag(nodoSplay pnuevoNodo){
        nodoSplay nodoPadre = pnuevoNodo.getPadre();
        nodoSplay nodoHijoIzqDeNuevoNodo=pnuevoNodo.getHijoIzquierdo();
        
        if(nodoHijoIzqDeNuevoNodo==null)
            nodoPadre.setHijoDerecho(null);
        else{
            nodoPadre.setHijoDerecho(nodoHijoIzqDeNuevoNodo);
            nodoHijoIzqDeNuevoNodo.setPadre(nodoPadre);
        }
        pnuevoNodo.setHijoIzquierdo(nodoPadre);
        pnuevoNodo.setPadre(null);
        _raiz=pnuevoNodo;
    }
        
        
    /**
     * Metodo para hacer los cambio e intercambios entre los nodos del arbol
     *
     * @param pnuevoNodo, nodo recien creado nodoPadre agregado al arbol binario
     * de busqueda
     */
    public void ZigAndZagORZagAndZig(nodoSplay nuevoNodo) {
        nodoSplay nodoPadre = nuevoNodo.getPadre();
        nodoSplay nodoAbuelo = nuevoNodo.getPadre().getPadre();
        boolean nuevoNodoEsHijoIzquierdo = (nuevoNodo == nodoPadre.getHijoIzquierdo());
        boolean padreEsHijoIzquierdo = (nodoPadre == nodoAbuelo.getHijoIzquierdo());
        nodoSplay respaldo1;
        nodoSplay respaldo2;
        nodoSplay respaldo3;
        nodoSplay respaldo4;
        nodoSplay W_Respaldo;
        if (padreEsHijoIzquierdo) {
            if (nuevoNodoEsHijoIzquierdo) {
                W_Respaldo = nuevoNodo.getHijoIzquierdo();
                respaldo3 = nuevoNodo.getHijoDerecho();
                respaldo4 = nodoPadre.getHijoDerecho();
                nuevoNodo.setHijoIzquierdo(W_Respaldo);
                if (W_Respaldo != null) {
                    W_Respaldo.setPadre(nuevoNodo);
                }
                nuevoNodo.setHijoDerecho(nodoPadre);
                nodoPadre.setPadre(nuevoNodo);
                nodoPadre.setHijoIzquierdo(respaldo3);
                if (respaldo3 != null) {
                    respaldo3.setPadre(nodoPadre);
                }
                nodoPadre.setHijoDerecho(respaldo4);
                if (respaldo4 != null) {
                    respaldo4.setPadre(nodoPadre);
                }
                nodoAbuelo.setHijoIzquierdo(nuevoNodo);
                nuevoNodo.setPadre(nodoAbuelo);
            } else {
                respaldo1 = nodoPadre.getHijoIzquierdo();
                respaldo2 = nuevoNodo.getHijoIzquierdo();
                W_Respaldo = nuevoNodo.getHijoDerecho();
                nuevoNodo.setHijoIzquierdo(nodoPadre);
                nodoPadre.setPadre(nuevoNodo);
                nuevoNodo.setHijoDerecho(W_Respaldo);
                if (W_Respaldo != null) {
                    W_Respaldo.setPadre(nuevoNodo);
                }
                nodoPadre.setHijoIzquierdo(respaldo1);
                if (respaldo1 != null) {
                    respaldo1.setPadre(nodoPadre);
                }
                nodoPadre.setHijoDerecho(respaldo2);
                if (respaldo2 != null) {
                    respaldo2.setPadre(nodoPadre);
                }
                nodoAbuelo.setHijoIzquierdo(nuevoNodo);
                nuevoNodo.setPadre(nodoAbuelo);
            }

        } else {
            if (nuevoNodoEsHijoIzquierdo) {
                System.out.println("Si entro 2");
                W_Respaldo = nuevoNodo.getHijoIzquierdo();
                respaldo3 = nuevoNodo.getHijoDerecho();
                respaldo4 = nodoPadre.getHijoDerecho();
                nuevoNodo.setHijoIzquierdo(W_Respaldo);
                if (W_Respaldo != null) {
                    W_Respaldo.setPadre(nuevoNodo);
                }
                nuevoNodo.setHijoDerecho(nodoPadre);
                nodoPadre.setPadre(nuevoNodo);
                nodoPadre.setHijoIzquierdo(respaldo3);
                if (respaldo3 != null) {
                    respaldo3.setPadre(nodoPadre);
                }
                nodoPadre.setHijoDerecho(respaldo4);
                if (respaldo4 != null) {
                    respaldo4.setPadre(nodoPadre);
                }
                nodoAbuelo.setHijoDerecho(nuevoNodo);
                nuevoNodo.setPadre(nodoAbuelo);
            } else {
                System.out.println("Anduvo Aqui2");
                respaldo1 = nodoPadre.getHijoIzquierdo();
                respaldo2 = nuevoNodo.getHijoIzquierdo();
                W_Respaldo = nuevoNodo.getHijoDerecho();
                nuevoNodo.setHijoIzquierdo(nodoPadre);
                nodoPadre.setPadre(nuevoNodo);
                nuevoNodo.setHijoDerecho(W_Respaldo);
                if (W_Respaldo != null) {
                    W_Respaldo.setPadre(nuevoNodo);
                }
                nodoPadre.setHijoIzquierdo(respaldo1);
                if (respaldo1 != null) {
                    respaldo1.setPadre(nodoPadre);
                }
                nodoPadre.setHijoDerecho(respaldo2);
                if (respaldo2 != null) {
                    respaldo2.setPadre(nodoPadre);
                }
                nodoAbuelo.setHijoDerecho(nuevoNodo);
                nuevoNodo.setPadre(nodoAbuelo);
            }
        }
    }
    
      /**
     * Metodo para eliminar elementos o elementos del arbol.
     * @param ppalabra 
     */
  public void remove(String ppalabra)
   {
       nodoSplay p;        
       nodoSplay nodoPadre;   
       nodoSplay nodoSiguiente;   
       p = encontrarNodo(ppalabra);
       if (!ppalabra.equals(p.getPalabra()))
          return;		
       if ( p.getHijoIzquierdo() == null && p.getHijoDerecho() == null ){
	  nodoPadre = p.getPadre();
	  if ( nodoPadre.getHijoIzquierdo() == p )
	     nodoPadre.setHijoIzquierdo(null);
	  else
	     nodoPadre.setHijoDerecho(null);
          return;
       }
       if ( p.getHijoIzquierdo() == null ){
          nodoPadre = p.getPadre();
          if ( nodoPadre.getHijoIzquierdo() == p )
             nodoPadre.setHijoIzquierdo(p.getHijoDerecho());
          else
             nodoPadre.setHijoDerecho(p.getHijoDerecho());
          return;
       }
       if ( p.getHijoDerecho()== null ){
          nodoPadre = p.getPadre();

          if ( nodoPadre.getHijoIzquierdo() == p )
             nodoPadre.setHijoIzquierdo(p.getHijoIzquierdo());
          else
             nodoPadre.setHijoDerecho(p.getHijoDerecho());
          return;
       }
       nodoSiguiente = p.getHijoDerecho();	
       while ( nodoSiguiente.getHijoIzquierdo() != null )
	   nodoSiguiente = nodoSiguiente.getHijoIzquierdo();
       p.setPalabra(nodoSiguiente.getPalabra());	
       p.setValor(nodoSiguiente.getValor());
       nodoPadre = nodoSiguiente.getPadre();	
       nodoPadre.setHijoIzquierdo(nodoSiguiente.getHijoDerecho());
       return;
   }

  /**
     * Metodo que realiza recorrido en postOrden
     * @param pNode 
     */
    public void postOrden(nodoSplay pNode){
        if(pNode.getHijoIzquierdo()== null && pNode.getHijoDerecho()==null)
            System.out.println(pNode.getPalabra());
        else if(pNode.getHijoDerecho()==null){
            postOrden(pNode.getHijoIzquierdo());
            System.out.println(pNode.getPalabra());
        }
        else if(pNode.getHijoIzquierdo()==null){
            postOrden(pNode.getHijoDerecho());
            System.out.println(pNode.getPalabra());
        }
        else{
            postOrden(pNode.getHijoIzquierdo());
            postOrden(pNode.getHijoDerecho());
            System.out.println(pNode.getPalabra());
        }            
    }
   

    public void mostrar() {
        System.out.println(_raiz.getPadre());
        System.out.println("Raiz : " + _raiz.getPalabra());
        System.out.println("");
        if (_raiz.getHijoIzquierdo() != null) {
            System.out.println("Padre Zurdo : " + _raiz.getHijoIzquierdo().getPalabra());
            if (_raiz.getHijoIzquierdo().getHijoIzquierdo() != null) {
                System.out.println("Nieto Zurdo : " + _raiz.getHijoIzquierdo().getHijoIzquierdo().getPalabra());
            } else {
                System.out.println("Nieto zurdo no tiene");
            }
            if (_raiz.getHijoIzquierdo().getHijoDerecho() != null) {
                System.out.println("Nieto Derecho : " + _raiz.getHijoIzquierdo().getHijoDerecho().getPalabra());
            } else {
                System.out.println("Nieto Derecho no tiene");
            }
        } else {
            System.out.println("Padre zurdo no tiene");
        }

        if (_raiz.getHijoDerecho() != null) {
            System.out.println("Padre Diestro : " + _raiz.getHijoDerecho().getPalabra());
            if (_raiz.getHijoDerecho().getHijoDerecho() != null) {
                System.out.println("Nieto Diestro : " + _raiz.getHijoDerecho().getHijoDerecho().getPalabra());
            } else {
                System.out.println("Nieto Diestro no tiene");
            }
            if (_raiz.getHijoDerecho().getHijoIzquierdo() != null) {
                System.out.println("Nieto Zurdo : " + _raiz.getHijoDerecho().getHijoIzquierdo().getPalabra());
            } else {
                System.out.println("Nieto Zurdo no tiene");
            }
        } else {
            System.out.println("Padre Diestro no tiene");
        }

        System.out.println("");
        System.out.println("");
        System.out.println("");
    }
    public void vista(){
        postOrden(_raiz);
    }
  
}
