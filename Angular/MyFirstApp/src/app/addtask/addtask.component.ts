import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-addtask',
  templateUrl: './addtask.component.html',
  styleUrls: ['./addtask.component.css']
})
export class AddtaskComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  item:string;

  //TODO perform add task logic
  add(){
    console.log(this.item);
    this.item='';
  }

}
