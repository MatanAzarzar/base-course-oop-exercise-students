package AerialVehicles.FighterJets;

import AerialVehicles.AerialAttackVehicle;
import AerialVehicles.AerialIntelligenceVehicle;
import AerialVehicles.AerialVehicle;
import Missions.AttackMission;
import Missions.IntelligenceMission;
import Missions.Mission;
import Missions.MissionTypeException;

public class F15 extends AerialVehicle implements AerialAttackVehicle, AerialIntelligenceVehicle {
  private int numOfMissiles;
  private String missilesType;
  private String sensorType;
  final int REPAIR_TIME = 250;

  public F15(
      String sensorType,
      int numOfMissiles,
      String missilesType,
      String pilotName,
      Mission mission,
      int hoursOfFlightSinceLastRepair,
      boolean statusFlight) {
    super(pilotName, mission, hoursOfFlightSinceLastRepair, statusFlight);
    this.numOfMissiles = numOfMissiles;
    this.missilesType = missilesType;
    this.sensorType = sensorType;
  }

  public int getNumOfMissiles() {
    return numOfMissiles;
  }

  public void setNumOfMissiles(int numOfMissiles) {
    this.numOfMissiles = numOfMissiles;
  }

  public String getMissilesType() {
    return missilesType;
  }

  public void setMissilesType(String missilesType) {
    this.missilesType = missilesType;
  }

  public String getSensorType() {
    return sensorType;
  }

  public void setSensorType(String sensorType) {
    this.sensorType = sensorType;
  }

  @Override
  public String attack() {
    return (getPilotName()
        + ": F15 Attacking "
        + ((AttackMission) getMission()).getTarget()
        + " with: "
        + missilesType
        + "X"
        + numOfMissiles);
  }

  @Override
  public String collectIntelligence() {
    return (getPilotName()
        + ": F15 Collecting Data in "
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
