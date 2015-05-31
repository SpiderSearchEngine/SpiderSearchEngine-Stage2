
package Logic;

/**
 * Clase del arbol Splay
 * @author Gerald M, Jairo O
 */
public class Splay{
   public nodoSplay _raiz;
   /**
    * Constructor de la clase
    */
   public Splay(){
      _raiz = null;
   }/**
    * Metodo que funciona para para agregar nuevos nodos al arbol
    * @param key, la palabra a insertar en un nodo adentro del arbol
    * @param ind, un indice, o el numero de relacionado a la cantidad de veses que aparecio una palabra./**
    * Metodo que funciona para para agregar nuevos nodos al arbol
    * @param key, la palabra a insertar en un nodo adentro del arbol
    * @param ind, un indice, o el numero de relacionado a la cantidad de veses que aparecio una palabra.
    */
   public void Insertar(String key, Integer ind){
       nodoSplay n;
       if ( _raiz == null ){ 
          _raiz = new nodoSplay( key, ind );
	  return;
       }
       n = encontrarNodo(key);
       if ( key.equals(n.getPalabra())){
          n.setValor(ind);			
	  return;
       }
       nodoSplay n1 = new nodoSplay( key, ind );
       n1.setPadre(n);
       if ( key.compareTo(n.getPalabra()) < 0 ){
	  n.setHijoIzquierdo(n1);  
          splay(n1);
       }
       else {
	  n.setHijoDerecho(n1);  
          splay(n1);
       }      
   }
   /**
    * Metodo para buscar un elemento en el arbol, para asi determinar como realizar 
    * la insercion.
    * @param key, palabra a insertar
    * @return 
    */
   public nodoSplay encontrarNodo(String key){
       nodoSplay tmp_node;
       nodoSplay prev_node;  
       tmp_node = _raiz;  
       prev_node = _raiz;
       while ( tmp_node != null ){
          if ( key.compareTo(tmp_node.getPalabra()) < 0 ){
	     prev_node = tmp_node;   
	     tmp_node = tmp_node.getHijoIzquierdo(); 
	  }
          else if ( key.compareTo(tmp_node.getPalabra()) > 0 ){
	     prev_node = tmp_node; 
	     tmp_node = tmp_node.getHijoDerecho(); 
	  }
          else{
	     return tmp_node;
	  }
       }
       return prev_node;
   }
   
   /**
    * Este metodo funciona para que el programa decida que swaps realizar.
    * @param n1, nodo recien creado y agregado al arbol binario de busqueda
    */
   public void splay(nodoSplay n1){
      while ( n1 != _raiz )
      {
         if ( n1.getPadre() == _raiz ){
            zigAndZag(n1);
         }
         else{
             
             zigAndZag2(n1);
         }
      }
   }
   /**
    * Metodo para hacer los cambio e intercambios entre los nodos del arbol
    * @param n1, nodo recien creado y agregado al arbol binario de busqueda
    */
   public void zigAndZag(nodoSplay n1){
     nodoSplay y = n1.getPadre();
     boolean n1ComoHijoIzq = (n1 == y.getHijoIzquierdo());
     nodoSplay yPadre;
     nodoSplay R1;
     nodoSplay R2;
     nodoSplay R3;
     nodoSplay R4;
     nodoSplay W;
     yPadre = y.getPadre();          
     if (n1ComoHijoIzq ){
       W  = n1.getHijoIzquierdo();
       R3 = n1.getHijoDerecho();
       R4 = y.getHijoDerecho(); 
       n1.setHijoIzquierdo(W);    
       if ( W != null ) 
           W.setPadre(n1);
       n1.setHijoDerecho(y);   
       y.setPadre(n1);
       y.setHijoIzquierdo(R3);   
       if ( R3 != null ) 
           R3.setPadre(y);
       y.setHijoDerecho(R4);  
       if ( R4 != null ) 
           R4.setPadre(y);
     }
     else{ 
       R1 = y.getHijoIzquierdo();   
       R2 = n1.getHijoIzquierdo(); 
       W  = n1.getHijoDerecho();
       n1.setHijoIzquierdo(y);      
       y.setPadre(n1);
       n1.setHijoDerecho(W);     
       if ( W != null ) 
           W.setPadre(n1);
       y.setHijoIzquierdo(R1);     
       if ( R1 != null ) 
           R1.setPadre(y);
       y.setHijoDerecho(R2);    
       if ( R2 != null ) 
           R2.setPadre(y);
     }
     _raiz = n1;         
     n1.setPadre(null);
   }
   
