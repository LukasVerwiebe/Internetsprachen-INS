# Übung 4: Feedback-Formular

Erweitern sie ihre Bewerbungswebsite um ein Feebackformular. Über dieses Formular kann ein Besucher ihre Bewerbungswebsite bewerten.

Obwohl die folgende Beschreibung recht Umfangreich ist, ist doch sehr viel Spielraum für die Gestaltung der Seite vorhanden. Bei der Realisierung dieser Seite gibt es kein richtiges oder falsches Aussehen, die unter beschriebenen Elemente sollen aber mindesten enthalten sein. 

Es wird erwartet das jeder Teilnehmer eine anders gestaltete Webseite präsentieren kann. Wie bei den vorhergehenden Aufgaben gilt, das keine Teamlösungen erlaubt sind.  Bevor sie Ihre Feedbackformular später im Testat präsentieren überprüfen sie ihren HTML-Code und die CSS-Datei über einem HTML-Validator z.B. http://validator.w3.org/

Alle Style-Anweisungen erfolgen über eine CSS-Datei.


## Das Formular besteht aus folgenden Elementen

- Dropdownliste als Anrede mit den Einträgen Herr/Frau/Dr./Prof.

- Eingabefeld für den Vorname. Dieses Feld muss ausgefüllt werden und Überprüfung erfolgt durch HTML/Browser. Diese Feld erhält beim laden des Formulars automatisch den Focus. Bei diesem Eingabefeld ist die Funktion autocomplete aktiviert.

- Eingabefeld für den Nachname. Dieses Feld muss ausgefüllt werden und Überprüfung erfolgt durch HTML/Browser. Bei diesem Eingabefeld ist die Funktion autocomplete aktiviert.  

- Checkbox mit Label „Kopie an meine Mailbox senden“ 

- Eingabefeld für eine Emailadresse vom Typ Email. Dieses Feld kann ausgefüllt werden. Die Syntaxprüfung erfolgt durch HTML/Browser. Das Eingabefeld verwendet den Platzthalter mit dem Text "Emailadresse eingeben"  

- Checkbox mit Label „Ich stehe für evtl. Rückfragen zur Verfügung.“ 

- Eingabefeld Telefonnummer. Dieses Feld kann ausgefüllt werden.

- Eingabefeld für eine URL/Website. Dieses Feld kann ausgefüllt werden. Die Syntaxprüfung erfolgt durch HTML/Browser 

- Eingabefeld vom Typ number für das Alter des Besuchers . Eine Auswahl im Bereich von 18 bis 99 ist möglich. Vorbelegt ist der Wert 21. 

- Checkbox mit Label „Ich werde die Seite wieder besuchen“ 

- Mehrzeiliges Textfeld mit Label „Was würden Sie verbessern?“ 

- Dropdownliste mit dem Label " Wie sind Sie auf diese Bewerbungsseite aufmerksam geworden?

- Die Dropdownliste bietet folgende Auswahl an.

   -- Bitte wählen --
      Allgemein
            Zufall
            Freunde/Bekannte
            Präsentation/Vortrag
            Frühere Nutzung
   Internet-Angebote
            Newsletter anderer Seiten
            Suchmaschine
            Linkliste
            Forum/Gästebuch-Eintrag
            Kostenlos/Gratis-Seite
   Medien
            Zeitung
            Zeitschrift
            Radio
            Fernsehen 

- Eine Gruppe von sechs Radiobuttons mit dem Label "Welche Note würdest du allgemein dem Inhalt geben? (1 = sehr gut, 6 = ungenügend)"

- Eine weitere Gruppe von sechs Radiobuttons mit dem Label "Welche Note würdest du allgemein dem Aussehen geben?  (1 = sehr gut, 6 = ungenügend)"
    
- Passwortfeld mit Label „Passwort- / Spamschutz: Bitte gib Internetsprachen ein“

- Submit-Button

- Reset-Button


## Ausblick auf die Übungen 5,6,7,8

In Übung 5 soll das Feedback-Formular mithilfe von PHP ausgewertet bzw. überprüft werden. Bei der Überprüfung erzeugt ihr PHP-Skript eine HTML-Seite die dem Absender darüber informiert ob das Formular korrekt ausgefüllt wurde.

In Übung 6 sorgt ihr PHP-Skript dafür, das die Werte des Feedback-Formulars zusätzlich in eine XML-Datei gespeichert werden. Jedes erneute absenden des Formulars bewirkt das ihr PHP-Skript eine neue XML-Datei mit einem anderen Dateinamen erzeugt. Im laufe der Zeit werden immer mehr XML-Dateien auf ihren Webserver gespeichert.

In Übung 7 schreiben sie ein Java-Programm das nachschaut ob XML-Dateien mit den Inhalten des Feedbackformulars vorliegen. Das Programm ließt (XML-Parser) nacheinander alle XML-Dateien ein. Während des einlesen (parsen) wird die XML-Datei mit einer DTD verglichen (validiert). Das Java-Programm strukturiert dabei die Daten neu, fügt Daten hinzu oder Filtert Daten aus. Die Daten werden anschließen in eine einzige neue XML-Datei (feedbacks.xml) gespeichert. In dieser neuen XML-Datei sind die verarbeiteten Werte aller gefundenen Feedback XML-Dateien zusammengefügt. Solch ein Java-Programm würde man regellmäßig und automatisch auf dem Webserver ausführen lassen.

In Übung 8 soll ein PHP-Skript die von ihrem Java-Programm erstellte feedbacks.xml einlesen (parsen). Dises PHP-Skript wird über ihre Bewerbungsseite aufgerufen. Beim parsen soll ihr PHP-Skript  eine HTML-Seite ausgeben. Auf dieser HTML-Seite werden alle Feedbacks als HTML-Tabbelle dargestellt.
