package pl.polris.epidemicsimulation.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "simulation_result",
        indexes = {@Index(name = "fk_simulation", columnList = "simulation_id", unique = false)})
public class SimulationResult {

    // ----------- Fields -----------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "simulation_day")
    private int simulationDay;

    //Shortcut: Pi
    @Column(name = "infected")
    private long infected;

    //Shortcut: Pv
    @Column(name = "prone_to_infection")
    private long proneToInfection;

    //Shortcut: Pm
    @Column(name = "dead")
    private long dead;

    //Shortcut: Pr
    @Column(name = "recovered")
    private long recovered;

    @ManyToOne
    @JoinColumn(name = "simulation_id", nullable = false)
    private SimulationParameters simulationParameters;

    // ----------- Constructors -----------

    public SimulationResult() {
    }

    public SimulationResult(int simulationDay, long infected, long proneToInfection, long dead, long recovered) {
        this.simulationDay = simulationDay;
        this.infected = infected;
        this.proneToInfection = proneToInfection;
        this.dead = dead;
        this.recovered = recovered;
    }


}
