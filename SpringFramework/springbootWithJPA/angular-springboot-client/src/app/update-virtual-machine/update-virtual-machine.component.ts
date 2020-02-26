import { Component, OnInit } from '@angular/core';
import { VirtualMachime } from '../virtual-machine';
import { ActivatedRoute, Router } from '@angular/router';
import { VirtualMachimeService } from '../virtual-machine.service';

@Component({
  selector: 'app-update-virtual-machine',
  templateUrl: './update-virtual-machine.component.html',
  styleUrls: ['./update-virtual-machine.component.css']
})
export class UpdateVirtualMachineComponent implements OnInit {

  id: number;
  virtualMachine: VirtualMachine;

  constructor(private route: ActivatedRoute,private router: Router,
    private virtualMachineService: VirtualMachineService) { }

  ngOnInit() {
    this.virtualMachine = new VirtualMachine();

    this.id = this.route.snapshot.params['id'];
    
    this.virtualMachineService.getVirtualMachine(this.id)
      .subscribe(data => {
        console.log(data)
        this.virtualMachine = data;
      }, error => console.log(error));
  }

  updateVirtualMachine() {
    this.virtualMachineService.updateVirtualMachine(this.id, this.virtualMachine)
      .subscribe(data => console.log(data), error => console.log(error));
    this.virtualMachine = new VirtualMachine();
    this.gotoList();
  }

  onSubmit() {
    this.updateVirtualMachine();    
  }

  gotoList() {
    this.router.navigate(['/vm']);
  }

}
