import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VendtcComponent } from './vendtc.component';

describe('VendtcComponent', () => {
  let component: VendtcComponent;
  let fixture: ComponentFixture<VendtcComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VendtcComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VendtcComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
