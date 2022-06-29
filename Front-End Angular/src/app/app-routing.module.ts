import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContactUsComponent } from './components/contact-us/contact-us.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { ErrorComponent } from './components/error/error.component';
import { SellassetComponent } from './components/sellasset/sellasset.component';
import { AuthGuard } from './services/auth.guard';
import { ViewassetComponent } from './components/viewasset/viewasset.component';
import { AllassetpriceComponent } from './components/allassetprice/allassetprice.component';

const routes: Routes = [
  {
    path:'',
    component:HomeComponent,
    pathMatch:'full'
  },
  {
    path:"login",
    component:LoginComponent,
    pathMatch:"full"
  },
  {
    path:"dashboard",
    component:DashboardComponent,
    pathMatch:"full",
    canActivate:[AuthGuard]
  },
  {
    path:"contact",
    component:ContactUsComponent,
    pathMatch:"full",
  
  },
  {
    path:"viewasset",
    component:ViewassetComponent,
    pathMatch:"full",
    canActivate:[AuthGuard]
  
  },
  {
    path:"sellasset",
    component:SellassetComponent,
    pathMatch:"full",
    canActivate:[AuthGuard]
  
  },
  {
    path:"currentprice",
    component:AllassetpriceComponent,
    pathMatch:"full",
    canActivate:[AuthGuard]
  
  },
  { 
    path: '**', 
    component: ErrorComponent 
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
