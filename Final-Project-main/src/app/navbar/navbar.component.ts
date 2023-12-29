import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserAuthService } from '../authService/user-auth.service';
import { UserStoreService } from '../authService/user-store.service';
import { SearchService } from '../home/search.service';
import { Stock } from '../stock/stock.model';
import { ChangeDetectorRef } from '@angular/core';
import { Renderer2, ElementRef } from '@angular/core';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit{


  selectedNavItem: string | null = null;
  public fullName : string = "";
  public role!:string;




  constructor(
    private router: Router, 
    private renderer: Renderer2, 
    private el: ElementRef,
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

  navigatePurchase() {
    this.router.navigateByUrl("purchase");
    this.activateNavItem('purchase');
  }

  navigateSale() {
    this.router.navigateByUrl("sale");
    this.activateNavItem('sale');
  }
  navigateStock() {
    this.router.navigateByUrl("stock");
    this.activateNavItem('stock');
  }
  
  navigateSaleList() {
    this.router.navigateByUrl("saleList");
    this.activateNavItem('saleList');
  }

  navigateHome() {
    this.router.navigateByUrl("home");
    this.activateNavItem('home');
  }
  navigatepurchaseList() {
    this.router.navigateByUrl("purchaseList");
    this.activateNavItem('purchaseList');
  }

  navigateWarranty() {
    this.router.navigateByUrl("checkService");
    this.activateNavItem('checkService');
  }

  navigateInvoice() {
    this.router.navigateByUrl("invoice");
    this.activateNavItem('invoice');
  }

  navigateSupplier() {
    this.router.navigateByUrl("supplier");
    this.activateNavItem('supplier');
  }


  


  private activateNavItem(item: string) {
    // Deactivate previously selected item
    if (this.selectedNavItem) {
      const prevNavItem = this.el.nativeElement.querySelector(`[data-item="${this.selectedNavItem}"]`);
      this.renderer.removeClass(prevNavItem, 'nav-item-active');
    }

    // Activate the clicked item
    const currentNavItem = this.el.nativeElement.querySelector(`[data-item="${item}"]`);
    this.renderer.addClass(currentNavItem, 'nav-item-active');

    // Update selectedNavItem
    this.selectedNavItem = item;
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
