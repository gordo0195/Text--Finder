/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolstring;



/**
 *
 * @author Gordo_0195
 */

import java.io.*;


public class LlamadaTXT {
    
    public static void main(String[] args) throws IOException{
        
        File Archivo;
        String referencia;
        FileReader  Lector = null;
        BufferedReader Bufer;
        ArbolString Principal = new ArbolString();
        try{
            Archivo = new File("C:\\Users\\Marco\\Documents\\Charla Mediación pedagógica.txt");
            referencia = Archivo.getName();
            Lector = new FileReader(Archivo.getPath());
            Bufer = new BufferedReader(Lector);
            
            String Linea = Bufer.readLine();
            String[] words = Linea.split("\\s+");
            while(Linea!= null){
                for(int i = 0; i < (Linea.length())-1; i++){
                    
                    words[i] = words[i].replaceAll("[^\\w]", "");
                    //System.out.println(words[i]);
                     Principal.addNode(words[i], referencia);
                }
            }
            
        }catch(Exception  e){
            System.out.println(e);
        }finally{//posible nullpointer 
            Lector.close();
        }
        Principal.traverseInOrder();
        
    }
    
}
