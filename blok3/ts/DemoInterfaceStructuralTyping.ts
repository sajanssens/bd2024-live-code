let inputFromBackend: PersonJson = JSON.parse('{"naam": "XYZ", "firstName": "Bram", "age": 45}')

// let bramToo: Person = inputFromBackend
console.log(inputFromBackend.firstName);
console.log(inputFromBackend.age);

interface PersonJson {
    firstName: string
    age: number
}
