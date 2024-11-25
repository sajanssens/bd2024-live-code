import {Injectable} from '@angular/core';
import {interval, map, Subject, take} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class MessageService {
  #messages = '';
  #messages$: Subject<string> = new Subject<string>();

  private readonly amount = 10;
  private readonly speed = 500;

  messageSync(): string {
    function wait(ms: number) {
      const start = Date.now();
      while (Date.now() - start < ms) {
        // Busy-wait loop
      }
    }

    for (let i = 0; i < this.amount; i++) {
      wait(this.speed)
      this.#messages += (new Date().toISOString() + "\n");
    }

    return this.#messages
  }

  tickStart(): void {
    interval(this.speed)
      .pipe(
        map(() => new Date().toISOString()),
        take(this.amount))
      .subscribe(
        dates => this.#messages$.next(dates)
      );
  }

  get messages$(): Subject<string> {
    return this.#messages$;
  }

}
