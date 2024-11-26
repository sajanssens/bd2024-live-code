import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormArrayDemoComponent } from './form-array-demo.component';

describe('FormArrayDemoComponent', () => {
  let component: FormArrayDemoComponent;
  let fixture: ComponentFixture<FormArrayDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormArrayDemoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormArrayDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
