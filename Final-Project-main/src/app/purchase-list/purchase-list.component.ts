import { Component } from '@angular/core';
import { Purchase } from '../stock/PurchaseModel';
import { HomeService } from '../stock/stock.service';

@Component({
  selector: 'app-purchase-list',
  templateUrl: './purchase-list.component.html',
  styleUrls: ['./purchase-list.component.css']
})
export class PurchaseListComponent {
  originalPurchaseList: Purchase[] = [];
  purchaseList: Purchase[] = [];
  searchDate!: string; // Add this property for storing the search date

  constructor(private stockService: HomeService) {}

  ngOnInit(): void {
    this.fetchStock();
  }

  fetchStock(): void {
    this.stockService.getAllPurchase().subscribe((data: Purchase[]) => {
      this.originalPurchaseList = data;
      this.filterPurchaseList();
    });
  }

  // Modify the method to filter the originalPurchaseList based on the searchDate
  searchByDate(): void {
    this.filterPurchaseList();
  }

  private filterPurchaseList(): void {
    if (this.searchDate) {
      // Use the Array.filter method to filter the originalPurchaseList
      this.purchaseList = this.originalPurchaseList.filter((purchase) => {
        // Assuming purchaseDate is a string in the format 'YYYY-MM-DDTHH:mm:ss.SSSZ'
        return purchase.purchaseDate.startsWith(this.searchDate);
      });
    } else {
      // If the search date is empty, show the original list
      this.purchaseList = [...this.originalPurchaseList];
    }
  }
}
 