import { Component, OnInit } from '@angular/core';
import { SimulationProperties } from 'src/app/common/simulation-properties';
import { SimulationService } from 'src/app/services/simulation.service';

@Component({
  selector: 'app-simulations-list',
  templateUrl: './simulations-list.component.html',
  styleUrls: ['./simulations-list.component.css']
})
export class SimulationsListComponent implements OnInit {

  simulationPropertiesList: SimulationProperties[];

  constructor(private simulationService: SimulationService) { }

  ngOnInit(): void {
    this.listSimulationsProperties();
  }


  listSimulationsProperties(){
    this.simulationService.getSimulationList().subscribe(
      data => {
        this.simulationPropertiesList = data;
      }
    )
  }
}
