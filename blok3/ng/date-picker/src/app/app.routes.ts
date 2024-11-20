import {Routes} from '@angular/router';
import {DatePickerComponent} from "./components/date-picker/date-picker.component";
import {BindingDemoComponent} from "./components/binding-demo/binding-demo.component";
import {PuzzleComponent} from "./components/puzzle/puzzle.component";

export const routes: Routes = [
  {path: '', component: DatePickerComponent},
  {
    path: 'date', component: DatePickerComponent,
    children: [
      {path: 'subbinding/:id', component: BindingDemoComponent}
    ]
  },
  {path: 'binding', component: BindingDemoComponent},
  {path: 'binding/:id', component: BindingDemoComponent},
  {path: 'puzzles', component: PuzzleComponent},

];
