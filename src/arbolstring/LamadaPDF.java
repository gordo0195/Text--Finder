
package arbolstring;

/**
 *
 * @author marco
 * 
 * Instituto Tecnológico de  Costa Rica
 * Area de Ingenieria de Computadores
 * Algoritmos y estructuras de datos I
 * Profesor: Antonio Torres.
 * Alumnos: Marco Picado M.
 *               Gretchell Ochoa.
 * Segundo semestre 2019.
 */
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * implemented by Marco Picado, based in work of Azeem.
 */
public class LamadaPDF  {
    /**
     * clase encargada de leer y procesar los caracteres previemente extraidos de un documeento PDF
     * @param args nulo
     */
    
    
    public static void main(String[] args) {
        /**
         * meetodo principal 
         * lee y devuelve  cada palabra insertada en el árbol
         */
        
        String path = "C:\\Users\\Marco\\Dropbox\\Introducción a Dropbox.pdf";
        File archivo = new File(path);
        String referencia = archivo.getName();
        ArbolString Principal = new ArbolString();
        LectorPDF pdfManager = new LectorPDF();
        pdfManager.setFilePath(path);
       
        try{            
            String texto = pdfManager.toText();
            String text = texto.toLowerCase();
            //System.out.println(text);
            String[] words = text.split("\\s+");
            
            for (int i = 0; i < words.length; i++) {
                
                 words[i] = words[i].replaceAll("[^\\w]", "");
                 
            }
            
            //String temp2 = Arrays.toString(words);
            //System.out.println(temp2);
            
            int tope = words.length;
            for(int i = 0; i < tope; i++){
                
                Principal.addNode(words[i], referencia);
                
            
            }
           
        }
        catch(IOException ex){
           System.out.println(ex.getMessage());
        }
        
        //Principal.traversePostOrder();
        //String str1 = (String) Principal.buscar( "la" );
        //System.out.println(str1);
        //String ss = Principal.imprimeBusqueda("la");
        Principal.imprimeBusqueda("la");
        //System.out.println(ss);
     }
    
}
 