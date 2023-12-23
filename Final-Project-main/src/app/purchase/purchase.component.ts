import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { PurchaseService } from './purchase.service';
import { Supplier } from './SupplierModel';

@Component({
  selector: 'app-purchase',
  templateUrl: './purchase.component.html',
  styleUrls: ['./purchase.component.css']
})
export class PurchaseComponent implements OnInit{

  form2!: FormGroup;

  supplierList !: Supplier[];


  constructor(private services: PurchaseService, private router: Router) { }

  ngOnInit(): void {

    this.services.getSupplier().subscribe((suppliers: Supplier[]) => {
      this.supplierList = suppliers;
      console.log(this.supplierList);
      
    });


    this.form2 = new FormGroup({
      purchaseDate: new FormControl('', Validators.required),
      price: new FormControl('', Validators.required),
      payment: new FormControl('', Validators.required),
      discount: new FormControl('', Validators.required),
      totalAmount: new FormControl('', Validators.required),
      deliveryAddress: new FormControl('', Validators.required),
      warranty: new FormControl('', Validators.required),
      stock: new FormGroup({
        quantity: new FormControl('', Validators.required),
        product: new FormGroup({
          productName: new FormControl(''),
          productType: new FormControl('', Validators.required),
          productDetails: new FormGroup({
            registrationNo: new FormControl('', Validators.required),
            chassisNumber: new FormControl('', Validators.required),
            engineNumber: new FormControl('', Validators.required),
            cubicCapacity: new FormControl('', Validators.required),
            noOfTyres: new FormControl('', Validators.required),
            numberOfCylinders: new FormControl('', Validators.required),
            yearOfManufacture: new FormControl('', Validators.required),
            engineCapacity: new FormControl('', Validators.required),
            mileage: new FormControl('', Validators.required),
            drive: new FormControl('', Validators.required),
            seatingCapacity: new FormControl('', Validators.required),
            fuelType: new FormControl('', Validators.required),
            exteriorColor: new FormControl('', Validators.required),
            carFeatures: new FormControl('', Validators.required),
            body: new FormControl('', Validators.required),
            rpm: new FormControl('', Validators.required),
          })
        }),
        supplier: new FormGroup({
          supplierId: new FormControl('', Validators.required),
        })
      })
    });
    
  }

  submit() {
    this.services.addTask(this.form2.value).subscribe(res => {

      this.ngOnInit();
    })

  }

}
