<?php
echo checkPasswort();
echo checkMailbox();
echo checkRückfrage();

// Aufgabe: 5.1
echo "<h1>Auswertung | Feedback</h1>";

// Den Value aus dem entsprechenden Select auslesen:
// $_GET Übertragen über URL
// $_POST Übertragen per Formular (Der unter Value eingetragene Wert wird übertragen)
// Nicht der Anzeige Name zwischen den HTML Tags
$anrede = $_POST['anrede'];
//for($i=0; $i < strlen($anrede);$i++)
//{
//  echo $anrede[$i];
//}

$aufmerksam = $_POST['aufmerksam'];
//for($i=0; $i < strlen($aufmerksam);$i++)
//{
//  $aufmerksam[$i];
//}

// Da Checkbox prüfen ob dieses gesetzt wurde und dann den Wert entsprechend
// setzten.
if(isset($_POST["mailbox"])) {
  $mailbox = "ausgewählt";
} else {
  $mailbox = "nicht ausgewählt";
}

if(isset($_POST["rückfrage"])) {
  $rückfrage = "zur Verfügung";
} else {
  $rückfrage = "nicht zur Verfügung";
}

if(isset($_POST["besuch"])) {
  $besuch = "Ja";
} else {
  $besuch = "Nein";
}

$vorname = $_POST["vorname"];
$nachname = $_POST["nachname"];
$alter = $_POST["alter"];
$telefon = $_POST["telefon"];
$email = $_POST["email"];
$webseite = $_POST["webseite"];
$verbesserung = $_POST["verbessern"];
$passwort = $_POST["password"];

if(isset($_POST["noteInhalt"])) {
  $noteInhalt = $_POST["noteInhalt"];
} else {
  $noteInhalt = 'Leer';
}

if(isset($_POST["noteAussehen"])) {
  $noteAussehen = $_POST["noteAussehen"];
} else {
  $noteAussehen = 'Leer';
}

echo "<br>";
echo "Der Vorname war: $vorname <br><br>";
echo "Der Nachname war: $nachname <br><br>";
echo "Die Anrede war: $anrede <br><br>";
echo "Das Alter war: $alter <br><br>";
echo "Die Telefonnummer war: $telefon <br><br>";
echo "Die Emailadresse war: $email <br><br>";
echo "Die Webseite war: $webseite <br><br>";
echo "Die Checkbox Kopie an meine Emailbox senden war: $mailbox <br><br>";
echo "Sie sthen für Rückfragen: $rückfrage <br><br>";
echo "Sie werden die Webseite wieder besuchen: $besuch <br><br>";

echo "Die Aufmerksamkeit auf die Webseite wurde hervorgerufen durch: $aufmerksam <br><br>";

echo "Was Sie verbessern wollen: $verbesserung <br><br>";
echo "Note für Inhalt: $noteInhalt <br><br>";
echo "Note für das Aussehen: $noteAussehen <br><br>";
echo "Passwort: $passwort <br><br>";

// Aufgabe: 5.2
echo "<br><br>";
echo "Vielen Dank $anrede $vorname $nachname das Sie meine Webseite besucht haben. <br><br>";

// Aufruf Methoden:
echo benotungInhalt();
echo benotungAussehen();
echo datumUndUhrzeit();
echo verbesserung();

// Aufgabe: 5.3
function checkPasswort() {
  // Da die Methode am Anfnag ausgeführt wird muss hier nochmal extra das Feld
  // Passwort abgerufen werden:
  $passwort = $_POST["password"];

  // Danach prüfung des Kennworts:
  if($passwort != "Internetsprachen") {
    echo "<script>alert('Das Passwort war nicht korrekt')</script>";
  } else {
    echo "<script>alert('Das Passwort war korrekt')</script>";
  }
}

// Aufgabe: 5.4
function checkMailbox() {
  if(isset($_POST["mailbox"])) {
    $mailbox = "ausgewählt";
  } else {
    $mailbox = "nicht ausgewählt";
  }
  $email = $_POST["email"];

  if($mailbox == "ausgewählt" && strlen($email) == 0) {
    echo "<script>alert('Es wurde keine Emailadresse angegeben. Obwohl die Checkbox Kopie an meine Emailbox senden aktiviert ist.')</script>";
  }
}

