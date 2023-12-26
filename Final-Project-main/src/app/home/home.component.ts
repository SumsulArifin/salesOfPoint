import { Component } from '@angular/core';
import { Stock } from './stock.model';
import { HomeService } from './home.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  stocks: Stock[] = [];

  constructor(private stockService: HomeService) { }

  ngOnInit(): void {
    this.fetchStock();
  }

  fetchStock(): void {
    this.stockService.getAllStock()
      .subscribe((data: Stock[]) => {
        this.stocks = data;
      });
  }

}
