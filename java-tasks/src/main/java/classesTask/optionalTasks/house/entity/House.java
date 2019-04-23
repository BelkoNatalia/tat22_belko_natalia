package classesTask.optionalTasks.house.entity;

import java.util.Arrays;

public class House {

    private Flat[] flatsInTheHouse;
    private int idOfHouse;
    private String streetOfFlat;
    private String typeOfBuilding;
    private int lifetimeOfBuilding;

    public House (){}

    public House (Flat[] flatsInTheHouse){
      this.flatsInTheHouse = flatsInTheHouse;
    }

    public House (Flat[] flatsInTheHouse, int idOfHouse, String streetOfFlat, String typeOfBuilding,
                  int lifetimeOfBuilding){
        this.flatsInTheHouse = flatsInTheHouse;
        this.idOfHouse = idOfHouse;
        this.streetOfFlat = streetOfFlat;
        this.typeOfBuilding = typeOfBuilding;
        this.lifetimeOfBuilding = lifetimeOfBuilding;
    }

    public Flat[] getFlatsInTheHouse() {
        return flatsInTheHouse;
    }

    public void setFlatsInTheHouse(Flat[] flatsInTheHouse) {
        this.flatsInTheHouse = flatsInTheHouse;
    }

    public int getIdOfHouse() {
        return idOfHouse;
    }

    public void setIdOfHouse(int idOfHouse) {
        this.idOfHouse = idOfHouse;
    }

    public String getStreetOfFlat() {
        return streetOfFlat;
    }

    public void setStreetOfFlat(String streetOfFlat) {
        this.streetOfFlat = streetOfFlat;
    }

    public String getTypeOfBuilding() {
        return typeOfBuilding;
    }

    public void setTypeOfBuilding(String typeOfBuilding) {
        this.typeOfBuilding = typeOfBuilding;
    }

    public int getLifetimeOfBuilding() {
        return lifetimeOfBuilding;
    }

    public void setLifetimeOfBuilding(int lifetimeOfBuilding) {
        this.lifetimeOfBuilding = lifetimeOfBuilding;
    }

    @Override
    public String toString() {
        return "House{" +
                "flatsInTheHouse=" + Arrays.toString(flatsInTheHouse) +
                ", idOfHouse=" + idOfHouse +
                ", streetOfFlat='" + streetOfFlat + '\'' +
                ", typeOfBuilding='" + typeOfBuilding + '\'' +
                ", lifetimeOfBuilding=" + lifetimeOfBuilding +
                '}';
    }
}