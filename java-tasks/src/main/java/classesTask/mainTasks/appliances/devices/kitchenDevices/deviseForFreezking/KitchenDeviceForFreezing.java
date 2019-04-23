package classesTask.mainTasks.appliances.devices.kitchenDevices.deviseForFreezking;

import classesTask.mainTasks.appliances.devices.FirmName;
import classesTask.mainTasks.appliances.devices.TypeDevice;
import classesTask.mainTasks.appliances.devices.kitchenDevices.InstallationSite;
import classesTask.mainTasks.appliances.devices.kitchenDevices.KitchenDevices;

public abstract class KitchenDeviceForFreezing extends KitchenDevices {
	protected int coolingTemperature;

	public KitchenDeviceForFreezing() {
	}
	
	public KitchenDeviceForFreezing(TypeDevice typeDevice, FirmName name, int power, boolean isOn, int lifetime,
									InstallationSite installationSite, int coolingTemperature) {
		super(typeDevice, name, power, isOn, lifetime, installationSite);
		this.coolingTemperature = coolingTemperature;
	}

	public int getCoolingTemperature() {
		return coolingTemperature;
	}

	public void setCoolingTemperature(int coolingTemperature) {
		this.coolingTemperature = coolingTemperature;
	}

}