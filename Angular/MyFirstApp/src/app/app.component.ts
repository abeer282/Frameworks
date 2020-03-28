import { TokenService } from './token.service';
import { Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UserData } from './UserData';
@Component({
  selector: 'app-root',
  providers:[TokenService],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'MyFirstApp';
  constructor( private _http: HttpClient, private tokenService: TokenService){

  }
  userData: UserData = new UserData;
  token='';
  error='';
  printUser(){
    console.log(this.userData.password+' :  ' +this.userData.username)
  }
  getToken(){
    this.tokenService.getToken(this.userData)
                  .subscribe(
                        res => {this.token=res.access_token;
                                this.error='';
                      },
                        err => {this.error='ERROR';
                                this.token='';
                      }
                        
                  );
    
    console.log("token in component");
    console.log(this.userData.username);

  }
  getUsernameOfToken(tokenInfo){
    console.log("IIIIIIpppppp")
    this._http.post(
        "http://localhost:8080/api/getUsername",

        {withCredentials:true}, 
        
        {headers: new HttpHeaders({'Authorization': 'Bearer '+tokenInfo['access_token']})}
            
    ).subscribe(res => console.log(res));

  }
}
