import {Injectable} from '@angular/core';
import {interval, map, Subject, take} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TimeService {
  #times: Date[] = [];
  #times$: Subject<Date> = new Subject<Date>();

  private readonly amount = 10;
  private readonly speed = 500;

  tickSync(): Date[] {
    function wait(ms: number) {
      const start = Date.now();
      while (Date.now() - start < ms) {
        // Busy-wait loop
      }
    }

    for (let i = 0; i < this.amount; i++) {
      wait(this.speed)
      this.#times.push(new Date())
    }

    return this.#times
  }

  tickStart(): void {
    interval(this.speed).pipe(
      map(() => new Date()),
      take(this.amount)
    ).subscribe(date =>
      this.#times$.next(date)
    );
  }

  get times$(): Subject<Date> {
    return this.#times$;
  }

}
