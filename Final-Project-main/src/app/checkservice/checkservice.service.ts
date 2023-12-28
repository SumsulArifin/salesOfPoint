import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Stock } from '../stock/stock.model';
import { CheckModel } from './CheckServiceModel';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
}
@Injectable({
  providedIn: 'root'
})
export class CheckserviceService {

  private apiUrl = 'http://localhost:8080/sale/warranty';

  constructor(private http: HttpClient) {}

  getStocksByProductName(invoice: number): Observable<CheckModel[]> {
    const url = `${this.apiUrl}/${invoice}`;
    return this.http.get<CheckModel[]>(url);
  }
}
