package classesTask.mainTasks.appliances.devices;

public abstract class Device implements TurnOnOf {

    protected TypeDevice typeDevice;
    protected FirmName firmName;
    protected int power;
    protected boolean isOn;
    protected int lifetime;

    public Device() {
    }

    public Device(TypeDevice typeDevice, FirmName name, int power, boolean isOn, int lifetime) {
        this.typeDevice = typeDevice;
        this.firmName = name;
        this.power = power;
        this.isOn = isOn;
        this.lifetime = lifetime;
    }

    public TypeDevice getTypeDevice() {
        return typeDevice;
    }

    public void setTypeDevice(TypeDevice typeDevice) {
        this.typeDevice = typeDevice;
    }

    public FirmName getFirmName() {
        return firmName;
    }

    public void setFirmName(FirmName firmName) {
        this.firmName = firmName;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public boolean getIsOn() {
        return isOn;
    }

    public void setIsOn(boolean isOn) {
        this.isOn = isOn;
    }

    public int getLifetime() {
        return lifetime;
    }

    public void setLifetime(int lifetime) {
        this.lifetime = lifetime;
    }

    public void turnOn() {
        isOn = true;
    }

    public void turnOf() {
        isOn = false;
    }

    public boolean getState() {
        return isOn;
    }
}