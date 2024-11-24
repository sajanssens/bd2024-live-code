import {Component} from '@angular/core';
import {ReaderSyncComponent} from "../reader-sync/reader-sync.component";
import {ReaderAsyncComponent} from "../reader-async/reader-async.component";
import {PusherComponent} from "../pusher/pusher.component";

@Component({
  selector: 'app-reader',
  standalone: true,
  imports: [
    ReaderSyncComponent,
    ReaderAsyncComponent,
    PusherComponent
  ],
  templateUrl: './demo.page.html',
  styleUrl: './demo.page.scss'
})
export class DemoPage {

}
