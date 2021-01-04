-- -----------------------------------------------------
-- Schema pandemic-simulation-app
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `pandemic_simulation_app`;

CREATE SCHEMA `pandemic_simulation_app`;
USE `pandemic_simulation_app` ;

-- -----------------------------------------------------
-- Table `pandemic-simulation-app`.`simulation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pandemic_simulation_app`.`simulation` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `simulation_name` VARCHAR(255) NULL DEFAULT NULL,
  `population` BIGINT NOT NULL,
  `initially_infected_population` BIGINT NOT NULL,
  `reproduction_number` DOUBLE(16,2) NOT NULL,
  `morality` DOUBLE(16,2) NOT NULL,
  `recovery_time` INT NOT NULL,
  `death_time` INT NOT NULL,
  `simulation_time` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE=InnoDB
AUTO_INCREMENT = 1;

-- -----------------------------------------------------
-- Table `pandemic-simulation-app`.`simulation_result`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pandemic_simulation_app`.`simulation_result` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `simulation_day` INT NOT NULL, 
  `infected` BIGINT NOT NULL,
  `prone_to_infection` BIGINT NOT NULL,
  `dead` BIGINT NOT NULL,
  `recovered` BIGINT NOT NULL,
  `simulation_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_simulation` (`simulation_id`),
  CONSTRAINT `fk_simulation` FOREIGN KEY (`simulation_id`) REFERENCES `simulation` (`id`)  ON UPDATE CASCADE)
ENGINE=InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Add sample data
-- -----------------------------------------------------

INSERT INTO simulation (simulation_name, population, initially_infected_population, reproduction_number, morality, recovery_time,
death_time, simulation_time)
VALUES ('Simulation 1', 20000, 200, 1.5,1.2,14,27,300);

INSERT INTO simulation (simulation_name, population, initially_infected_population, reproduction_number, morality, recovery_time,
death_time, simulation_time)
VALUES ('Simulation 2', 1000000, 1, 3,0.7,21,31,150);

INSERT INTO simulation (simulation_name, population, initially_infected_population, reproduction_number, morality, recovery_time,
death_time, simulation_time)
VALUES ('Simulation 3', 100, 3, 4,4,18,31,30);

INSERT INTO simulation (simulation_name, population, initially_infected_population, reproduction_number, morality, recovery_time,
death_time, simulation_time)
VALUES ('Simulation 4', 999999999, 30000, 1.1,0.9,10,20,20);
