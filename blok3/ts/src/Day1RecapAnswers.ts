/*
    Wat is:
        Node JS
        Type inference
        String interpolation
        Structural Typing
        NPM
        De file tsconfig.json
*/
/* Antwoorden
// Type inference
import {Compass} from "./Day1";
import {Compass as C2} from "./Day1-too";

let i = 42

// String interpolation
let inter = `Interpolated with a variable: ${i}`

// Structural Typing a.k.a. Duck Typing
//   If it walks like a duck, it quacks like duck, then... it's probably a duck.
//   We watch the shape of an OBJECT, if we recognise it as something, then we guess that's probably the type.

// NPM
//   Node Package Manager: package.json

// De file tsconfig.json configureert de tsc (transpiler!!).
*/

/* Hoe heten deze soorten types? En wat houden ze in? Antwoorden:
let a: number | string
// union type

let b: [string, number, string]
// b = ["", 42, "iets"] // tuple

let c: 42
// Literal type
// c = 42, iets anders mag er niet in!

let d: Compass = Compass.North
// enum
*/

/*
    Wat is de betekenis en de gewenste waarde van:
        noImplicitAny
        strictNullChecks
        strictPropertyInitialization
// noImplicitAny=true: je MOET een type aangeven (mag ook any zijn, liever niet)
//      function sum(i, j){..} mag dan niet

// strictNullChecks=true:
//      een variabele/const dat een type heeft, en dat heeft 'ie, MOET dan ook een waarde krijgen, en mag niet NULL worden.
//      Dus types zijn NOT nullable.
//      Als je wilt uitzonderen, mag dat via EenType | undefined | null,
//      bijv. private echtgenoot_e: Partner | undefined

// strictPropertyInitialization=true
//      Verplicht dat alle fields van een object een waarde hebben, mogen niet leeg blijven.
*/

/*
   Hoe kun je in typescript een method overloaden?
   // Standaard kan dit niet; je kunt hetzelfde bereiken m.b.v. optionele parameters.
class Person {

    loop(x?: number, y?: number) {

    }
}
 */

/*
    Wat betekenen de volgende begrippen:
     Rest parameters
     Spread operator
     Object destructuring
     Optional chaining
     Nullish coalescing
     Een property van een class
*/
/* Antwoorden

// Rest parameters
function restParams(...getallen: number[]): number {
    return getallen.reduce((sum, current) => sum + current, 0)
}

let totalBowlingPins = restParams(1, 2, 3, 4)

// Spread operator
let bowling = [1, 2, 3, 4]
let totalBowlingPinsToo = restParams(...bowling);

// Object destructuring
let [lowest, _, highest] = bowling
let lowestToo = bowling[0]
let highestToo = bowling[bowling.length - 1]

// Optional chaining is deze operator: ?.
// Dit is null safe aanroepen.

// Nullish coalescing is deze operator: ??
// Vaak gecombineerd met ?., dat geeft een default waarde als ?. niet kan.

// Een property van een class
// I.p.v. een getter aanroepen mag je de naam van het field gebruiken op het object.
// let p = new Dev("Jan")
// p.name is dan syntactic sugar voor p.getName()
// Hoe maak je dit?
class Dev {

    // fields
    #name: String

    constructor(name: String) {
        this.#name = name
    }

    // getters and setters
    get name() {
        return this.#name
    }

    set name(n: String) {
        if (n.length < 100)
            this.#name = n
    }
}

let p = new Dev("Jan")
// console.log(p.getName());
console.log(p.name);
p.name = "Bram"
p.name = "BramBramBramBramBramBramBramBramBramBramBramBramBramBramBramBram"
*/
