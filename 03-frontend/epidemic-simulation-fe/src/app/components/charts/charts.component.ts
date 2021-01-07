import { Component, Input, OnInit } from '@angular/core';
import { SimulationResult } from 'src/app/common/simulation-result';

@Component({
  selector: 'app-charts',
  templateUrl: './charts.component.html',
  styleUrls: ['./charts.component.css']
})
export class ChartsComponent implements OnInit {

  public simulationOptions = {
    responsive: true
  };

  public simulationLabels = [];
  public simulationChartType = 'line';
  public simulationChartLegend = true;

  public simulationChartData = [];

  constructor() {
    this.simulationChartData = [
      { data: [], label: '[Pi] - Infected' },
      { data: [], label: '[Pv] - Prone to infection' },
      { data: [], label: '[Pm] - Death cases' },
      { data: [], label: '[Pr] - Recovered' }
    ]
  }

  ngOnInit(): void {
  }

  loadSimulationResult(simulationResultList: SimulationResult[]) {
    let infectedData = [];
    let proneToInfectionData = [];
    let deathData = [];
    let recoveredData = [];

    simulationResultList.forEach(result => {
      infectedData.push(result.infected);
      proneToInfectionData.push(result.proneToInfection);
      deathData.push(result.dead);
      recoveredData.push(result.recovered);
      this.simulationLabels.push(result.simulationDay);
    });

    this.simulationChartData[0].data = infectedData;
    this.simulationChartData[1].data = proneToInfectionData;
    this.simulationChartData[2].data = deathData;
    this.simulationChartData[3].data = recoveredData;


  }
}

