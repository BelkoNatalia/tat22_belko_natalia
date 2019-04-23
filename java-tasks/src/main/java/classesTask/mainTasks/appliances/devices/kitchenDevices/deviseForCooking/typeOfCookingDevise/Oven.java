package classesTask.mainTasks.appliances.devices.kitchenDevices.deviseForCooking.typeOfCookingDevise;

import classesTask.mainTasks.appliances.devices.FirmName;
import classesTask.mainTasks.appliances.devices.TypeDevice;
import classesTask.mainTasks.appliances.devices.kitchenDevices.InstallationSite;
import classesTask.mainTasks.appliances.devices.kitchenDevices.deviseForCooking.KitchenDeviceForCooking;

public class Oven extends KitchenDeviceForCooking {
	private String typeOfHeatingElement;

	public Oven() {
	}

	public Oven(TypeDevice typeDevice, FirmName name, int power, boolean isOn, int lifetime,
				InstallationSite installationSite, int heatingTemperature, String typeOfHeatingElement) {
		super(typeDevice, name, power, isOn, lifetime, installationSite, heatingTemperature);
		this.typeOfHeatingElement = typeOfHeatingElement;
	}

	public String getTypeOfHeatingElement() {
		return typeOfHeatingElement;
	}

	public void setTypeOfHeatingElement(String typeOfHeatingElement) {
		this.typeOfHeatingElement = typeOfHeatingElement;
	}

	@Override
	public String toString() {
		return "Oven{" +
				"typeOfHeatingElement='" + typeOfHeatingElement + '\'' +
				", heatingTemperature=" + heatingTemperature +
				", installationSite=" + installationSite +
				", typeDevice=" + typeDevice +
				", firmName=" + firmName +
				", power=" + power +
				", isOn=" + isOn +
				", lifetime=" + lifetime +
				'}';
	}
}
