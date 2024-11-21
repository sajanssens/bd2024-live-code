import {AfterViewInit, Component} from '@angular/core';
import * as bs from 'bootstrap';

@Component({
  selector: 'app-sidebar',
  standalone: true,
  imports: [],
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.scss'
})
export class SidebarComponent implements AfterViewInit {
  ngAfterViewInit(): void {
    (() => {
      'use strict'
      const tooltipTriggerList = Array.from(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
      tooltipTriggerList.forEach(tooltipTriggerEl => {
        new bs.Tooltip(tooltipTriggerEl)
      })
    })()

  }

}
