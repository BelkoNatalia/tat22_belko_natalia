package classesTask.mainTasks.appliances.devices.cliningDevises.wetCleaningDevise;

import classesTask.mainTasks.appliances.devices.FirmName;
import classesTask.mainTasks.appliances.devices.TypeDevice;
import classesTask.mainTasks.appliances.devices.cliningDevises.CleaningDevice;
import classesTask.mainTasks.appliances.devices.cliningDevises.TypeCleaningSubject;

public abstract class WetCleaningDevise extends CleaningDevice {

    protected int waterVolume;

    public WetCleaningDevise() {
    }

    public WetCleaningDevise(TypeDevice typeDevice, FirmName name, int power, boolean isOn, int lifetime,
                             TypeCleaningSubject typeCleaningSubject, int waterVolume) {
        super(typeDevice, name, power, isOn, lifetime, typeCleaningSubject);
        this.waterVolume = waterVolume;
    }

    public int getWaterVolume() {
        return waterVolume;
    }

    public void setWaterVolume(int waterVolume) {
        this.waterVolume = waterVolume;
    }
}