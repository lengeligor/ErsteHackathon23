import {ActionReducerMap} from "@ngrx/store";
import {AppReducer, AppState} from "./app.reducer";

export interface State {
  app: AppState
}

export const reducers: ActionReducerMap<State> =  {
  app: AppReducer
}
