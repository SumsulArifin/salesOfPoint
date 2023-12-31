import { Component, OnInit } from '@angular/core';
import { CheckModel } from './CheckServiceModel';
import { CheckserviceService } from './checkservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-checkservice',
  templateUrl: './checkservice.component.html',
  styleUrls: ['./checkservice.component.css']
})
export class CheckserviceComponent implements OnInit{

  invoiceNo!: number;

  showTable: boolean = false;

  check!: CheckModel[];

  constructor(private service: CheckserviceService, private router: Router) { }

  ngOnInit(): void {

    
  }


  searchSalesByInvoiceNo(): void {
    
      this.service.getStocksByProductName(this.invoiceNo)
        .subscribe(check => {
          this.check = check;
          console.log(this.check);
          this.showTable = this.check.length > 0;
        });
    
    
  }

  getYearOfSaleDate(check: CheckModel): string | null {
    // Assuming yearOfManufacture is a property in the productDetails object
    return check?.saleDate || null;
  }

  getYearOfEndDate(check: CheckModel): string | null {
    // Assuming yearOfManufacture is a property in the productDetails object
    return check?.endDate || null;
  }

  routeToService() {
    this.router.navigateByUrl("getWarranty");
  }

}
