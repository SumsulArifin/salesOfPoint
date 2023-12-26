import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SaleService } from './sale.service';


@Component({
  selector: 'app-sale',
  templateUrl: './sale.component.html',
  styleUrls: ['./sale.component.css']
})
export class SaleComponent implements OnInit{

  saleForm!: FormGroup;

  constructor(private services: SaleService,
    private router: Router, 
    private formBuilder: FormBuilder,) { }



  ngOnInit(): void {
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
