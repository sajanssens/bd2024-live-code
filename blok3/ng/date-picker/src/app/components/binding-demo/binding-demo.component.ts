import {Component} from '@angular/core';
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-binding-demo',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './binding-demo.component.html',
  styleUrl: './binding-demo.component.scss'
})
export class BindingDemoComponent {
  nameInput = "";
  hide = false

  toggleHide() {
    this.hide = !this.hide;
  }
}
