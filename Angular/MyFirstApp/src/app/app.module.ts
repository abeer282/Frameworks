import { ButtonComponent } from './button/button.component';
import { TokenService } from './token.service';

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {  HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    ButtonComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule 
  ],
  providers: [TokenService],
  bootstrap: [AppComponent]
})
export class AppModule { }
