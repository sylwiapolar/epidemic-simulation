import { SimulationParameters } from "./simulation-parameters";
import { SimulationResult } from "./simulation-result";

export class SimulationDetails {

    simulationParameters: SimulationParameters;
    simulationResultList: SimulationResult[];


    constructor() {
        console.log("in simulaitonDetails constructor");
    }
}
