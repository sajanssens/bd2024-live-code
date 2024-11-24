import {Component} from '@angular/core';
import {MessageService} from "../message.service";
import {DatePipe, JsonPipe} from "@angular/common";

@Component({
  selector: 'app-reader-sync',
  standalone: true,
  imports: [
    JsonPipe,
    DatePipe
  ],
  templateUrl: './reader-sync.component.html',
  styleUrl: './reader-sync.component.scss'
})
export class ReaderSyncComponent {
  protected messages: string = '';

  constructor(private messageService: MessageService) {
  }

  getMessages() {
    this.messages = this.messageService.tickSync();
    console.log(this.messages);
  }

  clear() {
    this.messages=''
  }
}
