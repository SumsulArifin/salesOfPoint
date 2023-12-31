import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NavbarComponent } from './navbar/navbar.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { HomeComponent } from './home/home.component';
import { PurchaseComponent } from './purchase/purchase.component';
import { SaleComponent } from './sale/sale.component';
import { StockComponent } from './stock/stock.component';
import { PurchaseListComponent } from './purchase-list/purchase-list.component';
import { CheckserviceComponent } from './checkservice/checkservice.component';
import { SaleListComponent } from './sale-list/sale-list.component';
import { InvoiceComponent } from './invoice/invoice.component';
import { SupplierComponent } from './supplier/supplier.component';
import { GetwarrantyhomeComponent } from './getwarrantyhome/getwarrantyhome.component';





@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    RegistrationComponent,
    HomeComponent,
    PurchaseComponent,
    SaleComponent,
    StockComponent,
    PurchaseListComponent,
    CheckserviceComponent,
    SaleListComponent,
    InvoiceComponent,
    SupplierComponent,
    GetwarrantyhomeComponent,
  
    

 
    

  ],
  imports: [
    
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
