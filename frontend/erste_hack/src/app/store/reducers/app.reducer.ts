import {createFeatureSelector, createReducer, createSelector, on} from "@ngrx/store";
import {State} from "./index";
import {state} from "@angular/animations";
import {AppActions} from "../actions";

export const appFeatureKey = 'app';

export interface AppState {
  helloApp: string,
  currentTime: string,
  currentTimeError: string | null,
  currentTimeLoading: boolean,
}

export const initState: AppState = {
  helloApp: 'hi',
  currentTime: '',
  currentTimeError: null,
  currentTimeLoading: false
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
  initState,
  on(AppActions.GetCurrentDateStart, (state) => {
    return {
      ...state,
      currentTimeLoading: true,
    };
  }),
  on(AppActions.GetCurrentDateSuccess, (state, {payload}) => {
    console.log(payload)
    return {
      ...state,
      currentTimeLoading: false,
      currentTime: payload.dummyString
    };
  }),
  on(AppActions.GetCurrentDateError, (state, {error}) => {
    console.log(error)
    return {
      ...state,
      currentTimeLoading: false,
      currentTimeError: error
    };
  }),
)
