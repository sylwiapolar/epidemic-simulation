package pl.polris.epidemicsimulation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.polris.epidemicsimulation.dao.SimulationResultRepository;
import pl.polris.epidemicsimulation.entity.SimulationParameters;
import pl.polris.epidemicsimulation.entity.SimulationResult;

@Service
public class PandemicCalculationServiceImpl implements PandemicCalculationService {

    private SimulationResultRepository simulationResultRepository;

    @Autowired
    public PandemicCalculationServiceImpl(SimulationResultRepository simulationResultRepository) {
        this.simulationResultRepository = simulationResultRepository;
    }

    @Override
    public void performCalculation(SimulationParameters simulationParameters) {

        if (simulationParameters == null) {
            return;
        }

        int simulationID = simulationParameters.getId();
        long population = simulationParameters.getPopulation();
        long initiallyInfectedPopulation = simulationParameters.getInitiallyInfectedPopulation();
        double reproductionNumber = simulationParameters.getReproductionNumber();
        double mortality = simulationParameters.getMortality();
        int recoveryTime = simulationParameters.getRecoveryTime();
        int deathTime = simulationParameters.getDeathTime();
        int simulationTime = simulationParameters.getSimulationTime();

        for (int i = 1; i <= simulationTime; i++) {
            //TODO - refactor - implement calculations
            long infected = 1;
            long proneToInfection = 1;
            long dead = 1;
            long recovered = 1;
            int day = i;

            //TODO What about simulation parameters id??
            SimulationResult simulationResult = new SimulationResult(day, infected, proneToInfection, dead, recovered);
            simulationResult.setId(0);
            simulationResult.setSimulationParameters(simulationParameters);
            simulationResultRepository.save(simulationResult);
        }

    }
}
