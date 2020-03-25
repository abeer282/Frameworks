import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TokenService {
  num = Math.random();
  constructor(private _http: HttpClient) { }

  getToken(){
    return this._http.post(
      "http://localhost:8080/oauth/token?grant_type=password&username=biro&password=1234",

      {withCredentials:true}, 
      
      {headers: new HttpHeaders({'Authorization': 'Basic '+btoa('client:secret')})}
          
  );
  }
}
