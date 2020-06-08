package Entities;

public class Coordinates {
  Double longitude;
  Double latitude;

  public Coordinates(Double longitude, Double latitude) {
    this.longitude = longitude;
    this.latitude = latitude;
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  @Override
  public String toString() {
    return longitude + ", " + latitude;
  }
}
