import { TestBed } from '@angular/core/testing';

import { CalculatenetworthserviceService } from './calculatenetworthservice.service';

describe('CalculatenetworthserviceService', () => {
  let service: CalculatenetworthserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CalculatenetworthserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
