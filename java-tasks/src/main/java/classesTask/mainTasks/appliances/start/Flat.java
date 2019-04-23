package classesTask.mainTasks.appliances.start;

import classesTask.mainTasks.appliances.devices.Device;
import classesTask.mainTasks.appliances.devices.FirmName;
import classesTask.mainTasks.appliances.devices.TypeDevice;

public class Flat {
    private Device[] devices;

    public Flat() {
    }

    public Flat(Device[] devices) {
        this.devices = devices;
    }

    public Device[] getDevices() {
        return devices;
    }

    public void setDevices(Device[] devices) {
        this.devices = devices;
    }

    public Device findDeviceByTypeDevice(TypeDevice typeDevice) {
        Device findDevice = null;
        for (int i = 0; i < devices.length; i++) {
            if (devices[i].getTypeDevice().equals(typeDevice)) {
                findDevice = devices[i];
            }
        }
        return findDevice;
    }

    public int calcConsumedPower() {
        int sumConsumedPower = 0;
        for (Device el : devices) {
            if (el.getIsOn()) {
                sumConsumedPower = sumConsumedPower + el.getPower();
            }
        }
        return sumConsumedPower;
    }

    public Flat sortDevicesByPower() {
        for (int i = devices.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                int currentDevicePower = devices[j].getPower();
                int nextDevicePower = devices[j + 1].getPower();
                if (currentDevicePower > nextDevicePower) {
                    Device tempDevice = devices[j];
                    devices[j] = devices[j + 1];
                    devices[j + 1] = tempDevice;
                }
            }
        }
        return this;
    }

    public Device getDeviceByFirmNamePowerLifetime(FirmName firmName, int startPower, int endPower, int lifetime) {
        Device desiredDevise = null;
        for (int i = 0; i < devices.length; i++) {
            int currentDevicePower = devices[i].getPower();
            if (devices[i].getFirmName().equals(firmName) && currentDevicePower > startPower &&
                    currentDevicePower < endPower && devices[i].getLifetime() > lifetime) {
                desiredDevise = devices[i];
                break;
            }
        }
        return desiredDevise;
    }

    public void printDevices() {
        for (int i = 0; i < devices.length; i++) {
            System.out.println(devices[i]);
        }
    }

}
