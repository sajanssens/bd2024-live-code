import {Component, OnInit} from '@angular/core';
import {FormsModule} from "@angular/forms";
import {Contact} from "../../model/Contact";
import {ContactService} from "../../services/contact.service";
import {RouterLink, RouterOutlet} from "@angular/router";
import {MatSlideToggleModule} from "@angular/material/slide-toggle";
import {Observable} from "rxjs";
import {AsyncPipe} from "@angular/common";

@Component({
  selector: 'app-date-picker',
  standalone: true,
  imports: [
    FormsModule,
    RouterLink,
    RouterOutlet,
    MatSlideToggleModule,
    AsyncPipe
  ],
  templateUrl: './date-picker.component.html',
  styleUrl: './date-picker.component.scss'
})
export class DatePickerComponent implements OnInit {

  contacts!: Contact[];
  contacts$!: Observable<Contact[]>;

  constructor(private contactService: ContactService) {
  }

  ngOnInit(): void {
    this.contacts$ = this.contactService.contactsAreUpdated$
    this.contactService.getAll()
    // this.contacts$.subscribe(contacts => {
    //   this.contacts = contacts
    // })
  }

  delete(contactToDelete: Contact) {
    this.contactService.delete(contactToDelete)
  }


}
