import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Supplier } from '../purchase/SupplierModel';
import { PurchaseService } from '../purchase/purchase.service';
import { Book } from './TestModel';
import { TestService } from './test.service';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit{

  bookForm !: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private dataService: TestService // Assuming you have a DataService to handle CRUD operations
  ) { }


  ngOnInit(): void {
    this.bookForm = this.formBuilder.group({
      bookName: ['', Validators.required],
      bookType: ['', Validators.required],
      author: this.formBuilder.group({
        published: ['', Validators.required],
        authorName: ['', Validators.required]
      })
    });

  }

  onSubmit(): void {
    if (this.bookForm.valid) {
      const formData: Book = this.bookForm.value;

      this.dataService.createBook(formData).subscribe(
        response => {
          console.log('Data saved successfully:', response);
          this.bookForm.reset();
        },
        error => {
          console.error('Error saving data:', error);
        }
      );
    }
  }

}
