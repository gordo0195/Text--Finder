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



import java.io.FileInputStream;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;


public class LamadaDOC  {
    public static void main(String[] args) throws Exception{
         try{
             XWPFDocument file = new XWPFDocument(new FileInputStream("C:\\Users\\Marco\\Dropbox\\documentos\\Indígena.docx"));
             XWPFWordExtractor reading = new XWPFWordExtractor(file);
             System.out.println(reading.getText());
         }catch(Exception e){
             System.out.println(e);
         }
    
    
    }
} 