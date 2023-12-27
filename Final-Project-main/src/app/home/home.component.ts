import { Component } from '@angular/core';
import { Stock } from '../stock/stock.model';
import { HomeService } from '../stock/stock.service';
import { Purchase } from '../stock/PurchaseModel';
import { SearchService } from './search.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  stocks: Stock[] = [];

  purchaseList: Purchase[]=[];

  productName: string = '';

  showTable: boolean = false;

  constructor(private stockService: HomeService,
              private service: SearchService) { }

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
  searchStocksByProductName(): void {
    if (this.productName.trim() !== '') {
      this.service.getStocksByProductName(this.productName)
        .subscribe(stocks => {
          this.stocks = stocks;
        });
    }
    this.showTable = this.stocks.length > 0;
  }

}
