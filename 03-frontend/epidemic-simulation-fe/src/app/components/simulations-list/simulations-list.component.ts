import { Component, OnInit } from '@angular/core';
import { ParameterName } from 'src/app/common/parameter-name';
import { SimulationParameters } from 'src/app/common/simulation-parameters';
import { SimulationService } from 'src/app/services/simulation.service';

@Component({
  selector: 'app-simulations-list',
  templateUrl: './simulations-list.component.html',
  styleUrls: ['./simulations-list.component.css']
})
export class SimulationsListComponent implements OnInit {

  simulationParametersList: SimulationParameters[];
  ParameterName = ParameterName;

  constructor(
    private simulationService: SimulationService) {
  }

  ngOnInit(): void {
    this.listSimulationParameters();
  }

  listSimulationParameters() {
    this.simulationService.getSimulationList().subscribe(
      data => {
        this.simulationParametersList = data;
      }
    )
  }

  deleteSimulation(simulationId: number){
    this.simulationService.deleteSimulation(simulationId).subscribe(
      data => console.log(data)
    );
  }

}
