package AerialVehicles.UAVs.Hermes;

import AerialVehicles.AerialBdaVehicle;
import AerialVehicles.AerialIntelligenceVehicle;
import AerialVehicles.AerialVehicle;
import Missions.BdaMission;
import Missions.IntelligenceMission;
import Missions.Mission;
import Missions.MissionTypeException;

public class Zik extends AerialVehicle implements AerialBdaVehicle, AerialIntelligenceVehicle {
  private String sensorType;
  private String cameraType;
  final int REPAIR_TIME = 100;

  public Zik(
      String cameraType,
      String sensorType,
      String pilotName,
      Mission mission,
      int hoursOfFlightSinceLastRepair,
      boolean statusFlight) {
    super(pilotName, mission, hoursOfFlightSinceLastRepair, statusFlight);
    this.sensorType = sensorType;
    this.cameraType = cameraType;
  }

  public String getSensorType() {
    return sensorType;
  }

  public void setSensorType(String sensorType) {
    this.sensorType = sensorType;
  }

  public String getCameraType() {
    return cameraType;
  }

  public void setCameraType(String cameraType) {
    this.cameraType = cameraType;
  }

  @Override
  public String preformBda() {
    return  (getPilotName()
            + ": Zik taking pictures of "
            + ((BdaMission) getMission()).getObjective()
            + " with: "
            +cameraType + " camera");
  }


  @Override
  public String collectIntelligence() {
    return (getPilotName()
            + ": Zik Collecting Data in "
            + ((IntelligenceMission) getMission()).getRegion()
            + " with sensor type: "
            + sensorType);
  }

  @Override
  public void check() {
    if (getHoursOfFlightSinceLastRepair() > REPAIR_TIME) {
      repair();
    }
  }
}
