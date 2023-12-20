import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user.model';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
}
@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  PATH_OF_API = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  registerUser(user: User) {
    return this.http.post<User>(`${this.PATH_OF_API}/api/v1/auth/register`, user);
  }
}