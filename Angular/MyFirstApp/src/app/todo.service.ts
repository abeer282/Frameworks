import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class TodoService {
todoList=['aaaa','bbbb','cccc','ddddd'];
  constructor(private http:HttpClient) { this.load()}
  load(){
    
  }
  addItem(task:string, token:string){
this.todoList.unshift(task);
  }
}
