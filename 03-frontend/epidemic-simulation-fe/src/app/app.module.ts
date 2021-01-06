import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { SimulationsListComponent } from './components/simulations-list/simulations-list.component';
import { HttpClientModule } from '@angular/common/http';
import { SimulationService } from './services/simulation.service';
import { Routes, RouterModule } from '@angular/router';
import { SimulationDetailsComponent } from './components/simulation-details/simulation-details.component';
import { ReactiveFormsModule } from '@angular/forms';
import { AddSimulationFormComponent } from './components/add-simulation-form/add-simulation-form.component';
import { EditSimulationComponent } from './components/edit-simulation/edit-simulation.component';

const routes: Routes = [
  {path: 'simulations/:id', component: SimulationDetailsComponent},
  {path: 'edit-simulation/:id', component: EditSimulationComponent},
  {path: 'simulations', component: SimulationsListComponent},
  {path: '', redirectTo: '/simulations', pathMatch: 'full'},
  {path: '**', redirectTo: '/simulations', pathMatch: 'full'}
]

@NgModule({
  declarations: [
    AppComponent,
    SimulationsListComponent,
    SimulationDetailsComponent,
    SimulationsListComponent,
    AddSimulationFormComponent,
    EditSimulationComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [SimulationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
