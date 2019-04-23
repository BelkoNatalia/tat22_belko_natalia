package classesTask.mainTasks.appliances.devices.cliningDevises.wetCleaningDevise.typeOfWetDevise;

import classesTask.mainTasks.appliances.devices.FirmName;
import classesTask.mainTasks.appliances.devices.TypeDevice;
import classesTask.mainTasks.appliances.devices.cliningDevises.TypeCleaningSubject;
import classesTask.mainTasks.appliances.devices.cliningDevises.wetCleaningDevise.WetCleaningDevise;

public class SteamCleaner extends WetCleaningDevise {
    private int temperature;

    public SteamCleaner() {
    }

    public SteamCleaner(TypeDevice typeDevice, FirmName name, int power, boolean isOn, int lifetime,
                        TypeCleaningSubject typeCleaningSubject, int waterVolume, int temperature) {
        super(typeDevice, name, power, isOn, lifetime, typeCleaningSubject, waterVolume);
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "SteamCleaner{" +
                "temperature=" + temperature +
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