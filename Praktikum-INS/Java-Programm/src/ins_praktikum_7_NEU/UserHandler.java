
package ins_praktikum_7_NEU;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Die XML datei wird eingelesen und Knoten für Knoten wird durchgegangen;
 * Die Methoden StartElement(), endElement() und characters() werden verwendet
 * um festzulegen was bei aufruf der jeweiligen Knoten geschehen soll;
 * Über die Methoden warning(), error() und fatalError() werden verwendet um 
 * Meldungen des Parsers abzufangen und zu verarbeiten;
 * Die Methode printInfo() gibt den Text der jeweiligen Meldung aus und
 * Beendet das Gesamte Programm.
 * @author Lukas
 */
public class UserHandler extends DefaultHandler {
    
    /**
     * Boolean werte um sicherzustellen, dass nur die vorhandenen 
     * Elemente ausgelesen werden:
     */ 
    boolean anrede = false;
    boolean vorname = false;
    boolean nachname = false;
    boolean alter = false;
    boolean telefonnummer = false;
    boolean emailadresse = false;
    boolean webseite = false;
    boolean mailbox = false;
    boolean rueckfragen = false;
    boolean erneuterbesuch = false;
    boolean aufmerksamdurch = false;
    boolean noteinhalt = false;
    boolean noteaussehen = false;
    boolean vorschlag = false;
    boolean passwort = false;    
    
    // Liste in die Informationen der XML datei abgelegt werden:
    public ArrayList<String> dokument = new ArrayList<String>();
    
    /**
     * Abfangen von Warnungen des Parsers: 
     * Ausagbe Information: "Warning"
     * Aufruf Methode printInfo (Ausgabe der Meldung und Programm beenden)
     */     
    public void warning(SAXParseException e) throws SAXException {
         System.out.println("Warning: ");
         printInfo(e);
    }
    /**
     * Abfangen von Error Meldungen des Parsers: 
     * Ausagbe Information: "Error"
     * Aufruf Methode printInfo (Ausgabe der Meldung und Programm beenden)
     */ 
    public void error(SAXParseException e) throws SAXException {
         System.out.println("Error: ");
         printInfo(e);
    }
    /**
     * Abfangen von Fatal Error Meldungen des Parsers: 
     * Ausagbe Information: "Fatal error"
     * Aufruf Methode printInfo (Ausgabe der Meldung und Programm beenden)
     */  
    public void fatalError(SAXParseException e) throws SAXException {
         System.out.println("Fatal error: ");
         printInfo(e);
    }
    /**
     * Ausgabe der Exception und beenden des gesmten Programms: 
     * (Durch teil auslesen der Exception)
     */ 
    private void printInfo(SAXParseException e) {
        System.out.println("   System ID: "+e.getSystemId());
        System.out.println("   Line number: "+e.getLineNumber());
        System.out.println("   Column number: "+e.getColumnNumber());
        System.out.println("   Message: "+e.getMessage());
        // Gesamtes Programm beenden:
        System.exit(0);
    }
   
