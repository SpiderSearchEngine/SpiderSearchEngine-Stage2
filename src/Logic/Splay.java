package Logic;

public class Splay {

    public nodoSplay _raiz;

    /**
     * Constructor de la clase
     */
    public Splay() {
        _raiz = null;
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
    public void Insertar(String ppalabra, Integer pindice) {
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
                ZigOrZag(pnuevoNodo);
            } else {
                ZigAndZagORZagAndZig(pnuevoNodo);
            }
        }
    }

    /**
     * Metodo para hacer los cambio e intercambios entre los nodos del arbol
     *
     * @param pnuevoNodo, nodo recien creado nodoPadre agregado al arbol binario
     * de busqueda
     */
    public void ZigOrZag(nodoSplay pnuevoNodo) {
        nodoSplay nodoPadre = pnuevoNodo.getPadre();
        boolean n1ComoHijoIzq = (pnuevoNodo == nodoPadre.getHijoIzquierdo());
        nodoSplay Abuelo;
        nodoSplay respaldo1;
        nodoSplay respaldo2;
        nodoSplay respaldo3;
        nodoSplay respaldo4;
        nodoSplay W_respaldo;
        Abuelo = nodoPadre.getPadre();
        if (n1ComoHijoIzq) {
            W_respaldo = pnuevoNodo.getHijoIzquierdo();
            respaldo3 = pnuevoNodo.getHijoDerecho();
            respaldo4 = nodoPadre.getHijoDerecho();
            pnuevoNodo.setHijoIzquierdo(W_respaldo);
            if (W_respaldo != null) {
                W_respaldo.setPadre(pnuevoNodo);
            }
            pnuevoNodo.setHijoDerecho(nodoPadre);
            nodoPadre.setPadre(pnuevoNodo);
            nodoPadre.setHijoIzquierdo(respaldo3);
            if (respaldo3 != null) {
                respaldo3.setPadre(nodoPadre);
            }
            nodoPadre.setHijoDerecho(respaldo4);
            if (respaldo4 != null) {
                respaldo4.setPadre(nodoPadre);
            }
        } else {
            respaldo1 = nodoPadre.getHijoIzquierdo();
            respaldo2 = pnuevoNodo.getHijoIzquierdo();
            W_respaldo = pnuevoNodo.getHijoDerecho();
            pnuevoNodo.setHijoIzquierdo(nodoPadre);
            nodoPadre.setPadre(pnuevoNodo);
            pnuevoNodo.setHijoDerecho(W_respaldo);
            if (W_respaldo != null) {
                W_respaldo.setPadre(pnuevoNodo);
            }
            nodoPadre.setHijoIzquierdo(respaldo1);
            if (respaldo1 != null) {
                respaldo1.setPadre(nodoPadre);
            }
            nodoPadre.setHijoDerecho(respaldo2);
            if (respaldo2 != null) {
                respaldo2.setPadre(nodoPadre);
            }
        }
        _raiz = pnuevoNodo;
        pnuevoNodo.setPadre(null);
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
     *
     * @param n1
     */
    public void zigZigAndZagZag(nodoSplay n1) {
        nodoSplay y;
        nodoSplay z;
        nodoSplay zParent;
        nodoSplay R1;
        nodoSplay R2;
        nodoSplay R3;
        nodoSplay R4;
        y = n1.getPadre();
        z = y.getPadre();
        zParent = z.getPadre();
        boolean padreComohijoIzquierdo = (y == z.getHijoIzquierdo());
        boolean n1ComoHijoDerecho = (n1 == y.getHijoIzquierdo());
        if (n1ComoHijoDerecho && padreComohijoIzquierdo) {
            R1 = n1.getHijoIzquierdo();
            R2 = n1.getHijoDerecho();
            R3 = y.getHijoDerecho();
            R4 = z.getHijoDerecho();
            n1.setHijoIzquierdo(R1);
            if (R1 != null) {
                R1.setPadre(n1);
            }
            n1.setHijoDerecho(y);
            y.setPadre(n1);

            y.setHijoIzquierdo(R2);
            if (R2 != null) {
                R2.setPadre(y);
            }
            y.setHijoDerecho(z);  ///////////////////
            z.setPadre(y);
            z.setHijoIzquierdo(R3);
            if (R3 != null) {
                R3.setPadre(z);
            }
            z.setHijoDerecho(R4);
            if (R4 != null) {
                R4.setPadre(z);
            }
        } else if (!n1ComoHijoDerecho && padreComohijoIzquierdo) {
            R1 = y.getHijoIzquierdo();
            R2 = n1.getHijoIzquierdo();
            R3 = n1.getHijoDerecho();
            R4 = z.getHijoDerecho();
            n1.setHijoIzquierdo(y);
            y.setPadre(n1);
            n1.setHijoDerecho(z);
            z.setPadre(n1);
            y.setHijoIzquierdo(R1);
            if (R1 != null) {
                R1.setPadre(y);
            }
            y.setHijoDerecho(R2);
            if (R2 != null) {
                R2.setPadre(y);
            }
            z.setHijoIzquierdo(R3);
            if (R3 != null) {
                R3.setPadre(z);
            }
            z.setHijoDerecho(R4);
            if (R4 != null) {
                R4.setPadre(z);
            }
        } else if (n1ComoHijoDerecho && padreComohijoIzquierdo) {
            R1 = z.getHijoIzquierdo();
            R2 = n1.getHijoIzquierdo();
            R3 = n1.getHijoDerecho();
            R4 = y.getHijoDerecho();
            n1.setHijoIzquierdo(z);
            z.setPadre(n1);
            n1.setHijoDerecho(y);
            y.setPadre(n1);
            y.setHijoIzquierdo(R3);
            if (R3 != null) {
                R3.setPadre(y);
            }
            y.setHijoDerecho(R4);
            if (R4 != null) {
                R4.setPadre(y);
            }
            z.setHijoIzquierdo(R1);
            if (R1 != null) {
                R1.setPadre(z);
            }
            z.setHijoDerecho(R2);
            if (R2 != null) {
                R2.setPadre(z);
            }
        } else {
            R1 = z.getHijoIzquierdo();
            R2 = y.getHijoIzquierdo();
            R3 = n1.getHijoIzquierdo();
            R4 = n1.getHijoDerecho();
            n1.setHijoIzquierdo(y);
            y.setPadre(n1);
            n1.setHijoDerecho(R4);
            if (R4 != null) {
                R4.setPadre(n1);
            }
            y.setHijoIzquierdo(z);
            z.setPadre(y);
            y.setHijoDerecho(R3);
            if (R3 != null) {
                R3.setPadre(y);
            }
            z.setHijoIzquierdo(R1);
            if (R1 != null) {
                R1.setPadre(z);
            }
            z.setHijoDerecho(R2);
            if (R2 != null) {
                R2.setPadre(z);
            }
        }
        if (_raiz == z) {
            _raiz = n1;
            n1.setPadre(null);
        } else {
            if (zParent.getHijoIzquierdo() == z) {
                n1.setPadre(zParent);
                zParent.setHijoIzquierdo(n1);
            } else {
                n1.setPadre(zParent);
                zParent.setHijoDerecho(n1);
            }
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
}
