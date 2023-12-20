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

  private url = 'http://localhost:8080/api/login';

  

 

  constructor(private httpService: HttpClient) {}

  
  

  login(email: string, password: string): Observable<any> {
    const body = { email, password };
    return this.httpService.post(this.url, body);
  }
}
