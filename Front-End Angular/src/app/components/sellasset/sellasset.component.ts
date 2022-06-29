import { Component, OnInit } from '@angular/core';
import { AssetSaleResponse } from 'src/app/model/assetSaleResponse';
import { AllMutualFund } from 'src/app/model/availablemutualfund';
import { AllStock } from 'src/app/model/availablestock';
import { MutualFund } from 'src/app/model/mutualfund';
import { Portfolio } from 'src/app/model/portfolio';
import { SaleAsset } from 'src/app/model/saleasset';
import { StockDetail } from 'src/app/model/stockdetail';
import { CalculatenetworthserviceService } from 'src/app/services/calculatenetworthservice.service';
import { LoginService } from 'src/app/services/login.service';
import { MutualfundserviceService } from 'src/app/services/mutualfundservice.service';
import { StockserviceService } from 'src/app/services/stockservice.service';

@Component({
  selector: 'app-sellasset',
  templateUrl: './sellasset.component.html',
  styleUrls: ['./sellasset.component.css']
})
export class SellassetComponent implements OnInit {

  constructor(private calculatedNetService:CalculatenetworthserviceService,
    private loginService:LoginService,private mfservice:MutualfundserviceService,private sdService:StockserviceService) { }

    sell:boolean=false
    message: string=""
    saleAsset:SaleAsset[]=[]
    panelOpenState = false;
    token: string | null = ""
    mutualFundl:MutualFund[]=[]
    stockDetailList1:StockDetail[]=[]
    assetSaleResponse:AssetSaleResponse={saleStatus:false,networth:0,map:new Map()}
    portfolioResponse: Portfolio={portfolioid:0,stockDetailList:[],mutualFundList:[]};
    currentMfPrice:AllMutualFund={mutualFundId:0,mutualFundName:"",mutualFundValue:0};
    currentStockPrice:AllStock={stockId:0,stockName:"",stockValue:0}
    
  ngOnInit(): void {
    this.getAsset()
  }

  sellAsset()
  {
   
    this.token=  this.loginService.getToken();
    if(this.token!=null)
    {
      this.calculatedNetService.sellAsset(this.saleAsset).subscribe((data:AssetSaleResponse)=>
      {
        console.log(data);
        this.assetSaleResponse=data;
        
        console.log(this.assetSaleResponse.networth)
        console.log(this.assetSaleResponse.map)
        console.log(this.assetSaleResponse.saleStatus)
        this.sell=true
        this. getAsset()
        this.removeAll()

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

  add(e:SaleAsset){
    if(e.soldUnits<=0)
    {
      alert("You can't sell 0 units")
    }
    this.saleAsset.push(e)
  }
  remove(e:string){
    this.saleAsset.splice(this.getIndexByname(e),1)
  }
  getIndexByname(name:string){
    for(let i=0;i<this.saleAsset.length;i++){
      if(this.saleAsset[i].assetName.match(name)){
        return i;
      }
    }
    return -1;
  }



  removeAll()
  {
    this.saleAsset.splice(0)
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