// Aufgabe: 5.5
function checkRückfrage() {
  if(isset($_POST["rückfrage"])) {
    $rückfrage = "zur Verfügung";
  } else {
    $rückfrage = "nicht zur Verfügung";
  }
  $telefon = $_POST["telefon"];
  $email = $_POST["email"];
  $webseite = $_POST["webseite"];

  if($rückfrage == "zur Verfügung" && strlen($telefon) == 0 && strlen($email) == 0 && strlen($webseite) == 0) {
    echo "<script>alert('Es wurde keine Emailadresse oder Telefonnummer oder Webseite angegeben. Obwohl die Checkbox Ich stehe für evtl. Rückfragen zur Verfügung aktiviert ist.')</script>";
  }
}

// Aufgabe: 5.6
function benotungInhalt() {
  if(isset($_POST["noteInhalt"])) {
    $noteInhalt = $_POST["noteInhalt"];
    echo "<br>Benotung Inhalt: ";
  } else {
    $noteInhalt = 'Leer';
  }
  if($noteInhalt == 1 || $noteInhalt == 2) {
    echo "Ich freue mich, dass Ihnen der Inhalt der Webseite gefallen hat.<br><br>";
  } else if($noteInhalt == 3) {
    echo  "Ich werde mich bemühen in Zukunft den Inhalt der Seite zu optimieren.<br><br>";
  } else if($noteInhalt == 4) {
    echo "Ich werde versuchen den Inhalt zu verbessern.<br><br>";
  } else if($noteInhalt == 5) {
    echo "Schade das Ihnen der Inhalt nicht gefallen hat.<br><br>";
  } else if($noteInhalt == 6) {
    echo "Schade das Ihnen der Inhalt nicht gefallen hat. Ich versuche mich zu verbessern :(<br><br>";
  }
}

// Aufgabe: 5.7
function benotungAussehen() {
  if(isset($_POST["noteAussehen"])) {
    $noteAussehen = $_POST["noteAussehen"];
    echo "<br>Benotung Aussehen: ";
  } else {
    $noteAussehen = 'Leer';
  }
  if($noteAussehen == 1 || $noteAussehen == 2) {
    echo "Ich freue mich, dass Ihnen der Inhalt der Webseite gefallen hat.<br><br>";
  } else if($noteAussehen == 3) {
    echo  "Ich werde mich bemühen in Zukunft den Inhalt der Seite zu optimieren.<br><br>";
  } else if($noteAussehen == 4) {
    echo "Ich werde versuchen den Inhalt zu verbessern.<br><br>";
  } else if($noteAussehen == 5) {
    echo "Schade das Ihnen der Inhalt nicht gefallen hat.<br><br>";
  } else if($noteAussehen == 6) {
    echo "Schade das Ihnen der Inhalt nicht gefallen hat. Ich versuche mich zu verbessern :(<br><br>";
  }
}

// Aufgabe: 5.8
function datumUndUhrzeit() {
  $Datum = date('d.m.Y', time());
  $Uhrzeit = date('h:i:s', time());
  echo "<br>Ihre Feedbackwerte wurden am $Datum um $Uhrzeit Uhr angenommen.";
}

// Aufgabe: 5.9
function verbesserung() {
  $verbesserung = $_POST["verbessern"];
  if(isset($_POST["noteInhalt"])) {
    $noteInhalt = $_POST["noteInhalt"];
  } else {
    $noteInhalt = 'Leer';
  }
  if(isset($_POST["noteAussehen"])) {
    $noteAussehen = $_POST["noteAussehen"];
  } else {
    $noteAussehen = 'Leer';
  }
  if(strlen($verbesserung) != 0 && $noteInhalt > 0 && $noteAussehen > 0) {
    echo "<br><br>Danke, dass Sie sich die Zeit genommen haben und meine Webseite bewertet haben und eine Verbesserungsvorschlag gemacht haben. :)";
  }
}


