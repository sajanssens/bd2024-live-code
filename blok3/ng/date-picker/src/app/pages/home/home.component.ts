import {Component} from '@angular/core';
import {SidebarComponent} from "../../components/sidebar/sidebar.component";
import {FormArrayDemoComponent} from "../../components/form-array-demo/form-array-demo.component";
import {UploadComponent} from "../../components/upload/upload.component";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    SidebarComponent,
    FormArrayDemoComponent,
    UploadComponent
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {

}
