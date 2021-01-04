package pl.polris.epidemicsimulation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polris.epidemicsimulation.entity.SimulationParameters;

public interface SimulationParametersRepository extends JpaRepository<SimulationParameters, Integer> {
}
