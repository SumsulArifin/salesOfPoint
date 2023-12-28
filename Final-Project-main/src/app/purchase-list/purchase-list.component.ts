import { Component } from '@angular/core';
import { Purchase } from '../stock/PurchaseModel';
import { Stock } from '../stock/stock.model';
import { HomeService } from '../stock/stock.service';

@Component({
  selector: 'app-purchase-list',
  templateUrl: './purchase-list.component.html',
  styleUrls: ['./purchase-list.component.css']
})
export class PurchaseListComponent {


  purchaseList: Purchase[]=[];

  constructor(private stockService: HomeService) { }

  ngOnInit(): void {
    this.fetchStock();
  }

  fetchStock(): void {
    
      this.stockService.getAllPurchase()
      .subscribe((data: Purchase[]) => {
        this.purchaseList = data;
      });
  }

}
