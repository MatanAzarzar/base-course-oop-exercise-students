package Missions;

import Entities.Coordinates;

public abstract class Mission implements MissionService {
  private Coordinates coordinates;

  public Mission(Coordinates coordinates) {
    this.coordinates = coordinates;
  }

  public Coordinates getCoordinates() {
    return coordinates;
  }

  public void setCoordinates(Coordinates coordinates) {
    this.coordinates = coordinates;
  }

  @Override
  public void begin() {
    System.out.println("Beginning Mission");
  }

  @Override
  public void cancel() {
    System.out.println("Abort Mission!");
  }

  @Override
  public void finish() {
    System.out.println("Finish Mission");
  }
}
