import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserAuthService } from '../authService/user-auth.service';
import { UserStoreService } from '../authService/user-store.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit{
  public fullName : string = "";
  public role!:string;


  constructor(private router: Router,
    
    private userAuthService: UserAuthService,
    private auth:UserAuthService,
    private userStore: UserStoreService,
   ) {}


  ngOnInit(): void {

    this.userStore.getFullNameFromStore()
    .subscribe(val=>{
      const fullNameFromToken = this.auth.getfullNameFromToken();
      this.fullName = val || fullNameFromToken
      console.log(this.fullName);
      
    });
  
    this.userStore.getRoleFromStore()
    .subscribe(val=>{
      const roleFromToken = this.auth.getRoleFromToken();
      this.role = val || roleFromToken;
    })
    
  }

  navigate() {
    this.router.navigateByUrl("department", { skipLocationChange: true });
   
  }

  public isLoggedIn() {
    return this.userAuthService.isLoggedIn();
  }

  public logout() {
    this.userAuthService.clear();
    this.router.navigateByUrl("/login");
  }

  

}
