
package ins_praktikum_7_NEU;

import java.util.ArrayList;

/**
 *
 * @author Lukas
 */
public class Auswertungen {
    
    // Variablen für die Audgabewerte:
    private double durchschnitt = 0.0;
    private double besuch = 0;
    private int email = 0;    
    // Liste mit den Informationen der einzelnen XML Dateien:
    public ArrayList<ArrayList> dokumente = new ArrayList<ArrayList>();
    // Arrays in denen die Werte nacheinander eingelesen werden:
    private int[] notendurchschnitt;
    private String[] erneuteBesucher;
    private String[] emailangefordert;
    
    /**
     * Berechnung des Notenduchschnitts:
     */
    public void notendurschnitt() {
        try {
            // Festlegung der Größe des Arrays:
            notendurchschnitt = new int[dokumente.size()];
            double ergebnis = 0.0;        
            for(int i = 0; i < dokumente.size(); i++) {
                if(!dokumente.get(i).get(14).toString().equals("Leer")) {
                    notendurchschnitt[i] = Integer.parseInt(dokumente.get(i).get(14).toString());  
                }
            }
            // Durchschnitt berechnen:
            int laenge = notendurchschnitt.length;        
            int summe = 0;
            for(int i = 0; i < notendurchschnitt.length; i++) {
                summe = summe + notendurchschnitt[i];
            }        
            ergebnis = summe / laenge;        
            durchschnitt = ergebnis; 
        } catch(ArithmeticException e) {
            System.out.println("Es sind keine Dateien in dem Verzeichnis vorhanden!");
        }   
    }
    
    /**
     * Berechnung des Prozentwertes der Persoenen, die die Webseite erneut
     * besuchen wollen.
     */
    public void erneuterBesuch() {
        try {
            // Festlegung der Größe des Arrays:
            erneuteBesucher = new String[dokumente.size()];
            double ergebnis = 0.0;        
            for(int i = 0; i < dokumente.size(); i++) {
                erneuteBesucher[i] = dokumente.get(i).get(11).toString();            
            }
            // Anzahl erneuter Besuch berechnen:  
            for(int i = 0; i < erneuteBesucher.length; i++) {
                if(erneuteBesucher[i].toLowerCase().equals("ja")) {
                   ergebnis = ergebnis + 1; 
                }
            }
            // Berechnung des Prozentwertes:
            besuch = (int)(ergebnis / erneuteBesucher.length * 100.0); 
        } catch(Exception e) {
            System.out.println("Es sind keine Dateien in dem Verzeichnis vorhanden!");
        } 
    }
    
    /**
     * Berechnung der Anzahl der Personen die eine Email angefordert haben:
     */
    public void emailangefordert() {
        try {
            // Festlegung der Größe des Arrays:
            emailangefordert = new String[dokumente.size()];
            int ergebnis = 0;        
            for(int i = 0; i < dokumente.size(); i++) {
                emailangefordert[i] = dokumente.get(i).get(9).toString();            
            }
            // Anzahl erneuter Besuch berechnen:  
            for(int i = 0; i < emailangefordert.length; i++) {
                if(emailangefordert[i].toLowerCase().equals("ausgewählt")) {
                   ergebnis = ergebnis + 1; 
                }
            }      
            email = ergebnis; 
        } catch(Exception e) {
            System.out.println("Es sind keine Dateien in dem Verzeichnis vorhanden!");
        }
    }
    
    /**
     * Ausgabe der berechneten Werte:
     */
    public void auswertungergebnis() {
        System.out.println("-------------------------------------------");
        System.out.println("## Ergebnisse der Auswertungen ##");
        System.out.println("Durchschnitt für die Note Layout: " + durchschnitt);
        System.out.println("Prozentanteil erneuter Besuch: " + besuch + " %");
        System.out.println("Anzahl Email angefordert: " + email);
        System.out.println("-------------------------------------------");
    }
    
}
