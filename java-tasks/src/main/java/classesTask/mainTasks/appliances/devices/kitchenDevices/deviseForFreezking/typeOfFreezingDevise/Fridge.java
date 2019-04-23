package classesTask.mainTasks.appliances.devices.kitchenDevices.deviseForFreezking.typeOfFreezingDevise;

import classesTask.mainTasks.appliances.devices.FirmName;
import classesTask.mainTasks.appliances.devices.TypeDevice;
import classesTask.mainTasks.appliances.devices.kitchenDevices.InstallationSite;
import classesTask.mainTasks.appliances.devices.kitchenDevices.deviseForFreezking.KitchenDeviceForFreezing;

public class Fridge extends KitchenDeviceForFreezing {

	private int degreeOfCooling;

	public Fridge() {
	}

	public Fridge(TypeDevice typeDevice, FirmName name, int power, boolean isOn, int lifetime,
				  InstallationSite installationSite, int coolingTemperature,int degreeOfCooling) {
		super(typeDevice, name, power, isOn, lifetime, installationSite, coolingTemperature);
		this.degreeOfCooling = degreeOfCooling;
	}

	public int getDegreeOfCooling() {
		return degreeOfCooling;
	}

	public void setDegreeOfCooling(int degreeOfCooling) {
		this.degreeOfCooling = degreeOfCooling;
	}

	@Override
	public String toString() {
		return "Fridge{" +
				"degreeOfCooling=" + degreeOfCooling +
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
