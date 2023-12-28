import { Component, OnInit } from '@angular/core';
import { CheckModel } from './CheckServiceModel';
import { CheckserviceService } from './checkservice.service';

@Component({
  selector: 'app-checkservice',
  templateUrl: './checkservice.component.html',
  styleUrls: ['./checkservice.component.css']
})
export class CheckserviceComponent implements OnInit{

  invoiceNo!: number;

  showTable: boolean = false;

  check!: CheckModel[];

  constructor(private service: CheckserviceService) { }

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

}
