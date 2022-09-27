
package ins_praktikum_7_NEU;


import java.io.FileOutputStream;
import java.io.IOException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.DocumentType;

/**
 * Klasse mit der die XML Datei erzeugt wird:
 * Hier werden zunächst die Daten angepasst und dann wird schritt für Schritt
 * die XML Datei angelegt und ausgegeben.
 * @author Lukas
 */
public class XMLSchreiben {
    
    // String Werte für die XML Elemente und Attribute:
    private String sAnrede;
    private String sVorname;
    private String sNachname;
    private String sAlter;
    private String sRueckfrage;
    private String sEmailadresse;
    private String sTelefonnummer;
    private String sWebseite;
    private String sErneuterBesuch;
    private String sNoteInahlt;
    private String sNoteAussehen;
    private String sVorschlag;
    private String sEmailgesendet;
    private String sDatum;
    private String sUhrzeit;
    private String sEntwickerParser;
    
    // Liste mit den einzelnen eingelesenen XML Dateien:
    private ArrayList<ArrayList> listeDateien;
    
    // Konstruktor: Zuweisen der einzelnen XML Datein zu der Liste
    public XMLSchreiben(ArrayList<ArrayList> listeDateien) {
        this.listeDateien = listeDateien;
    }    
    
    // Festlegen der Werte durch auslesen aus der ArrayList:
    public void werteBestimmen(int position) {
        
        sVorname = listeDateien.get(position).get(3).toString();
        sNachname = listeDateien.get(position).get(4).toString();
        sAlter = listeDateien.get(position).get(5).toString();
        sTelefonnummer = listeDateien.get(position).get(6).toString();
        sEmailadresse = listeDateien.get(position).get(7).toString();
        sWebseite = listeDateien.get(position).get(8).toString();
        sEmailgesendet = listeDateien.get(position).get(9).toString();
        sVorschlag = listeDateien.get(position).get(15).toString();
        sDatum = listeDateien.get(position).get(1).toString();
        sUhrzeit = listeDateien.get(position).get(0).toString();
        
        // Ändern der Art der Anrede:
        if(listeDateien.get(position).get(2).toString().equals("Dr.")) {
            sAnrede = "Doktor";
        } else if(listeDateien.get(position).get(2).toString().equals("Prof.")) {
            sAnrede = "Professor";
        } else {
            sAnrede = listeDateien.get(position).get(2).toString();
        }
        
        // Ändern der Werte für Rückfrage:
        if(listeDateien.get(position).get(10).toString().equals("zur Verfügung")) {
            sRueckfrage = "true";
        } else {
            sRueckfrage = "false";
        }
        
        // Erneuter Besuch umstellen nach lowerCase:
        sErneuterBesuch = listeDateien.get(position).get(11).toString().toLowerCase();  
        
        // Ändern der Werte für die Note Inhalt:
        if(listeDateien.get(position).get(13).toString().equals("1")) {
            sNoteInahlt = "sehr_gut";
        } else if(listeDateien.get(position).get(13).toString().equals("2")) {
            sNoteInahlt = "gut";
        } else if(listeDateien.get(position).get(13).toString().equals("3")) {
            sNoteInahlt = "befriedigend";
        } else if(listeDateien.get(position).get(13).toString().equals("4")) {
            sNoteInahlt = "ausreichend";
        } else if(listeDateien.get(position).get(13).toString().equals("5")) {
            sNoteInahlt = "mangelhaft";
        } else if(listeDateien.get(position).get(13).toString().equals("6")) {
            sNoteInahlt = "ungenuegend";
        }
        
        sNoteAussehen = listeDateien.get(position).get(14).toString();
        
    }
    
