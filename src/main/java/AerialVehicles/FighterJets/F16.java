package AerialVehicles.FighterJets;

import AerialVehicles.AerialAttackVehicle;
import AerialVehicles.AerialBdaVehicle;
import AerialVehicles.AerialVehicle;
import Missions.AttackMission;
import Missions.BdaMission;
import Missions.Mission;
import Missions.MissionTypeException;

public class F16 extends AerialVehicle implements AerialAttackVehicle, AerialBdaVehicle {

  public F16(
      String cameraType,
      int numOfMissiles,
      String missilesType,
      String pilotName,
      Mission mission,
      int hoursOfFlightSinceLastRepair,
      boolean statusFlight) {
    super(pilotName, mission, hoursOfFlightSinceLastRepair, statusFlight);
    this.numOfMissiles = numOfMissiles;
    this.missilesType = missilesType;
    this.cameraType = cameraType;
  }

  private int numOfMissiles;
  private String missilesType;
  private String cameraType;
  final int REPAIR_TIME = 250;

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

  public String getCameraType() {
    return cameraType;
  }

  public void setCameraType(String cameraType) {
    this.cameraType = cameraType;
  }

  @Override
  public String attack() {
    return (getPilotName()
            + ": F16 Attacking "
            + ((AttackMission) getMission()).getTarget()
            + " with: "
            + missilesType
            + "X"
            + numOfMissiles);
  }


  @Override
  public String preformBda() {
    return  (getPilotName()
            + ": F16 taking pictures of "
            + ((BdaMission) getMission()).getObjective()
            + " with: "
            +cameraType + " camera");
  }

  @Override
  public void check() {
    if(getHoursOfFlightSinceLastRepair() > REPAIR_TIME){
      repair();
    }
  }
}
