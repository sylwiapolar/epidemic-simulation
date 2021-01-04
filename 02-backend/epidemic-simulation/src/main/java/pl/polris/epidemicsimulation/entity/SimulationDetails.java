package pl.polris.epidemicsimulation.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SimulationDetails {

    // ----------- Fields -----------

    private SimulationParameters simulationParameters;

    private List<SimulationResult> simulationResultList;


    // ----------- Constructors -----------

    public SimulationDetails(SimulationParameters simulationParameters, List<SimulationResult> simulationResultList) {
        this.simulationParameters = simulationParameters;
        this.simulationResultList = simulationResultList;
    }
}
