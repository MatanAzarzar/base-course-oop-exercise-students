package AerialVehicles;

import Entities.Coordinates;
import Missions.Mission;
import Missions.MissionTypeException;

public abstract class AerialVehicle implements AerialVehicleService {

  private String pilotName;
  private Mission mission;
  private int HoursOfFlightSinceLastRepair;
  private boolean statusFlight;

  public AerialVehicle(
      String pilotName, Mission mission, int hoursOfFlightSinceLastRepair, boolean statusFlight) {
    this.pilotName = pilotName;
    this.mission = mission;
    HoursOfFlightSinceLastRepair = hoursOfFlightSinceLastRepair;
    this.statusFlight = statusFlight;
  }

  public String getPilotName() {
    return pilotName;
  }

  public void setPilotName(String pilotName) {
    this.pilotName = pilotName;
  }

  public Mission getMission() {
    return mission;
  }

  public void setMission(Mission mission) {
    this.mission = mission;
  }

  public int getHoursOfFlightSinceLastRepair() {
    return HoursOfFlightSinceLastRepair;
  }

  public void setHoursOfFlightSinceLastRepair(int hoursOfFlightSinceLastRepair) {
    HoursOfFlightSinceLastRepair = hoursOfFlightSinceLastRepair;
  }

  public boolean isStatusFlight() {
    return statusFlight;
  }

  public void setStatusFlight(boolean statusFlight) {
    this.statusFlight = statusFlight;
  }

  @Override
  public void flyto() {
    System.out.println("flying to" + mission.getCoordinates().toString());
  }

  @Override
  public void land() {
    System.out.println("landing");
  }

  @Override
  public void repair() {
    statusFlight = true;
    HoursOfFlightSinceLastRepair = 0;
  }
}
