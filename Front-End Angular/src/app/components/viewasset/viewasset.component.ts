import { Component, OnInit } from '@angular/core';
import { AssetSaleResponse } from 'src/app/model/assetSaleResponse';
import { AllMutualFund } from 'src/app/model/availablemutualfund';
import { AllStock } from 'src/app/model/availablestock';
import { MutualFund } from 'src/app/model/mutualfund';
import { Portfolio } from 'src/app/model/portfolio';
import { StockDetail } from 'src/app/model/stockdetail';
import { CalculatenetworthserviceService } from 'src/app/services/calculatenetworthservice.service';
import { LoginService } from 'src/app/services/login.service';
import { MutualfundserviceService } from 'src/app/services/mutualfundservice.service';
import { StockserviceService } from 'src/app/services/stockservice.service';

@Component({
  selector: 'app-viewasset',
  templateUrl: './viewasset.component.html',
  styleUrls: ['./viewasset.component.css']
})


export class ViewassetComponent implements OnInit {
  balance :number=0
  token: string | null = ""

  assetSaleResponse:AssetSaleResponse={saleStatus:false,networth:0,map:new Map()} 
  portfolioResponse: Portfolio={portfolioid:0,stockDetailList:[],mutualFundList:[]}; 
  mutualFundl:MutualFund[]=[]
  stockDetailList1:StockDetail[]=[]
  currentMfPrice:AllMutualFund={mutualFundId:0,mutualFundName:"",mutualFundValue:0};
  currentStockPrice:AllStock={stockId:0,stockName:"",stockValue:0}
  

  constructor(private calculatedNetService:CalculatenetworthserviceService,private loginService:LoginService
    ,private mfservice:MutualfundserviceService,private sdService:StockserviceService) { }

  ngOnInit(): void {
    this.getNetWorth();
    this.getAsset();
  
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
  
  getAsset()
  {
    this.token=  this.loginService.getToken();
    if(this.token!=null)
    {
      this.calculatedNetService.getAsset().subscribe((data:Portfolio)=>
      {
        console.log(data);
        this.portfolioResponse= data;
        this. updateStockDetailList();
        this. updateMutualFundList();
      },
      (error:any)=>
      {
        console.log(error);
      });
  }
  }


  updateMutualFundList()
  {
  
    this.mutualFundl=this.portfolioResponse.mutualFundList
    for(let i=0;i<this.mutualFundl.length;i++){
      this.currentMfPrice={mutualFundId:0,mutualFundName:"",mutualFundValue:0};
      this.token=  this.loginService.getToken();
      if(this.token!=null)
      {
        this.mfservice.getCurrentMutualFund(this.mutualFundl[i].mutualFundName).subscribe((data:AllMutualFund)=>
        {
          console.log(data);
          if(this.mutualFundl[i].mutualFundName.match(data.mutualFundName)){

            this.mutualFundl[i].currentPrice=data.mutualFundValue;
          }
        },
        (error:any)=>
        {
          console.log(error);
  
        });
  
      }
    
    }
  }

  updateStockDetailList()
  {
   
    this.stockDetailList1=this.portfolioResponse.stockDetailList
    for(let i=0;i<this.stockDetailList1.length;i++){
      this.currentStockPrice={stockId:0,stockName:"",stockValue:0}
      this.token=  this.loginService.getToken();
      if(this.token!=null)
      {
        this.sdService.getStockDetails(this.stockDetailList1[i].stockName).subscribe((data:AllStock)=>
        {
          console.log(data);
          if(this.stockDetailList1[i].stockName.match(data.stockName)){
            this.stockDetailList1[i].currentPrice=data.stockValue;
          }
        },
        (error:any)=>
        {
          console.log(error);
  
        });
  
      }
    
    }
  }


}