   /**
    * Methode mit der die Start Elemente der XML Datei ausgelesen werden:
    * @param uri wenn namensraum verwendet wurde url (wird nicht verwendet)
    * @param localName lokal-Name ohne prefix (wird nicht verwendet)
    * @param qName Name des jeweiligen Elementes als String
    * @param attributes Attribute des Elementes (Die Daten können ausgegeben werden)
    * @throws SAXException 
    */ 
   @Override
   public void startElement(String uri, 
      String localName, String qName, Attributes attributes) throws SAXException {
//       System.out.println("uri: "+uri);
//       System.out.println("localName: "+localName);
//       System.out.println("qName: "+qName);
//       System.out.println("attributes: " +attributes);
      
        /**
         * equalsIgnoreCase = Groß- und Kleinschreibung wird nicht beachtet:
         * Durch DTD Prüfung allerdings ungeeignet, da klar festgelegt werden
         * muss ob Groß oder Klein. (Bsp. anrede und Anrede)
         */ 
      if(qName.equalsIgnoreCase("FeedbackDaten")) {
          // Auslesen der Attribute:
          String uhrzeit = attributes.getValue("Uhrzeit");
          String datum = attributes.getValue("Datum");
//          System.out.println("Datum: " + datum);
//          System.out.println("Uhrzeit: " + uhrzeit);
          // Datum und Uhrzeit werden der ArrayList hinzugefügt:
          dokument.add(uhrzeit);
          dokument.add(datum);
      }
      else if(qName.equalsIgnoreCase("PersoenlicheDaten")) {
          String position = attributes.getValue("position");
          String id = attributes.getValue("id");
//          System.out.println("Position: " + position);
//          System.out.println("ID: " + id);
      } else if(qName.equalsIgnoreCase("Anrede")) {
          // Wenn Elemente vorhanden wird dies im Boolean Wert festgehalten:
          anrede = true;
      } else if(qName.equalsIgnoreCase("Vorname")) {
          vorname = true;
      } else if(qName.equalsIgnoreCase("Nachname")) {
          nachname = true;
      } else if(qName.equalsIgnoreCase("Alter")) {
          alter = true;
      } else if(qName.equalsIgnoreCase("Telefonnummer")) {
          telefonnummer = true;
      } else if(qName.equalsIgnoreCase("Emailadresse")) {
          emailadresse = true;
      } else if(qName.equalsIgnoreCase("Webseite")) {
          webseite = true;
      } else if(qName.equalsIgnoreCase("Checkboxen")) {
          String position = attributes.getValue("position");
          String id = attributes.getValue("id");
//          System.out.println("Position: " + position);
//          System.out.println("ID: " + id);
      } else if(qName.equalsIgnoreCase("Mailbox")) {
          mailbox = true;
      } else if(qName.equalsIgnoreCase("Rueckfragen")) {
          rueckfragen = true;
      } else if(qName.equalsIgnoreCase("erneuterBesuch")) {
          erneuterbesuch = true;
      } else if(qName.equalsIgnoreCase("EntdecktDurch")) {
          String position = attributes.getValue("position");
          String id = attributes.getValue("id");
//          System.out.println("Position: " + position);
//          System.out.println("ID: " + id);
      } else if(qName.equalsIgnoreCase("AufmerksamDurch")) {
          aufmerksamdurch = true;
      } else if(qName.equalsIgnoreCase("Noten")) {
          String position = attributes.getValue("position");
          String id = attributes.getValue("id");
//          System.out.println("Position: " + position);
//          System.out.println("ID: " + id);
      } else if(qName.equalsIgnoreCase("NoteInhalt")) {
          noteinhalt = true;
      } else if(qName.equalsIgnoreCase("NoteAussehen")) {
          noteaussehen = true;
      } else if(qName.equalsIgnoreCase("Verbesserung")) {
          String position = attributes.getValue("position");
          String id = attributes.getValue("id");
//          System.out.println("Position: " + position);
//          System.out.println("ID: " + id);
      } else if(qName.equalsIgnoreCase("Vorschlag")) {
          vorschlag = true;
      } else if(qName.equalsIgnoreCase("Spamschutz")) {
          String position = attributes.getValue("position");
          String id = attributes.getValue("id");
//          System.out.println("Position: " + position);
//          System.out.println("ID: " + id);
      } else if(qName.equalsIgnoreCase("Passwort")) {
          passwort = true;
      }
      
   }
   
   /**
    * Auslesen des jeweiligen End Elmentes.
    * @param uri wenn namensraum verwendet wurde url (wird nicht verwendet)
    * @param localName lokal-Name ohne prefix (wird nicht verwendet)
    * @param qName Name des jeweiligen Elementes als String
    * @throws SAXException 
    */
   @Override
   public void endElement(String uri, 
      String localName, String qName) throws SAXException {
//       System.out.println("uri: "+uri);
//       System.out.println("localName: "+localName);
//       System.out.println("qName: "+qName);
       
        if(qName.equalsIgnoreCase("FeedbackDaten")) {
            //System.out.println("End Element :" + qName);
        } else if(qName.equalsIgnoreCase("PersoenlicheDaten")) {
            //System.out.println("End Element :" + qName);
        } else if(qName.equalsIgnoreCase("Checkboxen")) {
            //System.out.println("End Element :" + qName);
        } else if(qName.equalsIgnoreCase("EntdecktDurch")) {
            //System.out.println("End Element :" + qName);
        }  else if(qName.equalsIgnoreCase("Noten")) {
            //System.out.println("End Element :" + qName);
        } else if(qName.equalsIgnoreCase("Verbesserung")) {
            //System.out.println("End Element :" + qName);
        } else if(qName.equalsIgnoreCase("Spamschutz")) {
            //System.out.println("End Element :" + qName);
        }
        
   }
   
