import {Injectable} from '@angular/core';
import {Contact} from "../model/Contact";

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  contacts: Contact[] = [
    {id: 4, firstName: 'Sam', surname: 'Smith', email: 'sam.smith@music.com'},
    {id: 8, firstName: 'Frank', surname: 'Muscles', email: 'frank@muscles.com'},
    {id: 15, firstName: 'Eddy', surname: 'Valentino', email: 'eddy@valfam.co.uk'},
  ];

  getAll(): Contact[] {
    return this.contacts;
  }
}
