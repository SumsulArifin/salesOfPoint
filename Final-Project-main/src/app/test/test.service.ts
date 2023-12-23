import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
}
@Injectable({
  providedIn: 'root'
})
export class TestService {

  private url = 'http://localhost:8080/book';

  constructor(private httpService: HttpClient) { }

  // createData(task:Purchase) {
  //   return this.httpService.post<Purchase>(this.url + '/save' , task, httpOptions);
  // }

  // createData(book: Book): Observable<Book> {
  //   return this.httpService.post<Book>(this.url + '/save' , book, httpOptions);
  // }

  saveBook(data: any): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });

    return this.httpService.post<any>(`${this.url}/save`, { ...data.book, ...data.author }, { headers });
  }
  
  



}
