import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VieweachstockComponent } from './vieweachstock.component';

describe('VieweachstockComponent', () => {
  let component: VieweachstockComponent;
  let fixture: ComponentFixture<VieweachstockComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VieweachstockComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VieweachstockComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
