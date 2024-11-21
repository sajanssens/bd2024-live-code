import {Routes} from '@angular/router';
import {DatePickerComponent} from "./components/date-picker/date-picker.component";
import {BindingDemoComponent} from "./components/binding-demo/binding-demo.component";
import {PuzzleComponent} from "./components/puzzle/puzzle.component";
import {HomeComponent} from "./pages/home/home.component";
import {EditContactComponent} from "./components/date-picker/edit-contact/edit-contact.component";

export const routes: Routes = [
  {path: '', component: HomeComponent},
  {
    path: 'date', component: DatePickerComponent, children: [ // sub router-outlet maken in datepickercomponent
      {path: 'edit/:id', component: EditContactComponent}
    ]
  },
  {path: 'binding', component: BindingDemoComponent},
  {path: 'binding/:id', component: BindingDemoComponent},
  {path: 'puzzles', component: PuzzleComponent},

];
