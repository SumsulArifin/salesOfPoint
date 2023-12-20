import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
}
@Injectable({
  providedIn: 'root'
})
export class LoginService {

  PATH_OF_API = 'http://localhost:8080';
  constructor(private http: HttpClient) {}

  
  

  public login(loginData: any) {
    return this.http.post<any>(this.PATH_OF_API + '/api/v1/auth/authenticate', loginData, 
      // headers: this.requestHeader,
 )
  }
}
