import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { KokoComponent } from './components/koko/koko.component';


const routes: Routes = [
  {path: '',component:KokoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
