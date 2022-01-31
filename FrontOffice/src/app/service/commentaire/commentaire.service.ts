import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { SettingService } from '../setting/setting.service';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CommentaireService {

  error: any = {};
  reponse: any;
  errorData: any = {};
  constructor(
    private settingService : SettingService,
    private httpclient : HttpClient
  ) { }

  getApiCommentaireUrl(){
    return this.settingService.getDomaine()+"/commentaire";
  }
  createCommentaire(idAnnonce: any, idPersonne: any, description: any) {
    return new Promise((resolve, reject) => {
      const httpOptions = {
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
          'Accept': 'application/json'
        })
      };
      const body = {
      "idAnnonce": idAnnonce,
      "idPersonne": idPersonne,
      "description": description

      }
      this.httpclient.post(this.getApiCommentaireUrl(), body, httpOptions).pipe(
        catchError(this.handleError)
      ).subscribe(res => {
        resolve(res);
      }, (err) => {
        reject(err);
      });
    });
  }
  
  getCommentaires(id: any) {
    return new Promise((resolve, reject) => {
      const httpOptions = {
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
          'Accept': 'application/json'
        })
      };
      this.httpclient.get(this.getApiCommentaireUrl()+"s/"+id, httpOptions).pipe(
        catchError(this.handleError)
      ).subscribe(res => {
        resolve(res);
      }, (err) => {
        reject(err);
      });
    });
  }
  getListcommentaire(){
    return this.httpclient.get<any[]>(this.getApiCommentaireUrl()+"s");
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