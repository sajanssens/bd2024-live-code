import {Component} from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {Contact} from "./model/Contact";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
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
