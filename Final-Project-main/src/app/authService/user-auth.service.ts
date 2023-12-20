import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';


@Injectable({
  providedIn: 'root',
})
export class UserAuthService {

  private userPayload:any;
  constructor() {
    this.userPayload = this.decodedToken();
  }

  storeToken(tokenValue: string){
    localStorage.setItem('access_token', tokenValue)
  }
  storeRefreshToken(tokenValue: string){
    localStorage.setItem('refreshToken', tokenValue)
  }

  public setRoles(roles: []) {
    localStorage.setItem('role', JSON.stringify(roles));
  }

  public getRoles(): string[] {
    const storedItem = localStorage.getItem('role');
    if (storedItem !== null) {
        return JSON.parse(storedItem);
    }
    return []; // or handle this case based on your application logic
}


  getToken(){
    return localStorage.getItem('access_token')
  }
  getRefreshToken(){
    return localStorage.getItem('refreshToken')
  }

  isLoggedIn(): boolean{
    return !!localStorage.getItem('access_token')
  }

  decodedToken(){
    const jwtHelper = new JwtHelperService();
    const token = this.getToken()!;
    console.log(jwtHelper.decodeToken(token))
    return jwtHelper.decodeToken(token)
  }

  getfullNameFromToken(){
    if(this.userPayload)
    return this.userPayload.name;
  }

  getRoleFromToken(){
    if(this.userPayload)
    return this.userPayload.role;
  }



  public clear() {
    localStorage.clear();
  }

  //
}
