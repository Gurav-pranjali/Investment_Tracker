import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AssetSaleResponse } from '../model/assetSaleResponse';
import { Portfolio } from '../model/portfolio';
import { SaleAsset } from '../model/saleasset';
import { StockDetail } from '../model/stockdetail';
import { CN_URL } from './../app.constants';
import { LoginService } from './login.service';
@Injectable({
  providedIn: 'root'
})
export class CalculatenetworthserviceService {
  constructor(private http: HttpClient, private loginService: LoginService) { }

  getNetWorth() {
    let token = this.loginService.getToken();
    let options = {
      headers: { "Authorization": "Bearer " + token }
    }
    return this.http.get(`${CN_URL}/calculateNetworth/`, options)
  }

  getAsset() {
    let token = this.loginService.getToken();
    let options = {
      headers: { "Authorization": "Bearer " + token }
    }
    return this.http.get<Portfolio>(`${CN_URL}/calculateNetworth/viewAsset`, options)
  }

  sellAsset(stockDetail: SaleAsset[]) {
    let token = this.loginService.getToken();
    let options = {
      headers: { "Authorization": "Bearer " + token }
    }
    return this.http.post<AssetSaleResponse>(`${CN_URL}/calculateNetworth/sellAssets`, stockDetail, options);
  }


}
