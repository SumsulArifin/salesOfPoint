import { Component } from '@angular/core';
import { Purchase } from './PurchaseModel';
import { Stock } from './stock.model';
import { HomeService } from './stock.service';

@Component({
  selector: 'app-stock',
  templateUrl: './stock.component.html',
  styleUrls: ['./stock.component.css']
})
export class StockComponent {
  stocks: Stock[] = [];

  purchaseList: Purchase[]=[];

  constructor(private stockService: HomeService) { }

  ngOnInit(): void {
    this.fetchStock();
  }

  fetchStock(): void {
    this.stockService.getAllStock()
      .subscribe((data: Stock[]) => {
        this.stocks = data;
      });

      this.stockService.getAllPurchase()
      .subscribe((data: Purchase[]) => {
        this.purchaseList = data;
      });
  }


}
