
package arbolstring;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.List;

public class ArbolString {
 
    private String dato;
    public List referencia = new ArrayList();
    private ArbolString izquierda;
    private ArbolString derecha;
    public ArbolString raiz;
 
    public ArbolString() {
        this.raiz = null;
        this.dato = "";
        this.referencia.add(0, "");
        this.izquierda = null;
        this.derecha = null;
    }
    @SuppressWarnings("unchecked") 
    public ArbolString(String dato, String referencia) {
        this.dato = dato;
        this.referencia.add(referencia);
        this.izquierda = null;
        this.derecha = null;
    }
 
    public static ArbolString createTree( String content ) {
        ArbolString bstree = new ArbolString();
        if( content != null ) {
            
            content = content.replaceAll("(\\w+)\\p{Punct}(\\s|$)", "$1$2");
            String[] words = content.split( " " );
            bstree = new ArbolString();
            for( int i = 0; i < words.length; i++ ) {
                bstree.addNode( words[i], " ");
            }
        } 
        return bstree;
    }
 
     
   
    public void addNode(String dato, String referencia) {
        if (this.dato == null) {
            this.dato = dato;
            this.referencia.add(0, referencia);
        } else {
            if (this.dato.compareTo(dato) > 0) {
                if (this.izquierda != null) {
                    this.izquierda.addNode(dato, referencia);
                } else {
                    this.izquierda = new ArbolString(dato, referencia);
                }
 
            } else {
                if (this.derecha != null) {
                    this.derecha.addNode(dato, referencia);
                } else {
                    this.derecha = new ArbolString(dato, referencia);
                }
 
            }
        }
    }
     
    public void traversePreOrder() {
        System.out.println(this.dato+" , "+this.referencia.toString());
        if (this.izquierda != null) {
            this.izquierda.traversePreOrder();
        }
        if (this.derecha != null) {
            this.derecha.traversePreOrder();
        }
    }
 
    public void traverseInOrder() {
        if (this.izquierda != null) {
            this.izquierda.traverseInOrder();
        }
        System.out.println(this.dato+" , "+this.referencia.toString());
        if (this.derecha != null) {
            this.derecha.traverseInOrder();
        }
    }
 
 
    public void traversePostOrder() {
        if (this.izquierda != null) {
            this.izquierda.traversePostOrder();
        }
        if (this.derecha != null) {
            this.derecha.traversePostOrder();
        }
        System.out.println(this.dato+" , "+this.referencia.toString());
    }
    //public ArbolString nodo = new ArbolString();
    public String buscar(String llave){
       
       return buscarI(llave);
    
    }
    public  String buscarI(String str) {
        if(this.dato.equals(str)){
            return "encontrada!!! " + dato + " en: " + this.referencia.toString();
        }else if(str.compareTo(this.dato) < 0){
            return izquierda == null ? null:izquierda.buscarI(str);
        
        }else{
            return derecha == null ? null:derecha.buscarI(str);
        }
        
    }
    public boolean existe(String seBusca ){
    
        if(this.dato.equals(seBusca)){
            return true;
        }
        return false;
        /**else if(seBusca.compareTo(this.dato) < 0){
            return izquierda == null ? null:izquierda.existe(seBusca);
        
        }else if(seBusca.compareTo(this.dato) > 0){
            return derecha == null ? null:derecha.existe(seBusca);
        }
        return "ausente";*/
       
    }
    public String imprimeBusqueda(String seBusca){
        while(this.dato != null && !" ".equals(this.dato)){//this.dato != null && 
            Boolean está = existe(seBusca);
            if(está == true){
                System.out.println("encontrada! " + seBusca + " en: " + this.referencia.toString());
            }else{    
                if(seBusca.compareTo(this.dato) < 0){
                    return izquierda == null ? null:izquierda.imprimeBusqueda(seBusca);
        
                }else if(seBusca.compareTo(this.dato) > 0){
                    return derecha == null ? null:derecha.imprimeBusqueda(seBusca);
                }
        
            }    
        
        }
        return "ausente";
    }
    
    
    
     public static void main(String[] args) {
        /**
         * metodo principal
         * 
         * inserta y muestra
         */
        
        ArbolString Arbol = new ArbolString();
        
        Arbol.addNode("perro", "entrada1");
        Arbol.addNode("gato", "entrada2");
        Arbol.addNode("camello", "entrada3");
        Arbol.addNode("castillo", "entrada4");
        Arbol.traverseInOrder();
        //Arbol.traversePostOrder();
        //Arbol.traversePreOrder();
        
       String str1 = (String) Arbol.buscar( "castillo" );
       System.out.println(str1);
       Arbol.imprimeBusqueda("la");
    }
    
 
}
