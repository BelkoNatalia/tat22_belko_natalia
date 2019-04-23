package classesTask.mainTasks.appliances.devices.kitchenDevices.deviseForCooking;

import classesTask.mainTasks.appliances.devices.FirmName;
import classesTask.mainTasks.appliances.devices.TypeDevice;
import classesTask.mainTasks.appliances.devices.kitchenDevices.InstallationSite;
import classesTask.mainTasks.appliances.devices.kitchenDevices.KitchenDevices;

public abstract class KitchenDeviceForCooking extends KitchenDevices {

	protected int heatingTemperature;

	public KitchenDeviceForCooking() {
	}

	public KitchenDeviceForCooking(TypeDevice typeDevice, FirmName name, int power, boolean isOn, int lifetime,
								   InstallationSite installationSite, int heatingTemperature) {
		super(typeDevice, name, power, isOn, lifetime, installationSite);
		this.heatingTemperature = heatingTemperature;
	}

	public int getHeatingTemperature() {
		return heatingTemperature;
	}

	public void setHeatingTemperature(int heatingTemperature) {
		this.heatingTemperature = heatingTemperature;
	}
}