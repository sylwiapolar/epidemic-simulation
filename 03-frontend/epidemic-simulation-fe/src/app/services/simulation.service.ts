
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { SimulationDetails } from '../common/simulation-details';
import { SimulationParameters } from '../common/simulation-parameters';

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

  submitSimulation(simulationParameters: SimulationParameters){    
    return this.httpClient.post<SimulationParameters>(this.baseUrl, simulationParameters);
  }

  deleteSimulation(simulationId: number): Observable<any> {
    const simulationUrl = `${this.baseUrl}/${simulationId}`;
    return this.httpClient.delete(simulationUrl, {responseType: 'text'});
  }


  //TODO
  editSimulation(simulationParameters: SimulationParameters): Observable<SimulationDetails> {
    // const simulationUrl = `${this.baseUrl}/${simulationId}`;
    return this.httpClient.put<SimulationDetails>(this.baseUrl, simulationParameters);
  }
  
  

}