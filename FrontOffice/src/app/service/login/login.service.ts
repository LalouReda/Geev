import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { SettingService } from '../setting/setting.service';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  error: any = {};
  reponse: any;
  errorData: any = {};
  constructor(
    private settingService : SettingService,
    private httpclient : HttpClient
  ) { }

  getApiPersonneUrl(){
    return this.settingService.getDomaine()+"/personne";
  }
  create(personne: any) {
    return new Promise((resolve, reject) => {
      const httpOptions = {
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
          'Accept': 'application/json'
        })
      };
      const body = {
        "nom": personne.nom,
        "prenom": personne.prenom,
        "email": personne.email,
        "description": personne.description,
        "telephone": personne.telephone,
        "password": personne.password
      }
      this.httpclient.post(this.getApiPersonneUrl(), body, httpOptions).pipe(
        catchError(this.handleError)
      ).subscribe(res => {
        resolve(res);
      }, (err) => {
        reject(err);
      });
    });
  }
  verifier(email: any,password:any) {
    return new Promise((resolve, reject) => {
      const httpOptions = {
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
          'Accept': 'application/json'
        })
      };
      const body = {
        "email": email,
        "password": password
      }
      this.httpclient.post(this.settingService.getDomaine()+"/login", body, httpOptions).pipe(
        catchError(this.handleError)
      ).subscribe(res => {
        resolve(res);
      }, (err) => {
        reject(err);
      });
    });
  }
  updatePersonne(personne: any) {
    return new Promise((resolve, reject) => {
      const httpOptions = {
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
          'Accept': 'application/json'
        })
      };
      const body = {
        "idPersonne": personne.idPersonne,
        "nom": personne.nom,
        "prenom": personne.prenom,
        "email": personne.email,
        "description": personne.description,
        "telephone": personne.telephone
      }
      this.httpclient.put(this.getApiPersonneUrl(), body, httpOptions).pipe(
        catchError(this.handleError)
      ).subscribe(res => {
        resolve(res);
      }, (err) => {
        reject(err);
      });
    });
  }
  deletePersonne(id: any) {
    return new Promise((resolve, reject) => {
      const httpOptions = {
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
          'Accept': 'application/json'
        })
      };
      this.httpclient.delete(this.getApiPersonneUrl()+"/"+id, httpOptions).pipe(
        catchError(this.handleError)
      ).subscribe(res => {
        resolve(res);
      }, (err) => {
        reject(err);
      });
    });
  }
  
  getPersonne(id: any) {
    return new Promise((resolve, reject) => {
      const httpOptions = {
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
          'Accept': 'application/json'
        })
      };
      this.httpclient.get(this.getApiPersonneUrl()+"/"+id, httpOptions).pipe(
        catchError(this.handleError)
      ).subscribe(res => {
        resolve(res);
      }, (err) => {
        reject(err);
      });
    });
  }
  getListPersonnes(){
    return this.httpclient.get<any[]>(this.getApiPersonneUrl()+"s");
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



