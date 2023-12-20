import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SharedService {

  private userRoleSubject: BehaviorSubject<string | null> = new BehaviorSubject<string | null>(null);
  private userNameSubject: BehaviorSubject<string | null> = new BehaviorSubject<string | null>(null);

  userRole$: Observable<string | null> = this.userRoleSubject.asObservable();
  userName$: Observable<string | null> = this.userNameSubject.asObservable();

  setUserRole(userRole: string | null): void {
    this.userRoleSubject.next(userRole);
  }

  setUserName(userName: string | null): void {
    this.userNameSubject.next(userName);
  }
}
