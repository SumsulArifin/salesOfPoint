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

  originalStocks: Stock[] = [];

  productName: string = '';

  showTable: boolean = false;

  searchProduct!:string;

  constructor(private stockService: HomeService,
              private service: SearchService) { }

  ngOnInit(): void {
    this.fetchStock();
  }

  fetchStock(): void {
    this.stockService.getAllStock()
      .subscribe((data: Stock[]) => {
        this.stocks = data;
        this.originalStocks = [...this.stocks];
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

  searchByProduct(): void {
    if (this.searchProduct) {
      // Use the Array.filter method to filter the originalStocks
      this.stocks = this.originalStocks.filter((stock) => {
        // Assuming productName is a string
        return stock.product.productName.toLowerCase().includes(this.searchProduct.toLowerCase());
      });
    } else {
      // If the search product is empty, show the original list
      this.stocks = [...this.originalStocks];
    }
  }

}
