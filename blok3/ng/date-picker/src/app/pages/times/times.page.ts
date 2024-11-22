import { Component } from '@angular/core';
import {TimerComponent} from "../../components/timer-sync/timer.component";
import {TimerAsyncComponent} from "../../components/timer-async/timer-async.component";

@Component({
  selector: 'app-times',
  standalone: true,
  imports: [
    TimerComponent,
    TimerAsyncComponent
  ],
  templateUrl: './times.page.html',
  styleUrl: './times.page.scss'
})
export class TimesPage {

}
