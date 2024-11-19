class Persoon {

    #firstName: String;

    constructor(firstName: String, public age?: Number, public address?: String) {
        this.#firstName = firstName;
    }

    // public getFirstName(): String {
    //     return this._firstName;
    // }

    get firstName() {
        // if ... validate
        return this.#firstName;
    }

    set firstName(newName: String) {
        // if ... validate
        this.#firstName = newName;
    }

    doeiets(): String {
        return "iets"
    }

    printName(firstName = "bram", lastName: string) {
        if (lastName !== undefined) {
            console.log(`${firstName} ${lastName}`);
        } else {
            console.log(firstName);
        }
        const oneTwoThree = [1, 2, 3];
        const zeroToThree = [0, oneTwoThree];
    }
}

// Person bram   =
let bram: Persoon = new Persoon("Bram", 45)
// console.log(bram.getFirstName())
console.log(bram.firstName)
bram.firstName = "Saran"

let doeIets = () => "Iets...";
console.log(doeIets());
console.log(bram.address?.length.toString() ?? "Geen adres..." );

const f = (x: number) => x + x;
let number = f(2);

