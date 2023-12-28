import { Component, OnInit } from '@angular/core';
import { CheckModel } from './CheckServiceModel';
import { CheckserviceService } from './checkservice.service';

@Component({
  selector: 'app-checkservice',
  templateUrl: './checkservice.component.html',
  styleUrls: ['./checkservice.component.css']
})
export class CheckserviceComponent implements OnInit{

  invoiceNo: number = 0;

  showTable: boolean = false;

  check!: CheckModel[];

  constructor(private service: CheckserviceService) { }

  ngOnInit(): void {
    
  }


  searchSalesByInvoiceNo(): void {
    if (this.invoiceNo !== null) {
      this.service.getStocksByProductName(this.invoiceNo)
        .subscribe(check => {
          this.check = check;
        });
    }
    this.showTable = this.check.length > 0;
  }

}
