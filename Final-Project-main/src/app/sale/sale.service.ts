import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Stock } from '../home/stock.model';
import { PurchaseModel } from './GetPurchase';


@Injectable({
  providedIn: 'root'
})
export class SaleService {

  
  
  private url = 'http://localhost:8080/sale';

  private urls = 'http://localhost:8080/stock';

  private urlGetPrice = 'http://localhost:8080';

 

  constructor(private httpService: HttpClient) {}

  saveSale(data: any): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
  
    const requestBody = {
      quantity: data.sale.quantity,
      saleDate: data.sale.saleDate,
      price: data.sale.price,
      discount: data.sale.discount,
      totalAmount: data.sale.totalAmount,
      stock: {
        stockId: data.stock.stockId,
        customer: {
          firstName: data.customer.firstName,
          lastName: data.customer.lastName,
          email: data.customer.email,
          phoneNumber: data.customer.phoneNumber,
         
        },
      }
    };
    console.log('Request Body:', requestBody);
    return this.httpService.post<any>(`${this.url}/save`, requestBody, { headers });
  }

  getStock() : Observable<Stock[]> {
    const task = this.httpService.get<Stock[]>(this.urls + '/getAllStock');
    return task;
  }

  find(stockId: number): Observable<PurchaseModel[]> {
    return this.httpService.get<PurchaseModel[]>(`${this.urlGetPrice}/purchase/${stockId}`);
  }

}
