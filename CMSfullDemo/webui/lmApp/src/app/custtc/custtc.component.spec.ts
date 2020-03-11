import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CusttcComponent } from './custtc.component';

describe('CusttcComponent', () => {
  let component: CusttcComponent;
  let fixture: ComponentFixture<CusttcComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CusttcComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CusttcComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
