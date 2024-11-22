import {Component} from '@angular/core';
import {TimeService} from "../../services/time.service";
import {JsonPipe} from "@angular/common";

@Component({
  selector: 'app-timer-sync',
  standalone: true,
  imports: [
    JsonPipe
  ],
  templateUrl: './timer.component.html',
  styleUrl: './timer.component.scss'
})
export class TimerComponent {
  protected dates: Date[] = [];

  constructor(private timeService: TimeService) {
  }

  getTimes() {
    this.dates = this.timeService.tickSync();
  }
}
