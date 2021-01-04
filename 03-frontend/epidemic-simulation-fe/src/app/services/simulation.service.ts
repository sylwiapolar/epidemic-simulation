import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { SimulationProperties } from '../common/simulation-properties';

@Injectable({
  providedIn: 'root'
})
export class SimulationService {

  // TODO refactor url from hardcoded
  private baseUrl = 'http://localhost:8080/api/simulations';

  constructor(private httpClient: HttpClient) { }

  getSimulationList(): Observable<any> {
    return this.httpClient.get(this.baseUrl);
  }

  
}

