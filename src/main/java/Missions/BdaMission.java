package Missions;

import AerialVehicles.AerialBdaVehicle;
import AerialVehicles.AerialVehicle;
import Entities.Coordinates;

public class BdaMission extends Mission {
  String objective;

  public BdaMission(String objective,Coordinates coordinates) {
    super(coordinates);
    this.objective = objective;
  }

  public String getObjective() {
    return objective;
  }

  public void setObjective(String objective) {
    this.objective = objective;
  }
}
