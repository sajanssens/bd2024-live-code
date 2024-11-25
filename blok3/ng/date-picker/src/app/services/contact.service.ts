import {Injectable} from '@angular/core';
import {Contact} from "../model/Contact";
import {BehaviorSubject} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  #contacts: Contact[];
  #contactsAreUpdated: BehaviorSubject<Contact[]>;

  constructor(private httpClient: HttpClient) {
    this.#contacts = [];
    this.#contactsAreUpdated = new BehaviorSubject<Contact[]>(this.#contacts)
  }

  get contactsAreUpdated$(): BehaviorSubject<Contact[]> {
    return this.#contactsAreUpdated
  }

  sendRefresh() {
    this.#contactsAreUpdated.next(this.#contacts)
  }

  private readonly _url = 'http://localhost:3000/';

  getAll(): void {
    this.httpClient.get<Contact[]>(this._url + 'contacts')
      .subscribe(contactsFromBackend => {
          this.#contacts = contactsFromBackend
          this.sendRefresh()
        }
      )
  }

  add(newContact: Contact) {
    this.httpClient.post<Contact>(this._url + 'contacts', newContact)
      .subscribe(addedContact => {
        this.#contacts.push(addedContact)
        this.sendRefresh()
      })
  }

  save(editingContact: Contact) {
    this.httpClient.put<Contact>(this._url + `contacts/${editingContact.id}`, editingContact)
      .subscribe(editedContact => {
          this.replaceInContacts(editedContact)
          this.sendRefresh()
        }
      )
  }

  delete(contactToDelete: Contact) {
    this.httpClient.delete<Contact>(this._url + `contacts/${contactToDelete.id}`)
      .subscribe(c => {
          this.#contacts.splice(this.#contacts.indexOf(c), 1)
          this.sendRefresh()
        }
      )
  }

  get(id: string): Contact {
    return this.#contacts.filter(c => c.id === +id)[0];
  }

  private replaceInContacts(contact: Contact) {
    const find = this.#contacts.find(c => c.id === contact.id);
    if (find) {
      find.firstName = contact.firstName
      find.surname = contact.surname
      find.email = contact.email
    }
  }
}
