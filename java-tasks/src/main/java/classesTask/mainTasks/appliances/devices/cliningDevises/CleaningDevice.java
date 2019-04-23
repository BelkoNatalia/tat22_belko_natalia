package classesTask.mainTasks.appliances.devices.cliningDevises;

import classesTask.mainTasks.appliances.devices.Device;
import classesTask.mainTasks.appliances.devices.FirmName;
import classesTask.mainTasks.appliances.devices.TypeDevice;

public abstract class CleaningDevice extends Device {
    protected TypeCleaningSubject typeCleaningSubject;

    public CleaningDevice() {
    }

    public CleaningDevice(TypeDevice typeDevice, FirmName name, int power, boolean isOn, int lifetime,
                          TypeCleaningSubject typeCleaningSubject) {
        super(typeDevice, name, power, isOn, lifetime);
        this.typeCleaningSubject = typeCleaningSubject;
    }

    public TypeCleaningSubject getTypeCleaningSubject() {
        return typeCleaningSubject;
    }

    public void setTypeCleaningSubject(TypeCleaningSubject typeCleaningSubject) {
        this.typeCleaningSubject = typeCleaningSubject;
    }

}