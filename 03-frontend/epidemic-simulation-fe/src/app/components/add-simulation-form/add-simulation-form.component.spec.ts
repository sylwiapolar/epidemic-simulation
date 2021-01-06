import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddSimulationFormComponent } from './add-simulation-form.component';

describe('AddSimulationFormComponent', () => {
  let component: AddSimulationFormComponent;
  let fixture: ComponentFixture<AddSimulationFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddSimulationFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddSimulationFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
