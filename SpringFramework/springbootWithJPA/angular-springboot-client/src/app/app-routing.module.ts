import { VirtualMachineDetailsComponent } from './virtual-machine-details/virtual-machine-details.component';
import { CreateVirtualMachineComponent } from './create-virtual-machine/create-virtual-machine.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { VirtualMachineListComponent } from './virtual-machine-list/virtual-machine-list.component';
import { UpdateVirtualMachineComponent } from './update-virtual-machine/update-virtual-machine.component';

const routes: Routes = [
  { path: '', redirectTo: 'virtualMachine', pathMatch: 'full' },
  { path: 'vm', component: VirtualMachineListComponent },
  { path: 'add', component: CreateVirtualMachineComponent },
  { path: 'update/:id', component: UpdateVirtualMachineComponent },
  { path: 'details/:id', component: VirtualMachineDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
