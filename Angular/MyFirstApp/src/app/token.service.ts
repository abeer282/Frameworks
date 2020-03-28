import { TokenData } from './TokenData';
import { Injectable } from '@angular/core';
import { UserData } from './UserData';

import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TokenService {
  constructor(private _http: HttpClient) { }

  getToken(userData){
    const getTokenUrl = 'http://localhost:8080/oauth/token';
    
    var  getTokenParams : HttpParams =new HttpParams();
    getTokenParams = getTokenParams.append('grant_type','password');
    getTokenParams = getTokenParams.append('username',userData.username);
    getTokenParams = getTokenParams.append('password',userData.password);


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
