package classesTask.mainTasks.appliances.devices.kitchenDevices.deviseForCooking.typeOfCookingDevise;

import classesTask.mainTasks.appliances.devices.FirmName;
import classesTask.mainTasks.appliances.devices.TypeDevice;
import classesTask.mainTasks.appliances.devices.kitchenDevices.InstallationSite;
import classesTask.mainTasks.appliances.devices.kitchenDevices.deviseForCooking.KitchenDeviceForCooking;

public class Microwave extends KitchenDeviceForCooking {
	private int powerOfMicrowave;

	public Microwave() {
	}

	public Microwave(TypeDevice typeDevice, FirmName name, int power, boolean isOn, int lifetime,
					 InstallationSite installationSite, int heatingTemperature, int powerOfMicrowave) {
		super(typeDevice, name, power, isOn, lifetime, installationSite, heatingTemperature);
		this.powerOfMicrowave = powerOfMicrowave;
	}

	public int getPowerOfMicrowave() {
		return powerOfMicrowave;
	}

	public void setPowerOfMicrowave(int typeOfHeatingElement) {

		this.powerOfMicrowave = powerOfMicrowave;
	}

	@Override
	public String toString() {
		return "Microwave{" +
				"powerOfMicrowave=" + powerOfMicrowave +
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