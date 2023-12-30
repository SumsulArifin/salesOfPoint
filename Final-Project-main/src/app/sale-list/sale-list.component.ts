import { Component } from '@angular/core';
import { Sale } from './saleList.model';
import { SaleService } from './SaleService.service';

@Component({
  selector: 'app-sale-list',
  templateUrl: './sale-list.component.html',
  styleUrls: ['./sale-list.component.css']
})
export class SaleListComponent {

  sales: Sale[] = [];

  constructor(private saleService: SaleService) { }

  ngOnInit(): void {
    this.getAllSales();
  }

  getAllSales() {
    this.saleService.getAllSales()
      .subscribe(data => {
        this.sales = data;
      });
  }

  getYearOfSaleDate(sale: Sale): string | null {
    // Assuming yearOfManufacture is a property in the productDetails object
    return sale?.saleDate || null;
  }

  getYearOfWarranty(sale: Sale): string | null {
    // Assuming yearOfManufacture is a property in the productDetails object
    return sale?.warranty?.endDate || null;
  }

}
