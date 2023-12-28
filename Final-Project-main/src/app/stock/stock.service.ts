import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Stock } from './stock.model';
import { Purchase } from './PurchaseModel';

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  private apiUrl = 'http://localhost:8080/stock';
  private apiPurUrl = 'http://localhost:8080/purchase';

  constructor(private http: HttpClient) { }

  getAllStock(): Observable<Stock[]> {
    return this.http.get<Stock[]>(`${this.apiUrl}/getAllStock`);
  }

  getAllPurchase(): Observable<Purchase[]> {
    return this.http.get<Purchase[]>(`${this.apiPurUrl}/getAllPurchase`);
  }
}
