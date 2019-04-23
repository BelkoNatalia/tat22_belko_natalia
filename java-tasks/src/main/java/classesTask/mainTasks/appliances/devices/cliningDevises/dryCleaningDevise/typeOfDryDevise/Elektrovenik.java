package classesTask.mainTasks.appliances.devices.cliningDevises.dryCleaningDevise.typeOfDryDevise;

import classesTask.mainTasks.appliances.devices.FirmName;
import classesTask.mainTasks.appliances.devices.TypeDevice;
import classesTask.mainTasks.appliances.devices.cliningDevises.TypeCleaningSubject;
import classesTask.mainTasks.appliances.devices.cliningDevises.dryCleaningDevise.DryCleaningDevice;

public class Elektrovenik extends DryCleaningDevice {
    private int numberOfBrushes;

    public Elektrovenik() {
    }

    public Elektrovenik(TypeDevice typeDevice, FirmName name, int power, boolean isOn, int lifetime,
                        TypeCleaningSubject typeCleaningSubject, int pressure, int numberOfBrushes) {
        super(typeDevice, name, power, isOn, lifetime, typeCleaningSubject, pressure);
        this.numberOfBrushes = numberOfBrushes;
    }

    public int getNumberOfBrushes() {
        return numberOfBrushes;
    }

    public void setNumberOfBrushes(int numberOfBrushes) {
        this.numberOfBrushes = numberOfBrushes;
    }

    @Override
    public String toString() {
        return "Elektrovenik{" +
                "numberOfBrushes=" + numberOfBrushes +
                ", pressure=" + pressure +
                ", typeCleaningSubject=" + typeCleaningSubject +
                ", typeDevice=" + typeDevice +
                ", firmName=" + firmName +
                ", power=" + power +
                ", isOn=" + isOn +
                ", lifetime=" + lifetime +
                '}';
    }
}