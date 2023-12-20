import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { HomeComponent } from './home/home.component';






// import { LoginComponent } from './login/login.component';

const routes: Routes = [
  
  {path: "login" , component: LoginComponent},
  {path: "registration" , component: RegistrationComponent},
  {path: "home" , component: HomeComponent},
 
  {path: "**" , component: LoginComponent},


  {path: " " , component: LoginComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
