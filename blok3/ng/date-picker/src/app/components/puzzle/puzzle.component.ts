import {Component} from '@angular/core';
import {Puzzle} from "../../model/Puzzle";
import {Router} from "@angular/router";
import {PuzzleService} from "../../services/puzzle.service";

@Component({
  selector: 'app-puzzle',
  standalone: true,
  imports: [],
  templateUrl: './puzzle.component.html',
  styleUrl: './puzzle.component.scss'
})
export class PuzzleComponent {
  puzzles: Puzzle[];

  constructor(private puzzleService: PuzzleService, private router: Router) {
    this.puzzles = this.puzzleService.getAll();
  }

  home() {
    this.router.navigate([''])
  }
}
