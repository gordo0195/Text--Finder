/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolstring;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import java.io.*;

/**
 *
 * @author Gordo_0195
 */
public class LlamadaDocx {
    
    public static void main(String[] args) throws InvalidFormatException{
       
        ArbolString Principal = new ArbolString(); 
        File Archivo;
        String referencia = "";
        XWPFWordExtractor extractor;
        XWPFDocument document;
        String texto_extraido;
        try{
           
            Archivo = new File("C:\\Users\\Marco\\Dropbox\\documentos\\Indígena.docx");
            referencia = Archivo.getName();
            FileInputStream file = new FileInputStream(Archivo.getPath());
            document = new XWPFDocument(OPCPackage.open(file));
            extractor = new XWPFWordExtractor(document);
            texto_extraido = extractor.getText();
            String text = texto_extraido.toLowerCase();
            System.out.println(text);
            String[] words = text.split("\\s+");
            
            for (int i = 0; i < words.length; i++) {
                
                 words[i] = words[i].replaceAll("[^\\w]", "");
                 
            }
            for(int i = 0; i < (words.length)-1; i++){
                    
                    words[i] = words[i].replaceAll("[^\\w]", "");
                    //System.out.println(words[i]);
                     Principal.addNode(words[i], referencia);
            }
        }catch(IOException e){
            System.out.println(e);
        }Principal.traverseInOrder();
        
        
    }
    
    }
    

