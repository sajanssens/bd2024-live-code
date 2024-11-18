let inputFromBackend: PersonJson = JSON.parse('{"naam": "XYZ", "firstName": "Bram", "age": 45}')

// let bramToo: Person = inputFromBackend
console.log(inputFromBackend.firstName);
console.log(inputFromBackend.age);

interface PersonJson {
    firstName: string
    age: number

    calculateAge(): number
}

class Human implements PersonJson {
    firstName: string = "";
    age: number = 43;

    calculateAge(): number {
        throw new Error("Method not implemented.");
    }

}
