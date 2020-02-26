import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateVirtualMachineComponent } from './create-virtual-machine/create-virtual-machine.component';
import { VirtualMachineListComponent } from './virtual-machine-list/virtual-machine-list.component';
import { VirtualMachineDetailsComponent } from './virtual-machine-details/virtual-machine-details.component';
import { UpdateVirtualMachineComponent } from './update-virtual-machine/update-virtual-machine.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    CreateVirtualMachineComponent,
    VirtualMachineListComponent,
    VirtualMachineDetailsComponent,
    UpdateVirtualMachineComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
	FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
