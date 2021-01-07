package pl.polris.epidemicsimulation.service;

import org.springframework.stereotype.Service;
import pl.polris.epidemicsimulation.entity.SimulationParameters;
import pl.polris.epidemicsimulation.entity.SimulationResult;

import java.util.List;

@Service
public interface PandemicCalculationService {

    public void performCalculation(SimulationParameters simulationParameters);
}
