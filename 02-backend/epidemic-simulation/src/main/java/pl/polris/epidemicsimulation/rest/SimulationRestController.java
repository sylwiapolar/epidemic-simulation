package pl.polris.epidemicsimulation.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.polris.epidemicsimulation.constants.RoutingParameters;
import pl.polris.epidemicsimulation.entity.SimulationDetails;
import pl.polris.epidemicsimulation.entity.SimulationParameters;
import pl.polris.epidemicsimulation.entity.SimulationResult;
import pl.polris.epidemicsimulation.service.PandemicCalculationService;
import pl.polris.epidemicsimulation.service.SimulationResultService;
import pl.polris.epidemicsimulation.service.SimulationService;

import java.util.List;

@RestController
@CrossOrigin(origins = RoutingParameters.ORIGIN_URL)
@RequestMapping("/api")
public class SimulationRestController {

    private SimulationService simulationService;
    private PandemicCalculationService pandemicCalculationService;
    private SimulationResultService simulationResultService;

    @Autowired
    public SimulationRestController(SimulationService simulationService, PandemicCalculationService pandemicCalculationService,
                                    SimulationResultService simulationResultService) {
        this.simulationService = simulationService;
        this.pandemicCalculationService = pandemicCalculationService;
        this.simulationResultService = simulationResultService;
    }

    // Returns list of simulations
    @GetMapping(RoutingParameters.ROUTE_SIMULATIONS)
    public List<SimulationParameters> findAll() {
        return simulationService.findAll();
    }

    // Returns specific simulation details by id
    @GetMapping(RoutingParameters.ROUTE_SIMULATION_ID)
    public SimulationDetails getSimulation(@PathVariable int simulationId) {

        SimulationParameters simulationParameters = simulationService.findById(simulationId);

        if (simulationParameters == null) {
            throw new RuntimeException("Simulation not found id: " + simulationId);

        } else {
            List<SimulationResult> simulationResultList = simulationResultService.findAllBySimulationId(simulationId);
            SimulationDetails simulationDetails = new SimulationDetails(simulationParameters, simulationResultList);
            return simulationDetails;
        }
    }


    // Add simulation
    @PostMapping(RoutingParameters.ROUTE_SIMULATION)
    public SimulationParameters addSimulation(@RequestBody SimulationParameters simulationParameters) {

        simulationParameters.setId(0);
        simulationService.save(simulationParameters);
        pandemicCalculationService.performCalculation(simulationParameters);

        return simulationParameters;
    }

    // Edit simulation
    //TODO  Provide validation for wrong id's
    @PutMapping(RoutingParameters.ROUTE_SIMULATION)
    public SimulationDetails updateSimulation(@RequestBody SimulationParameters simulationParameters) {

//        System.out.println("simulation parameters id from FE: " + simulationParameters.getId());

        deleteSimulationResult(simulationParameters.getId());

        simulationService.save(simulationParameters);
        pandemicCalculationService.performCalculation(simulationParameters);
        List<SimulationResult> simulationResultList = simulationResultService.findAllBySimulationId(simulationParameters.getId());
        SimulationDetails simulationDetails = new SimulationDetails(simulationParameters, simulationResultList);

        return simulationDetails;
    }

    // Delete simulation
    @DeleteMapping(RoutingParameters.ROUTE_SIMULATION_ID)
    public String deleteSimulation(@PathVariable int simulationId) {
        SimulationParameters tempSimulationParameters = simulationService.findById(simulationId);

        if (tempSimulationParameters == null) {
            throw new RuntimeException("Simulation id not found: " + simulationId);
        }

        simulationService.deleteById(simulationId);
        return "Deleted simulation id: " + simulationId;
    }


    public void deleteSimulationResult(int simulationId) {
        List<SimulationResult> oldSimulationResultList = simulationResultService.findAllBySimulationId(simulationId);

        for( SimulationResult tempSimRes : oldSimulationResultList) {
            int simulationResultId = tempSimRes.getId();
            simulationResultService.deleteById(simulationResultId);
        }
    }
}

