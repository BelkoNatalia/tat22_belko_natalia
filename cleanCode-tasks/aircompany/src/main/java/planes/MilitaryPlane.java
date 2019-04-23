package planes;

import models.MilitaryPlaneTypes;

import java.util.Objects;

public class MilitaryPlane extends Plane{

    private MilitaryPlaneTypes typeOfMilitaryPlane;

    public MilitaryPlane(String modelOfPlane, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryPlaneTypes typeOfMilitaryPlane) {
        super(modelOfPlane, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.typeOfMilitaryPlane = typeOfMilitaryPlane;
    }

    public MilitaryPlaneTypes getTypeOfMilitaryPlane() {
        return typeOfMilitaryPlane;
    }

    public void setTypeOfMilitaryPlane(MilitaryPlaneTypes typeOfMilitaryPlane) {
        this.typeOfMilitaryPlane = typeOfMilitaryPlane;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", typeOfMilitaryPlane=" + typeOfMilitaryPlane +
                '}');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MilitaryPlane)) return false;
        if (!super.equals(o)) return false;
        MilitaryPlane that = (MilitaryPlane) o;
        return typeOfMilitaryPlane == that.typeOfMilitaryPlane;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), typeOfMilitaryPlane);
    }
}
