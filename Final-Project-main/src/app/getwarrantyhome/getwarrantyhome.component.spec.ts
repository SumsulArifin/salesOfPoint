import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetwarrantyhomeComponent } from './getwarrantyhome.component';

describe('GetwarrantyhomeComponent', () => {
  let component: GetwarrantyhomeComponent;
  let fixture: ComponentFixture<GetwarrantyhomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetwarrantyhomeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetwarrantyhomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
