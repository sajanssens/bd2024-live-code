import {Component} from '@angular/core';
import {DatePickerComponent} from "./components/date-picker/date-picker.component";
import {BindingDemoComponent} from "./components/binding-demo/binding-demo.component";
import {MenubarComponent} from "./components/menubar/menubar.component";
import {RouterOutlet} from "@angular/router";
import {MatSlideToggleModule} from "@angular/material/slide-toggle";
import {MatBadgeModule} from "@angular/material/badge";
import {SidebarComponent} from "./components/sidebar/sidebar.component";

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html',
  imports: [
    DatePickerComponent,
    BindingDemoComponent,
    MenubarComponent,
    RouterOutlet,
    MatSlideToggleModule,
    MatBadgeModule,
    SidebarComponent
  ],
  styleUrl: './app.component.scss'
})
export class AppComponent {


}
