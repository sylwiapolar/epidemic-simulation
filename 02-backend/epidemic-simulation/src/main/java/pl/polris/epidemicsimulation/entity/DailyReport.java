package pl.polris.epidemicsimulation.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DailyReport {

    private int simulationDay;

    //Shortcut: Pi
    private long infected;

    //Shortcut: Pv
    private long proneToInfection;

    //Shortcut: Pm
    private long dead;

    //Shortcut: Pr
    private long recovered;



    //Shortcut: Pi_t
    private long infectedToday;

    //Shortcut: Pm_t
    private long deadToday;

    public DailyReport(int simulationDay, long infected, long proneToInfection, long dead, long recovered,
                       long infectedToday, long deadToday) {

        this.simulationDay = simulationDay;
        this.infected = infected;
        this.proneToInfection = proneToInfection;
        this.dead = dead;
        this.recovered = recovered;
        this.infectedToday = infectedToday;
        this.deadToday = deadToday;
    }
}
