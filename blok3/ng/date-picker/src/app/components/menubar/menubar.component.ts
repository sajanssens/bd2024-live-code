import { Component } from '@angular/core';
import {RouterLink} from "@angular/router";
import {MatButtonToggleModule} from "@angular/material/button-toggle";
import {MatMenuModule} from "@angular/material/menu";

@Component({
  selector: 'app-menubar',
  standalone: true,
  imports: [
    RouterLink,
    MatButtonToggleModule,
    MatMenuModule
  ],
  templateUrl: './menubar.component.html',
  styleUrl: './menubar.component.scss'
})
export class MenubarComponent {

}
