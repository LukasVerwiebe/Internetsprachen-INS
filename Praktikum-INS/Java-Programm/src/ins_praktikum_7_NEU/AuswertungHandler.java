
package ins_praktikum_7_NEU;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Verarbeitung der Auswertungs Datei:
 * Wird verwendet um die Überprüfung der XML durch die DTD Datei durchzuführen
 * und die entsprechneden Meldungen abzufangen.
 * @author Lukas
 */
public class AuswertungHandler extends DefaultHandler {
    
    public void warning(SAXParseException e) throws SAXException {
         System.out.println("Warning: ");
         printInfo(e);
      }
      public void error(SAXParseException e) throws SAXException {
         System.out.println("Error: ");
         printInfo(e);
      }
      public void fatalError(SAXParseException e) throws SAXException {
         System.out.println("Fattal error: ");
         printInfo(e);
      }
      private void printInfo(SAXParseException e) {
         System.out.println("   System ID: "+e.getSystemId());
         System.out.println("   Line number: "+e.getLineNumber());
         System.out.println("   Column number: "+e.getColumnNumber());
         System.out.println("   Message: "+e.getMessage());
         System.exit(0);
      }
      
   @Override
   public void startElement(String uri, 
      String localName, String qName, Attributes attributes) throws SAXException {
      
      
      
   }

   @Override
   public void endElement(String uri, 
      String localName, String qName) throws SAXException {
        
        
        
   }

   @Override
   public void characters(char ch[], 
      int start, int length) throws SAXException {

      
   }  
    
}
