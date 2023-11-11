import {Injectable} from "@angular/core";
import {catchError, map, mergeMap, Observable, of} from "rxjs";
import {Action} from "@ngrx/store";
import {Actions, createEffect, ofType} from '@ngrx/effects'
import {AppActions} from "../actions";
import {AppService} from "../../services/app.service";

@Injectable()
export class AppEffects {
  constructor(
    private actions$: Actions,
    private appService: AppService) {
  }

  GetCurrentDate$: Observable<Action> = createEffect(() =>
    this.actions$.pipe(
      ofType(AppActions.GetCurrentDateStart),
      mergeMap(
        () => this.appService.getCurrentTime()
          .pipe(
            map(data => {
              return AppActions.GetCurrentDateSuccess({payload: data});
            }),
            catchError(error => of(AppActions.GetCurrentDateError(error)),
            ),
          ),
      ),
    ),
  );

  GetFinancialData$: Observable<Action> = createEffect(() =>
    this.actions$.pipe(
      ofType(AppActions.GetFinancialDataStart),
      mergeMap(
        () => this.appService.getFinancialData()
          .pipe(
            map(data => {
              return AppActions.GetFinancialDataSuccess({payload: data});
            }),
            catchError(error => of(AppActions.GetFinancialDataError(error)),
            ),
          ),
      ),
    ),
  );

}
