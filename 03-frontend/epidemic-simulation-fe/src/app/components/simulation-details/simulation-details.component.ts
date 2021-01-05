import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SimulationDetails } from 'src/app/common/simulation-details';
import { SimulationService } from 'src/app/services/simulation.service';

@Component({
  selector: 'app-simulation-details',
  templateUrl: './simulation-details.component.html',
  styleUrls: ['./simulation-details.component.css']
})
export class SimulationDetailsComponent implements OnInit {

  simulationDetails: SimulationDetails = new SimulationDetails();

  constructor(private simulationService: SimulationService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.handleSimulationDetails();
    })
  }

  handleSimulationDetails() {
    const simulationId = +this.route.snapshot.paramMap.get('id');

    this.simulationService.getSimulationDetails(simulationId).subscribe(
      data => {
        this.simulationDetails = data;
      }
    )
  }

}
