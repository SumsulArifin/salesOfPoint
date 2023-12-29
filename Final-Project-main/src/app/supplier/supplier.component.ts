import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { SupplierService } from './supplier.service';


@Component({
  selector: 'app-supplier',
  templateUrl: './supplier.component.html',
  styleUrls: ['./supplier.component.css']
})
export class SupplierComponent implements OnInit{

  supplierForm!: FormGroup;

  constructor(private services: SupplierService,
    private router: Router) { }

  ngOnInit(): void {

    this.supplierForm = new FormGroup({
      supplierName: new FormControl(''),
      contactPerson: new FormControl(''),
      email: new FormControl(''),
      phoneNumber: new FormControl(''),
      
    })
    
  }


  onSubmit() {
   
    this.services.addSupplier(this.supplierForm.value).subscribe((res:any) => {
      console.log('Post created successfully');
      // this.router.navigateByUrl('employeeList');
    })

}
}