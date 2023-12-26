import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Stock } from './stock.model';

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  private apiUrl = 'http://localhost:8080/stock';

  constructor(private http: HttpClient) { }

  getAllStock(): Observable<Stock[]> {
    return this.http.get<Stock[]>(`${this.apiUrl}/getAllStock`);
  }
}
