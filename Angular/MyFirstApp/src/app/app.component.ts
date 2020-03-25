import { Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'MyFirstApp';
  constructor(private _http: HttpClient){}

  getToken(){
    console.log("HIIII")
    this._http.post(
        "http://localhost:8080/oauth/token?grant_type=password&username=biro&password=1234",

        {withCredentials:true}, 
        
        {headers: new HttpHeaders({'Authorization': 'Basic '+btoa('client:secret')})}
            
    ).subscribe(res => {console.log(res); this.getUsernameOfToken(res)});
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
