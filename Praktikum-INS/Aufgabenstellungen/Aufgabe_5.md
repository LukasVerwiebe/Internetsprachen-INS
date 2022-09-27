# Übung 5: Plausibilitätsprüfung des Feedbackformulars mit PHP

In dieser Übung sollen sie lernen mit PHP die Werte eines HTML-Formulars auszuwerten. Auch bei dieser Aufgabenstellung geht es nicht primär darum das sie das Formular perfekt oder sinnvoll auswerten. Sie sollen selbständig üben eine solche Auswertung zu realisieren. Der Programmcode soll ihren Fähigkeiten entsprechen und von Ihnen persönlich entwickelt worden sein.

Wenn sie in ihrem Feedbackformular den Absende-Button betätigen soll ihr Skript auswertung.php aufgerufen werden.


## Aufgabe 5.1
Ihr Skript soll als erstes alle Übergabeparameter (die Werte des Formulars) als HTML-Seite zurück liefern. Die soll ihnen bei der weiteren Entwicklung helfen und die Funktion soll später einfach in ihrem Quellcode deaktivierbar sein. Geben sie die Werte ungefähr so aus.

- Die Anrede war: Frau

- Der Vorname war: Liselotte

- Der Nachname war: Pulver

- Die Checkbox „Kopie an meine Mailbox senden“ war: ausgewählt.

- Die Aufmerksamkeit auf die Webseite wurde hervorgerufen durch: Zeitschrift

- Note für Inhalt: befriedigend

- Passwort: Mathematik  


## Aufgabe 5.2
Ihr Skript soll eine freundliche Antwort generieren bei der die Felder Anrede, Vorname Nachname verwendet werden.

Beispiel: Vielen Dank Frau Liselotte Pulver das Sie meine Webseite besucht haben.


## Aufgabe 5.3
Sie werten den Spamschutz/Passwort aus. Wenn der String nicht „Internetsprachen“ ist wird eine entsprechende Meldung ausgegeben und eine weitere Überprüfung der Eingabefelder wird nicht durchgeführt. Es werden keine weiteren Meldungen ausgegeben.


## Aufgabe 5.4
Sie prüfen ob die Checkbox „Kopie an meine Mailbox senden „ ausgewählt wurde. Wenn sie ausgewählt wurde, muss eine Emailadresse angeben werden. Wenn keine Emailadresse eingegeben wurde generieren sie eine Warnmeldung. Die weitere Überprüfung der Eingabefelder wird  durchgeführt.


## Aufgabe 5.5
Sie prüfen ob die Checkbox „Ich stehe für evtl. Rückfragen zur Verfügung“ ausgewählt wurde. Wenn sie ausgewählt wurde, muss entweder das Feld Telefon oder das Feld Webseite oder das Feld Emailadresse ausgefüllt sein. Ist keines der drei Felder ausgefüllt generieren sie eine Warnmeldung. Die weitere Überprüfung der Eingabefelder wird durchgeführt.


## Aufgabe 5.6
Sie werten die Note für die Inhalt aus. Wenn die Note 1 oder 2 war geben sie z.B. den Text „Ich freue mich das Ihnen der Inhalt der gefallen hat“ aus.

Bei den Wert 3 geben sie einen Text wie :“ Ich werde mich bemühen in Zukunft den Inhalt der Seite zu optimieren." aus.

Bei allen anderen Werten geben sie einen anderen Text aus.


## Aufgabe 5.7
Sie werten die Note für das Aussehen aus und generieren je nach Note unterschiedliche Ausgaben.


## Aufgabe 5.8
Bestimmen sie das aktuelle Datum und Uhrzeit und verwenden sie diese für eine Meldung wie z.B. „Ihre Feedbackwerte wurden am 11.11.2018 um 11:11 Uhr angenommen


## Aufgabe 5.9
Denken sie sich noch eine weitere mehr oder weniger sinnvolle Überprüfung aus und implementieren sie diese Überprüfung in ihrem PHP-Skript.


## Ausblick auf die Aufgaben 6,7 und 8
In dieser Übung soll das Feedback-Formular mithilfe von PHP ausgewertet bzw. überprüft werden. Bei der Überprüfung erzeugt ihr PHP-Skript eine HTML-Seite die dem Absender darüber informiert ob das Formular korrekt ausgefüllt wurde.

In Übung 6 sorgt ihr PHP-Skript dafür, das die Werte des Feedback-Formulars zusätzlich in eine XML-Datei gespeichert werden. Jedes erneute absenden des Formulars bewirkt das ihr PHP-Skript eine neue XML-Datei mit einem anderen Dateinamen erzeugt. Im laufe der Zeit werden immer mehr XML-Dateien auf ihren Webserver gespeichert.

In Übung 7 schreiben sie ein Java-Programm das nachschaut ob XML-Dateien mit den Inhalten des Feedbackformulars vorliegen. Das Programm ließt (XML-Parser) nacheinander alle XML-Dateien ein. Während des einlesen (parsen) wird die XML-Datei mit einer DTD verglichen (validiert). Das Java-Programm strukturiert dabei die Daten neu, fügt Daten hinzu oder Filtert Daten aus.

Die Daten werden anschließen in eine einzige neue XML-Datei (feedbacks.xml) gespeichert. In dieser neuen XML-Datei sind die verarbeiteten Werte aller gefundenen Feedback XML-Dateien zusammengefügt. Solch ein Java-Programm würde man regelmässig und automatisch auf dem Webserver ausführen lassen.

In Übung 8 soll ein PHP-Skript die von ihrem Java-Programm erstellte feedbacks.xml einlesen (parsen). Das PHP-Skript wird über ihre Bewerbungsseite aufgerufen. Beim parsen soll ihr PHP-Skript  eine HTML-Seite ausgeben. Auf dieser HTML-Seite werden alle Feedbacks als HTML-Tabbelle dargestellt.
