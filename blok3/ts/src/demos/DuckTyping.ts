interface Person {
    name: string;
    age: number;
}

let p = {name: "Bram", age: 45}

function doSomething(p: Person) {
    console.log(p.name);
    console.log(p.age);
}

doSomething(p)