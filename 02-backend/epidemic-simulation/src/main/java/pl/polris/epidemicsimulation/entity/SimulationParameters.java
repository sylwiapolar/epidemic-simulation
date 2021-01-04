package pl.polris.epidemicsimulation.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="simulation")
public class SimulationParameters {

    // ----------- Fields -----------

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    //Shortcut: N
    @Column(name="simulation_name")
    private String simulationName;

    //Shortcut: P
    @Column(name="population")
    private long population;

    //Shortcut: I
    @Column(name="initially_infected_population")
    private long initiallyInfectedPopulation;

    //Shortcut: R
    @Column(name="reproduction_number")
    private double reproductionNumber;

    //Shortcut: M
    @Column(name="morality")
    private double mortality;

    //Shortcut: Ti
    @Column(name="recovery_time")
    private int recoveryTime;

    //Shortcut: Tm
    @Column(name="death_time")
    private int deathTime;

    //Shortcut: Ts
    @Column(name="simulation_time")
    private int simulationTime;

    // ----------- Constructors -------------


    public SimulationParameters() {
    }

    public SimulationParameters(String simulationName, long population, long initiallyInfectedPopulation,
                                int reproductionNumber, int mortality, int recoveryTime, int deathTime, int simulationTime) {
        this.simulationName = simulationName;
        this.population = population;
        this.initiallyInfectedPopulation = initiallyInfectedPopulation;
        this.reproductionNumber = reproductionNumber;
        this.mortality = mortality;
        this.recoveryTime = recoveryTime;
        this.deathTime = deathTime;
        this.simulationTime = simulationTime;
    }



    // ----------- toString -------------

    @Override
    public String toString() {
        return "Simulation{" +
                "id=" + id +
                ", simulationName='" + simulationName + '\'' +
                ", population=" + population +
                ", initiallyInfectedPopulation=" + initiallyInfectedPopulation +
                ", reproductionNumber=" + reproductionNumber +
                ", mortality=" + mortality +
                ", recoveryTime=" + recoveryTime +
                ", deathTime=" + deathTime +
                ", simulationTime=" + simulationTime +
                '}';
    }
}
