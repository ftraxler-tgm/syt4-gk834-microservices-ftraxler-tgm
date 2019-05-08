# Middleware Engineering "Microservices" - Taskdescription

## Einführung

Diese Übung soll helfen die Funktionsweise und Einsatzmöglichkeiten von Microservices in dezentralen Systemen zu verstehen. Anhand eines Tutorials wird ein Microservice implementiert, das in weiterer Folge als Erweiterung zur Übung GK8.3.1 Middleware Engineering "Document Oriented Middleware using MongoDB" eingesetzt werden soll.

Die Daten der Zentrale, die in einem NoSQL Repository gespeichert werden, sollen um
* ein User Service und
* ein Data Service

erweitert werden.


## Ziele

Das Ziel dieser Übung ist die Implementierung eines Microservices und die Einbindung in ein bestehendes Middleware-System.

## Voraussetzungen

* [GK8.3.1 Middleware Engineering "Document Oriented Middleware using MongoDB"](https://elearning.tgm.ac.at/mod/assign/view.php?id=56851)
* Grundlagen Maven oder Gradle
* [Grundlagen Spring Cloud](https://spring.io/)
* [Grundlagen zu Spring Cloud Netflix](http://cloud.spring.io/spring-cloud-static/Greenwich.SR1/multi/multi__spring_cloud_netflix.html)
* [Grundlagen Microservices](https://www.edureka.co/blog/what-is-microservices/)
* [Microservices with Spring](https://spring.io/blog/2015/07/14/microservices-with-spring)
* [Grundlagen Eureka Service](https://spring.io/guides/gs/service-registration-and-discovery/)
* [Service Registration with Eureka](https://www.tutorialspoint.com/spring_boot/spring_boot_service_registration_with_eureka.htm)


## Aufgabenstellung

Führen Sie die einzelnen Schritte des Tutorials ["Microservices with Spring"](https://spring.io/blog/2015/07/14/microservices-with-spring) durch und implementieren Sie das Beispiel zu Account Service.

Wenn das Account Service funktionsfähig ist, dann probieren Sie das Account Service in die Zentrale der Windparks einzubinden und als User Service (Firstname, Lastname, Role, Password) zu adaptieren. Entwickeln Sie danach ein weiteres Service zur Abfrage von Windkratanlagen Daten.


![Windpark - Zentrale - Microservices](resources/windpark_microservices.png)

Die Daten liegen in einem NoSQL Repository in der Zentrale vor. Eine Abfrage auf diese Daten soll durch den Einsatz von 2 Microservices umgesetzt werden:
* Abfrage, ob User im Userkatalog eingetragen ist
* Abfrage der Daten durch ein Data Service

Das Data Service soll in dieser Übung sehr einfach gestaltet werden und soll das Ergebnis der Fragestellung aus [GK8.3.1 Middleware Engineering "Document Oriented Middleware using MongoDB"](https://elearning.tgm.ac.at/mod/assign/view.php?id=56851) anzeigen.


## Bewertung
Gruppengrösse: 1 Person
### Grundanforderungen **überwiegend erfüllt**
- [x] Durchlesen des Tutorials "Micro with Spring"
- [x] Implementieren des Beispiels "Account Service"
- [x] Einzelne Schritte und Komponenten des Beispiels verstehen und im Protokoll dokumentieren
- [x] Einbindung des Account Services als "User Service" in die Übung GK8.3.1 Middleware Engineering "Document Oriented Middleware using MongoDB"
- [x] Beantwortung der Fragestellungen
### Grundanforderungen **zur Gänze erfüllt**
- [x] Implementieren eines Data Service zur Abfrage der Daten aus dem NoSQL Repository
- [x] Erstellung eines Workflows, wo zuerst das User Serive zur Prüfung der Zugangsdaten geprüft werden und danach erst die Abfrage durch das Daten Service stattfindet. Falls Prüfung des Users nicht erfolgreich ist, soll eine Fehlermeldung ausgegeben werden.


## Fragestellung für Protokoll

+ Was versteht man unter Microservices?
+ Stellen Sie anhand eines Beispiels den Einsatz von Microservices dar.
+ Wie kann man Spring Cloud nutzen und welche Tools werden dabei unterstützt?
+ Beschreiben Sie das Spring Cloud Netflix Projekt. Aus welchen Bestandteilen setzt sich dieses Projekt zusammen?
+ Wofür werden die Annotations @EnableEurekaServer und @EnableDiscoveryClient verwendet?
+ Wie werden in dem Account Service die Properties gesetzt und welche Parameter werden hier verwendet?
+ Wie funktioniert das Logging bei diesem Beispiel? Ist es möglich das Logging zu erhöhen bzw. komplett abzudrehen?
  Wenn ja, wie?

## Links und Dokumente
* [Microservices with Spring](https://spring.io/blog/2015/07/14/microservices-with-spring)
* [Microservices with Spring Boot](https://medium.com/omarelgabrys-blog/microservices-with-spring-boot-intro-to-microservices-part-1-c0d24cd422c3)
* [Eureka – Microservice-Registry mit Spring Cloud](https://www.heise.de/developer/artikel/Eureka-Microservice-Registry-mit-Spring-Cloud-2848238.html?seite=all)
* [Spring Boot Tutorial: In 10 Schritten zur Microservices-Architektur](https://jaxenter.de/spring-boot-tutorial-microservices-cloud-foundry-kubernetes-58695)
* [Introducing Spring Cloud](https://spring.io/blog/2014/06/03/introducing-spring-cloud)

