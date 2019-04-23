package classesTask.mainTasks.appliances.devices.cliningDevises.dryCleaningDevise.typeOfDryDevise;

import classesTask.mainTasks.appliances.devices.FirmName;
import classesTask.mainTasks.appliances.devices.TypeDevice;
import classesTask.mainTasks.appliances.devices.cliningDevises.TypeCleaningSubject;
import classesTask.mainTasks.appliances.devices.cliningDevises.dryCleaningDevise.DryCleaningDevice;

public class VacuumCleaner extends DryCleaningDevice {

    private int lengthOfHandle;

    public VacuumCleaner() {
    }

    public VacuumCleaner(TypeDevice typeDevice, FirmName name, int power, boolean isOn, int lifetime,
                         TypeCleaningSubject typeCleaningSubject, int pressure, int lengthOfHandle) {
        super(typeDevice, name, power, isOn, lifetime, typeCleaningSubject, pressure);
        this.lengthOfHandle = lengthOfHandle;
    }

    public int getLengthOfHandle() {
        return lengthOfHandle;
    }

    public void setLengthOfHandle(int lengthOfHandle) {
        this.lengthOfHandle = lengthOfHandle;
    }

    @Override
    public String toString() {
        return "VacuumCleaner{" +
                "lengthOfHandle=" + lengthOfHandle +
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