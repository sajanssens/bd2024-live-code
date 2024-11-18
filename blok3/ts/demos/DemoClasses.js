"use strict";
var __classPrivateFieldSet = (this && this.__classPrivateFieldSet) || function (receiver, state, value, kind, f) {
    if (kind === "m") throw new TypeError("Private method is not writable");
    if (kind === "a" && !f) throw new TypeError("Private accessor was defined without a setter");
    if (typeof state === "function" ? receiver !== state || !f : !state.has(receiver)) throw new TypeError("Cannot write private member to an object whose class did not declare it");
    return (kind === "a" ? f.call(receiver, value) : f ? f.value = value : state.set(receiver, value)), value;
};
var __classPrivateFieldGet = (this && this.__classPrivateFieldGet) || function (receiver, state, kind, f) {
    if (kind === "a" && !f) throw new TypeError("Private accessor was defined without a getter");
    if (typeof state === "function" ? receiver !== state || !f : !state.has(receiver)) throw new TypeError("Cannot read private member from an object whose class did not declare it");
    return kind === "m" ? f : kind === "a" ? f.call(receiver) : f ? f.value : state.get(receiver);
};
var _a, _b;
var _Persoon_firstName;
class Persoon {
    constructor(firstName, age, address) {
        this.age = age;
        this.address = address;
        _Persoon_firstName.set(this, void 0);
        __classPrivateFieldSet(this, _Persoon_firstName, firstName, "f");
    }
    // public getFirstName(): String {
    //     return this._firstName;
    // }
    get firstName() {
        // if ... validate
        return __classPrivateFieldGet(this, _Persoon_firstName, "f");
    }
    set firstName(newName) {
        // if ... validate
        __classPrivateFieldSet(this, _Persoon_firstName, newName, "f");
    }
    doeiets() {
        return "iets";
    }
    printName(firstName = "bram", lastName) {
        if (lastName !== undefined) {
            console.log(`${firstName} ${lastName}`);
        }
        else {
            console.log(firstName);
        }
        const oneTwoThree = [1, 2, 3];
        const zeroToThree = [0, oneTwoThree];
    }
}
_Persoon_firstName = new WeakMap();
// Person bram   =
let bram = new Persoon("Bram", 45);
// console.log(bram.getFirstName())
console.log(bram.firstName);
bram.firstName = "Saran";
let doeIets = () => "Iets...";
console.log(doeIets());
console.log((_b = (_a = bram.address) === null || _a === void 0 ? void 0 : _a.length.toString()) !== null && _b !== void 0 ? _b : "Geen adres...");
const f = (x) => x + x;
let number = f(2);
