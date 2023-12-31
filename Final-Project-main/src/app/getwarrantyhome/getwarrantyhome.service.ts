import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';



const headers = new HttpHeaders({
  'Content-Type': 'application/json'
});

@Injectable({
  providedIn: 'root'
})
export class GetwarrantyhomeService {

  private url = 'http://localhost:8080/sale';



  constructor(private httpService: HttpClient) { }


  find(id:number) : Observable<any>{
    return this.httpService.get(this.url + '/getSaleById/' + id)
  }
}
