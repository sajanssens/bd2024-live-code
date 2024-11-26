import {Injectable} from '@angular/core';
import {Contact} from "../model/Contact";
import {BehaviorSubject} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {serverUrl} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  uri = serverUrl + '/contacts';

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

  getAll(): void {
    this.httpClient.get<Contact[]>(this.uri)
      .subscribe(contactsFromBackend => {
          this.#contacts = contactsFromBackend
          this.sendRefresh()
        }
      )
  }

  add(newContact: Contact) {
    this.httpClient.post<Contact>(this.uri, newContact)
      .subscribe(addedContact => {
        this.#contacts.push(addedContact)
        this.sendRefresh()
      })
  }

  save(editingContact: Contact) {
    this.httpClient.put<Contact>(this.uri + `/${editingContact.id}`, editingContact)
      .subscribe(editedContact => {
          this.replaceInContacts(editedContact)
          this.sendRefresh()
        }
      )
  }

  delete(contactToDelete: Contact) {
    this.httpClient.delete<Contact>(this.uri + `${contactToDelete.id}`)
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
