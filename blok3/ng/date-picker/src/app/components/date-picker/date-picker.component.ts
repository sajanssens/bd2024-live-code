import {Component} from '@angular/core';
import {FormsModule} from "@angular/forms";
import {Contact} from "../../model/Contact";
import {ContactService} from "../../services/contact.service";
import {RouterLink, RouterOutlet} from "@angular/router";
import {MatSlideToggleModule} from "@angular/material/slide-toggle";

@Component({
  selector: 'app-date-picker',
  standalone: true,
  imports: [
    FormsModule,
    RouterLink,
    RouterOutlet,
    MatSlideToggleModule
  ],
  templateUrl: './date-picker.component.html',
  styleUrl: './date-picker.component.scss'
})
export class DatePickerComponent {
  name = "world"
  contacts: Contact[];

  constructor(contactService: ContactService) {
    this.contacts = contactService.getAll()
  }

  delete(contactToDelete: Contact) {
    this.contacts.splice(this.contacts.indexOf(contactToDelete), 1);
  }
}
