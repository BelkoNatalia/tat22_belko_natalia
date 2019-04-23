package classesTask.mainTasks.appliances.devices.kitchenDevices.deviseForFreezking.typeOfFreezingDevise;

import classesTask.mainTasks.appliances.devices.FirmName;
import classesTask.mainTasks.appliances.devices.TypeDevice;
import classesTask.mainTasks.appliances.devices.kitchenDevices.InstallationSite;
import classesTask.mainTasks.appliances.devices.kitchenDevices.deviseForFreezking.KitchenDeviceForFreezing;

public class Freezer extends KitchenDeviceForFreezing {
	private int degreeOfFreezing;

	public Freezer() {
	}

	public Freezer(TypeDevice typeDevice, FirmName name, int power, boolean isOn, int lifetime,
				   InstallationSite installationSite, int coolingTemperature, int degreeOfFreezing) {
		super(typeDevice, name, power, isOn, lifetime, installationSite, coolingTemperature);
		this.degreeOfFreezing = degreeOfFreezing;
	}

	public int getDegreeOfFreezing() {
		return degreeOfFreezing;
	}

	public void setDegreeOfFreezing(int degreeOfFreezing) {
		this.degreeOfFreezing = degreeOfFreezing;
	}

	@Override
	public String toString() {
		return "Freezer{" +
				"degreeOfFreezing=" + degreeOfFreezing +
				", coolingTemperature=" + coolingTemperature +
				", installationSite=" + installationSite +
				", typeDevice=" + typeDevice +
				", firmName=" + firmName +
				", power=" + power +
				", isOn=" + isOn +
				", lifetime=" + lifetime +
				'}';
	}
}