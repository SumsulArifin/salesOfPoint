import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { PurchaseService } from './purchase.service';
import { Supplier } from './SupplierModel';

@Component({
  selector: 'app-purchase',
  templateUrl: './purchase.component.html',
  styleUrls: ['./purchase.component.css']
})
export class PurchaseComponent implements OnInit{

  purchaseForm!: FormGroup;

  supplierList !: Supplier[];


  constructor(private services: PurchaseService,
     private router: Router, 
     private formBuilder: FormBuilder,) { }

  ngOnInit(): void {

    this.services.getSupplier().subscribe((newPost: Supplier[]) => {
      this.supplierList = newPost;
    })

    this.buildForm();
  }

  buildForm() {
    this.purchaseForm = this.formBuilder.group({
      purchase: this.formBuilder.group({
        purchaseDate: ['', Validators.required],
        price: ['', Validators.required],
        payment: ['', Validators.required],
        discount: ['', Validators.required],
        totalAmount: ['', Validators.required],
        deliveryAddress: ['', Validators.required],
        warranty: ['', Validators.required],
      }),
      stock: this.formBuilder.group({
        quantity: ['', Validators.required],
        supplierId: [''],
      }),
      product: this.formBuilder.group({
        productName: ['', Validators.required],
        productType: ['', Validators.required],
      }),
      productDetails: this.formBuilder.group({
        registrationNo: ['', Validators.required],
        chassisNumber: ['', Validators.required],
        engineNumber: ['', Validators.required],
        cubicCapacity: ['', Validators.required],
        noOfTyres: ['', Validators.required],
        numberOfCylinders: ['', Validators.required],
        yearOfManufacture: ['', Validators.required],
        mileage: ['', Validators.required],
        drive: ['', Validators.required],
        seatingCapacity: ['', Validators.required],
        fuelType: ['', Validators.required],
        exteriorColor: ['', Validators.required],
        carFeatures: ['', Validators.required],
        body: ['', Validators.required],
        exportedFrom: ['', Validators.required],
        }),
      supplier: this.formBuilder.group({
        supplierId: [''],
      }),
    });
  }

    

  onSubmit() {
    if (this.purchaseForm.valid) {
      const formData = this.purchaseForm.value;
      try {
        console.log('Trying to access data.purchase:', formData.purchase);
        console.log('Trying to access data.stock:', formData.stock);
        console.log('Trying to access data.product:', formData.product);
        console.log('Trying to access data.product.productDetails:', formData.product.productDetails);
      } catch (error) {
        console.error('Error accessing form data:', error);
      }
      this.services.savePurchase(formData).subscribe(
        response => {
          console.log('Data saved successfully', response);
        },
        error => {
          console.error('Error saving data', error);
        }
      );
    }
  }

}
