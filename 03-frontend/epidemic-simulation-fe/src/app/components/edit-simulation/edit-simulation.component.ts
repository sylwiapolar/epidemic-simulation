import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ParameterName } from 'src/app/common/parameter-name';
import { SimulationService } from 'src/app/services/simulation.service';
import { ActivatedRoute } from '@angular/router';
import { SimulationParameters } from 'src/app/common/simulation-parameters';

@Component({
  selector: 'app-edit-simulation',
  templateUrl: './edit-simulation.component.html',
  styleUrls: ['./edit-simulation.component.css']
})
export class EditSimulationComponent implements OnInit {

  ParameterName = ParameterName;
  simulationEditForm: FormGroup;
  simulationParameters: SimulationParameters = new SimulationParameters();
  simulationId: number;

  constructor(
    private simulationService: SimulationService,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder) {

    this.createForm();
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.simulationId = params['id'];
    });

    //TODO remove this log after validation
    console.log(this.simulationId);
  }

  //TODO duplicate code with add form - need to  refactor
  createForm() {
    this.simulationEditForm = this.formBuilder.group({
      simulationName: new FormControl('', [Validators.required]),
      population: new FormControl('', [Validators.required, Validators.min(1)]),
      initInfected: new FormControl('', [Validators.required, Validators.min(1)]),
      reproductionNum: new FormControl('', [Validators.required]),
      morality: new FormControl('', [Validators.required]),
      recoveryTime: new FormControl('', [Validators.required, Validators.min(1)]),
      deathTime: new FormControl('', [Validators.required, Validators.min(1)]),
      simulationTime: new FormControl('', [Validators.required, Validators.min(1)])
    })
  }

  editSimulation() {
    let formParam =this.simulationEditForm.value;

    this.simulationParameters = {
      id : this.simulationId,
      simulationName : formParam.simulationName,
      population : formParam.population,
      initInfected : formParam.initInfected,
      reproductionNum : formParam.reproductionNum,
      morality : formParam.morality,
      recoveryTime : formParam.recoveryTime,
      deathTime : formParam.deathTime,
      simulationTime : formParam.simulationTime
    }

    this.simulationService.editSimulation(this.simulationParameters).subscribe(
          //TODO remove this data function after validation
      data => {
        console.log('message from submit simulation = ', data);
      }
    );

    this.simulationEditForm.reset();
  }


}
