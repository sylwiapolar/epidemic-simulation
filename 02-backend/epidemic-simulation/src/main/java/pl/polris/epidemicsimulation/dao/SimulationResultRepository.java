package pl.polris.epidemicsimulation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polris.epidemicsimulation.entity.SimulationResult;

public interface SimulationResultRepository extends JpaRepository<SimulationResult, Integer>, SimulationResultRepositoryCustom {

}