   /**
    * Auslesen der Werte die in den Elementen festgehalten wurden:
    * @param ch die einzelnen Zeichen der XML Datei (also alle!)
    * @param start Start der Zeichenkette (Bsp: Anrede="Herr" start=146, length=4)
    * @param length Länge der Zeichenkette
    * @throws SAXException 
    */
   @Override
   public void characters(char ch[], 
      int start, int length) throws SAXException {
//       System.out.println("ch[]: "+ch[12]);
//       System.out.println("start: "+start);
//       System.out.println("length: "+length);
//       System.out.println(new String(ch, start, length));
       
       // Prüfen ob Element vorhanden:
      if(anrede) {
        //System.out.println("Anrede: " + new String(ch, start, length));
        // Dem Array den Element Wert zuweisen: Auslesen Zeichen von start und wie lange length
        dokument.add(new String(ch, start, length));
        // Boolean wieder auf False setzten damit nächster Wert eingelesen wird:
        anrede = false;
      } else if(vorname) {
        //System.out.println("Vorname: " + new String(ch, start, length));
        dokument.add(new String(ch, start, length));
        vorname = false;
      } else if(nachname) {
        //System.out.println("Nachname: " + new String(ch, start, length));
        dokument.add(new String(ch, start, length));
        nachname = false;
      } else if(alter) {
        //System.out.println("Alter: " + new String(ch, start, length));
        dokument.add(new String(ch, start, length));
        alter = false;
      } else if(telefonnummer) {
        //System.out.println("Telefonnummer: " + new String(ch, start, length));
        dokument.add(new String(ch, start, length));
        telefonnummer = false;
      } else if(emailadresse) {
        //System.out.println("Emailadresse: " + new String(ch, start, length));
        dokument.add(new String(ch, start, length));
        emailadresse = false;
      } else if(webseite) {
        //System.out.println("Webseite: " + new String(ch, start, length));
        dokument.add(new String(ch, start, length));
        webseite = false;
      } else if(mailbox) {
        //System.out.println("Mailbox: " + new String(ch, start, length));
        dokument.add(new String(ch, start, length));
        mailbox = false;
      } else if(rueckfragen) {
        //System.out.println("Rückfragen: " + new String(ch, start, length));
        dokument.add(new String(ch, start, length));
        rueckfragen = false;
      } else if(erneuterbesuch) {
        //System.out.println("Erneuter Besuch: " + new String(ch, start, length));
        dokument.add(new String(ch, start, length));
        erneuterbesuch = false;
      } else if(aufmerksamdurch) {
        //System.out.println("Aufmerksamkeit Durch: " + new String(ch, start, length));
        dokument.add(new String(ch, start, length));
        aufmerksamdurch = false;
      } else if(noteinhalt) {
        //System.out.println("Note für Inhalt: " + new String(ch, start, length));
        dokument.add(new String(ch, start, length));
        noteinhalt = false;
      } else if(noteaussehen) {
        //System.out.println("Note für Aussehen: " + new String(ch, start, length));
        dokument.add(new String(ch, start, length));
        noteaussehen = false;
      } else if(vorschlag) {
        //System.out.println("Vorschlag: " + new String(ch, start, length));
        dokument.add(new String(ch, start, length));
        vorschlag = false;
      } else if(passwort) {
        //System.out.println("Passwort: " + new String(ch, start, length));
        dokument.add(new String(ch, start, length));
        passwort = false;
      }      
   }  
   
   
   
}
