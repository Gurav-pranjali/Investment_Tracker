//response schema for rest api
export class StockDetail{
    constructor(
        public stId:number,
        public stockName:string,
        public stockCount:number,
        public currentPrice:number
        ){}
}