package pl.polris.epidemicsimulation.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import pl.polris.epidemicsimulation.entity.SimulationResult;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional(readOnly = true)
public class SimulationResultRepositoryImpl implements SimulationResultRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public SimulationResultRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<SimulationResult> findAllBySimulationId(int id) {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<SimulationResult> query = currentSession.createQuery("FROM SimulationResult WHERE simulation_id=:simulationId");
        query.setParameter("simulationId", id);

        List<SimulationResult> simulationResultList = query.getResultList();
        currentSession.close();
        return simulationResultList;
    }
}
