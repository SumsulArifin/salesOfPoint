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

  searchProduct!:string;
  
  stocks: Stock[] = [];

  originalStocks: Stock[] = [];

  purchaseList: Purchase[]=[];

  constructor(private stockService: HomeService) { }

  ngOnInit(): void {
    this.fetchStock();
  }

  fetchStock(): void {
    this.stockService.getAllStock().subscribe((data: Stock[]) => {
      this.stocks = data;
      this.originalStocks = [...this.stocks]; // Make a copy for initial display
    });

      this.stockService.getAllPurchase()
      .subscribe((data: Purchase[]) => {
        this.purchaseList = data;
      });
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

  getYearOfManufacture(stock: Stock): string | null {
    // Assuming yearOfManufacture is a property in the productDetails object
    return stock?.product?.productDetails?.yearOfManufacture || null;
  }


}
