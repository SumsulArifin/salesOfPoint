import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { PurchaseComponent } from './purchase/purchase.component';
import { SaleComponent } from './sale/sale.component';
import { StockComponent } from './stock/stock.component';
import { PurchaseListComponent } from './purchase-list/purchase-list.component';
import { CheckserviceComponent } from './checkservice/checkservice.component';






// import { LoginComponent } from './login/login.component';

const routes: Routes = [
  // {path:' ', redirectTo:'login'},
  // {path:'', redirectTo:'login', pathMatch:'full'},
  {path:'login',component:LoginComponent},
  {path: "register" , component: RegistrationComponent},
  {path: "home" , component: HomeComponent},
  {path: "purchase" , component: PurchaseComponent},
  {path: "purchaseList" , component: PurchaseListComponent},
  {path: "sale" , component: SaleComponent},
  {path: "navbar" , component: NavbarComponent},
  {path: "stock" , component: StockComponent},
  {path: "checkService" , component: CheckserviceComponent},
  {path: " " , component: LoginComponent},

  {path: "**" , component: LoginComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
