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
    const getTokenParams : HttpParams =new HttpParams()
    .append('grant_type','password')
    .append('username',username)
    .append('password',password)
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