// Aufgabe: 6 | XML Datei erstellen mit XMLWriter
// Bedingungen für das Erstellen der XML Datei abfragen
if($passwort == "Internetsprachen"
  && (($mailbox == "ausgewählt" && strlen($email) > 0)
    || $mailbox == "nicht ausgewählt")
  && (($rückfrage == "zur Verfügung" || strlen($telefon) > 0
    || strlen($email) > 0
    || strlen($webseite) > 0) || $rückfrage == "nicht zur Verfügung")) {

      // Sicherstelllen, dass alle Felder einen Wert besitzen:
      // Wenn nicht wird ein "-" eingefügt um Fehler bei der
      // weiteren Bearbeitung zu vermeiden.
      if(strlen($verbesserung) == 0) {
        $verbesserung = '-';
      }
      if(strlen($telefon) == 0) {
        $telefon = '-';
      }
     if(strlen($email) == 0) {
        $telefon = '-';
      }
      if(strlen($webseite) == 0) {
        $webseite = '-';
      }

// Datum und Uhrzeit bestimmen:
$Datum = date('d.m.Y', time());
$Uhrzeit = date('h:i:s', time());

// Start XMLWriter:
$xml = new XMLWriter();
$xml->openMemory();
$xml->startDocument('1.0', 'UTF-8');
$xml->writeDTD('FeedbackDaten', null, 'test.dtd');
// DTD Datei:

// FeedbackDaten
$xml->startElement('FeedbackDaten');
$xml->writeAttribute('Datum', $Datum);
$xml->writeAttribute('Uhrzeit', $Uhrzeit);

// Erstes Element Persönliche Daten
$xml->startElement('PersoenlicheDaten');
$xml->writeAttribute('id', 1);
$xml->writeAttribute('position', 'test');

// Anrede:
$xml->startElement('Anrede');
$xml->text($anrede);
$xml->endElement();

// Vorname:
$xml->startElement('Vorname');
$xml->text($vorname);
$xml->endElement();

// Nachname:
$xml->startElement('Nachname');
$xml->text($nachname);
$xml->endElement();

// Alter:
$xml->startElement('Alter');
$xml->text($alter);
$xml->endElement();

// Telefonnummer:
$xml->startElement('Telefonnummer');
$xml->text($telefon);
$xml->endElement();

// Emailadresse:
$xml->startElement('Emailadresse');
$xml->text($email);
$xml->endElement();

// Webseite:
$xml->startElement('Webseite');
$xml->text($webseite);
$xml->endElement();

// Schließen von PersönlicheDaten:
$xml->endElement();


// Erstes Element Checkboxen:
$xml->startElement('Checkboxen');
$xml->writeAttribute('id', 2);
$xml->writeAttribute('position', 'test2');

// Mailbox:
$xml->startElement('Mailbox');
$xml->text($mailbox);
$xml->endElement();

// Rückfragen:
$xml->startElement('Rueckfragen');
$xml->text($rückfrage);
$xml->endElement();

// Erneuter Besuch:
$xml->startElement('erneuterBesuch');
$xml->text($besuch);
$xml->endElement();

// Schließen von Checkboxen:
$xml->endElement();


// Erstes Element Entdeckt:
$xml->startElement('EntdecktDurch');
$xml->writeAttribute('id', 3);
$xml->writeAttribute('position', 'test3');

// Erneuter AufmerksamDurch:
$xml->startElement('AufmerksamDurch');
$xml->text($aufmerksam);
$xml->endElement();

// Schließen von Entdeckt:
$xml->endElement();


// Erstes Element Noten:
$xml->startElement('Noten');
$xml->writeAttribute('id', 4);
$xml->writeAttribute('position', 'test4');

// NoteInhalt:
$xml->startElement('NoteInhalt');
$xml->text($noteInhalt);
$xml->endElement();

// NoteAussehen:
$xml->startElement('NoteAussehen');
$xml->text($noteAussehen);
$xml->endElement();

// Schließen von Noten:
$xml->endElement();


// Erstes Element Verbesserung:
$xml->startElement('Verbesserung');
$xml->writeAttribute('id', 5);
$xml->writeAttribute('position', 'test5');

// Vorschlag:
$xml->startElement('Vorschlag');
$xml->text($verbesserung);
$xml->endElement();

// Schließen von Verbesserung:
$xml->endElement();


// Erstes Element Spamschutz:
$xml->startElement('Spamschutz');
$xml->writeAttribute('id', 6);
$xml->writeAttribute('position', 'test6');

// Vorschlag:
$xml->startElement('Passwort');
$xml->text($passwort);
$xml->endElement();

// Schließen von Passwort:
$xml->endElement();


// Schließen der FeedbackDaten:
$xml->endElement();


// Ende des Dokuments:
$xml->endDocument();



// XML Dokument erzeugen:
$datei = datumMitUhrzeit();
file_put_contents($datei, $xml->outputMemory());

}

// Funktion für Datum mit Uhrzeit:
function datumMitUhrzeit() {
  $DatumZeit = date('d.m.Y_h_i_s', time());
  $endung = '.xml';
  // Array für Dateinamen zusammensetzung:
  $var[1] = $DatumZeit;
  $var[2] = $endung;
  // Dateinamen zusammensetzten:
  $Dateiname = "$var[1]$var[2]";
  return $Dateiname;
}

?>
