import { ButtonComponent } from './button/button.component';
import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NotfoundComponent } from './notfound/notfound.component';


const routes: Routes = [
              {path: "", redirectTo:"button", pathMatch: "full"},
              {path: "button", component: ButtonComponent},
              {path: "**", component: NotfoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
