import {Component} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {ContactService} from "../../../services/contact.service";
import {Contact} from "../../../model/Contact";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-edit-contact',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './edit-contact.component.html',
  styleUrl: './edit-contact.component.scss'
})
export class EditContactComponent {
  private id = '0'
  firstName = '';
  surname = '';
  email = '';

  constructor(private route: ActivatedRoute, private contactService: ContactService) {
    this.route.paramMap.subscribe((params) => {
        this.id = params.get("id") ?? '0'
        let contact = this.contactService.get(this.id)
        this.firstName = contact.firstName;
        this.surname = contact.surname;
        this.email = contact.email;
      }
    );
  }

  save() {
    let contact: Contact = {
      id: +this.id,
      firstName: this.firstName,
      surname: this.surname,
      email: this.email
    };

    this.contactService.save(contact);
  }

}