    public void zigAndZag2(nodoSplay n1){
     nodoSplay y = n1.getPadre();
     boolean n1ComoHijoIzq = (n1 == y.getHijoIzquierdo());
     nodoSplay yPadre;
     nodoSplay R1;
     nodoSplay R2;
     nodoSplay R3;
     nodoSplay R4;
     nodoSplay W;
     yPadre = y.getPadre(); 
     nodoSplay abue=n1.getPadre().getPadre();
     if (n1ComoHijoIzq ){
         System.out.println("Si entro");
       W  = n1.getHijoIzquierdo();
       R3 = n1.getHijoDerecho();
       R4 = y.getHijoDerecho(); 
       n1.setHijoIzquierdo(W);    
       if ( W != null ) 
           W.setPadre(n1);
       n1.setHijoDerecho(y);   
       y.setPadre(n1);
       y.setHijoIzquierdo(R3);   
       if ( R3 != null ) 
           R3.setPadre(y);
       y.setHijoDerecho(R4);  
       if ( R4 != null ) 
           R4.setPadre(y);
       abue.setHijoIzquierdo(n1);
       n1.setPadre(abue);
     }
     else{ 
         System.out.println("Anduvo Aqui");
       R1 = y.getHijoIzquierdo();   
       R2 = n1.getHijoIzquierdo(); 
       W  = n1.getHijoDerecho();
       n1.setHijoIzquierdo(y);      
       y.setPadre(n1);
       n1.setHijoDerecho(W);     
       if ( W != null ) 
           W.setPadre(n1);
       y.setHijoIzquierdo(R1);     
       if ( R1 != null ) 
           R1.setPadre(y);
       y.setHijoDerecho(R2);    
       if ( R2 != null ) 
           R2.setPadre(y);
       abue.setHijoIzquierdo(n1);
       n1.setPadre(abue);
     }
     //root = n1;         
     //n1.setPadre(null);
   }
   /**
    * 
    * @param n1 
    */
   public void zigZigAndZagZag(nodoSplay n1){
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
     if (n1ComoHijoDerecho && padreComohijoIzquierdo){ 
       R1 = n1.getHijoIzquierdo();   
       R2 = n1.getHijoDerecho();  
       R3 = y.getHijoDerecho();  
       R4 = z.getHijoDerecho();  
       n1.setHijoIzquierdo(R1);  
       if ( R1 != null ) 
           R1.setPadre(n1);
       n1.setHijoDerecho(y);  
       y.setPadre(n1);
       
       y.setHijoIzquierdo(R2);  
       if ( R2 != null ) 
           R2.setPadre(y);
       y.setHijoDerecho(z);  ///////////////////
       z.setPadre(y);
       z.setHijoIzquierdo(R3);  
       if ( R3 != null ) 
           R3.setPadre(z);
       z.setHijoDerecho(R4); 
       if ( R4 != null ) 
           R4.setPadre(z);
     }
     else if (!n1ComoHijoDerecho && padreComohijoIzquierdo){ 
       R1 = y.getHijoIzquierdo();  
       R2 = n1.getHijoIzquierdo();  
       R3 = n1.getHijoDerecho();   
       R4 = z.getHijoDerecho();  
       n1.setHijoIzquierdo(y);     
       y.setPadre(n1);
       n1.setHijoDerecho(z);    
       z.setPadre(n1);
       y.setHijoIzquierdo(R1);    
       if ( R1 != null ) 
           R1.setPadre(y);
       y.setHijoDerecho(R2);   
       if ( R2 != null ) 
           R2.setPadre(y);
       z.setHijoIzquierdo(R3);    
       if ( R3 != null ) 
           R3.setPadre(z);
       z.setHijoDerecho(R4);   
       if ( R4 != null ) 
           R4.setPadre(z);
     }
     else if (n1ComoHijoDerecho && padreComohijoIzquierdo){ 
       R1 = z.getHijoIzquierdo();             
       R2 = n1.getHijoIzquierdo();            
       R3 = n1.getHijoDerecho();            
       R4 = y.getHijoDerecho();      
       n1.setHijoIzquierdo(z);      
       z.setPadre(n1);
       n1.setHijoDerecho(y);     
       y.setPadre(n1);
       y.setHijoIzquierdo(R3);    
       if ( R3 != null ) 
           R3.setPadre(y);
       y.setHijoDerecho(R4);   
       if ( R4 != null ) 
           R4.setPadre(y);
       z.setHijoIzquierdo(R1);    
       if ( R1 != null ) 
           R1.setPadre(z);
       z.setHijoDerecho(R2);   
       if ( R2 != null ) 
           R2.setPadre(z);
     }
     else{ 
       R1 = z.getHijoIzquierdo();              
       R2 = y.getHijoIzquierdo();         
       R3 = n1.getHijoIzquierdo();           
       R4 = n1.getHijoDerecho();          
       n1.setHijoIzquierdo(y);      
       y.setPadre(n1);
       n1.setHijoDerecho(R4);    
       if ( R4 != null ) 
           R4.setPadre(n1);
       y.setHijoIzquierdo(z);      
       z.setPadre(y);
       y.setHijoDerecho(R3);    
       if ( R3 != null ) 
           R3.setPadre(y);
       z.setHijoIzquierdo(R1);     
       if ( R1 != null ) 
           R1.setPadre(z);
       z.setHijoDerecho(R2);    
       if ( R2 != null ) 
           R2.setPadre(z);
     }
     if ( _raiz == z ){
        _raiz = n1;            
        n1.setPadre(null);
     }
     else{
        if ( zParent.getHijoIzquierdo() == z ){ 
          n1.setPadre(zParent);
          zParent.setHijoIzquierdo(n1);
        }
        else{ 
          n1.setPadre(zParent);
          zParent.setHijoDerecho(n1);
        }
     }
   }
   public void mostrar(){
       System.out.println(_raiz.getPadre());
       System.out.println("Raiz : "+_raiz.getPalabra());
       System.out.println("");
       if (_raiz.getHijoIzquierdo()!=null){
           System.out.println("Padre Zurdo : "+_raiz.getHijoIzquierdo().getPalabra());
           if (_raiz.getHijoIzquierdo().getHijoIzquierdo()!=null)
                System.out.println("Nieto Zurdo : "+_raiz.getHijoIzquierdo().getHijoIzquierdo().getPalabra());
                else
                    System.out.println("Nieto zurdo no tiene");
           if (_raiz.getHijoIzquierdo().getHijoDerecho()!=null)
               System.out.println("Nieto Derecho : "+_raiz.getHijoIzquierdo().getHijoDerecho().getPalabra());
               else
                    System.out.println("Nieto Derecho no tiene");
       }
       else
           System.out.println("Padre zurdo no tiene");
       
       if (_raiz.getHijoDerecho()!=null){
           System.out.println("Padre Diestro : "+_raiz.getHijoDerecho().getPalabra());
           if (_raiz.getHijoDerecho().getHijoDerecho()!=null)
                System.out.println("Nieto Diestro : "+_raiz.getHijoDerecho().getHijoDerecho().getPalabra());
           else
                System.out.println("Nieto Diestro no tiene");
           if (_raiz.getHijoDerecho().getHijoIzquierdo()!=null)
               System.out.println("Nieto Zurdo : "+_raiz.getHijoDerecho().getHijoIzquierdo().getPalabra());
           else
               System.out.println("Nieto Zurdo no tiene");
       }
       else
           System.out.println("Padre Diestro no tiene");
       
       
       
       System.out.println("");
       System.out.println("");
       System.out.println("");
   }
 
   
   
   
}