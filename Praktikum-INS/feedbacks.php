<!DOCTYPE html>
<html lang="de" dir="ltr">
	<head>
		<meta charset="utf-8">
		<title>Bewerbung | Start</title>
		<link rel="stylesheet" type="text/css" href="auswertung.css">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css">
		<link rel="icon" href="bilder\ski.png">
	</head>
	<body>
    <div id="seite">
		<div id="inhalt">
		<div class="containerHead">
			<div><img src="bilder\ski2.png"></div>
			<h1>Bewerbung | Feedback Auswertung</h1>
		</div>
    <div></div>

    <?php

    $xml = new XMLReader();
    $xml->open('xml\Aktuelle_Datei\auswertung.xml');

		// Array für die jeweiligen XML Einträge:
    $members = array();

    while($xml->read()) {
      // Sammeln der Attribute von besucher:
      if($xml->nodeType == XMLREADER::ELEMENT && $xml->localName == 'besucher') {
        // Array für die Sammlung der Werte:
        $member = array();
				
        $member['vorname'] = $xml->getAttribute('vorname');
        $member['nachname'] = $xml->getAttribute('nachname');
        $member['anrede'] = $xml->getAttribute('anrede');
      }
      // Wert des Element alter:
      if($xml->nodeType == XMLREADER::ELEMENT && $xml->localName == 'alter') {
        $xml->read();
        $member['alter'] = $xml->value;
      }

      // Sammeln der Attribute von kontakt:
      if($xml->nodeType == XMLREADER::ELEMENT && $xml->localName == 'kontakt') {
        //$xml->read();
        $member['rueckfrage_erlaubt'] = $xml->getAttribute('rueckfrage_erlaubt');
      }
      // Wert des Element emailadresse:
      if($xml->nodeType == XMLREADER::ELEMENT && $xml->localName == 'emailadresse') {
        $xml->read();
        $member['emailadresse'] = $xml->value;
      }
      // Wert des Element Webseite:
      if($xml->nodeType == XMLREADER::ELEMENT && $xml->localName == 'website') {
        $xml->read();
        $member['website'] = $xml->value;
      }
      // Wert des Element telefonnumer:
      if($xml->nodeType == XMLREADER::ELEMENT && $xml->localName == 'telefonnummer') {
        $xml->read();
        $member['telefonnummer'] = $xml->value;
      }
      // Wert des Element bewertung:
      if($xml->nodeType == XMLREADER::ELEMENT && $xml->localName == 'bewertung') {
        //$xml->read();
        $member['note_inhalt'] = $xml->getAttribute('note_inhalt');
        $member['note_aussehen'] = $xml->getAttribute('note_aussehen');
        $member['erneuter_besuch'] = $xml->getAttribute('erneuter_besuch');
      }
      // Wert des Element vorschlag:
      if($xml->nodeType == XMLREADER::ELEMENT && $xml->localName == 'vorschlag') {
        $xml->read();
        $member['vorschlag'] = $xml->value;
      }
      // Wert des Element email-gesendet:
      if($xml->nodeType == XMLREADER::ELEMENT && $xml->localName == 'email-gesendet') {
        $xml->read();
        $member['email-gesendet'] = $xml->value;
      }
      // Wert des Element datum:
      if($xml->nodeType == XMLREADER::ELEMENT && $xml->localName == 'datum') {
        $xml->read();
        $member['datum'] = $xml->value;
      }
      // Wert des Element uhrzeit:
      if($xml->nodeType == XMLREADER::ELEMENT && $xml->localName == 'uhrzeit') {
        $xml->read();
        $member['uhrzeit'] = $xml->value;
        // Letztes Element: Nun das Member Array in die Collection einfügen
        $members[] = $member;
      }


    }

    echo ausgabeMembers($members);

    function ausgabeMembers($members) {
      $r = '';

      // Tabelle erstellen:
      if(count($members) > 0) {
        // Tabellen Überschriften:
				// .= setzt $r auf den Wert '<table class="table"><tr id="start">' usw.
				// äuqivalent zu $ r = $r . '<tr id="start">':
        $r .= '<table class="table">';
        $r .= '<tr id="start">';
        $r .= '<td id="startspalte" colspan="15">Alle Feedbacks</td>';
        $r .= '</tr>';
        $r .= '<tr>';
        $r .= '<th class="überschrift">Vorname</th>';
        $r .= '<th class="überschrift">Nachname</th>';
        $r .= '<th class="überschrift">Anrede</th>';
        $r .= '<th class="überschrift">Alter</th>';
        $r .= '<th class="überschrift">Rückfrage</th>';
        $r .= '<th class="überschrift">Email</th>';
        $r .= '<th class="überschrift">Webseite</th>';
        $r .= '<th class="überschrift">Telefon</th>';
        $r .= '<th class="überschrift">Note Inhalt</th>';
        $r .= '<th class="überschrift">Note Aussehen</th>';
        $r .= '<th class="überschrift">Erneuter Besuch</th>';
        $r .= '<th class="überschrift">Vorschlag</th>';
        $r .= '<th class="überschrift">Email gesendet</th>';
        $r .= '<th class="überschrift">Datum</th>';
        $r .= '<th class="überschrift">Uhrzeit</th>';
        $r .= '</tr>';

        foreach ($members as $member) {
          // Tabellen Einträge:
          $r .= '<tr>';
          $r .= '<td>' . $member['vorname'] . '</td>';
          $r .= '<td>' . $member['nachname'] . '</td>';
          $r .= '<td>' . $member['anrede'] . '</td>';
          $r .= '<td>' . $member['alter'] . '</td>';
          $r .= '<td>' . $member['rueckfrage_erlaubt'] . '</td>';
          $r .= '<td>' . $member['emailadresse'] . '</td>';
          $r .= '<td>' . $member['website'] . '</td>';
          $r .= '<td>' . $member['telefonnummer'] . '</td>';
          // Prüfen welche Note und Farbe setzten wenn nötig:
          if($member['note_inhalt'] == 'mangelhaft') {
            $r .= '<td class="benotung">' . $member['note_inhalt'] . '</td>';
          } else if($member['note_inhalt'] == 'ungenuegend'){
            $r .= '<td class="benotung">' . $member['note_inhalt'] . '</td>';
          } else {
            $r .= '<td>' . $member['note_inhalt'] . '</td>';
          }
          // Prüfen welche Note und Farbe setzten wenn nötig:
          if($member['note_aussehen'] == '5') {
            $r .= '<td class="benotung">' . $member['note_aussehen'] . '</td>';
          } else if($member['note_aussehen'] == '6') {
            $r .= '<td class="benotung">' . $member['note_aussehen'] . '</td>';
          } else {
            $r .= '<td>' . $member['note_aussehen'] . '</td>';
          }
          $r .= '<td>' . $member['erneuter_besuch'] . '</td>';
          $r .= '<td>' . $member['vorschlag'] . '</td>';
          $r .= '<td>' . $member['email-gesendet'] . '</td>';
          $r .= '<td>' . $member['datum'] . '</td>';
          $r .= '<td>' . $member['uhrzeit'] . '</td>';
          $r .= '</tr>';
        }
        $r .= '</table>';
      }
      return $r;
    }

    ?>

  </body>
</html>
