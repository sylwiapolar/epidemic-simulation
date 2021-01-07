import { AfterViewInit, Component, Input, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SimulationDetails } from 'src/app/common/simulation-details';
import { SimulationService } from 'src/app/services/simulation.service';
import { ChartsComponent } from '../charts/charts.component';

@Component({
  selector: 'app-simulation-details',
  templateUrl: './simulation-details.component.html',
  styleUrls: ['./simulation-details.component.css']
})
export class SimulationDetailsComponent implements OnInit {

  simulationDetails: SimulationDetails = new SimulationDetails();
  @ViewChild(ChartsComponent) chartComponentRef: ChartsComponent;

  constructor(private simulationService: SimulationService,
    private route: ActivatedRoute) {

  }

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.handleSimulationDetails();
    });
    console.log("Oninit simulationDetails");
  }

  handleSimulationDetails() {
    const simulationId = +this.route.snapshot.paramMap.get('id');

    this.simulationService.getSimulationDetails(simulationId).subscribe(
      data => {
        this.simulationDetails = data;
        this.chartComponentRef.loadSimulationResult(data.simulationResultList);    
        console.log("Oninit handle");
      }

    )

    console.log("Oninit after data");
  }

}
