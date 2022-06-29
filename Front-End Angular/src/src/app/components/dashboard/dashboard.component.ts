import { Component, OnInit } from '@angular/core';
import { AssetSaleResponse } from 'src/app/model/assetSaleResponse';
import { Portfolio } from 'src/app/model/portfolio';
import { CalculatenetworthserviceService } from 'src/app/services/calculatenetworthservice.service';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private calculatedNetService:CalculatenetworthserviceService,
    private loginService:LoginService) { }
 balance :number=0
 uname:string=""
 //jwt token
 token: string | null = ""
assetSaleResponse:AssetSaleResponse={saleStatus:false,networth:0} 
 portfolioResponse: Portfolio={portfolioid:0,stockDetailList:[],mutualFundList:[]}; 


  ngOnInit(): void {
  }

  getAsset()
  {
    this.token=  this.loginService.getToken();
    if(this.token!=null)
    {
      this.calculatedNetService.getAsset().subscribe((data:Portfolio)=>
      {
        console.log(data);
        this.portfolioResponse= data;

      },
      (error:any)=>
      {
        console.log(error);
      });
  }
  }

  getNetWorth()
  {
    this.token=  this.loginService.getToken();
    if(this.token!=null)
    {
      this.calculatedNetService.getNetWorth().subscribe((data:any)=>
      {
        console.log(data);
        this.balance = data;
      },
      (error:any)=>
      {
        console.log(error);

      });
   }
  }

  
}
