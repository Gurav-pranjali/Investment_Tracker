import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginService } from './login.service';
import { MF_URL } from './../app.constants';
import { AllMutualFund } from '../model/availablemutualfund';

@Injectable({
  providedIn: 'root'
})
export class MutualfundserviceService {

  constructor(private http: HttpClient, private loginService: LoginService) { }

  getAllMutualFund() {
    let token = this.loginService.getToken();
    let options = {
      headers: { "Authorization": "Bearer " + token }
    }
    return this.http.get<AllMutualFund[]>(`${MF_URL}/MutualFund/allmf`, options)

  }

  getCurrentMutualFund(mfname: String) {
    let token = this.loginService.getToken();
    let options = {
      headers: { "Authorization": "Bearer " + token }

    }
    return this.http.get<AllMutualFund>(`${MF_URL}/MutualFund/` + mfname, options)
  }
}
