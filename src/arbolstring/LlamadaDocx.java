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

/**
 *
 * @author Gordo_0195
 */
public class LlamadaDocx {
    
    public static void main(String[] args) throws InvalidFormatException{
        
        XWPFWordExtractor extractor;
        XWPFDocument document;
        String texto_extraido;
        try{
            FileInputStream file = new FileInputStream("C:\\Users\\Gordo_0195\\Documents\\La Historia de Alberto Prada.docx");
            document = new XWPFDocument(OPCPackage.open(file));
            extractor = new XWPFWordExtractor(document);
            texto_extraido = extractor.getText();
            System.out.println(texto_extraido);
            
        }catch(IOException e){
            System.out.println(e);
        }
        
        
    }
    
}
