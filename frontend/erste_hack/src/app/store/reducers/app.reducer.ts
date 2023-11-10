import {createFeatureSelector, createReducer, createSelector} from "@ngrx/store";
import {State} from "./index";
import {state} from "@angular/animations";

export const appFeatureKey = 'app';

export interface AppState {
  helloApp: string
}

export const initState: AppState = {
  helloApp: 'hi'
}

//selectors

export const selectAppState = createFeatureSelector<State, AppState>(
  appFeatureKey
);

export const selectAppHello = createSelector(
  selectAppState,
  state => state.helloApp
)

export const AppReducer = createReducer(
  initState
)
