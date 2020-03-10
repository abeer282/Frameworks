import { TestBed } from '@angular/core/testing';

import { KikiService } from './kiki.service';

describe('KikiService', () => {
  let service: KikiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(KikiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
