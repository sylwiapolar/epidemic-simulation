package pl.polris.epidemicsimulation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polris.epidemicsimulation.entity.SimulationResult;

import java.util.List;

// Spring Data JPA provides CRUD methods findAll(), findById(), save(), deleteById()
//TODO
public interface SimulationResultRepository extends JpaRepository<SimulationResult, Integer>, SimulationResultRepositoryCustom {

}
