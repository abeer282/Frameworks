import { VirtialMachineComponent } from '../virtialMachine-details/virtial-machine-details.component';
import { Observable } from "rxjs";
import { VirtialMachineService } from "../virtial-machine.service";
import { virtialMachine } from "../virtial-machine";
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-virtual-machine-list',
  templateUrl: './virtual-machine-list.component.html',
  styleUrls: ['./virtual-machine-list.component.css']
})
export class VirtualMachineListComponent implements OnInit {
virtialMachines: Observable<VirtialMachine[]>;

  constructor(private virtialMachineService: VirtialMachineService,
    private router: Router) {}

  ngOnInit(): void {
	  this.reloadData();
  }
 reloadData() {
    this.virtialMachines = this.virtialMachineService.getVirtialMachinesList();
  }

  deleteVirtialMachine(id: number) {
    this.virtialMachineService.deleteVirtialMachine(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  virtialMachineDetails(id: number){
    this.router.navigate(['details', id]);
  }
}
