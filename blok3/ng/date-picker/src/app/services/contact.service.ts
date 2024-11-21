import {Injectable} from '@angular/core';
import {Contact} from "../model/Contact";
import {BehaviorSubject, Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  contacts: Contact[];
  #contactsAreUpdated: BehaviorSubject<Contact[]>;

  constructor() {
    this.contacts = [
      {id: 4, firstName: 'Sam', surname: 'Smith', email: 'sam.smith@music.com'},
      {id: 8, firstName: 'Frank', surname: 'Muscles', email: 'frank@muscles.com'},
      {id: 15, firstName: 'Eddy', surname: 'Valentino', email: 'eddy@valfam.co.uk'},
    ];

    this.#contactsAreUpdated = new BehaviorSubject<Contact[]>(this.contacts)
  }

  get contactsAreUpdated$(): Observable<Contact[]> {
    return this.#contactsAreUpdated
  }

  getAll() {
    this.refresh()
  }

  refresh() {
    this.#contactsAreUpdated.next(this.contacts)
  }

  add(newContact: Contact) {
    this.contacts.push(newContact);
    this.refresh()
  }

  save(editingContact: Contact) {
    let find = this.contacts.find(c => c.id === editingContact.id);
    if (find) {
      find.firstName = editingContact.firstName
      find.surname = editingContact.surname
      find.email = editingContact.email
    }
    this.refresh()
  }

  delete(contactToDelete: Contact) {
    this.contacts.splice(this.contacts.indexOf(contactToDelete), 1);
    this.refresh()
  }

  get(id: string): Contact {
    return this.contacts.filter(c => c.id === +id)[0];
  }
}
