import {Component} from '@angular/core';
import {TimeService} from "../../services/time.service";

@Component({
  selector: 'app-timer-async',
  standalone: true,
  imports: [],
  templateUrl: './timer-async.component.html',
  styleUrl: './timer-async.component.scss'
})
export class TimerAsyncComponent {
  protected dates: Date[] = [];

  constructor(private timeService: TimeService) {
  }

  startTiming() {
    this.timeService.tickStart();
  }

  subscribe() {
    this.timeService.times$.subscribe(time =>
      this.dates.push(time)
    )
  }
}
