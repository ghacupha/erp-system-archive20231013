import {PaymentLabelService} from "../../payment-label/service/payment-label.service";

jest.mock('@angular/router');

import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { of, Subject } from 'rxjs';

import { SignedPaymentService } from '../service/signed-payment.service';
import { ISignedPayment, SignedPayment } from '../signed-payment.model';
import { IDealer } from 'app/entities/dealers/dealer/dealer.model';
import { DealerService } from 'app/entities/dealers/dealer/service/dealer.service';
import { IPlaceholder } from 'app/entities/erpService/placeholder/placeholder.model';
import { PlaceholderService } from 'app/entities/erpService/placeholder/service/placeholder.service';

import { SignedPaymentUpdateComponent } from './signed-payment-update.component';
import {PaymentCategoryService} from '../../payments/payment-category/service/payment-category.service';
import {IPaymentLabel} from '../../payment-label/payment-label.model';
import {IPaymentCategory} from '../../payments/payment-category/payment-category.model';

describe('Component Tests', () => {
  describe('SignedPayment Management Update Component', () => {
    let comp: SignedPaymentUpdateComponent;
    let fixture: ComponentFixture<SignedPaymentUpdateComponent>;
    let activatedRoute: ActivatedRoute;
    let signedPaymentService: SignedPaymentService;
    let paymentLabelService: PaymentLabelService;
    let dealerService: DealerService;
    let paymentCategoryService: PaymentCategoryService;
    let placeholderService: PlaceholderService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
        declarations: [SignedPaymentUpdateComponent],
        providers: [FormBuilder, ActivatedRoute],
      })
        .overrideTemplate(SignedPaymentUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(SignedPaymentUpdateComponent);
      activatedRoute = TestBed.inject(ActivatedRoute);
      signedPaymentService = TestBed.inject(SignedPaymentService);
      paymentLabelService = TestBed.inject(PaymentLabelService);
      dealerService = TestBed.inject(DealerService);
      paymentCategoryService = TestBed.inject(PaymentCategoryService);
      placeholderService = TestBed.inject(PlaceholderService);

      comp = fixture.componentInstance;
    });

    describe('ngOnInit', () => {
      it('Should call PaymentLabel query and add missing value', () => {
        const signedPayment: ISignedPayment = { id: 456 };
        const paymentLabels: IPaymentLabel[] = [{ id: 60214 }];
        signedPayment.paymentLabels = paymentLabels;

        const paymentLabelCollection: IPaymentLabel[] = [{ id: 40943 }];
        jest.spyOn(paymentLabelService, 'query').mockReturnValue(of(new HttpResponse({ body: paymentLabelCollection })));
        const additionalPaymentLabels = [...paymentLabels];
        const expectedCollection: IPaymentLabel[] = [...additionalPaymentLabels, ...paymentLabelCollection];
        jest.spyOn(paymentLabelService, 'addPaymentLabelToCollectionIfMissing').mockReturnValue(expectedCollection);

        activatedRoute.data = of({ signedPayment });
        comp.ngOnInit();

        expect(paymentLabelService.query).toHaveBeenCalled();
        expect(paymentLabelService.addPaymentLabelToCollectionIfMissing).toHaveBeenCalledWith(
          paymentLabelCollection,
          ...additionalPaymentLabels
        );
        expect(comp.paymentLabelsSharedCollection).toEqual(expectedCollection);
      });

      it('Should call Dealer query and add missing value', () => {
        const signedPayment: ISignedPayment = { id: 456 };
        const dealer: IDealer = { id: 5585 };
        signedPayment.dealer = dealer;

        const dealerCollection: IDealer[] = [{ id: 84792 }];
        jest.spyOn(dealerService, 'query').mockReturnValue(of(new HttpResponse({ body: dealerCollection })));
        const additionalDealers = [dealer];
        const expectedCollection: IDealer[] = [...additionalDealers, ...dealerCollection];
        jest.spyOn(dealerService, 'addDealerToCollectionIfMissing').mockReturnValue(expectedCollection);

        activatedRoute.data = of({ signedPayment });
        comp.ngOnInit();

        expect(dealerService.query).toHaveBeenCalled();
        expect(dealerService.addDealerToCollectionIfMissing).toHaveBeenCalledWith(dealerCollection, ...additionalDealers);
        expect(comp.dealersSharedCollection).toEqual(expectedCollection);
      });

      it('Should call PaymentCategory query and add missing value', () => {
        const signedPayment: ISignedPayment = { id: 456 };
        const paymentCategory: IPaymentCategory = { id: 19158 };
        signedPayment.paymentCategory = paymentCategory;

        const paymentCategoryCollection: IPaymentCategory[] = [{ id: 56755 }];
        jest.spyOn(paymentCategoryService, 'query').mockReturnValue(of(new HttpResponse({ body: paymentCategoryCollection })));
        const additionalPaymentCategories = [paymentCategory];
        const expectedCollection: IPaymentCategory[] = [...additionalPaymentCategories, ...paymentCategoryCollection];
        jest.spyOn(paymentCategoryService, 'addPaymentCategoryToCollectionIfMissing').mockReturnValue(expectedCollection);

        activatedRoute.data = of({ signedPayment });
        comp.ngOnInit();

        expect(paymentCategoryService.query).toHaveBeenCalled();
        expect(paymentCategoryService.addPaymentCategoryToCollectionIfMissing).toHaveBeenCalledWith(
          paymentCategoryCollection,
          ...additionalPaymentCategories
        );
        expect(comp.paymentCategoriesSharedCollection).toEqual(expectedCollection);
      });

      it('Should call Placeholder query and add missing value', () => {
        const signedPayment: ISignedPayment = { id: 456 };
        const placeholders: IPlaceholder[] = [{ id: 75417 }];
        signedPayment.placeholders = placeholders;

        const placeholderCollection: IPlaceholder[] = [{ id: 2425 }];
        jest.spyOn(placeholderService, 'query').mockReturnValue(of(new HttpResponse({ body: placeholderCollection })));
        const additionalPlaceholders = [...placeholders];
        const expectedCollection: IPlaceholder[] = [...additionalPlaceholders, ...placeholderCollection];
        jest.spyOn(placeholderService, 'addPlaceholderToCollectionIfMissing').mockReturnValue(expectedCollection);

        activatedRoute.data = of({ signedPayment });
        comp.ngOnInit();

        expect(placeholderService.query).toHaveBeenCalled();
        expect(placeholderService.addPlaceholderToCollectionIfMissing).toHaveBeenCalledWith(
          placeholderCollection,
          ...additionalPlaceholders
        );
        expect(comp.placeholdersSharedCollection).toEqual(expectedCollection);
      });

      it('Should call SignedPayment query and add missing value', () => {
        const signedPayment: ISignedPayment = { id: 456 };
        const signedPaymentGroup: ISignedPayment = { id: 96038 };
        signedPayment.signedPaymentGroup = signedPaymentGroup;

        const signedPaymentCollection: ISignedPayment[] = [{ id: 53605 }];
        jest.spyOn(signedPaymentService, 'query').mockReturnValue(of(new HttpResponse({ body: signedPaymentCollection })));
        const additionalSignedPayments = [signedPaymentGroup];
        const expectedCollection: ISignedPayment[] = [...additionalSignedPayments, ...signedPaymentCollection];
        jest.spyOn(signedPaymentService, 'addSignedPaymentToCollectionIfMissing').mockReturnValue(expectedCollection);

        activatedRoute.data = of({ signedPayment });
        comp.ngOnInit();

        expect(signedPaymentService.query).toHaveBeenCalled();
        expect(signedPaymentService.addSignedPaymentToCollectionIfMissing).toHaveBeenCalledWith(
          signedPaymentCollection,
          ...additionalSignedPayments
        );
        expect(comp.signedPaymentsSharedCollection).toEqual(expectedCollection);
      });

      it('Should update editForm', () => {
        const signedPayment: ISignedPayment = { id: 456 };
        const paymentLabels: IPaymentLabel = { id: 61040 };
        signedPayment.paymentLabels = [paymentLabels];
        const dealer: IDealer = { id: 7943 };
        signedPayment.dealer = dealer;
        const paymentCategory: IPaymentCategory = { id: 84241 };
        signedPayment.paymentCategory = paymentCategory;
        const placeholders: IPlaceholder = { id: 24907 };
        signedPayment.placeholders = [placeholders];
        const signedPaymentGroup: ISignedPayment = { id: 84795 };
        signedPayment.signedPaymentGroup = signedPaymentGroup;

        activatedRoute.data = of({ signedPayment });
        comp.ngOnInit();

        expect(comp.editForm.value).toEqual(expect.objectContaining(signedPayment));
        expect(comp.paymentLabelsSharedCollection).toContain(paymentLabels);
        expect(comp.dealersSharedCollection).toContain(dealer);
        expect(comp.paymentCategoriesSharedCollection).toContain(paymentCategory);
        expect(comp.placeholdersSharedCollection).toContain(placeholders);
        expect(comp.signedPaymentsSharedCollection).toContain(signedPaymentGroup);
      });
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', () => {
        // GIVEN
        const saveSubject = new Subject<HttpResponse<SignedPayment>>();
        const signedPayment = { id: 123 };
        jest.spyOn(signedPaymentService, 'update').mockReturnValue(saveSubject);
        jest.spyOn(comp, 'previousState');
        activatedRoute.data = of({ signedPayment });
        comp.ngOnInit();

        // WHEN
        comp.save();
        expect(comp.isSaving).toEqual(true);
        saveSubject.next(new HttpResponse({ body: signedPayment }));
        saveSubject.complete();

        // THEN
        expect(comp.previousState).toHaveBeenCalled();
        expect(signedPaymentService.update).toHaveBeenCalledWith(signedPayment);
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', () => {
        // GIVEN
        const saveSubject = new Subject<HttpResponse<SignedPayment>>();
        const signedPayment = new SignedPayment();
        jest.spyOn(signedPaymentService, 'create').mockReturnValue(saveSubject);
        jest.spyOn(comp, 'previousState');
        activatedRoute.data = of({ signedPayment });
        comp.ngOnInit();

        // WHEN
        comp.save();
        expect(comp.isSaving).toEqual(true);
        saveSubject.next(new HttpResponse({ body: signedPayment }));
        saveSubject.complete();

        // THEN
        expect(signedPaymentService.create).toHaveBeenCalledWith(signedPayment);
        expect(comp.isSaving).toEqual(false);
        expect(comp.previousState).toHaveBeenCalled();
      });

      it('Should set isSaving to false on error', () => {
        // GIVEN
        const saveSubject = new Subject<HttpResponse<SignedPayment>>();
        const signedPayment = { id: 123 };
        jest.spyOn(signedPaymentService, 'update').mockReturnValue(saveSubject);
        jest.spyOn(comp, 'previousState');
        activatedRoute.data = of({ signedPayment });
        comp.ngOnInit();

        // WHEN
        comp.save();
        expect(comp.isSaving).toEqual(true);
        saveSubject.error('This is an error!');

        // THEN
        expect(signedPaymentService.update).toHaveBeenCalledWith(signedPayment);
        expect(comp.isSaving).toEqual(false);
        expect(comp.previousState).not.toHaveBeenCalled();
      });
    });

    describe('Tracking relationships identifiers', () => {
      describe('trackPaymentLabelById', () => {
        it('Should return tracked PaymentLabel primary key', () => {
          const entity = { id: 123 };
          const trackResult = comp.trackPaymentLabelById(0, entity);
          expect(trackResult).toEqual(entity.id);
        });
      });

      describe('trackDealerById', () => {
        it('Should return tracked Dealer primary key', () => {
          const entity = { id: 123 };
          const trackResult = comp.trackDealerById(0, entity);
          expect(trackResult).toEqual(entity.id);
        });
      });

      describe('trackPaymentCategoryById', () => {
        it('Should return tracked PaymentCategory primary key', () => {
          const entity = { id: 123 };
          const trackResult = comp.trackPaymentCategoryById(0, entity);
          expect(trackResult).toEqual(entity.id);
        });
      });

      describe('trackPlaceholderById', () => {
        it('Should return tracked Placeholder primary key', () => {
          const entity = { id: 123 };
          const trackResult = comp.trackPlaceholderById(0, entity);
          expect(trackResult).toEqual(entity.id);
        });
      });

      describe('trackSignedPaymentById', () => {
        it('Should return tracked SignedPayment primary key', () => {
          const entity = { id: 123 };
          const trackResult = comp.trackSignedPaymentById(0, entity);
          expect(trackResult).toEqual(entity.id);
        });
      });
    });

    describe('Getting selected relationships', () => {
      describe('getSelectedPaymentLabel', () => {
        it('Should return option if no PaymentLabel is selected', () => {
          const option = { id: 123 };
          const result = comp.getSelectedPaymentLabel(option);
          expect(result === option).toEqual(true);
        });

        it('Should return selected PaymentLabel for according option', () => {
          const option = { id: 123 };
          const selected = { id: 123 };
          const selected2 = { id: 456 };
          const result = comp.getSelectedPaymentLabel(option, [selected2, selected]);
          expect(result === selected).toEqual(true);
          expect(result === selected2).toEqual(false);
          expect(result === option).toEqual(false);
        });

        it('Should return option if this PaymentLabel is not selected', () => {
          const option = { id: 123 };
          const selected = { id: 456 };
          const result = comp.getSelectedPaymentLabel(option, [selected]);
          expect(result === option).toEqual(true);
          expect(result === selected).toEqual(false);
        });
      });

      describe('getSelectedPlaceholder', () => {
        it('Should return option if no Placeholder is selected', () => {
          const option = { id: 123 };
          const result = comp.getSelectedPlaceholder(option);
          expect(result === option).toEqual(true);
        });

        it('Should return selected Placeholder for according option', () => {
          const option = { id: 123 };
          const selected = { id: 123 };
          const selected2 = { id: 456 };
          const result = comp.getSelectedPlaceholder(option, [selected2, selected]);
          expect(result === selected).toEqual(true);
          expect(result === selected2).toEqual(false);
          expect(result === option).toEqual(false);
        });

        it('Should return option if this Placeholder is not selected', () => {
          const option = { id: 123 };
          const selected = { id: 456 };
          const result = comp.getSelectedPlaceholder(option, [selected]);
          expect(result === option).toEqual(true);
          expect(result === selected).toEqual(false);
        });
      });
    });
  });
});