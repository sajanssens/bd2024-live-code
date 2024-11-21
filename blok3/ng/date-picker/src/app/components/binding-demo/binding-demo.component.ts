import {Component} from '@angular/core';
import {FormsModule} from "@angular/forms";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {PuzzleService} from "../../services/puzzle.service";
import {PuzzleComponent} from "../puzzle/puzzle.component";
import {HelloPipe} from "../../pipes/hello.pipe";

@Component({
  selector: 'app-binding-demo',
  standalone: true,
  imports: [
    FormsModule,
    PuzzleComponent,
    HelloPipe
  ],
  templateUrl: './binding-demo.component.html',
  styleUrl: './binding-demo.component.scss'
})
export class BindingDemoComponent {
  nameInput = "";
  hide = false
  id = '0';

  constructor(private route: ActivatedRoute, private puzzleService: PuzzleService) {
    // static way:
    // this.id = this.route.snapshot.params['id'];

    // dynamic i.e. reactive way:
    this.route.paramMap.subscribe(
      (params) => this.id = params.get("id") ?? '0'
    );
  }

  toggleHide() {
    this.hide = !this.hide;
  }

  mustHide() {
    return this.nameInput === '' || this.hide
  }
}
