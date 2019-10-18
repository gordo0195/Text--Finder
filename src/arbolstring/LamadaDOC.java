/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolstring;

/**
 *
 * @author Marco
 */


import java.io.File;  
import java.util.List;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;



public class LamadaDOC  {
    public static void main(String[] args) {
         try{
             
            File archivo = new File("/media/gordo-0195/MARCO/documentos/gestión restaurante.docx");
             FileInputStream path = new FileInputStream(archivo.getAbsolutePath());
             
             XWPFDocument file = new XWPFDocument(path);
             XWPFWordExtractor reading = new XWPFWordExtractor(file);
             
            System.out.println(reading.getText());
            //List<XWPFParagraph> paragraphs = file.getParagraphs();*/
            

        } catch (IOException e) {
            System.out.println(e);
            }
        
    
    }
} 