import {  Router } from '@angular/router';
import { TokenService } from './../token.service';
import { Component, OnInit } from '@angular/core';
import { UserData } from '../UserData';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent  {

  constructor(private tokenService:TokenService, private router:Router) { }

  userData: UserData = new UserData();
  error=false;

 
  login(){
    if(this.userData.username.length > 0 && this.userData.password.length > 0){
      this.tokenService.getToken(this.userData)
      .subscribe(res=> {

            res.expires_in=new Date().getTime()+res.expires_in*1000;

            sessionStorage.setItem('jsessionid',JSON.stringify(res));
            
            this.router.navigateByUrl('/home');
          }, 
      error=> this.error=true);
    }
  }
}
