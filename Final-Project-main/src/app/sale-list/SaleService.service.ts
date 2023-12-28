import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Sale } from './saleList.model';


@Injectable({
  providedIn: 'root'
})
export class SaleService {
  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getAllSales(): Observable<Sale[]> {
    const url = `${this.baseUrl}/sale/getAllSale`;
    return this.http.get<Sale[]>(url);
  }
}
