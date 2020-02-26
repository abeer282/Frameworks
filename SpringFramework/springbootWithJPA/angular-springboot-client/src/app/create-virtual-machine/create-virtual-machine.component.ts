import { VirtualMachineService } from '../virtual-machine.service';
import { VirtualMachine } from '../virtual-machine';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-create-virtual-machine',
  templateUrl: './create-virtual-machine.component.html',
  styleUrls: ['./create-virtual-machine.component.css']
})
export class CreateVirtualMachineComponent implements OnInit {
  virtualMachine: VirtualMachine = new VirtualMachine();
  submitted = false;

  constructor(private virtualMachineService: VirtualMachineService,
    private router: Router) { }

  ngOnInit(): void {
  }
   newVirtualMachine(): void {
    this.submitted = false;
    this.virtualMachine = new VirtualMachine();
  }

  save() {
    this.virtualMachineService.createVirtualMachine(this.virtualMachine)
      .subscribe(data => console.log(data), error => console.log(error));
    this.virtualMachine = new VirtualMachine();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/vm']);
  }
}
