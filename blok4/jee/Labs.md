## Labs Jakarta EE

1. **Jakarta EE Container**
	- download OpenLiberty en bekijk de install dir	
		- kies voor de kale kernel versie en bekijk de README.
		- doe dan `server create`
	- maak een HelloWorld webapp in maven en deploy en run op OpenLiberty
		- bewerk de `server.xml` van defaultServer om de juiste features toe te voegen
          - in dit geval hebben we in elk geval de volgende spec nodig: Jakarta Servlet
          - kijk hier voor de bijbehorende feature(s): https://openliberty.io/docs/latest/reference/feature/feature-overview.html
          - afhankelijk van wat je app nog meer doet, heb je extra specs en features nodig 
		- voer uit `featureUtility installServerFeatures defaultServer`
          - Opmerking: mogelijk moet je nog een artifact repository instellen als je niet bij maven central mag:
            - Maak bestand: `wlp\etc\featureUtility.properties`
            - Zet deze regel in dat bestand: \
              `mavenCentralMirror.url=https://nexus.belastingdienst.nl/nexus/repository/repo`
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
    4. OpenApi/Swagger toevoegen.
    5. Breid die resource uit met: GET met queryparam, GET met pathparam, POST, PUT en DELETE.
       - test met bijv. de Http client in IDEA of met Postman.
    6. Maak een Dao/Repo voor je objecten.
    7. Bouw JPA in.
    8. Maak gebruik van sub resources: acties op één entity moeten in een aparte resource.
    9. Bouw een CORS filter.
    10. Zorg ervoor dat je JSON-array in je response een naam krijgt (zodat een client hierop kan selecteren): 
        - van unnamed `[ {..}, .. ]` naar named `{ "arraynaam": [ {..}, .. ] }`
    11. Handling errors implementeren m.b.v. exceptions en foutmeldingen.
    12. Connectedness implementeren.
    13. Integratietest maken met behulp van `test-containers`.


3. REST security

| # | Task                          | Zie bd2024-live-code-maart                          |
|---|-------------------------------|-----------------------------------------------------|
| 1 | Login pagina in Angular maken | blok3/ng/baseball-quiz/../login-component/*         |
| 2 | Login endpoint in backend     | blok4/baseball-quiz/...../resources/UsersResource   |
| 3 | JWT toevoegen - backend       | blok4/baseball-quiz/...../resources/UsersResource   |
| 4 | JWT toevoegen - frontend      | blok3/ng/baseball-quiz/../services/user.service.ts  |
| 5 | JWT meesturen vanuit frontend | blok3/ng/baseball-quiz/../guards/jwt.interceptor.ts |
| 6 | AuthFilter toevoegen          | blok4/baseball-quiz/...../util/AuthFilter           |

3. CDI (TODO)
4. EJB (TODO)
5. JMS (TODO)
