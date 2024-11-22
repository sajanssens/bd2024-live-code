import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TimesPage } from './times.page';

describe('TimesComponent', () => {
  let component: TimesPage;
  let fixture: ComponentFixture<TimesPage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TimesPage]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TimesPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
