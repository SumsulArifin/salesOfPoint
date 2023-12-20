import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, NgForm } from '@angular/forms';
import { Data, Router } from '@angular/router';
import { LoginService } from './login.service';
import { SharedService } from '../shared.service';
import { UserAuthService } from '../authService/user-auth.service';
import { UserStoreService } from '../authService/user-store.service';

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
    private auth: UserAuthService,
    private router: Router,
    private userStore: UserStoreService,

  ) { }


  ngOnInit(): void {

    this.form2 = new FormGroup({

      email: new FormControl(''),
      password: new FormControl(''),
    })
  }




  login(loginForm: NgForm) {
    this.service.login(loginForm.value).subscribe(
      (response: Data) => {
        this.auth.storeToken(response['access_token']);
        const tokenPayload = this.auth.decodedToken();
        console.log(tokenPayload);
        this.userStore.setRoleForStore(tokenPayload.role);      
        this.auth.storeRefreshToken(response['refreshToken']);
        this.router.navigate(['/home']);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  registerUser() {
    this.router.navigate(['/register']);
  }





}
