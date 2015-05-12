/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.io.IOException;

/**
 * Clase que toma el texto plano y le aplica una serie de metodos para eliminar 
 * simbolos y signo ademas de aplicar las expresiones regulares.
 * @author Jairo O, Gerald M.
 */
public class formatoTexto {
    private String _dato;
    private String[] _expresiones=new String[48];
    /**
     * Metodo que quita los signos de puntuacion, y algunas signos al texto plano extraido
     * 
     */
    public formatoTexto(){
       _expresiones[0]="ª";
       _expresiones[1]="º";
       _expresiones[2]="\\";
       _expresiones[3]="!";
       _expresiones[4]="...";
       _expresiones[5]="¿";
       _expresiones[6]="?";
       _expresiones[7]="(";
       _expresiones[8]="[";
       _expresiones[9]="_";
       _expresiones[10]="-";
       _expresiones[11]="|";
       _expresiones[12]="'";
       _expresiones[13]="{";
       _expresiones[14]="/";
       _expresiones[15]=")";
       _expresiones[16]="=";
       _expresiones[17]="]";
       _expresiones[18]="}";
       _expresiones[19]="·";
       _expresiones[20]="$";
       _expresiones[21]="&nbsp";
       _expresiones[22]="Ç";
       _expresiones[23]="º";
       _expresiones[24]="!";
       _expresiones[25]="&";
       _expresiones[26]="•";
       _expresiones[27]="@";
       _expresiones[28]="url";
       _expresiones[29]=":";
       _expresiones[30]=".";
       _expresiones[31]=",";
       _expresiones[32]="*";
       _expresiones[33]="+";
       _expresiones[34]="¡";
       _expresiones[35]=";";
       _expresiones[36]="1";
       _expresiones[37]="2";
       _expresiones[38]="3";
       _expresiones[39]="4";
       _expresiones[40]="5";
       _expresiones[41]="6";
       _expresiones[42]="7";
       _expresiones[43]="8";
       _expresiones[44]="9";
       _expresiones[45]="0";
       _expresiones[46]="px";
       _expresiones[47]="\"";
    }
    /**
     * Metodo que aplica la expresion regular al texto extraido
     * @param pUrl, Url de la pagina a la cual se le va a extraer el texto.
     * @return
     * @throws IOException 
     */
    public stackList eliminarLinks(String pUrl) throws IOException{
       extraeTexto extratorDeTexto=new extraeTexto();
       _dato=extratorDeTexto.extraerTexto(pUrl);
       _dato=_dato.replaceAll("\\<.*?>", " ");
       for(int i=0; i<_expresiones.length;i++){
           _dato=_dato.replace(_expresiones[i], " ");
       }
       tokenizer token=new tokenizer(_dato, pUrl);
       return token.procesar();
    }       
}
