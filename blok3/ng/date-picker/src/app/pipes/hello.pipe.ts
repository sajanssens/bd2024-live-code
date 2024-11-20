import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'hello',
  standalone: true
})
export class HelloPipe implements PipeTransform {

  transform(value: string, suffix: string): string {
    return `Hello ${value}${suffix}`
  }

}
