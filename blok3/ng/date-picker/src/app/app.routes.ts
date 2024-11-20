import {Routes} from '@angular/router';
import {DatePickerComponent} from "./components/date-picker/date-picker.component";
import {BindingDemoComponent} from "./components/binding-demo/binding-demo.component";

export const routes: Routes = [
  {path: '', component: DatePickerComponent},
  {path: 'date', component: DatePickerComponent},
  {path: 'binding', component: BindingDemoComponent}
];
