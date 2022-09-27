# Übung 7: Feedback-XML mit Java parsen

In der Übung 7 sollen sie ein Java-Programm schreiben , dass XML-Dateien einließt. Das Programm kann die eingelesen Daten verändern/anpassen/manipulieren, statistische Daten berechnen und die Daten umsortieren. Anschließend werden die angepassten Daten in eine neue XML-Datei geschrieben.

Die Daten ihres Feedbackformulars werden bei jeden absenden des Formulars, von Ihrem PHP Skript, in eine eigene XML-Datei geschrieben. Bisher wurde nicht vorgegeben welche Werte des Formulars als Element und welche als Attribute gespeichert werden. Die Namen der Elemente und Attribute wurde nicht vorgegeben. Die Reihenfolge der Werte wurde nicht vorgegeben. Aus diesem Grund ist es unwahrscheinlich das mehrere Teilnehmer die gleiche Struktur für ihre XML Dateien verwenden. Ihr Java-Programm sorgt dafür, das ihre Feedbackdateien in ein Format das für alle Teilnehmer gleich ist, konvertiert werden.


## Aufgabe 7.1
Entwickeln sie eine DTD die zu ihren XML-Dateien passt. Überprüfen sie anschließend mit einem online XML-Validator (z.B.http://www.xmlvalidation.com) ob ihre XML-Dateien zu dieser DTD „gültig“ sind. Tip: Sorgen sie dafür das ihr PHP-Skript in die XML-Datei schreibt, das eine DTD verwendet werden soll.


## Aufgabe 7.2
Sie sollen jetzt ein Java-Programm schreiben, das nacheinander alle XML-Dateien die sich in einem Verzeichnis befinden einliest. Verwenden sie zum einlesen einen XML-Parser. Beim einlesen soll die Validierung des XML-Parsers eingeschaltet sein. Das bedeutet der XML-Parser überprüft ob die XML-Datei wohl geformt und gültig zur angegebenen DTD ist. Wird eine Fehler erkannt, sorgt ihr Error-Handler dafür das eine eigene verständliche Fehlermeldung ausgegeben , das einlesen abgebrochen und das Programm beendet wird.

Aktuellen Beispielcode für die Verwendung des Xerces Sax Parsers finden sie z.B. unter https://www.tutorialspoint.com/xerces/xerces_sax_parse_document.htm


## Aufgabe 7.3
Jetzt entwickeln sie einen Eventhandler der die Werte der Elemente und Attribute verarbeitet. Die Werte alle gefunden XML-Dateien werden zuerst von dem Programm im Hauptspeicher (RAM) gehalten (Arraylist oder Hashtable oder ….).
  

## Aufgabe 7.4
Das Programm bestimmt nach (nicht während des Parsen) dem einlesen einige statische Daten und gibt sie aus.
Bestimmen sie den Durchschnitt für die Note Layout.
Bestimmen sie wie viel Prozent der Personen beabsichtigen ihre Website erneut zu Besuchen.
Bestimmen sie die Anzahl der Besucher an die eine Email gesendet werden sollte
   

## Aufgabe 7.5
Nachdem die Statistiken ausgeben wurden sollen jetzt die Werte alle Formulare in eine XML-Datei geschrieben werden. Das bedeutet, in dieser Datei sind nicht nur die Werte eines Formulars, sondern von allen bisher abgesendeten Formularen enthalten. Diesmal wird Ihnen für die Ausgabedatei eine DTD vorgegeben. Das bedeutet die Namen der Attribute und Elemente sind festgelegt. Es ist festgelegt welche Werte als Attribut und welche als Element geschrieben werden. Die Reihenfolge der Elemente/Attribute ist vorgegeben. Es ist festgelegt welche Elemente/Attribute vorhanden sein müssen und welche optional sind. Es ist teilweise vorgegeben welche Werte für Attribute erlaubt sind

Beispiele:
- Für eine Checkbox: nicht true/false ; nicht 1/0 ; erlaubt ja/nein
- Für die Anrede: nicht Dr. ; nicht Prof. ; erlaubt Doktor , erlaubt Professor.
- Für Note Inhalt: erlaubt sind sehr_gut|gut|befriedigend|ausreichend|ungenuegend|mangelhaft
- Für Note Aussehen: 1|2|3|4|5|6
- Aus diesem Grund muss ihr Java-Programm (nicht das HTML-Formular, nicht das PHP-Skrip) Werte anpassen. Wenn sie bisher für die Note Inhalt Zahlenwerte verwenden muss ihr Programm diese Werte in die entsprechenden Zeichenfolgen
- sehr_gut|gut|befriedigend|ausreichend|mangelhaft|ungenuegend umsetzen.
- Wenn sie bisher für die Checkox "Seite erneut besuchen" z.B. die Werte true/false verwendet haben, dann müssen sie diese jetzt in die Werte ja/nein überführen.

DTD-für Ausgabedatei

<!ELEMENT feedbackdatenbank (feedback*, entwicker_parser)>
<!ELEMENT feedback (besucher,bewertung,info)>
<!ELEMENT besucher (alter,kontakt)>
<!ATTLIST besucher
anrede (Herr|Frau|Doktor|Professor) #IMPLIED
vorname CDATA #REQUIRED
nachname CDATA #REQUIRED
>
<!ELEMENT kontakt (emailadresse?,website?,telefonnummer?)>
<!ATTLIST kontakt
rueckfrage_erlaubt (true|false) #IMPLIED
>
<!ELEMENT alter (#PCDATA)>
<!ELEMENT emailadresse (#PCDATA)>
<!ELEMENT telefonnummer (#PCDATA)>
<!ELEMENT website (#PCDATA)>
<!ELEMENT bewertung (vorschlag?)>
<!ATTLIST bewertung
erneuter_besuch (ja|nein) "ja"
note_inhalt (sehr_gut|gut|befriedigend|ausreichend|mangelhaft|ungenuegend) #IMPLIED
note_aussehen (1|2|3|4|5|6) #IMPLIED
>
<!ELEMENT vorschlag (#PCDATA)>
<!ELEMENT info (email-gesendet?,datum,uhrzeit)>
<!ELEMENT email-gesendet (#PCDATA)>
<!ELEMENT datum (#PCDATA)>
<!ELEMENT uhrzeit (#PCDATA)>
<!ELEMENT entwicker_parser (#PCDATA)>


## Aufgabe 7.6
Wahrscheinlich werden sie zum schreiben der XML-Datei eine Bibliothek verwenden, die nicht in der Lage ist, eine DTD zu berücksichtigen. Das bedeutet beim schreiben wird die Gültigkeit und vielleicht auch die Wohlgeformtheit nicht überprüft.

Überprüfen sie mit einem online XML-Validator (z.B.http://www.xmlvalidation.com) die Gültigkeit der Ausgabedatei zur vorgegebenen DTD.


## Aufgabe 7.7
Ihr Java-Programm soll jetzt automatisch nach dem schreiben der Ausgabedatei, diese erneut mit einem XML-Parser einlesen und validieren. Sie müssen keinen Eventhandler realisieren sondern nur den Error-Handler implementieren.
