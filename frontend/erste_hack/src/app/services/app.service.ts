import { Injectable } from '@angular/core';
import {catchError, Observable, tap} from "rxjs";
import {environmentDevelop} from "../../environments/environment.develop";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AppService {

  private envUrl: string = environmentDevelop.apiURL

  constructor(
    private httpClient: HttpClient,
  ) { }

  getCurrentTime(): Observable<any> {
    return this.httpClient.get<any>(this.envUrl+'ping')
  }

  getFinancialData(): Observable<any> {
    return this.httpClient.get<any>(this.envUrl+'graph')
  }


  private static handleError(error: any): Promise<AppService> {
    return Promise.reject(error);
  }
}
