import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReaderSyncComponent } from './reader-sync.component';

describe('TimerSyncComponent', () => {
  let component: ReaderSyncComponent;
  let fixture: ComponentFixture<ReaderSyncComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ReaderSyncComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReaderSyncComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
