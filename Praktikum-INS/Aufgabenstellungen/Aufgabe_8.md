# Übung 8: Feedbacks-XML mit PHP parsen und als HTML-Tabelle darstellen

In der Übung sieben haben sie mit Java die einzelnen Feeedbacks eingelesen und die Daten umstrukturiert und anschließend alle Feedbacks in eine gemeinsame XML-Datei gespeichert. Durch die Vorgabe einer DTD wurde erreicht das die Ausgabedatei bei allen Praktikumsteilnehmern die gleiche Struktur hat.

Das Java-Programm aus Aufgabe sieben würde man automatisch (z.B. jede Nacht, jede Stunde oder wenn ein neues Feedback gegeben wurde) ausführen lassen. Jetzt wollen sie sich das Ergebnis mit Hilfe eines Webbrowsers anzeigen lassen. Fügen sie ihrer Bewerbungs-Website den Menüpunkt Auswertung hinzu. Den Zugriff auf diese Daten würde man normalerweise durch Authentifizierung einschränken. Das Vorgehen wie man beim Apache-Webserver Authentifizierung einstellt, haben sie im INP-Praktikum gelernt, aber im Rahmen des INS-Praktikums wird auf den Einsatz von Authentifizierung verzichtet.

Beim Aufruf des Menüpunkts Auswertung soll ein PHP-Skript (feedbacks.php) aufgerufen werden. Das PHP-Skript feedbacks.php sollen sie selbständig entwickeln und folgende Funktionalität besitzen. Es wird die XML-Datei mit allen Feedbacks eingelesen und die Daten aller Feedbacks werden als HTML-Tabelle dargestellt. Die HTML-Tabelle soll durch CSS ein ansprechendes Aussehen erhalten. Verwenden sie dabei in CSS Normale-Klassen und wo es für sie sinnvoll erscheint ID-Klassen.

Es wird hier mit Absicht nicht genau spezifiziert wie die HTML-Tabelle aussehen soll oder welche Spalten in welcher Reihenfolge angezeigt werden sollen. Hierdurch soll wieder erreicht werden das jeder Teilnehmer eine eigene individuelle Lösung erarbeitet. Es wird nicht bewertet wie schön oder wie lesbar die Tabelle ist.

Hier aber ein paar Vorgaben für die Tabelle:
Die erste Zeile der Tabelle dient als Tabellenbeschreibung.
Die erste Zeile der Tabelle soll nur eine Spalte haben und den Text „Alle Feedbacks“ beinhalten.
Die Tabellenfelder der ersten Zeile haben die Hintergrundfarbe grün.
Die Schriftstärke der ersten Zeile ist fett.
Die Schriftfarbe der ersten Zeile ist weiß.

Die zweite Zeile der Tabelle dient als Spaltenüberschrift.
Die Tabellenfelder der zweiten Zeile haben die Hintergrundfarbe rot.
In der zweiten Zeile der Tabelle wird die Schrift kursiv dargestellt.

Für die folgenden Zeilen gilt:
Schriftstärke ist normal.
Die Schrift ist nicht kursiv.
Die Hintergrundfarbe der Tabellenfelder ist weiß.
Wenn eine Bewertung „mangelhaft“ oder „ungenuegend“ bzw. „5“ oder „6“ ist, dann wird die Schriftfarbe in dem entsprechenden Tabellenfeld auf rot gesetzt.


## Hinweis zum Testat:

Wie bei allen vorherigen Aufgaben gilt , das jeder Praktikumsteilnehmer eine eigene selbständig erstellte Lösung präsentiert. Beim Testat muss der Teilnehmer in der Lage sein, seine Lösung zu erläutern und selbständig  direkt in einem überschaubaren Zeitrahmen Anpassungen umzusetzen. Teamlösungen sind nicht zulässig und Aussagen wie "Den Aufgabenteil beherrsche ich nicht, weil ein anderes Teammitglied ihn erstellt hat" werden nicht akzeptiert.

Vor dem erfolgreichem Testat müssen sie zusätzlich alle ihre im Rahmen des Praktikums erstellten Dateien (.html .css .php .java) über Moodle einreichen. Die von den Teilnehmer eingereichten Lösungen werden nachträglich noch miteinander verglichen um zu überprüfen ob jeder Teilnehmer wirklich eine eigenständige Lösungen erarbeitet hat.

Wenn Kopien von Ausarbeitungen bzw Ausarbeitungen die nur modifiziert wurden, erkannt werden, wird das Praktikum für die betroffenen Teilnehmer als nicht erfolgreich gewertet.
