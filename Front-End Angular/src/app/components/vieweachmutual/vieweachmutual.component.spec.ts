import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VieweachmutualComponent } from './vieweachmutual.component';

describe('VieweachmutualComponent', () => {
  let component: VieweachmutualComponent;
  let fixture: ComponentFixture<VieweachmutualComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VieweachmutualComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VieweachmutualComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
