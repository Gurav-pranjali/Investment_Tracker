import { MutualFund } from "./mutualfund";
import { StockDetail } from "./stockdetail";

//response schema for rest api
export class Portfolio{
    constructor(
        public  portfolioid:number,
        public stockDetailList:StockDetail[],
        public mutualFundList:MutualFund[]
        ){}
}