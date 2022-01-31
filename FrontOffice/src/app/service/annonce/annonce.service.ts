import { HttpClient, HttpErrorResponse, HttpHeaders, HttpParams } from '@angular/common/http';
import { SettingService } from '../setting/setting.service';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AnnonceService {

  error: any = {};
  reponse: any;
  errorData: any = {};
  constructor(
    private settingService : SettingService,
    private httpclient : HttpClient
  ) { }

  getApiAnnonceUrl(){
    return this.settingService.getDomaine()+"/annonce";
  }
  createAnnonce(annonce: any) {
    return new Promise((resolve, reject) => {
      const httpOptions = {
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
          'Accept': 'application/json'
        })
      };
      const body = {
        "title": annonce.titre,
      "image": annonce.image,
      "description": annonce.description,
      "adresseDeRecuperation": annonce.adresse,
      "idPersonne": localStorage.getItem("idPersonne")
      }
      this.httpclient.post(this.getApiAnnonceUrl(), body, httpOptions).pipe(
        catchError(this.handleError)
      ).subscribe(res => {
        resolve(res);
      }, (err) => {
        reject(err);
      });
    });
  }
  updateAnnonce(annonce: any) {
    return new Promise((resolve, reject) => {
      const httpOptions = {
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
          'Accept': 'application/json'
        })
      };
      const body = {
        "title": annonce.titre,
        "image": annonce.image,
        "description": annonce.description,
        "adresseDeRecuperation": annonce.adresse,
        "idPersonne": localStorage.getItem("idPersonne")
      }
      this.httpclient.put(this.getApiAnnonceUrl(), body, httpOptions).pipe(
        catchError(this.handleError)
      ).subscribe(res => {
        resolve(res);
      }, (err) => {
        reject(err);
      });
    });
  }
  deleteAnnonce(id: any) {
    return new Promise((resolve, reject) => {
      const httpOptions = {
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
          'Accept': 'application/json'
        })
      };
      this.httpclient.delete(this.getApiAnnonceUrl()+"/"+id, httpOptions).pipe(
        catchError(this.handleError)
      ).subscribe(res => {
        resolve(res);
      }, (err) => {
        reject(err);
      });
    });
  }
  getListAnnonces(){
    return this.httpclient.get<any[]>(this.getApiAnnonceUrl()+"s");
  }
  public upload(formData:any) {
    let headers = new HttpHeaders();
    let r: any;
    r=null;


    //this is the important step. You need to set content type as null
    headers.set('Content-Type', r);
    headers.set('Accept', "multipart/form-data");
    let params = new HttpParams();
    return this.httpclient.post<FormData>(this.settingService.getDomaine()+"/uploadFile", formData, { params, headers });
  }
  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
        alert(error.error.message);
        // A client-side or network error occurred. Handle it accordingly.
        console.error('Une erreur est survenue:', error.error.message);
    } else {
        //error(`Backend returned code ${error.status}, ` + `body was: ${error.error}`);
        // The backend returned an unsuccessful response code.
        // The response body may contain clues as to what went wrong.
        console.error(`Backend returned code ${error.status}, ` + `body was: ${error.error}`);
    }
    // return an observable with a user-facing error message
    this.errorData = {
        errorTitle: 'Oops! Échec de la demande.',
        errorDesc: 'Quelque chose de terrible est arrivé. Veuillez réessayer plus tard.'
    };
    return throwError(this.errorData);
  }
}
