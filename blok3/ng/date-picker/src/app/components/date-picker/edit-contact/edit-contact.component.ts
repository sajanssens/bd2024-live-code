import {Component} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {ContactService} from "../../../services/contact.service";
import {Contact} from "../../../model/Contact";
import {FormsModule} from "@angular/forms";
import {Location as Loc} from '@angular/common';


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
  editmode = true;

  constructor(private route: ActivatedRoute, private contactService: ContactService, private location: Loc, private router: Router) {
    this.route.paramMap.subscribe((params) => {
        this.id = params.get("id") ?? '0'
        this.editmode = +this.id > 0
        const contact = this.contactService.get(this.id)
        this.firstName = contact.firstName;
        this.surname = contact.surname;
        this.email = contact.email;
      }
    );
  }

  save() {
    const contact: Contact = {
      id: +this.id,
      firstName: this.firstName,
      surname: this.surname,
      email: this.email
    };
    if (this.editmode)
      this.contactService.save(contact);
    else
      this.contactService.add(contact);

    this.back()
  }

  private back() {
    this.router.navigate(['date'])
  }

}
