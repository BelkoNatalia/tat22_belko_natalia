package classesTask.mainTasks.appliances.devices.cliningDevises.dryCleaningDevise;

import classesTask.mainTasks.appliances.devices.FirmName;
import classesTask.mainTasks.appliances.devices.TypeDevice;
import classesTask.mainTasks.appliances.devices.cliningDevises.CleaningDevice;
import classesTask.mainTasks.appliances.devices.cliningDevises.TypeCleaningSubject;

public abstract class DryCleaningDevice extends CleaningDevice {
    protected int pressure;

    public DryCleaningDevice() {
    }

    public DryCleaningDevice(TypeDevice typeDevice, FirmName name, int power, boolean isOn, int lifetime,
                             TypeCleaningSubject typeCleaningSubject, int pressure) {
        super(typeDevice, name, power, isOn, lifetime, typeCleaningSubject);
        this.pressure = pressure;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }
}
