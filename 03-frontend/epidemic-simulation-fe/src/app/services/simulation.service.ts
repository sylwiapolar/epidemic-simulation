
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { SimulationDetails } from '../common/simulation-details';

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

  getSimulationDetails(simulationId: number): Observable<SimulationDetails> {

    const simulationUrl = `${this.baseUrl}/${simulationId}`;

    return this.httpClient.get<SimulationDetails>(simulationUrl);
  }

  
}