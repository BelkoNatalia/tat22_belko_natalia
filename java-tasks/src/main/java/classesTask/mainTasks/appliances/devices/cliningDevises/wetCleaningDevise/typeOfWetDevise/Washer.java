package classesTask.mainTasks.appliances.devices.cliningDevises.wetCleaningDevise.typeOfWetDevise;

import classesTask.mainTasks.appliances.devices.FirmName;
import classesTask.mainTasks.appliances.devices.TypeDevice;
import classesTask.mainTasks.appliances.devices.cliningDevises.TypeCleaningSubject;
import classesTask.mainTasks.appliances.devices.cliningDevises.wetCleaningDevise.WetCleaningDevise;

public class Washer extends WetCleaningDevise {
    private int chamberVolume;

    public Washer() {
    }

    public Washer(TypeDevice typeDevice, FirmName name, int power, boolean isOn, int lifetime,
                  TypeCleaningSubject typeCleaningSubject, int waterVolume, int chamberVolume) {
        super(typeDevice, name, power, isOn, lifetime, typeCleaningSubject, waterVolume);
        this.chamberVolume = chamberVolume;
    }

    public int getChamberVolume() {
        return chamberVolume;
    }

    public void setChamberVolume(int chamberVolume) {
        this.chamberVolume = chamberVolume;
    }

    @Override
    public String toString() {
        return "Washer{" +
                "chamberVolume=" + chamberVolume +
                ", waterVolume=" + waterVolume +
                ", typeCleaningSubject=" + typeCleaningSubject +
                ", typeDevice=" + typeDevice +
                ", firmName=" + firmName +
                ", power=" + power +
                ", isOn=" + isOn +
                ", lifetime=" + lifetime +
                '}';
    }
}