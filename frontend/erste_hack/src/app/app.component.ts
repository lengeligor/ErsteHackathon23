import {Component, OnInit} from '@angular/core';
import {Store} from "@ngrx/store";
import {AppActions} from "./store/actions";
import {Observable, observable} from "rxjs";

import * as AppSelectors from './store/reducers/app.reducer'
import * as fromState from './store/reducers'
import * as Highcharts from 'highcharts'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{

  constructor(private store: Store<fromState.State>) {
  }

  helloState$  = new Observable<string>();

  ngOnInit(): void {
    this.store.dispatch(AppActions.AppAction());
    this.store.dispatch(AppActions.GetCurrentDateStart());
    this.store.dispatch(AppActions.GetFinancialDataStart());
    this.helloState$ = this.store.select(AppSelectors.selectAppHello)
  }
}
