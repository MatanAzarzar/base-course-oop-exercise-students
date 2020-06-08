package AerialVehicles.UAVs.Haron;

import AerialVehicles.AerialAttackVehicle;
import AerialVehicles.AerialIntelligenceVehicle;
import AerialVehicles.AerialVehicle;
import Missions.AttackMission;
import Missions.IntelligenceMission;
import Missions.Mission;
import Missions.MissionTypeException;

public class Eitan extends AerialVehicle implements AerialAttackVehicle, AerialIntelligenceVehicle {
  private int numOfMissiles;
  private String missilesType;
  private String sensorType;
  final int REPAIR_TIME = 150;

  public Eitan(
      int numOfMissiles,
      String missilesType,
      String sensorType,
       String pilotName,
      Mission mission,
      int hoursOfFlightSinceLastRepair,
      boolean statusFlight) {
    super(pilotName, mission, hoursOfFlightSinceLastRepair, statusFlight);
    this.numOfMissiles = numOfMissiles;
    this.missilesType = missilesType;
    this.sensorType = sensorType;
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
            + ": Eitan Attacking "
            + ((AttackMission) getMission()).getTarget()
            + " with: "
            + missilesType +"X"+ numOfMissiles);
  }


  @Override
  public String collectIntelligence() {
    return (getPilotName()
            + ": Eitan Collecting Data in "
            + ((IntelligenceMission) getMission()).getRegion()
            + " with sensor type: "
            + sensorType);
  }
  @Override
  public void check() {
    if(getHoursOfFlightSinceLastRepair() > REPAIR_TIME){
      repair();
    }
  }
}
