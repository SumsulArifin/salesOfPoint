import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from './login.service';
import { SharedService } from '../shared.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  form2 !: FormGroup;

  userRole: string | null = null;

  constructor(
    private service: LoginService,

    private router: Router,

    private sharedService: SharedService

  ) { }


  ngOnInit(): void {

    this.form2 = new FormGroup({

      email: new FormControl(''),
      password: new FormControl(''),
    })
  }






  onSubmit(): void {
    const email = this.form2.get('email')?.value;
    const password = this.form2.get('password')?.value;

    this.service.login(email, password).subscribe(
      (response: any) => {
        console.log('Response:', response);
        if (response != null) {

          this.userRole = response.role;

          this.sharedService.setUserRole(response.role);
          this.sharedService.setUserName(response.name);

          

            this.router.navigateByUrl("home");
            
          

          

          // Assuming the response contains employee details
          // You can handle the response data accordingly
          console.log('Employee Details:', response);

          // Redirect to the desired page or perform other actions
        } else {
          // Handle login failure
          console.error('Login failed. Employee details not found.');
        }
      },
      (error) => {
        // Log the error to the console
        console.error('HTTP error:', error);
      }
    );
  }

  registerUser() {

    this.router.navigateByUrl("registration");
  }
}
