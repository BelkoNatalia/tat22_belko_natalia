package classesTask.mainTasks.appliances.devices.kitchenDevices;

import classesTask.mainTasks.appliances.devices.Device;
import classesTask.mainTasks.appliances.devices.FirmName;
import classesTask.mainTasks.appliances.devices.TypeDevice;

public abstract class KitchenDevices extends Device {

	protected InstallationSite installationSite;

	public KitchenDevices() {
	}

	public KitchenDevices(TypeDevice typeDevice, FirmName name, int power, boolean isOn, int lifetime,
						  InstallationSite installationSite) {
		super(typeDevice, name, power, isOn, lifetime);
		this.installationSite = installationSite;
	}

	public InstallationSite getInstallationSite() {
		return installationSite;
	}

	public void setInstallationSite(InstallationSite installationSite) {
		this.installationSite = installationSite;
	}
}