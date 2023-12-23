import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Purchase } from './PurchaseModel';
import { Supplier } from './SupplierModel';
import { Observable } from 'rxjs';
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

  private urlSupplier = 'http://localhost:8080/supplier';

  constructor(private httpService: HttpClient) {}

  addTask(task:Purchase) {
    return this.httpService.post<Purchase>(this.url + '/save' , task, httpOptions);
  }

  getSupplier() : Observable<Supplier[]> {
    const task = this.httpService.get<Supplier[]>(this.urlSupplier + '/getAllSupplier');
    return task;
  }
}
