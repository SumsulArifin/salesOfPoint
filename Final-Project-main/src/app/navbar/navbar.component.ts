import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserAuthService } from '../authService/user-auth.service';
import { UserStoreService } from '../authService/user-store.service';
import { SearchService } from '../home/search.service';
import { Stock } from '../stock/stock.model';

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
    private service: SearchService
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

  navigatePurchase() {
    this.router.navigateByUrl("purchase");
   
  }

  navigateSale() {
    this.router.navigateByUrl("sale");
   
  }
  navigateStock() {
    this.router.navigateByUrl("stock");
   
  }
  
  navigateSaleList() {
    this.router.navigateByUrl("saleList");
   

  }

  navigateHome() {
    this.router.navigateByUrl("home");
   
  }
  navigatepurchaseList() {
    this.router.navigateByUrl("purchaseList");
   
  }

  navigateWarranty() {
    this.router.navigateByUrl("checkService");
   
  }

  navigateInvoice() {
    this.router.navigateByUrl("invoice");
   
  }



  


  





  

  navigateTest() {
    this.router.navigateByUrl("test");
   
  }

  public isLoggedIn() {
    return this.userAuthService.isLoggedIn();
  }

  public logout() {
    this.userAuthService.clear();
    this.router.navigateByUrl("/login");
  }
 
  

}
