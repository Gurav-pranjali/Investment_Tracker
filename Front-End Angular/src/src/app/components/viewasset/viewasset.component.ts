import { Component, OnInit } from '@angular/core';
import { AssetSaleResponse } from 'src/app/model/assetSaleResponse';
import { Portfolio } from 'src/app/model/portfolio';
import { CalculatenetworthserviceService } from 'src/app/services/calculatenetworthservice.service';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-viewasset',
  templateUrl: './viewasset.component.html',
  styleUrls: ['./viewasset.component.css']
})


export class ViewassetComponent implements OnInit {
  balance :number=0
  token: string | null = ""

  assetSaleResponse:AssetSaleResponse={saleStatus:false,networth:0} 
  portfolioResponse: Portfolio={portfolioid:0,stockDetailList:[],mutualFundList:[]}; 
  

  constructor(private calculatedNetService:CalculatenetworthserviceService,private loginService:LoginService) { }

  ngOnInit(): void {
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
  
  networth:any= this.getNetWorth();

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

  asset:any=this.getAsset();

}
