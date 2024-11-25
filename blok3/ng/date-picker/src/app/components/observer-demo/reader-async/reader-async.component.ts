import {Component} from '@angular/core';
import {MessageService} from "../message.service";
import {DatePipe} from "@angular/common";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-reader-async',
  standalone: true,
  imports: [
    DatePipe
  ],
  templateUrl: './reader-async.component.html',
  styleUrl: './reader-async.component.scss'
})
export class ReaderAsyncComponent {
  protected messages = ''
  private subscription: Subscription | undefined;

  constructor(private messageService: MessageService) {
  }

  subscribe() {
    this.subscription = this.messageService.messages$.subscribe(message => {
        this.messages += message + '\n'
      }
    );
  }

  unsubscribe() {
    // this will stop the observable completely:
    // this.messageService.messages$.unsubscribe()

    this.subscription?.unsubscribe();
  }

  clear() {
    this.messages=''
  }
}
