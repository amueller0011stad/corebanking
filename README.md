# Beispielapplikation f&uuml;r ein REST-Projekt mit Jersey, Jetty and Gradle

### Voraussetzungen
- [JDK 1.8]
- [Eclipse Neon]

### Starten der Anwendung

 - Download/clone.
 - Im Eclipse: Import as Gradle Project
 - DB Setup -> siehe unten
 - bei den Gradle-Tasks gretty -> appRun/appStart aufrufen
 - im Browser dann 
    - http://localhost:8080/corebanking/corebanking/banks/list Liste aller Banken
    Beispieloutput: [{"id":1,"bankNumber":3321,"description":"Demo","serverAdress":"localhost"}]
 - f√ºr ein create: curl -H "Content-Type: application/json" -X PUT -d '{"bankNumber":3321,"description":"Demo","serverAdress":"localhost"}' http://localhost:8080/corebanking/corebanking/banks/create
 - Zum Debuggen appRunDebug w‰hlen und einen Remotedebugger auf Port 5005 starten

### Gradle Tasks f&uuml;r den DB-Setup
 - derbyStart: Startet derby
 - derbyCreateDb: legt die Datenbank an die wir benutzen, muss nur einmal aufgerufen werden
 - flywayMigrate: legt die Datenbanktabellen an, muss nur einmal aufgerufen werden

### Erweiterungsm&ouml;glichkeiten:
 - REST-Api mit Swagger beschreiben
 - Weitere Zugriffsmethode (Delete, Update, Get by Id, ...)
 - Jetty Plugin ersetzen durch gretty
 . Gradle nimmt zu bauen die Java-Version mit der Eclipse gestartet wurde. Das finde ich suboptimal
 - Andere DB-Zufgriffsm√∂gichkeiten demonstrieren (Named Querys, JPQL, ...)
 - ....
 
### Jersey 
0. Wird nicht mehr benˆtigt.
1. jersey-bundle-1.8.jar
2. Ben√∂tigt wird org.json.jar

### Postman
* Postman Chrome Plugin installieren
* Collection aus Ordner postman/ importieren
* Vorhandene Request zum Testen der Api verwenden
