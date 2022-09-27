
package ins_praktikum_7_NEU;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
 *
 * @author Lukas
 */
public class XML_parser {
    
    public static void main(String[] args) throws SAXException, TransformerException{
        try {
            // Klasse für die Auswertung der Daten:
            Auswertungen auswertung = new Auswertungen();
                        
            
            // Pfad in dem die XML Dateien zu finden sind:
            File pfad = new File("E:\\xampp\\htdocs");
            // Array mit den Dateien des Pfades erstellen:
            File filesList[] = pfad.listFiles();
            /**
             * For Schliefe mit der sichergestellt wird, dass 
             * alle Datien mit der endung .xml eingelesen werden.
             */
            for(File file : filesList) {
                // Namen der Datien holen und in kleinschrift umschreiben:
                String dateiende = file.getName().toLowerCase();
                // Prüfung ob datei mit .xml endet:
                if(dateiende.endsWith(".xml")) {
                    // Instantz der SAXParser Factory erzeugen:
                    SAXParserFactory factory = SAXParserFactory.newInstance();
                    /**
                     * Prüfen der DTD Datei beim einlesen aktivieren:
                     * (Die DTD Datei muss dafür zwingend vorhanden sein)
                     */
                    factory.setValidating(true);
                    // Neue Instanz des SAXParser erzeugen:
                    SAXParser saxParser = factory.newSAXParser();
                    /**
                     * Neue Instanz der Klasse Userhandler erzeugen,
                     * Mit diesem werden die XML Dateien ausgelesen: 
                     */
                    UserHandler userhandler = new UserHandler();
                    /**
                     * Die Datei und die Instanz des Userhandlers an 
                     * den SAXParser übergeben:
                     */
                    saxParser.parse(file, userhandler);
                    
                    /**
                     * Daten der einzelnen XML Dateien aus der Klasse Userhanlder
                     * der Liste in der Klasse Auswertung übergeben:
                     * (Zu allen XML Dateien werden dort einträge geführt um 
                     * die Daten weiter verwenden zu können)
                     */ 
                    auswertung.dokumente.add(userhandler.dokument);
                    
                    // Datei verschieben um doppeltes einlesen zu vermeiden:
//                    file.renameTo(new File("E:\\xampp\\htdocs\\xml\\Alte_Dateien\\"
//                            + file.getName()));
                    
                }
                
            }
            
            // Berechnunegn für die Auswertung:
            auswertung.notendurschnitt();
            auswertung.erneuterBesuch();
            auswertung.emailangefordert();
            // Ausgabe der Auswertung:
            auswertung.auswertungergebnis();
            
            // XML Datei erzeugen:
//            XMLSchreiben xmldatei = new XMLSchreiben(auswertung.dokumente);
//            xmldatei.xmldateischreiben();
         
            // Validierung des Auswertungsdatei:
            File pfad2 = new File("E:\\xampp\\htdocs\\xml");
            File filesList2[] = pfad2.listFiles();
            for(File file2 : filesList2) {
                String dateiende = file2.getName().toLowerCase();
                if(dateiende.endsWith(".xml")) {
                    SAXParserFactory factory2 = SAXParserFactory.newInstance();
                    factory2.setValidating(true);
                    SAXParser saxParser2 = factory2.newSAXParser();
                    AuswertungHandler userhandler2 = new AuswertungHandler();
                    saxParser2.parse(file2, userhandler2);
                    
                    // Aktueles Datum und Uhrzeit ermitteln:
                    DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yy-MM-dd_HH-mm-ss");
                    String datum = dtf2.format(LocalDateTime.now());
                    
                    // Datei aus dem Ordner Aktuelle_Datei entfernen, damit nur eine vorhanden ist:
                    File pfad3 = new File("E:\\xampp\\htdocs\\xml\\Aktuelle_Datei");
                    File filesList3[] = pfad3.listFiles();
                    for(File file3 : filesList3) {
                        String dateiende3 = file3.getName().toLowerCase();
                        if(dateiende3.endsWith(".xml")) {
                        // Ordner Aktuelle Datei leeren:
                        file3.renameTo(new File("E:\\xampp\\htdocs\\xml\\Alte_Dateien\\"
                            + "auswertung_" + datum + ".xml"));
                        }
                    }
                    /*file3.getName()*/
                    // Datei verschieben um doppeltes einlesen zu vermeiden:
                    file2.renameTo(new File("E:\\xampp\\htdocs\\xml\\Aktuelle_Datei\\"
                            + file2.getName()));
                    
                }
                
            }
         
      }catch (ParserConfigurationException e) {
         System.out.println(e.toString());
      } catch (SAXException e) {
         System.out.println(e.toString());
      } catch (IOException e) {
         System.out.println(e.toString());
      }
      
   }
    
}

