package pl.polris.epidemicsimulation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.polris.epidemicsimulation.dao.SimulationParametersRepository;
import pl.polris.epidemicsimulation.entity.SimulationParameters;

import java.util.List;
import java.util.Optional;

@Service
public class SimulationServiceImpl implements SimulationService {

    private SimulationParametersRepository simulationParametersRepository;

    @Autowired
    public SimulationServiceImpl(SimulationParametersRepository simulationParametersRepository){
        this.simulationParametersRepository = simulationParametersRepository;
    }

    // ### Returns all instances of specified type ###
    @Override
    public List<SimulationParameters> findAll() {
        return simulationParametersRepository.findAll();
    }

    @Override
    public SimulationParameters findById(int id) {
        Optional<SimulationParameters> result = simulationParametersRepository.findById(id);

        SimulationParameters simulationParameters = null;
        if (result.isPresent()) {
            simulationParameters = result.get();
        } else {
            throw new RuntimeException("Did not find simulation id: " + id);
        }

        return simulationParameters;
    }

    @Override
    public void save(SimulationParameters simulationParameters) {
        simulationParametersRepository.save(simulationParameters);
    }

    @Override
    public void deleteById(int id) {
        simulationParametersRepository.deleteById(id);
    }
}
