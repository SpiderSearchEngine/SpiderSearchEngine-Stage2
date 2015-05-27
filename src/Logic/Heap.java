package Logic;

import java.util.Scanner;

/**
 * Clase para creacion y manipulacion del Heap de mayores
 * @author Gerald M, Jairo O.
 */
public class Heap { 
        private int mTamañoDeArreglo;
        /**
         * Constructor de la clase
         */
        public Heap(){}
        /**
         * Metodo para insertar adentro del Arreglo
         * @param pArrayArbol, Arreglo que representa el arbol.
         */
        public void Insertar(nodeArray[] pArrayArbol){      
            Acomodar(pArrayArbol);   
            int indice=mTamañoDeArreglo;
            while (indice>0){
                swap(pArrayArbol,0, indice);
                mTamañoDeArreglo = mTamañoDeArreglo-1;
                MayorElementoEnHeap(pArrayArbol, 0);
                indice-=1;
            }
        }  
        /**
         * 
         * @param pArrayArbol, Arreglo que representa el arbol. 
         */
        public void Acomodar(nodeArray[] pArrayArbol){
            mTamañoDeArreglo = pArrayArbol.length-1;
            int indice=mTamañoDeArreglo/2;
            while (indice>=0){
             MayorElementoEnHeap(pArrayArbol, indice); 
             indice-=1;
            }
        }

        /**
         *
         * @param pArrayArbol , Arreglo que representa el arbol.
         * @param pindice, indice del arreglo
         */
        public void MayorElementoEnHeap(nodeArray[] pArrayArbol, int pindice){ 
                int left = 2*pindice ;
                int right = 2*pindice + 1;
                int max = pindice;
                if (left <= mTamañoDeArreglo && pArrayArbol[left].getData() > pArrayArbol[pindice].getData())
                    max = left;
                if (right <= mTamañoDeArreglo && pArrayArbol[right].getData() > pArrayArbol[max].getData())  
                    max = right;
                if (max != pindice){
                    swap(pArrayArbol, pindice, max);
                    MayorElementoEnHeap(pArrayArbol, max);
                }
        }    

        /**
         * 
         * @param pArrayArbol, Arreglo que representa el arbol.
         * @param pindice, indice del arreglo
         * @param pmaximo, ultima posicion del Arreglo
         */

        public void swap(nodeArray[] pArrayArbol, int pindice, int pmaximo){
            int tmp = pArrayArbol[pindice].getData();
            pArrayArbol[pindice].setData(pArrayArbol[pmaximo].getData()); 
            pArrayArbol[pmaximo].setData(tmp); 
        }    

        /**
         * Metodo para recorrer todo el arreglo o arbol Heap e ir imprimiendo en 
         * pantalla el valor de cada uno de sus elementos.
         * @param parrayArbol, Arreglo que representa el arbol.
         * @param pmaximo, ultima posicion del Arreglo 
         */
    public void mostrar(nodeArray[] parrayArbol, int pmaximo){
        int k=pmaximo-1;
        int cont=0;
        while(k>-1){
            System.out.println(" #: "+cont+" valor: "+parrayArbol[k].getData());
            k-=1;
            cont+=1;
        }
    }
           

    }

