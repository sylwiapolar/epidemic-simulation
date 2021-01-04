package pl.polris.epidemicsimulation.service;

import pl.polris.epidemicsimulation.entity.SimulationParameters;

import java.util.List;

public interface SimulationService {

    public List<SimulationParameters> findAll();

    public SimulationParameters findById(int id);

    public void save(SimulationParameters simulationParameters);

    public void deleteById(int id);
}
