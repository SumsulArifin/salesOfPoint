import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RegModel } from './RegistrationModel';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
}
@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  private url = 'http://localhost:8080/api';

  constructor(private httpService: HttpClient) {}

  addTask(task:RegModel) {
    return this.httpService.post<RegModel>(this.url + '/registration' , task, httpOptions);
  }
}