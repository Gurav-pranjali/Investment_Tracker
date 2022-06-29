import { TestBed } from '@angular/core/testing';

import { MutualfundserviceService } from './mutualfundservice.service';

describe('MutualfundserviceService', () => {
  let service: MutualfundserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MutualfundserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
