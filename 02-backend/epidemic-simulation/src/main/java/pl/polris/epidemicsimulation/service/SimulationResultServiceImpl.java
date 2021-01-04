package pl.polris.epidemicsimulation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.polris.epidemicsimulation.dao.SimulationParametersRepository;
import pl.polris.epidemicsimulation.dao.SimulationResultRepository;
import pl.polris.epidemicsimulation.entity.SimulationParameters;
import pl.polris.epidemicsimulation.entity.SimulationResult;

import java.util.List;
import java.util.Optional;

@Service
public class SimulationResultServiceImpl implements SimulationResultService {

    private SimulationResultRepository simulationResultRepository;

    @Autowired
    public SimulationResultServiceImpl(SimulationResultRepository simulationResultRepository){
        this.simulationResultRepository = simulationResultRepository;
    }

    @Override
    public List<SimulationResult> findAll() {
        return simulationResultRepository.findAll();
    }

    @Override
    public SimulationResult findById(int id) {
        Optional<SimulationResult> result = simulationResultRepository.findById(id);

        SimulationResult simulationResult = null;
        if (result.isPresent()) {
            simulationResult = result.get();
        } else {
            throw new RuntimeException("Did not find simulation result id: " + id);
        }

        return simulationResult;
    }

    @Override
    public void save(SimulationResult simulationParameters) {
        simulationResultRepository.save(simulationParameters);
    }

    @Override
    public void deleteById(int id) {
        simulationResultRepository.deleteById(id);
    }

    @Override
    public List<SimulationResult> findAllBySimulationId(int id) {
        return simulationResultRepository.findAllBySimulationId(id);
    }





}
