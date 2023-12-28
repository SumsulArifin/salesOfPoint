import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckserviceComponent } from './checkservice.component';

describe('CheckserviceComponent', () => {
  let component: CheckserviceComponent;
  let fixture: ComponentFixture<CheckserviceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CheckserviceComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CheckserviceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
