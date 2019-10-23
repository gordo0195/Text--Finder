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
        FileReader  Lector = null;
        BufferedReader Bufer;
        ArbolString Principal = new ArbolString();
        try{
            Archivo = new File("C:\\Users\\Gordo_0195\\Documents\\proyecto taller segundo semestre\\notas.txt");
            Lector = new FileReader(Archivo);
            Bufer = new BufferedReader(Lector);
            
            String Linea = Bufer.readLine();
            String[] words = Linea.split("\\s+");
            while(Linea!= null){
                for(int i = 0; i < (Linea.length())-1; i++){
                    
                    words[i] = words[i].replaceAll("[^\\w]", "");
                    //System.out.println(words[i]);
                     Principal.insertar(words[i]);
                }
            }
            
        }catch(Exception  e){
            System.out.println(e);
        }finally{
            Lector.close();
        }Principal.PreOrden(Principal);
    }
    
}
