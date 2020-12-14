import { TestBed } from '@angular/core/testing';

import { IdenDocTypeService } from './iden-doc-type.service';

describe('IdenDocTypeService', () => {
  let service: IdenDocTypeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IdenDocTypeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
