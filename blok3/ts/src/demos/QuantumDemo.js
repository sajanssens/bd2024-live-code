// declaration site:
let bram = {}

bram.name = 'Bram'
bram.age = 45
bram.printName = function () {
    console.log(this.name)
}

// call site
bram.printName()

