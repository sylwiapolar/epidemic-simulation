import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { SimulationsListComponent } from './components/simulations-list/simulations-list.component';
import { HttpClientModule } from '@angular/common/http';
import { SimulationService } from './services/simulation.service';

@NgModule({
  declarations: [
    AppComponent,
    SimulationsListComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [SimulationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
