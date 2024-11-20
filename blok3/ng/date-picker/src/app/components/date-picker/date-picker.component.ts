import {Component} from '@angular/core';
import {FormsModule} from "@angular/forms";
import {Contact} from "../../model/Contact";

@Component({
  selector: 'app-date-picker',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './date-picker.component.html',
  styleUrl: './date-picker.component.scss'
})
export class DatePickerComponent {
  name = "world"

  contacts: Contact[] = [
    {id: 4, firstName: 'Sam', surname: 'Smith', email: 'sam.smith@music.com'},
    {id: 8, firstName: 'Frank', surname: 'Muscles', email: 'frank@muscles.com'},
    {id: 15, firstName: 'Eddy', surname: 'Valentino', email: 'eddy@valfam.co.uk'},
  ];

  delete(contactToDelete: Contact) {
    this.contacts.splice(this.contacts.indexOf(contactToDelete), 1);
  }
}
