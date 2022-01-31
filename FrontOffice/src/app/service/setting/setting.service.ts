import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SettingService {

  public domain =   'http://localhost:8080';

  constructor() { }

  getDomaine(){
    return this.domain;
  }  
  
  getImgDir(){
    return this.domain+"/downloadFile/";
  }

}
