import {Injectable} from '@angular/core';
import {Contact} from "../model/Contact";
import {BehaviorSubject} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  contacts: Contact[];
  #contactsAreUpdated: BehaviorSubject<Contact[]>;

  constructor(private httpClient: HttpClient) {
    this.contacts = [
      // {id: 4, firstName: 'Sam', surname: 'Smith', email: 'sam.smith@music.com'},
      // {id: 8, firstName: 'Frank', surname: 'Muscles', email: 'frank@muscles.com'},
      // {id: 15, firstName: 'Eddy', surname: 'Valentino', email: 'eddy@valfam.co.uk'},
    ];

    this.#contactsAreUpdated = new BehaviorSubject<Contact[]>(this.contacts)
  }


  get contactsAreUpdated$(): BehaviorSubject<Contact[]> {
    return this.#contactsAreUpdated
  }

  refresh() {
    this.#contactsAreUpdated.next(this.contacts)
  }

  getAll(): void {
    const response$ = this.httpClient.get<Contact[]>('http://localhost:3000/contacts');
    response$.subscribe(
      contactsFromBackend => this.contactsAreUpdated$.next(contactsFromBackend)
    )
    // this.refresh()
  }

  add(newContact: Contact) {
    this.httpClient.post<Contact>('http://localhost:3000/contacts', newContact)
      .subscribe(() => this.getAll())
    // this.contacts.push(newContact);
    // this.refresh()
  }

  save(editingContact: Contact) {
    const find = this.contacts.find(c => c.id === editingContact.id);
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
