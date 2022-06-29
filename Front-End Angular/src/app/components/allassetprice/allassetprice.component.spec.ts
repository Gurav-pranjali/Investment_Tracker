import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllassetpriceComponent } from './allassetprice.component';

describe('AllassetpriceComponent', () => {
  let component: AllassetpriceComponent;
  let fixture: ComponentFixture<AllassetpriceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllassetpriceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AllassetpriceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
