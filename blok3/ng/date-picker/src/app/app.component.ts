import {Component} from '@angular/core';
import {DatePickerComponent} from "./components/date-picker/date-picker.component";
import {BindingDemoComponent} from "./components/binding-demo/binding-demo.component";
import {MenubarComponent} from "./components/menubar/menubar.component";
import {RouterOutlet} from "@angular/router";

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html',
  imports: [
    DatePickerComponent,
    BindingDemoComponent,
    MenubarComponent,
    RouterOutlet
  ],
  styleUrl: './app.component.scss'
})
export class AppComponent {


}
