import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { RegistrationService } from './registration.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit{


  form2!: FormGroup;

  constructor(private services: RegistrationService, private router: Router) { }

  ngOnInit(): void {
    this.form2 = new FormGroup({
      name: new FormControl(''),
      email: new FormControl(''),
      password: new FormControl(''),
      role: new FormControl(''),

    })
  }

  submit() {
    console.log(this.form2.value)


    this.services.addTask(this.form2.value).subscribe(res => {

      this.router.navigateByUrl('login2');

      this.ngOnInit();

    })

  }
}
