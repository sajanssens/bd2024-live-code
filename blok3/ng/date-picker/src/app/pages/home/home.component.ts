import {Component} from '@angular/core';
import {SidebarComponent} from "../../components/sidebar/sidebar.component";
import {FormArrayDemoComponent} from "../../components/form-array-demo/form-array-demo.component";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    SidebarComponent,
    FormArrayDemoComponent
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {

}
