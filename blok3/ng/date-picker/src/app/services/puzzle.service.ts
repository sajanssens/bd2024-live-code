import {Injectable} from '@angular/core';
import {Puzzle} from "../model/Puzzle";

@Injectable({
  providedIn: 'root'
})
export class PuzzleService {

  private puzzles: Puzzle[] = [
    {id: 1, vraag: "Wat is 1+1?", antwoord: "2"},
    {id: 2, vraag: "Wat is 1+2?", antwoord: "2"},
    {id: 3, vraag: "Welk jaar is het nu?", antwoord: "2024"},
    {id: 3, vraag: "Wat is de waarde van PI?", antwoord: "3.14159265"},
    {id: 4, vraag: "Wat is het antwoord?", antwoord: "42"}
  ]

  getAll() {
    return this.puzzles
  }


}
