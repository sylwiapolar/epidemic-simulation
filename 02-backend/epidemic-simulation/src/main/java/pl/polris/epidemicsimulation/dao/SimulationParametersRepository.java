package pl.polris.epidemicsimulation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polris.epidemicsimulation.entity.SimulationParameters;

// Spring Data JPA provides CRUD methods findAll(), findById(), save(), deleteById()
public interface SimulationParametersRepository extends JpaRepository<SimulationParameters, Integer> {
}
