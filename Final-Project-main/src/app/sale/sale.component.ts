import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SaleService } from './sale.service';


import { PurchaseModel } from './GetPurchase';
import { Stock } from '../stock/stock.model';


@Component({
  selector: 'app-sale',
  templateUrl: './sale.component.html',
  styleUrls: ['./sale.component.css']
})
export class SaleComponent implements OnInit{

  stockid!: number;

  basePrice!: PurchaseModel[];

  stockList!: Stock[];

  saleForm!: FormGroup;

  constructor(private services: SaleService,
    private router: Router, 
    private formBuilder: FormBuilder,) { }



  ngOnInit(): void {




    this.services.getStock().subscribe((newPost: Stock[]) => {
      this.stockList = newPost;
      console.log(this.stockList);
      
    });

    this.createForm();
  }


  createForm(): void {
    this.saleForm = this.formBuilder.group({
      sale: this.formBuilder.group({
      quantity: ['', Validators.required],
      saleDate: ['', Validators.required],
      price: ['', Validators.required],
      discount: ['', Validators.required],
      totalAmount: ['', Validators.required],
    }),
      stock: this.formBuilder.group({
       
        stockId: [], 
        
      }),
      customer: this.formBuilder.group({
        
        firstName: ['', Validators.required],
        lastName: ['', Validators.required],
        email: ['', Validators.required],
        phoneNumber: ['', Validators.required],
        

      }),
    });
    this.saleForm.get('sale.discount')?.valueChanges.subscribe(discount => {
      this.calculateTotalAmount(discount);
    });
  }

  calculateTotalAmount(discount: number): void {
    const price = this.saleForm.get('sale.price')?.value || 0;
    const calculatedTotalAmount = price - discount;

    // Set the calculated total amount in the form
    this.saleForm.patchValue({
      sale: {
        totalAmount: calculatedTotalAmount,
      },
    });
  }

  onProductSelectionChange(): void {
    const selectedStockId = this.saleForm.get('stock.stockId')?.value;

    // Fetch purchase details based on the selected stockId
    this.services.find(selectedStockId).subscribe((task: PurchaseModel[]) => {
      this.basePrice = task;

      // Assuming you have a single purchase for a stockId
      if (this.basePrice.length > 0) {
        // Update the price field in the form with the fetched price
        this.saleForm.patchValue({
          sale: {
            price: this.basePrice[0].price,
          },
        });
        this.calculateTotalAmount(this.saleForm.get('sale.discount')?.value);
      }
    });
  }



  onSubmit() {
    if (this.saleForm.valid) {
      const formData = this.saleForm.value;

      console.log(formData);
      
     
      this.services.saveSale(formData).subscribe(
        response => {
          console.log('Data saved successfully', response);
          this.router.navigateByUrl("home");
        },
        error => {
          console.error('Error saving data', error);
        }
      );
    }
  }

}
