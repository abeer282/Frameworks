import { TokenData } from './TokenData';
import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TokenService {
  num = Math.random();
  constructor(private _http: HttpClient) { }

  getToken(username: string, password: string){
    const getTokenUrl = 'http://localhost:8080/oauth/token';
    
    var  getTokenParams : HttpParams =new HttpParams();
    getTokenParams = getTokenParams.append('grant_type','password');
    getTokenParams = getTokenParams.append('username',username);
    getTokenParams = getTokenParams.append('password',password);


    const getTokenHeaders: HttpHeaders = new HttpHeaders()
    .append('Authorization', 'Basic '+btoa('client:secret'));
    return this._http.post<TokenData>(getTokenUrl,
                  {
                      withCredentials:true
                  },{
                      headers: getTokenHeaders,
                      params: getTokenParams
                  }          
    );
  }
}
