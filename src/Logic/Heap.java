package Logic;

import java.util.Scanner;

/**
 * Clase para creacion y manipulacion del Heap de mayores
 * @author Gerald M, Jairo O.
 */
public class Heap <G>{ 
        private int _TamañoDeArreglo;
        private int _Indice=0;
        private int _IndiceMaximo=1000;
        private nodeArray _arr[];
        private nodeArray _raiz;
        /**
         * Constructor de la clase
         */
        public Heap(){
        this._arr = new nodeArray[1000];
        _TamañoDeArreglo=_arr.length;
        int indices=0;
        while (indices<_TamañoDeArreglo){
            _arr[indices]=new nodeArray(-1,"");
            indices+=1;
        }
        }
        /**
         * Metodo para insertar correctamente en el arbol.
         * @param pArrayArbol, Arreglo que representa el arbol.
         */
        public void Monticulo(){      
            Acomodar();   
            int indice=_IndiceMaximo;
            while (indice>0){
                swap(0, indice);
                _IndiceMaximo = _IndiceMaximo-1;
                MayorElementoEnHeap(0);
                indice-=1;
            }
        }  
        /**
         * Metodo para llamar a hacer el ordenamiento del arbol.
         * @param pArrayArbol, Arreglo que representa el arbol. 
         */
        public void Acomodar(){
            _IndiceMaximo = _arr.length-1;
            int indice=_IndiceMaximo/2;
            while (indice>=0){
             MayorElementoEnHeap(indice); 
             indice-=1;
            }
        }

        /**
         *Metodo para realizar el ordenamiento del arbol 
         * @param pArrayArbol , Arreglo que representa el arbol.
         * @param pindice, indice del arreglo
         */
        public void MayorElementoEnHeap(int pindice){ 
                int left = 2*pindice ;
                int right = 2*pindice + 1;
                int max = pindice;
                if (left <= _TamañoDeArreglo && _arr[left].getPeso() > _arr[pindice].getPeso())
                    max = left;
                if (right <= _TamañoDeArreglo && _arr[right].getPeso() > _arr[max].getPeso())  
                    max = right;
                if (max != pindice){
                    swap(pindice, max);
                    MayorElementoEnHeap(max);
                }
        }    

        /**
         * Metodo para realizar los diferentes cambios entre los nodos del arbol.
         * @param pArrayArbol, Arreglo que representa el arbol.
         * @param pindice, indice del arreglo
         * @param pmaximo, ultima posicion del Arreglo
         */
        public void swap(int pindice, int pmaximo){
            int tmp = _arr[pindice].getPeso();
            String tmp2=_arr[pindice].getDocumentos();
            _arr[pindice].setPeso(_arr[pmaximo].getPeso()); 
            _arr[pindice].setDocumentos(_arr[pmaximo].getDocumentos());
            _arr[pmaximo].setPeso(tmp); 
            _arr[pmaximo].setDocumentos(tmp2);
        }    

        /**
         * Metodo para recorrer todo el arreglo o arbol Heap e ir imprimiendo en 
         * pantalla el valor de cada uno de sus elementos.
         * @param parrayArbol, Arreglo que representa el arbol.
         * @param pmaximo, ultima posicion del Arreglo 
         */
        public void mostrar(int pmaximo){
            int k=pmaximo-1;
            int cont=0;
            while(k>-1){
                System.out.println(" #: "+cont+" valor: "+_arr[k].getPeso());
                k-=1;
                cont+=1;
            }
        }
        /**
         * Este metodo auxiliar se encargar de eliminar el elemento Mayor del Heap 
         * @return 
         */
        public nodeArray remove(int top){                          
          nodeArray root =_arr[0];
          _arr[0] = _arr[--top];
          shiftDown(0,top-1);
          return root;
        }
        /**
         * Aqui se elimina el elemento mayor y se manda a ordenar de nuevo el arbol.
         */
        public void eliminar(){
        _raiz=_arr[_arr.length-1];
        _arr[_arr.length-1].setPeso(-1);
        _arr[_arr.length-1].setDocumentos("");
        Monticulo();
        }
        /**
         * Este metodo se encargara de hacer los movimientos, intercambios y remplazos para 
         * lograr eliminar el elemento buscado.
         */
        public void shiftDown(int index,int topmax){
          int largerChild;
          nodeArray top = _arr[0];       
          while(index < topmax/2)      
             {                               
             int leftChild = 2*index+1;
             int rightChild = leftChild+1;
             if(rightChild < topmax && _arr[leftChild].getPeso() < _arr[rightChild].getPeso())
                largerChild = rightChild;
             else
                largerChild = leftChild;       
             if( top.getPeso() >= _arr[largerChild].getPeso() )
                break;               
             _arr[index] = _arr[largerChild];
             index = largerChild;        
             }  
           _arr[index] = top;      
        }
        /**
         * Este metodo crea los datos del elemento a insertar para introducirlos
         * al Heap, con eso manda a acomodar de una vez el arbol
         * @param Documento
         * @param peso 
         */
        public void Insertar(String Documento,int peso){
            if (_Indice<_TamañoDeArreglo){
                _arr[_Indice].setPeso(peso);
                _arr[_Indice].setDocumentos(Documento);
                _Indice+=1;
                Monticulo();
            }
        }
        /**
         * Metodo para ver como quedo el arreglo que representa el arbol.
         */
        public void demostrar(){
            for (int i = 0; i < _TamañoDeArreglo; i++){
                if (_arr[i].getDocumentos()!=""){
                    System.out.println(" Peso: "+_arr[i].getPeso()+" Documento: "+_arr[i].getDocumentos()); 
                }
            }
        }
    
}

