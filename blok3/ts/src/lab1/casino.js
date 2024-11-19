// @ts-check
class Person {
    /**
     * @param {string} name
     */
    constructor(name) {
        this.name = name;
    }
}

class Player extends Person {
    /**
     *
     * @param {string} name
     * @param {number} chips
     */
    constructor(name, chips) {
        super(name);
        this.chips = chips;
    }

    toString() {
        return `${this.name} has ${this.chips} number of chips left`;
    }
}


class RouletteBoard {
    constructor() {
        /**
         * @type {any[]}
         */
        this.bets = [];
    }

    /**
     *
     * @param {Player} player
     * @param {number} bet
     */
    placeBetOneChip(player, bet) {
        let record = this.bets.find((r) => r.player === player && r.bet === bet);
        if (!record) {
            record = {player: player, bet: bet, numberOfChips: 0};
            this.bets.push(record);
        }
        record.numberOfChips++;
        return this;
    }

    play() {
        const winningNumber = Math.floor(Math.random() * 36)
        console.log(`The winningNumber is ${winningNumber}`);
        this.bets
            .filter(b => b.bet === winningNumber)
            .forEach(b => {
                const loot = b.numberOfChips * 10
                b.player.chips += loot
                console.log(`${b.player} wins ${loot}`)
            })

        this.bets = []
    }
}

const playerOne = new Player('Han', 46);
const playerTwo = new Player('Leia', 68);
const highestNumberOfChips = Math.max(playerOne.chips, playerTwo.chips);
console.log(highestNumberOfChips + ' is the highest number of chips');

new RouletteBoard()
    .placeBetOneChip(playerOne, 20)
    .placeBetOneChip(playerOne, 20)
    .placeBetOneChip(playerTwo, 1)
    .placeBetOneChip(playerTwo, 20)
    .placeBetOneChip(playerTwo, 6)
    .placeBetOneChip(playerTwo, 31)
    .placeBetOneChip(playerTwo, 5)
    .placeBetOneChip(playerTwo, 4)
    .play();
