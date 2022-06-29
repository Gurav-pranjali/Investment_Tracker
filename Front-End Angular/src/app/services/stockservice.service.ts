import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginService } from './login.service';
import { SD_URL } from './../app.constants';
import { AllStock } from '../model/availablestock';

@Injectable({
  providedIn: 'root'
})
export class StockserviceService {

  constructor(private http: HttpClient, private loginService: LoginService) {
  }

  getAllStockDetails() {
    let token = this.loginService.getToken();
    let options = {
      headers: { "Authorization": "Bearer " + token }
    }
    return this.http.get<AllStock[]>(`${SD_URL}/SharePrice/allstock`, options)
  }


  getStockDetails(stock: String) {
    let token = this.loginService.getToken();
    let options = {
      headers: { "Authorization": "Bearer " + token }

    }
    return this.http.get<AllStock>(`${SD_URL}/SharePrice/` + stock, options)
  }
}
