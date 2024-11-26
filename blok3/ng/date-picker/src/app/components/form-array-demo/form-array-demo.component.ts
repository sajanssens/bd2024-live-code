import {Component} from '@angular/core';
import {FormArray, FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {JsonPipe} from "@angular/common";

@Component({
  selector: 'app-form-array-demo',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    JsonPipe
  ],
  templateUrl: './form-array-demo.component.html',
  styleUrl: './form-array-demo.component.scss'
})
export class FormArrayDemoComponent {
  candies: Candy[];
  candyForm: FormGroup;

  constructor() {
    this.candies = [
      {id: 1, name: 'Twix'},
      {id: 2, name: 'Skittles'},
      {id: 3, name: 'Twinkies'},
      {id: 4, name: 'Smarties'},
      {id: 5, name: 'Mars'}
    ];

    this.candyForm = new FormGroup({
      name: new FormControl(''),
      candies: new FormArray(
        this.candies.map(
          candy =>
            new FormGroup({
              like: new FormControl(false),
              name: new FormControl(candy.name),
              why: new FormControl(''),
            })
        )
      ),
    });
  }
}

interface Candy {
  id: number
  name: string
}
