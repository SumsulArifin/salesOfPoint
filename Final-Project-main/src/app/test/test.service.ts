import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { Purchase } from '../purchase/PurchaseModel';
import { Supplier } from '../purchase/SupplierModel';
import { Book } from './TestModel';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
}
@Injectable({
  providedIn: 'root'
})
export class TestService {

  private url = 'http://localhost:8080';

  constructor(private httpService: HttpClient) { }

  // createData(task:Purchase) {
  //   return this.httpService.post<Purchase>(this.url + '/save' , task, httpOptions);
  // }

  // createData(book: Book): Observable<Book> {
  //   return this.httpService.post<Book>(this.url + '/save' , book, httpOptions);
  // }

  createBook(data: Book): Observable<any> {
    return this.httpService.post<any>(`${this.url}/book/save`, data);
  }
  
  



}
