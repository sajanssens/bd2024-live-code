import {Injectable} from '@angular/core';
import {interval, map, Observable, Subject, take} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class MessageService {
  #messages = '';
  #messages$: Observable<string> = new Subject<string>();

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
    this.#messages$ =
      interval(this.speed)
        .pipe(
          map(() => new Date().toISOString()),
          take(this.amount));
  }

  get messages$(): Observable<string> {
    return this.#messages$;
  }

}
