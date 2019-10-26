
package arbolstring;

public class ArbolString {
 
    private String dato;
    private String referencia;
    private ArbolString izquierda;
    private ArbolString derecha;
    public ArbolString raiz;
 
    public ArbolString() {
        this.raiz = null;
    }
     
    public ArbolString(String dato, String referencia) {
        this.dato = dato;
        this.referencia = referencia;
        this.izquierda = null;
        this.derecha = null;
    }
 
    public static ArbolString createTree( String content ) {
        ArbolString bstree = new ArbolString();
        if( content != null ) {
            //
            // Remove the punctuation from the content
            //
            content = content.replaceAll("(\\w+)\\p{Punct}(\\s|$)", "$1$2");
            String[] words = content.split( " " );
            bstree = new ArbolString();
            for( int i = 0; i < words.length; i++ ) {
                bstree.addNode( words[i], " ");
            }
        } 
        return bstree;
    }
 
     
    // As a convention, if the key to be inserted is less than the key of root
    // node, then key is inserted in
    // left sub-tree; If key is greater, it is inserted in right sub-tree. If it
    // is equal, as a convention, it
    // is inserted in right sub-tree
    public void addNode(String dato, String referencia) {
        if (this.dato == null) {
            this.dato = dato;
            this.referencia = referencia;
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
        System.out.println(this.dato+" , "+this.referencia);
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
        System.out.println(this.dato+" , "+this.referencia);
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
        System.out.println(this.dato+" , "+this.referencia);
    }
    //public ArbolString nodo = new ArbolString();
    public String buscar(String llave){
       
       return buscarI(llave,raiz);
    
    }
    public  String buscarI(String str, ArbolString nodo) {
        
        int cmp = nodo.dato.compareTo(str);
        
        if (raiz == null) {
            return null;
        }else{
            if(nodo.dato.equals(str)){
        
                return dato + "encontrado"; //dato encontrado 
        
            }else if (cmp < 0) {
                 return buscarI(str, nodo.izquierda);
                
            } else  {
                 return buscarI(str, nodo.derecha);
            }
           
        }
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
        Arbol.traversePostOrder();
        Arbol.traversePreOrder();
        
       //Arbol.buscar("camello");
    }
    
 
}
