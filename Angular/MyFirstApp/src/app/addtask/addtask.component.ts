import { TodoService } from './../todo.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-addtask',
  templateUrl: './addtask.component.html',
  styleUrls: ['./addtask.component.css']
})
export class AddtaskComponent implements OnInit {

  constructor(private todo:TodoService) { }

  ngOnInit(): void {
  }

  item:string;


  add(){
    this.todo.addItem(this.item, '');
    console.log(this.item);
    this.item='';
  }

}
