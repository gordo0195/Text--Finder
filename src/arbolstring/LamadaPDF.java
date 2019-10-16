/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolstring;

/**
 *
 * @author marco
 */
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author Azeem
 */
public class LamadaPDF  {

    public static void main(String[] args) {
        
        ArbolString Principal = new ArbolString();
        LectorPDF pdfManager = new LectorPDF();
        pdfManager.setFilePath("/home/marco/Documentos/imagenes progra/documentacion externa.pdf");
       
        try{
            String text = pdfManager.toText();
            System.out.println(text);
            String[] words = text.split("\\s+");
            
            for (int i = 0; i < words.length; i++) {
                 // You may want to check for a non-word character before blindly
                // performing a replacement
                // It may also be necessary to adjust the character class
                 words[i] = words[i].replaceAll("[^\\w]", "");
                 
            }
            
            String temp2 = Arrays.toString(words);
            //System.out.println(temp2);
            
            int tope = words.length;
            for(int i = 0; i < tope; i++){
                
                Principal.insertar(words[i]);
                
            
            }
           
        }
        catch(IOException ex){
           System.out.println(ex.getMessage());
        }
        
        Principal.PreOrden(Principal);
       
     }
    
}
