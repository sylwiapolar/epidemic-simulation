package pl.polris.epidemicsimulation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.polris.epidemicsimulation.dao.SimulationResultRepository;
import pl.polris.epidemicsimulation.entity.DailyReport;
import pl.polris.epidemicsimulation.entity.SimulationParameters;
import pl.polris.epidemicsimulation.entity.SimulationResult;

import java.util.ArrayList;
import java.util.List;

@Service
public class PandemicCalculationServiceImpl implements PandemicCalculationService {

    private SimulationResultRepository simulationResultRepository;

    @Autowired
    public PandemicCalculationServiceImpl(SimulationResultRepository simulationResultRepository) {
        this.simulationResultRepository = simulationResultRepository;
    }

    @Override
    public void performCalculation(SimulationParameters simulationParameters) {

        if (simulationParameters == null) {
            return;
        }

//        int simulationID = simulationParameters.getId();
        long population = simulationParameters.getPopulation();
        long initiallyInfectedPopulation = simulationParameters.getInitInfected();
        double reproductionNumber = simulationParameters.getReproductionNum();
        double morality = simulationParameters.getMorality();
        int recoveryTime = simulationParameters.getRecoveryTime();
        int deathTime = simulationParameters.getDeathTime();
        int simulationTime = simulationParameters.getSimulationTime();

        long dead = 0L;
        long recovered = 0L;
        long infected = initiallyInfectedPopulation;
        long proneToInfection = population - infected;

        long infectedToday = 0L;
        long deadToday = 0L;
        long recoveredToday;

        List<DailyReport> dailyReportList = new ArrayList<>();

        DailyReport dailyReport = new DailyReport(0, infected, proneToInfection, dead, recovered, infected, deadToday);
        dailyReportList.add(dailyReport);

        SimulationResult simulationResult = new SimulationResult(0, infected, proneToInfection, dead, recovered);
        simulationResult.setId(0);
        simulationResult.setSimulationParameters(simulationParameters);
        simulationResultRepository.save(simulationResult);


        for (int i = 1; i <= simulationTime; i++) {

            if (infected == 0 && proneToInfection == 0) {
                break;
            }

            if ((i < recoveryTime) && (i < deathTime) && proneToInfection > 0) {
                //Uproszczenie - ilość zarażonych zaokrąglamy w dół
                infectedToday = (long) (infected * reproductionNumber);

                if (infectedToday >= proneToInfection) {
                    infectedToday = proneToInfection;
                }
                infected += infectedToday;
                proneToInfection -= infectedToday;


                System.out.println("===================== 1 if ========================");
                System.out.println("Day: " + (i));
                System.out.println("Infected today: " + infectedToday);
                System.out.println("Infected total: " + infected);
                System.out.println("Prone to infection : " + proneToInfection);

            } else if ((i >= deathTime) && (i < recoveryTime) && proneToInfection >= 0) {
                deadToday = (long) (morality * (dailyReportList.get(i - deathTime).getInfectedToday()));
                dead += deadToday;
                infected -= deadToday;

                infectedToday = (long) (infected * reproductionNumber);

                if (infectedToday >= proneToInfection) {
                    infectedToday = proneToInfection;
                }
                infected += infectedToday;
                proneToInfection -= infectedToday;


                System.out.println("===================== 2 if ========================");
                System.out.println("Day: " + (i));
                System.out.println("Dead today: " + deadToday + " " + (morality * (dailyReportList.get(i - deathTime).getInfectedToday())));
                System.out.println("morality: " + morality);
                System.out.println("Infected that day: " + (dailyReportList.get(i - deathTime).getInfectedToday()));
                System.out.println("Infected today: " + infectedToday);
                System.out.println("Infected total: " + infected);
                System.out.println("Dead total: " + dead);
                System.out.println("Prone to infection : " + proneToInfection);
//TODO add restriction to frontend that death time must be < recovery time, or add code below with some refactoring

//            } else if ((i < deathTime) && (i >= recoveryTime)) {
//                recoveredToday = dailyReportList.get(i - recoveryTime).getInfectedToday();
//                recovered += recoveredToday;
//                infected -= recoveredToday;
//
//                infectedToday = (long) (infected * reproductionNumber);
//                infected += infectedToday;
//
//                proneToInfection -= infectedToday;

            } else if ((i >= deathTime) && (i >= recoveryTime) && proneToInfection >= 0) {
                deadToday = (long) (morality * (dailyReportList.get(i - deathTime).getInfectedToday()));
                dead += deadToday;
                infected -= deadToday;

                recoveredToday = dailyReportList.get(i - recoveryTime).getInfectedToday()
                        - dailyReportList.get((i - recoveryTime) + deathTime).getDeadToday();
                recovered += recoveredToday;
                infected -= recoveredToday;

                infectedToday = (long) (infected * reproductionNumber);

                if (infectedToday >= proneToInfection) {
                    infectedToday = proneToInfection;
                }
                infected += infectedToday;
                proneToInfection -= infectedToday;


                System.out.println("===================== 3 if ========================");
                System.out.println("Day: " + (i));
                System.out.println("Dead today: " + deadToday + " " + (morality * (dailyReportList.get(i - deathTime).getInfectedToday())));
                System.out.println("Infected that day: " + (dailyReportList.get(i - deathTime).getInfectedToday()));
                System.out.println("Infected today: " + infectedToday);
                System.out.println("Recovered today: " + recoveredToday + " without casting: " +
                        (dailyReportList.get(i - recoveryTime).getInfectedToday()
                                - dailyReportList.get((i - recoveryTime) + deathTime).getDeadToday()));
                System.out.println("Death that day " + dailyReportList.get((i - recoveryTime) + deathTime).getDeadToday());
                System.out.println("Infected total: " + infected);
                System.out.println("Dead total: " + dead);
                System.out.println("Prone to infection : " + proneToInfection);
            }

            dailyReport = new DailyReport(i, infected, proneToInfection, dead, recovered, infectedToday, deadToday);
            dailyReportList.add(dailyReport);

            simulationResult = new SimulationResult(i, infected, proneToInfection, dead, recovered);
            simulationResult.setId(0);
            simulationResult.setSimulationParameters(simulationParameters);
            simulationResultRepository.save(simulationResult);
        }
    }
}
