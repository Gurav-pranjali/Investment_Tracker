import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewassetComponent } from './viewasset.component';

describe('ViewassetComponent', () => {
  let component: ViewassetComponent;
  let fixture: ComponentFixture<ViewassetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewassetComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewassetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
