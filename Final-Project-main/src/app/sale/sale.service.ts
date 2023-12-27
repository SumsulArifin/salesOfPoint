import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PurchaseModel } from './GetPurchase';
import { Stock } from '../stock/stock.model';


@Injectable({
  providedIn: 'root'
})
export class SaleService {



  private url = 'http://localhost:8080/sale';

  private urls = 'http://localhost:8080/stock';

  private urlGetPrice = 'http://localhost:8080';



  constructor(private httpService: HttpClient) { }

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
      },
      customer: {
        firstName: data.customer.firstName,
        lastName: data.customer.lastName,
        email: data.customer.email,
        phoneNumber: data.customer.phoneNumber,

      },
      warranty: {
        startDate: data.warranty.startDate,
        endDate: data.warranty.endDate,
        terms1: data.warranty.terms1,
        terms2: data.warranty.terms2,
        terms3: data.warranty.terms3,
        terms4: data.warranty.terms4,
        terms5: data.warranty.terms5,
        terms6: data.warranty.terms6,
        terms7: data.warranty.terms7,
        terms8: data.warranty.terms8,
        terms9: data.warranty.terms9,
        terms10: data.warranty.terms10,
        comment: data.warranty.comment,

      },

    };
    console.log('Request Body:', requestBody);
    return this.httpService.post<any>(`${this.url}/save`, requestBody, { headers });
  }

  getStock(): Observable<Stock[]> {
    const task = this.httpService.get<Stock[]>(this.urls + '/getAllStock');
    return task;
  }

  find(stockId: number): Observable<PurchaseModel[]> {
    return this.httpService.get<PurchaseModel[]>(`${this.urlGetPrice}/purchase/${stockId}`);
  }

}
