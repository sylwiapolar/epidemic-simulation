import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ParameterName } from 'src/app/common/parameter-name';
import { SimulationService } from 'src/app/services/simulation.service';


@Component({
  selector: 'app-add-simulation-form',
  templateUrl: './add-simulation-form.component.html',
  styleUrls: ['./add-simulation-form.component.css']
})
export class AddSimulationFormComponent implements OnInit {

  ParameterName = ParameterName;
  simulationForm: FormGroup;
  @ViewChild('simulationName') nameElementRef: ElementRef;

  constructor(
    private simulationService: SimulationService,
    private formBuilder: FormBuilder) {

    this.createForm();
  }

  ngOnInit(): void {
  }

  ngAfterViewInit(){
    this.nameElementRef.nativeElement.focus();
  }

  createForm() {
    this.simulationForm = this.formBuilder.group({
      simulationName: new FormControl('', [Validators.required]),
      population: new FormControl('', [Validators.required, Validators.min(1)]),
      initInfected: new FormControl('', [Validators.required, Validators.min(1)]),
      reproductionNum: new FormControl('', [Validators.required, Validators.min(0)]),
      morality: new FormControl('', [Validators.required, Validators.min(0), Validators.max(1)]),
      recoveryTime: new FormControl('', [Validators.required, Validators.min(1)]),
      deathTime: new FormControl('', [Validators.required, Validators.min(1)]),
      simulationTime: new FormControl('', [Validators.required, Validators.min(1)])
    })
  }


  submitSimulation() {
    console.log(this.simulationForm.value);

    this.simulationService.submitSimulation(this.simulationForm.value).subscribe(
      data => console.log('message from submit simulation = ', data)
    );

    this.simulationForm.reset();
  }

}
