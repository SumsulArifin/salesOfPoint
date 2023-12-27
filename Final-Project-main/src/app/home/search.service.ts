import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Stock } from '../stock/stock.model';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  private apiUrl = 'http://localhost:8080/stock/byProductName';

  constructor(private http: HttpClient) {}

  getStocksByProductName(productName: string): Observable<Stock[]> {
    const url = `${this.apiUrl}/${productName}`;
    return this.http.get<Stock[]>(url);
  }
}
