## Labs Jakarta EE

1. **Jakarta EE Container**
	- download OpenLiberty, bekijk de install dir	
		kies voor de kale kernel versie en bekijk de README.
		doe dan `server create`
	- maak een HelloWorld in maven en deploy en run op WLP
		- bewerk de `server.xml` van defaultServer
		- voer uit `featureUtility installServerFeatures defaultServer`
		- zet je war in de `dropins` folder
		- voer uit `server run`
	- gebruik nu de `liberty-maven-plugin` met `mvn liberty:dev`

2. **REST**
    1. Maak een nieuwe rest-app met een simpele `HelloWorldResource`:
       - maak nieuw leeg maven project
       - voeg jakarta ee 10 toe aan je pom.
       - maak één class en annoteer deze met `@ApplicationPath`
       - maak sub-packages:
           - domain
           - repositories
           - resources
       - maak je eerste resource op een uniek `@Path` met een `@GET` endpoint die `Hello World` teruggeeft.
    2. Breid je GET endpoint uit met een query parameter id: als deze negatief is, geef dan een http 400 terug.
    3. Maak je tweede resource met een GET endpoint die een List van objecten teruggeeft als JSON.
    4. Breid die resource uit met: GET met queryparam, GET met pathparam, POST, PUT en DELETE.
       - test met bijv. de Http client in IDEA of met Postman.
    5. Maak een Dao/Repo voor je objecten.
    6. Maak gebruik van sub resources: acties op één entity moeten in een aparte resource.
    7. Bouw ondersteuning in voor XML-responses.
    8. Zorg ervoor dat je JSON-array in je response een naam krijgt (zodat een client hierop kan selecteren): 
       - van unnamed `[ {..}, .. ]` naar named `{ "arraynaam": [ {..}, .. ] }`
    9. Bouw een CORS filter.
    10. Maak een filter die checkt of je ingelogd bent. Zo niet, dan geef je een `401` terug. 
        Dit kun je nabootsen door in de request een header op te nemen: `Authorization: true`.
        Dit filter moet NIET worden uitgevoerd als er `@NotSecured` boven een methode staat.
    11. Bouw JPA in.
    12. Handling errors implementeren m.b.v. exceptions en foutmeldingen.
    13. OpenApi/Swagger toevoegen.
    14. Connectedness implementeren.
    15. JWT implementeren.
    16. Integratietest maken met behulp van `test-containers`.

3. CDI (TODO)
4. EJB (TODO)
5. JMS (TODO)
