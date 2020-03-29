import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { TasklistComponent } from './tasklist/tasklist.component';
import { AddtaskComponent } from './addtask/addtask.component';

const routes: Routes = [
  {path: "", redirectTo:"home", pathMatch: "full"},
  {path: "login", component: LoginComponent},
  {path: "home", component: HomeComponent},
  {path: "*",component:HomeComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)
   ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
