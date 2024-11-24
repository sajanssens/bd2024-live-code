import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReaderAsyncComponent } from './reader-async.component';

describe('ReaderAsyncComponent', () => {
  let component: ReaderAsyncComponent;
  let fixture: ComponentFixture<ReaderAsyncComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ReaderAsyncComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReaderAsyncComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
