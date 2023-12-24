import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { TestService } from './test.service';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {
  bookForm!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private dataService: TestService
  ) { }

  ngOnInit() {
    this.buildForm();
  }

  buildForm() {
    this.bookForm = this.formBuilder.group({
      book: this.formBuilder.group({
        bookName: ['', Validators.required],
        bookType: ['', Validators.required],
      }),
      author: this.formBuilder.group({
        published: ['', Validators.required],
        authorName: ['', Validators.required],
      })
    });
  }

  onSubmit() {
    if (this.bookForm.valid) {
      const formData = this.bookForm.value;
      console.log('Form Data:', formData);
      this.dataService.saveBook(formData).subscribe(
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
