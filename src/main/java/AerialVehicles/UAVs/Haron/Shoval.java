package AerialVehicles.UAVs.Haron;

import AerialVehicles.AerialAttackVehicle;
import AerialVehicles.AerialBdaVehicle;
import AerialVehicles.AerialIntelligenceVehicle;
import AerialVehicles.AerialVehicle;
import Missions.*;

public class Shoval extends AerialVehicle
    implements AerialIntelligenceVehicle, AerialBdaVehicle, AerialAttackVehicle {
  private int numOfMissiles;
  private String missilesType;
  private String sensorType;
  private String cameraType;
  final int REPAIR_TIME = 150;


  public Shoval(
      String cameraType,
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

  @Override
  public String preformBda() {
    return  (getPilotName()
            + ": Shoval taking pictures of "
            + ((BdaMission) getMission()).getObjective()
            + " with: "
            +cameraType + " camera");
  }


  @Override
  public String collectIntelligence() {
    return (getPilotName()
            + ": Shoval Collecting Data in "
            + ((IntelligenceMission) getMission()).getRegion()
            + " with sensor type: "
            + sensorType);
  }

  @Override
  public String attack() {
    return (getPilotName()
            + ": Shoval Attacking "
            + ((AttackMission) getMission()).getTarget()
            + " with: "
            + missilesType
            + "X"
            + numOfMissiles);
  }

  @Override
  public void check() {
    if(getHoursOfFlightSinceLastRepair() > REPAIR_TIME){
      repair();
    }
  }
}
