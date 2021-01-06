import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
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
  // TODO Check for what is FormControl: In one tutorial form was initialized: 
  // simulationForm = new FormGroup({simName new FormControl(), ...});
  simulationForm;

  constructor(
    private simulationService: SimulationService,
    private formBuilder: FormBuilder) {

    this.createForm();
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

  createForm() {
    this.simulationForm = this.formBuilder.group({
      simName: new FormControl('', [Validators.required]),
      population: new FormControl('', [Validators.required, Validators.min(1)]),
      initInfected: new FormControl('', [Validators.required, Validators.min(1)]),
      reproductionNum: new FormControl('', [Validators.required]),
      morality: new FormControl('', [Validators.required]),
      recoveryTime: new FormControl('', [Validators.required, Validators.min(1)]),
      deathTime: new FormControl('', [Validators.required, Validators.min(1)]),
      simulationTime: new FormControl('', [Validators.required, Validators.min(1)])
    })
  }

  submitSimulation() {
    console.log(this.simulationForm.value);
    // let simulationParameters = new SimulationParameters();
    // simulationParameters.id = 0;
    // simulationParameters.simulationName = this.simulationForm.value.simulationName;
    // simulationParameters.population = this.simulationForm.value.population;
    // simulationParameters.initInfected = this.simulationForm.value.initInfected;
    // simulationParameters.reproductionNum = this.simulationForm.value.reproductionNum;
    // simulationParameters.mortality = this.simulationForm.value.mortality;
    // simulationParameters.recoveryTime = this.simulationForm.value.recoveryTime;
    // simulationParameters.deathTime = this.simulationForm.value.deathTime;
    // simulationParameters.simulationTime = this.simulationForm.value.simulationTime;
    // console.log(simulationParameters.simulationName)

// TODO this doesn't pass correct data
    this.simulationService.submitSimulation(this.simulationForm.value).subscribe(
      data => console.log('message from submit simulation = ', data)
    );

    this.simulationForm.reset();
  }

}
