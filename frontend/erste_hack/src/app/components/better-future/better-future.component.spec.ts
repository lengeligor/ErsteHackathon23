import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BetterFutureComponent } from './better-future.component';

describe('BetterFutureComponent', () => {
  let component: BetterFutureComponent;
  let fixture: ComponentFixture<BetterFutureComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BetterFutureComponent]
    });
    fixture = TestBed.createComponent(BetterFutureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
