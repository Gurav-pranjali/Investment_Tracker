import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthResponse } from '../model/authResponse';
import { API_URL } from './../app.constants';
@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) {}
  //calling the server to generate token
  generateToken(credentials:any)
  {
    //token generate
    return this.http.post<AuthResponse>(`${API_URL }/getToken`,credentials)
  }
 
  //for lofin user
  loginUser(token:string)
  {
    localStorage.setItem("token",token)
    return true;
  }
  // To check the Login
  isLoggedIn()
  {
    let token=localStorage.getItem("token");
    if(token==undefined|| token===''||token==null)
    {
      return false;
    }
    else
    {
      return true;
    }
  }
  //To logout
  logout()
  {
    localStorage.removeItem('token');
    return true;
  }

  getToken()
  {
    return localStorage.getItem("token")
  }
}
