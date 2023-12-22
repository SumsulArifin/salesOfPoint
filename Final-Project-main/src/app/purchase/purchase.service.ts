import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Purchase } from './PurchaseModel';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
}
@Injectable({
  providedIn: 'root'
})
export class PurchaseService {

  private url = 'http://localhost:8080/purchase';

  constructor(private httpService: HttpClient) {}

  addTask(task:Purchase) {
    return this.httpService.post<Purchase>(this.url + '/save' , task, httpOptions);
  }
}
