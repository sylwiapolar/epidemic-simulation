package pl.polris.epidemicsimulation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import pl.polris.epidemicsimulation.entity.SimulationResult;

import java.util.List;

@NoRepositoryBean
public interface SimulationResultRepositoryCustom {

    public List<SimulationResult> findAllBySimulationId(int simulationId);
}