    /**
     * Erstelleung der Elemente für die XML Datei:
     * Befüllung der Attribute und Elemente.
     */ 
    public void xmldateischreiben() throws TransformerException, ParserConfigurationException {
        try {
            /**
             * Neue Instanz für den DocumentBuilderFactory und Zuweisung 
             * zu DocumentBuilder Objekt.
             */ 
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            // Validierung durch DTD Datei anschalten:
            docFactory.setValidating(true);

            // Neues Dokument erzeugen:
            Document doc = docBuilder.newDocument();
            // root Element feedbackdatenbank:
            Element rootElement = doc.createElement("feedbackdatenbank");
            // Erster Knoten des Dokuments:
            doc.appendChild(rootElement);
            
            // Wiederholt die Elemente von feedback erstellen:
            for(int i = 0; i < listeDateien.size(); i++) {  
                // Zu beginn erst die einzelnen Werte bestimmen:(Methode aufrufen)
                werteBestimmen(i);
        
            // Element feedback:
            Element feedback = doc.createElement("feedback");
            rootElement.appendChild(feedback);
            
            // Elemente von feedback:
            Element besucher = doc.createElement("besucher");
            //besucher.setTextContent("Test");
            feedback.appendChild(besucher);
            
            // Elemente von besucher: 
            Element alter = doc.createElement("alter");
            alter.setTextContent(sAlter);
            besucher.appendChild(alter);
            
            Element kontakt = doc.createElement("kontakt");
            //kontakt.setTextContent("Test");
            besucher.appendChild(kontakt);
            
            // Attribute von Besucher:
            besucher.setAttribute("anrede", sAnrede);
            besucher.setAttribute("vorname", sVorname);
            besucher.setAttribute("nachname", sNachname);
            
            // Elemente von kontakt:
            Element emailadresse = doc.createElement("emailadresse");
            emailadresse.setTextContent(sEmailadresse);
            kontakt.appendChild(emailadresse);
            
            Element website = doc.createElement("website");
            website.setTextContent(sWebseite);
            kontakt.appendChild(website);
            
            Element telefonnummer = doc.createElement("telefonnummer");
            telefonnummer.setTextContent(sTelefonnummer);
            kontakt.appendChild(telefonnummer);
            
            // Attribute von Kontakt:
            kontakt.setAttribute("rueckfrage_erlaubt", sRueckfrage);
            
            Element bewertung = doc.createElement("bewertung");
            //bewertung.setTextContent("Test");
            feedback.appendChild(bewertung);
            
            // Elemente von bewertung:
            Element vorschlag = doc.createElement("vorschlag");
            vorschlag.setTextContent(sVorschlag);
            bewertung.appendChild(vorschlag);
            
            // Attribute bewertung:
            bewertung.setAttribute("erneuter_besuch", sErneuterBesuch);
            bewertung.setAttribute("note_inhalt", sNoteInahlt);
            bewertung.setAttribute("note_aussehen", sNoteAussehen);
                        
            Element info = doc.createElement("info");
            //info.setTextContent("Test");
            feedback.appendChild(info);
            
            // Elemente von info:
            Element email_gesendet = doc.createElement("email-gesendet");
            email_gesendet.setTextContent(sEmailgesendet);
            info.appendChild(email_gesendet);
            
            Element datumxml = doc.createElement("datum");
            datumxml.setTextContent(sDatum);
            info.appendChild(datumxml);
            
            Element uhrzeit = doc.createElement("uhrzeit");
            uhrzeit.setTextContent(sUhrzeit);
            info.appendChild(uhrzeit);
            
            } // Schleife zu ende:
        
            // Element entwicker_parser:
            Element entwicker_parser = doc.createElement("entwicker_parser");
            rootElement.appendChild(entwicker_parser);
            entwicker_parser.setTextContent(sEntwickerParser);
            

            // Aktueles Datum und Uhrzeit ermitteln:
            DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yy-MM-dd_HH-mm-ss");
            String datum = dtf2.format(LocalDateTime.now());
            
            // Die Auswertungsdaten in eine XML Datei schreiben: 
            try  (FileOutputStream output =
                        new FileOutputStream("E:\\xampp\\htdocs\\xml\\auswertung.xml")) {
                // Methode writeXml Aufrufen: übergabe Document und ausgabeort
                writeXml(doc, output);
            } catch (IOException e) {
                e.printStackTrace();
            }  
            
        } catch(Exception e) {
            System.out.println("Fehler");
        }
        
    } 
    
    /**
     * Methode zum erstellen des Fertigen XML Dokumentes und Ausgabe:
     * @param doc zu erstellendes Dokument
     * @param output  Ausgabeort
     * @throws TransformerException 
     */
    private static void writeXml(Document doc,
                                 OutputStream output)
            throws TransformerException {
        /**
         * Neue Instanz für den TransformerFactory und Zuweisung 
         * zu Transformer Objekt.
        */ 
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        // Anlegen der DOMSource mit dem übergebenen XML Dokument:
        DOMSource source = new DOMSource(doc);
        // Anlegen des StreamResult mit dem Ausgabeort:
        StreamResult result = new StreamResult(output);
        
        // Doctype einfügen: wird verwendet für den verweis auf die DTD Datei
        DOMImplementation domImpl = doc.getImplementation();
        DocumentType doctype = domImpl.createDocumentType("doctype", "test", "auswertung.dtd");
        //Transformer xformer = TransformerFactory.newInstance().newTransformer();
        // Dem angelegten Transorner den neuen DocType übergeben und diesen so anfügen:
        transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, doctype.getPublicId());
        transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, doctype.getSystemId());
        
        // Erstellung der XML Datei und Ausgabe:
        transformer.transform(source, result);

    }
}
