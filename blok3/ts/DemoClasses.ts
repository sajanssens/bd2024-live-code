class Persoon {

    #firstName: String;

    constructor(firstName: String, public age: Number) {
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
}

// Person bram   =
let bram: Persoon = new Persoon("Bram", 45)
// console.log(bram.getFirstName())
console.log(bram.firstName)
bram.firstName = "Saran"
