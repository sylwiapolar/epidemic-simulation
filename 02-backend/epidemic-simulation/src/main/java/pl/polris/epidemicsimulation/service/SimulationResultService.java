package pl.polris.epidemicsimulation.service;

import pl.polris.epidemicsimulation.entity.SimulationParameters;
import pl.polris.epidemicsimulation.entity.SimulationResult;

import java.util.List;

public interface SimulationResultService {

    public List<SimulationResult> findAll();

    public SimulationResult findById(int id);

    public void save(SimulationResult simulationResult);

    public void deleteById(int id);

    List<SimulationResult> findAllBySimulationId(int simulationId);
}

