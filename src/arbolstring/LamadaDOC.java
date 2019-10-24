/*
 *
 */
package arbolstring;

/**
 *
 * @author Marco
 * Instituto Tecnológico de  Costa Rica
 * Area de Ingenieria de Computadores
 * Algoritmos y estructuras de datos I
 * Profesor: Antonio Torres.
 * Alumnos: Marco Picado M.
 *               Gretchell Ochoa.
 * Segundo semestre 2019.
 */


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class LamadaDOC  {
    /**
     * 
     * clase  encargada de leer los documentos con extención .doc
     * genera sus propios parámetros sobre la marcha
     * se  basa en la biblioteca apache poi
     * 
     */
    
    public static void main(String[] args) {
        /**
         * @param nulo
         * metodo principal
         * lee y devuelve el  nodo insertaado en el arbol 
         */
        
        
        FileInputStream File;//recoge los caracteres y los almacena en memoria
        WordExtractor extractor;//interpreta los caracteres extraidos 
        HWPFDocument doc;//procesa los caracteres interpretados y los hace extraibles para implementarlos 
                                    //dentro de un string 
        ArbolString Principal = new ArbolString();
        
                
        try{
            File = new FileInputStream ("C:\\Users\\Gordo_0195\\Documents\\La Historia de Alberto Prada 1.doc");
            doc = new HWPFDocument(File);
            extractor = new WordExtractor(doc);
            String texto_extraido = extractor.getText();
            System.out.println(texto_extraido);
            
            String[] words = texto_extraido.split("\\s+");//el string se transforma en arreglo y se quitan los espacios
            
            for (int i = 0; i < words.length; i++) {
                
                 words[i] = words[i].replaceAll("[^\\w]", "");//se eliminan todos los caracteres que no son letras
                 
            }
            
            String temp2 = Arrays.toString(words);//lo vuelve a convertir en string 
            
            
            int tope = words.length;
            for(int i = 0; i < tope; i++){//itera el arreglo y  añade cada palabra al arbol
                
                Principal.insertar(words[i]);
                
            
            }
            
            

        } catch (IOException e) {
            System.out.println(e);
            }
        
        Principal.PreOrden(Principal);
    }
} 