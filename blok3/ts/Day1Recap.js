/*
    Wat is:
        Node JS
        Type inference
        String interpolation
        Structural Typing
        NPM
        De file tsconfig.json
*/
/* Hoe heten deze soorten types? En wat houden ze in?
let a: string | number
let b: [string, number, string]
let c: 42
let d: Compass = Compass.North
*/
/*
    Wat is de betekenis en de gewenste waarde van:
        noImplicitAny
        strictNullChecks
        strictPropertyInitialization
*/
/*
Hoe kun je in typescript een method overloaden?
 */
/*
    Wat betekenen de volgende begrippen:
     Rest parameters
     Spread operator
     Object destructuring
     Optional chaining
     Nullish coalescing
     Een property
*/
/* Antwoorden op de laatste vraag
// Rest parameters
function restParams(...getallen: number[]): number {
    return getallen.reduce((sum, current) => sum + current, 0)
}

let totalBowlingPins = restParams(1, 2, 3, 4)

// Spread operator
let bowling = [1, 2, 3, 4]
let totalBowlingPinsToo = restParams(...bowling);

// Object destructuring
let [lowest, , , highest] = bowling
let lowestToo = bowling[0]
let highestToo = bowling[3]

// Optional chaining
let fifth = bowling[4]?.valueOf()

// Nullish coalescing
let fifthOrElseDefault = fifth ?? -1

// Een property
class Developer {
    constructor(private _firstName: string) {

    }

    get firstName() {
        console.log("Calling getter...")
        return this._firstName
    }
}

let piet = new Developer("Piet")
console.log(piet.firstName);
*/
