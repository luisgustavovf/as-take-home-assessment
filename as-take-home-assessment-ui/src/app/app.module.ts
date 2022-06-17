import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule} from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import {AppComponent} from './app.component';
import {TopBarComponent} from './component/top-bar/top-bar.component';
import {
    BestMatchedRestaurantListComponent
} from './component/best-matched-restaurant-list/best-matched-restaurant-list.component';
import {HttpClientModule} from "@angular/common/http";

@NgModule({
    imports: [
        BrowserModule,
        ReactiveFormsModule,
        HttpClientModule,
        RouterModule.forRoot([
            {path: '', component: BestMatchedRestaurantListComponent},
        ]),
        FormsModule
    ],
  declarations: [
    AppComponent,
    TopBarComponent,
    BestMatchedRestaurantListComponent
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at https://angular.io/license
*/