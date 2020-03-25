import { TokenService } from './token.service';
import { Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
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

  getToken(){
    console.log(this.tokenService.getToken());
    console.log("HIIII")
    this.tokenService.getToken().subscribe(res => {console.log(res); this.getUsernameOfToken(res)});
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
