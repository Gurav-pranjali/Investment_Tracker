import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SellassetComponent } from './sellasset.component';

describe('SellassetComponent', () => {
  let component: SellassetComponent;
  let fixture: ComponentFixture<SellassetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SellassetComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SellassetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
