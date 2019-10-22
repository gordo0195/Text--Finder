/*
 *
 */
package arbolstring;

/**
 *
 * @author Marco
 */


import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class LamadaDOC  {
    public static void main(String[] args) {
        
        
        FileInputStream File;
        WordExtractor extractor;
        HWPFDocument doc;
        
        
                
        try{
            File = new FileInputStream ("C:\\Users\\Gordo_0195\\Documents\\La Historia de Alberto Prada 1.doc");
            doc = new HWPFDocument(File);
            extractor = new WordExtractor(doc);
            String texto_extraido = extractor.getText();
            System.out.println(texto_extraido);
            
            

        } catch (IOException e) {
            System.out.println(e);
            }
        
    
    }
} 