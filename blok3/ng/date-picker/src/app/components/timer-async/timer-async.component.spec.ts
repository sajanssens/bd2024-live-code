import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TimerAsyncComponent } from './timer-async.component';

describe('TimerAsyncComponent', () => {
  let component: TimerAsyncComponent;
  let fixture: ComponentFixture<TimerAsyncComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TimerAsyncComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TimerAsyncComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
