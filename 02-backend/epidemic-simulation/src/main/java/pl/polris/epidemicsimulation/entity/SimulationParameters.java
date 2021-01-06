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
    private long initInfected;

    //Shortcut: R
    @Column(name="reproduction_number")
    private double reproductionNum;

    //Shortcut: M
    @Column(name="morality")
    private double morality;

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

    public SimulationParameters(String simulationName, long population, long initInfected,
                                int reproductionNum, int morality, int recoveryTime, int deathTime, int simulationTime) {
        this.simulationName = simulationName;
        this.population = population;
        this.initInfected = initInfected;
        this.reproductionNum = reproductionNum;
        this.morality = morality;
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
                ", initInfected=" + initInfected +
                ", reproductionNum=" + reproductionNum +
                ", morality=" + morality +
                ", recoveryTime=" + recoveryTime +
                ", deathTime=" + deathTime +
                ", simulationTime=" + simulationTime +
                '}';
    }
}
