import { TokenService } from './token.service';
import { Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UserData } from './UserData';
@Component({
  selector: 'app-root',
  providers:[TokenService],
  templateUrl: './app.component.html'
})
export class AppComponent {
 }