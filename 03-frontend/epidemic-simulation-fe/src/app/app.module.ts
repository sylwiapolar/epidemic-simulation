import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { SimulationsListComponent } from './components/simulations-list/simulations-list.component';
import { HttpClientModule } from '@angular/common/http';
import { SimulationService } from './services/simulation.service';
import { Routes, RouterModule } from '@angular/router';
import { SimulationDetailsComponent } from './components/simulation-details/simulation-details.component';
import { ReactiveFormsModule } from '@angular/forms';

const routes: Routes = [
  {path: 'simulations/:id', component: SimulationDetailsComponent},
  {path: 'simulations', component: SimulationsListComponent},
  {path: '', redirectTo: '/simulations', pathMatch: 'full'},
  {path: '**', redirectTo: '/simulations', pathMatch: 'full'}
]

@NgModule({
  declarations: [
    AppComponent,
    SimulationsListComponent,
    SimulationDetailsComponent,
    SimulationsListComponent
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
