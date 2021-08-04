import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { ActivatedRoute, convertToParamMap } from '@angular/router';

import { ErpGatewayTestModule } from '../../../../test.module';
import { FixedAssetAcquisitionComponent } from 'app/entities/assets/fixed-asset-acquisition/fixed-asset-acquisition.component';
import { FixedAssetAcquisitionService } from 'app/entities/assets/fixed-asset-acquisition/fixed-asset-acquisition.service';
import { FixedAssetAcquisition } from 'app/shared/model/assets/fixed-asset-acquisition.model';

describe('Component Tests', () => {
  describe('FixedAssetAcquisition Management Component', () => {
    let comp: FixedAssetAcquisitionComponent;
    let fixture: ComponentFixture<FixedAssetAcquisitionComponent>;
    let service: FixedAssetAcquisitionService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [ErpGatewayTestModule],
        declarations: [FixedAssetAcquisitionComponent],
        providers: [
          {
            provide: ActivatedRoute,
            useValue: {
              data: of({
                defaultSort: 'id,asc',
              }),
              queryParamMap: of(
                convertToParamMap({
                  page: '1',
                  size: '1',
                  sort: 'id,desc',
                })
              ),
            },
          },
        ],
      })
        .overrideTemplate(FixedAssetAcquisitionComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(FixedAssetAcquisitionComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(FixedAssetAcquisitionService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new FixedAssetAcquisition(123)],
            headers,
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.fixedAssetAcquisitions && comp.fixedAssetAcquisitions[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should load a page', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new FixedAssetAcquisition(123)],
            headers,
          })
        )
      );

      // WHEN
      comp.loadPage(1);

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.fixedAssetAcquisitions && comp.fixedAssetAcquisitions[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should calculate the sort attribute for an id', () => {
      // WHEN
      comp.ngOnInit();
      const result = comp.sort();

      // THEN
      expect(result).toEqual(['id,desc']);
    });

    it('should calculate the sort attribute for a non-id attribute', () => {
      // INIT
      comp.ngOnInit();

      // GIVEN
      comp.predicate = 'name';

      // WHEN
      const result = comp.sort();

      // THEN
      expect(result).toEqual(['name,desc', 'id']);
    });
  });
});