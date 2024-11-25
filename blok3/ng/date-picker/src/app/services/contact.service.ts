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

  getAll(): void {
    this.httpClient.get<Contact[]>('http://localhost:3000/contacts')
      .subscribe(contactsFromBackend => {
          this.#contacts = contactsFromBackend
          this.sendRefresh()
        }
      )
  }

  add(newContact: Contact) {
    this.httpClient.post<Contact>('http://localhost:3000/contacts', newContact)
      .subscribe(addedContacts =>
        this.updateCachedContacts(addedContacts)
      )
  }

  save(editingContact: Contact) {
    this.httpClient.put<Contact>(`http://localhost:3000/contacts/${editingContact.id}`, editingContact)
      .subscribe(editedContact =>
        this.updateCachedContacts(editedContact)
      )
  }

  delete(contactToDelete: Contact) {
    this.httpClient.delete<Contact>(`http://localhost:3000/contacts/${contactToDelete.id}`)
      .subscribe(c => {
        this.#contacts.splice(this.#contacts.indexOf(c), 1)
        this.sendRefresh()
      })
  }

  get(id: string): Contact {
    return this.#contacts.filter(c => c.id === +id)[0];
  }

  private updateCachedContacts(contact: Contact) {
    const find = this.#contacts.find(c => c.id === contact.id);
    if (find) {
      find.firstName = contact.firstName
      find.surname = contact.surname
      find.email = contact.email
    }
    this.sendRefresh()
  }
}
