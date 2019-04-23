package planes;

import models.ClassificationLevel;
import models.ExperimentalPlaneTypes;

public class ExperimentalPlane extends Plane{

    private ExperimentalPlaneTypes typeOfExperimentalPlane;
    private ClassificationLevel classificationLevel;

    public ExperimentalPlane(String modelOfPlane, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalPlaneTypes experimentalType, ClassificationLevel classificationLevel) {
        super(modelOfPlane, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.typeOfExperimentalPlane = experimentalType;
        this.classificationLevel = classificationLevel;
    }

    public ClassificationLevel getClassificationLevel(){
        return classificationLevel;
    }

    public void setClassificationLevel(ClassificationLevel classificationLevel){
        this.classificationLevel = classificationLevel;
    }

    public ExperimentalPlaneTypes getTypeOfExperimentalPlane() {
        return typeOfExperimentalPlane;
    }

    public void setTypeOfExperimentalPlane(ExperimentalPlaneTypes typeOfExperimentalPlane) {
        this.typeOfExperimentalPlane = typeOfExperimentalPlane;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", typeOfExperimentalPlane=" + typeOfExperimentalPlane +
                        ", classificationLevel=" + classificationLevel +
                        '}');
    }
}