export class AssetSaleResponse{
    constructor(
        public  saleStatus:boolean,
	    public networth:number,
        public map: Map<string, number> = new Map()
        ){}
}