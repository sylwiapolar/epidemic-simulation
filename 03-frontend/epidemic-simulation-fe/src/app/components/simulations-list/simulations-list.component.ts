import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
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
  checkoutForm;

  constructor(
    private simulationService: SimulationService,
    private formBuilder: FormBuilder) { 
      this.checkoutForm = this.formBuilder.group({
        simName: '',
        population: '',
        initInfected: '',
        reproductionNum: '',
        morality: '',
        recoveryTime: '',
        deathTime: '',
        simulationTime: ''
      })
    }

  ngOnInit(): void {
    this.listSimulationParameters();
  }


  listSimulationParameters(){
    this.simulationService.getSimulationList().subscribe(
      data => {
        this.simulationParametersList = data;
      }
    )
  }

  onSubmit() {
    //TODO write code to submit data to database
    this.checkoutForm.reset();
  }
}
