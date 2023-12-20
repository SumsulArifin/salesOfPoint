import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { RegistrationService } from './registration.service';
import { User } from './user.model';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit{


  form2!: FormGroup;
  user = new User('', '', '', '');

  constructor(private services: RegistrationService, private router: Router) { }

  ngOnInit(): void {
    this.form2 = new FormGroup({
      name: new FormControl(''),
      email: new FormControl(''),
      password: new FormControl(''),
      role: new FormControl(''),

    })
  }

  doRegister() {
    this.services.registerUser(this.user).subscribe({
      next: (response) => {
        console.log(response); // Log the response if needed
        this.router.navigate(['login']);
      },
      error: (error) => {
        console.error(error); // Handle error if necessary
      },
      complete: () => {},
    });

    
  }

}
