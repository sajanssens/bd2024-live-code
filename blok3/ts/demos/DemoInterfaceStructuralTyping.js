"use strict";
let inputFromBackend = JSON.parse('{"naam": "XYZ", "firstName": "Bram", "age": 45}');
// let bramToo: Person = inputFromBackend
console.log(inputFromBackend.firstName);
console.log(inputFromBackend.age);
class Human {
    constructor() {
        this.firstName = "";
        this.age = 43;
    }
    calculateAge() {
        throw new Error("Method not implemented.");
    }
}
