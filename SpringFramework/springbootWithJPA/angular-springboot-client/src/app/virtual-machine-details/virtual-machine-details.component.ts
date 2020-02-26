import { VirtualMachine } from '../virtual-machine';
import { Component, OnInit, Input } from '@angular/core';
import { VirtualMachineService } from '../virtual-machine.service';
import { VirtualMachineListComponent } from '../virtual-machine-list/virtual-machine-list.component';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-virtual-machine-details',
  templateUrl: './virtual-machine-details.component.html',
  styleUrls: ['./virtual-machine-details.component.css']
})
export class VirtualMachineDetailsComponent implements OnInit {

  id: number;
  virtualMachine: VirtualMachine;

  constructor(private route: ActivatedRoute,private router: Router,
    private virtualMachineService: VirtualMachineService) { }

  ngOnInit() {
    this.virtualMachine = new VirtualMachine();

    this.id = this.route.snapshot.params['id'];
    
    this.VirtualMachineService.getVirtualMachine(this.id)
      .subscribe(data => {
        console.log(data)
        this.virtualMachine = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['vm']);
  }
}
