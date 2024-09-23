## Mocken

- Mocken
  - als je een methode wilt testen die ook methodes van andere klasses aanroept
  - kun je alleen doen op methodes van dependencies, i.e. fields van je te testen klasse, 
      - dus niet op lokale variabelen en ook niet op static methodes
  - kan zijn dat je je code wat moet verbouwen (verbeteren!)


- In MVC heeft 
  - iedere viewklasse een controller als field
  - iedere controller een of meer dao's als field(s)
  - ieder van dit soort fields een setter
