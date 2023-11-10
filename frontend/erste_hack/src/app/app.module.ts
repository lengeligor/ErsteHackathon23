import { NgModule, isDevMode } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {StoreModule} from "@ngrx/store";
import {reducers} from "./store/reducers";
import { StoreDevtoolsModule } from '@ngrx/store-devtools';
import {HttpClientModule} from "@angular/common/http";
import {EffectsModule} from "@ngrx/effects";
import {AppEffects} from "./store/effects/app.effects";
import { NavComponent } from './shared/nav/nav.component';
import { ChartModule } from 'primeng/chart';
import { BetterFutureComponent } from './components/better-future/better-future.component';
import { HomeComponent } from './components/home/home.component';
import { SharedHeaderComponent } from './shared/shared-header/shared-header.component';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    BetterFutureComponent,
    HomeComponent,
    SharedHeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    StoreModule.forRoot(reducers),
    StoreDevtoolsModule.instrument({ maxAge: 25, logOnly: !isDevMode() }),
    EffectsModule.forRoot([
      AppEffects
    ]),
    ChartModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
