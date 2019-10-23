/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolstring;

import static com.sun.javafx.fxml.expression.Expression.get;

/**
 *
 * @author marco
 */
public class ArbolString {

    /**
     * @param args the command line arguments
     */
    
    String dato;
    ArbolString derecha, izquierda;
    
    public ArbolString(){
        this.dato = "";
        this.izquierda = null;
        this.derecha = null;
    
    }
    public boolean esta_vacio(){
        if(this.dato == "" && this.izquierda == null && this.derecha == null){
            return true;
        } return false;
    
    }
   public void insertar(String dato){
       if(this.esta_vacio()){
           this.dato = dato;
           this.izquierda = new ArbolString();
           this.derecha = new ArbolString();
       }else{
           if(this.izquierda == null){
               this.izquierda.insertar(dato);
           }else{
               this.derecha.insertar(dato);
           }
       }
    }
    
    void PreOrden(ArbolString raiz){
        if(!raiz.esta_vacio()){
            System.out.println(raiz.dato);
            PreOrden(raiz.izquierda);
            PreOrden(raiz.derecha);
        }
    }
    
    //public String buscar(String d) {
   // return buscar( d);
//}

public String buscar(ArbolString aux, String str) {
    if (aux == null) {
        return null;
    }
    int cmp = str.compareTo(aux.dato);
    if (cmp < 0) {
        return get(aux.izquierda, str);
    } else if (cmp > 0) {
        return get(aux.derecha, str);
    } else {
        return aux.dato;
    }
}
    
    public static void main(String[] args) {
        
        ArbolString Arbol = new ArbolString();
        
        Arbol.insertar("perro");
        Arbol.insertar("gato");
        Arbol.insertar("camello");
        Arbol.insertar("castillo");
        Arbol.PreOrden(Arbol);
        Arbol.buscar("camello");
    }
    
}
