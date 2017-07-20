import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router'
import { HttpModule } from '@angular/http'

// imports for loading & configuring in-memory web api
import { InMemoryWebApiModule } from 'angular-in-memory-web-api'

import { AppComponent } from './app.component';
import { HeroDetailComponent } from "./hero-detail.component";
import { HeroesComponent } from "./heroes.component";
import { HeroService } from "./hero.service";
import { DashBoardComponent } from "./dashboard.component";
import { AppRoutingModule } from "./app-routing.module";
import { InMemoryDataService } from "./in-memory-data.service";


@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpModule,
    InMemoryWebApiModule.forRoot(InMemoryDataService)
  ],
  declarations: [
    AppComponent,
    HeroDetailComponent,
    HeroesComponent,
    DashBoardComponent],
  bootstrap: [AppComponent],
  providers: [HeroService]
})
export class AppModule { }
