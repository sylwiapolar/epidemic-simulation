export class SimulationParameters {

    id: number;
    simulationName: string;
    population: number;
    initInfected: number;
    reproductionNum: number;
    mortality: number;
    recoveryTime: number;
    deathTime: number;
    simulationTime: number;

    constructor() { }
}
