import {Component} from '@angular/core';
import {MessageService} from "../message.service";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-pusher',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './pusher.component.html',
  styleUrl: './pusher.component.scss'
})
export class PusherComponent {
  message = ''

  constructor(private messageService: MessageService) {
  }

  push() {
    this.messageService.messages$.next(this.message)
    this.message = ''
  }

  start() {
    this.messageService.tickStart();
  }
}
