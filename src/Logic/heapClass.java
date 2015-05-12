
package Logic;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import org.w3c.dom.Node;
/**
 *Clase para Para manipular el arbol Heaps. Se encuentran los metodos insertar elementos y realizar la lectura de los mismos.
 * @author Gerald M, Jairo O. 
 */
public class heapClass <H extends Comparable<H>> {
    private nodeArray[] _elementos;
    private int mTamañoTeArreglo;
    private int mNumeroDeNodos;
    /**
     * Constructor de la clase
     */
    public heapClass(int pTamañoTeArreglo){
        this.mTamañoTeArreglo=pTamañoTeArreglo;
        this.mNumeroDeNodos=0;
        _elementos=new nodeArray[mTamañoTeArreglo];
    }
    /**
     * Metodo para verificar si el arreglo esta vacio
     */
     public boolean vacio(){
         return mNumeroDeNodos==0; 
     }
    /**
     * Metodo que inserta un elemento al arreglo y ademas de ello le aplica los 
     * Swaps correspondientes hasta lograr acomodar el elemento donde corresponde.
     * @param elemento 
     */
    public void insertar(int key){
        nodeArray mElemento= new nodeArray(key);
        _elementos[mNumeroDeNodos]=mElemento;
        swap(mNumeroDeNodos++);
    }
    /**
     * Metodo que toma los elementos despues de ser insertados y realizar los movimientos
     * o intercambios necesarios para acomodar en la posicion correcta todos los datos.
     */
    private void swap(int indice){
        int k=indice-1;
        while (k>0){
            int p=(k-1)/2;
            nodeArray hijo=_elementos[k];
            nodeArray padre=_elementos[p];
            if (hijo.getData()==padre.getData()){
                _elementos[k].setData(padre.getData());
                _elementos[p].setData(hijo.getData());
                k=p;
            }else
                break;
        }
    }
    /**
     * Metodo para recorrer todo el arreglo o arbol Heap e ir imprimiendo en 
     * pantalla el valor de cada uno de sus elementos.
     */
    public void mostrar(int indice){
        int k=_elementos.length-1;
        while(k>-1){
            System.out.println(_elementos[k].getData());
            k-=1;
        }
    }
}
