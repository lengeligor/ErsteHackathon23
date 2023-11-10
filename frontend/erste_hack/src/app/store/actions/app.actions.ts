import {createAction, props} from "@ngrx/store";

export const AppAction = createAction('[App] - Hello erste action');
export const GetCurrentDateStart = createAction('[App] - Get date start')

export const GetCurrentDateSuccess = createAction(
  '[App] - Get date start success',
  props<{payload: any}>(),
);

export const GetCurrentDateError = createAction(
  '[App] - Get date start error',
  props<{error: any}>(),
);
