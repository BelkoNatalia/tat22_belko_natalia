package classesTask.mainTasks.appliances.start;

import classesTask.mainTasks.appliances.devices.Device;
import classesTask.mainTasks.appliances.devices.FirmName;
import classesTask.mainTasks.appliances.devices.TypeDevice;
import classesTask.mainTasks.appliances.devices.cliningDevises.TypeCleaningSubject;
import classesTask.mainTasks.appliances.devices.cliningDevises.dryCleaningDevise.typeOfDryDevise.Elektrovenik;
import classesTask.mainTasks.appliances.devices.cliningDevises.dryCleaningDevise.typeOfDryDevise.VacuumCleaner;
import classesTask.mainTasks.appliances.devices.cliningDevises.wetCleaningDevise.typeOfWetDevise.SteamCleaner;
import classesTask.mainTasks.appliances.devices.cliningDevises.wetCleaningDevise.typeOfWetDevise.Washer;
import classesTask.mainTasks.appliances.devices.kitchenDevices.InstallationSite;
import classesTask.mainTasks.appliances.devices.kitchenDevices.deviseForCooking.typeOfCookingDevise.Microwave;
import classesTask.mainTasks.appliances.devices.kitchenDevices.deviseForCooking.typeOfCookingDevise.Oven;
import classesTask.mainTasks.appliances.devices.kitchenDevices.deviseForFreezking.typeOfFreezingDevise.Freezer;
import classesTask.mainTasks.appliances.devices.kitchenDevices.deviseForFreezking.typeOfFreezingDevise.Fridge;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {

        Fridge firstFridge = new Fridge(TypeDevice.FRIDGE, FirmName.BOSH, 200, true, 10,
                InstallationSite.COMBINED_KITCHEN,
                25, 5);
        Fridge secondFridge = new Fridge(TypeDevice.FRIDGE, FirmName.ELECTROLUX, 220, false, 15,
                InstallationSite.KITCHEN,
                30, 6);
        Freezer freezer = new Freezer(TypeDevice.FREEZER, FirmName.ELECTROLUX, 220, true, 20,
                InstallationSite.KITCHEN,
                30, 5);
        Oven oven = new Oven(TypeDevice.OVEN, FirmName.BOSH, 200, false, 10,
                InstallationSite.COMBINED_KITCHEN, 150, "htr75");
        Microwave microwave = new Microwave(TypeDevice.MICROWAVE, FirmName.BOSH, 200, false, 10,
                InstallationSite.KITCHEN, 150, 400);
        VacuumCleaner vacuumCleaner = new VacuumCleaner(TypeDevice.VACUUM_CLEANER, FirmName.VECO, 200, false,
                10, TypeCleaningSubject.UNIVERSAL_TYPE, 100, 120);
        Elektrovenik elektrovenik = new Elektrovenik(TypeDevice.ELEKTROVENIK, FirmName.BOSH, 200, false,
                5, TypeCleaningSubject.FLOOR_TYPE, 50, 4);
        Washer washer = new Washer(TypeDevice.WASHER, FirmName.BOSH, 200, false,
                5, TypeCleaningSubject.CLOTHES_TYPE, 95, 100);
        SteamCleaner steamCleaner = new SteamCleaner(TypeDevice.STEAM_CLEANER, FirmName.ELECTROLUX, 100, false,
                5, TypeCleaningSubject.UNIVERSAL_TYPE, 100, 100);


        Device[] devices = {firstFridge, secondFridge, freezer, oven, microwave, vacuumCleaner, elektrovenik,
                washer, steamCleaner};

        Flat flat = new Flat(devices);

        getMainMenu(flat);
    }

    private static void getMainMenu(Flat flat) {
        do {
            getMainPointsMenu();
            Scanner scanner = new Scanner(System.in);
            int pointMenu = scanner.nextInt();

            switch (pointMenu) {
                case 1:
                    turnOnDevice(flat);
                    break;
                case 2:
                    System.out.println("Power = " + flat.calcConsumedPower());
                    break;
                case 3:
                    flat.sortDevicesByPower().printDevices();
                    break;
                case 4:
                    findDeviceByFirmNamePowerLifetime(flat);
                    break;
                case 5:
                    System.out.println("Goodbye!!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong number");
                    System.out.println("Please repeat choosing numbers");
            }
        } while (isContinue());

    }

    private static void getMainPointsMenu() {
        System.out.println("Choose number menu:");
        System.out.println("1 - Turn on device");
        System.out.println("2 - Calc consumed power");
        System.out.println("3 - Sort devices by power");
        System.out.println("4 - Find device by name firm, power, and lifetime");
        System.out.println("5 - Exit");
    }

    private static boolean isContinue() {
        System.out.println("Do you want to continue Y/N:");
        Scanner scanner = new Scanner(System.in);
        String choose = scanner.next();
        boolean isContinue = true;
        if (choose.equalsIgnoreCase("N")) {
            isContinue = false;
        }
        return isContinue;
    }

    private static void turnOnDevice(Flat flat) {
        Device currentDevice = flat.findDeviceByTypeDevice(getTypeDevise());
        currentDevice.turnOn();
        boolean stateOfCurrentDevice = currentDevice.getState();
        System.out.println(currentDevice.getTypeDevice() + " is turn on " + stateOfCurrentDevice);
    }

    private static void findDeviceByFirmNamePowerLifetime(Flat flat) {
        FirmName firmName = getFirmName();
        int startPower = getStartPower();
        int endPower = getEndPower();
        int lifetime = getLifetime();

        Device suitableDevise = flat.getDeviceByFirmNamePowerLifetime(firmName, startPower, endPower, lifetime);
        if (suitableDevise == null) {
            System.out.println("Suitable devise has not found");
        } else {
            System.out.println(suitableDevise);
        }
    }

    private static TypeDevice getTypeDevise() {
        getTypeDevisePointMenu();
        Scanner scanner = new Scanner(System.in);
        int pointMenu = scanner.nextInt();
        TypeDevice typeDevice = null;
        switch (pointMenu) {
            case 1:
                typeDevice = TypeDevice.MICROWAVE;
                break;
            case 2:
                typeDevice = TypeDevice.OVEN;
                break;
            case 3:
                typeDevice = TypeDevice.FREEZER;
                break;
            case 4:
                typeDevice = TypeDevice.FRIDGE;
                break;
            case 5:
                typeDevice = TypeDevice.VACUUM_CLEANER;
                break;
            case 6:
                typeDevice = TypeDevice.ELEKTROVENIK;
                break;
            case 7:
                typeDevice = TypeDevice.WASHER;
                break;
            case 8:
                typeDevice = TypeDevice.STEAM_CLEANER;
                break;
            default:
                System.out.println("Wrong number");
                System.out.println("Please repeat choosing numbers");

        }
        return typeDevice;
    }

    private static void getTypeDevisePointMenu (){
        System.out.println("Input number by type of device");
        System.out.println("1 - MICROWAVE");
        System.out.println("2 - OVEN");
        System.out.println("3 - FREEZER");
        System.out.println("4 - FRIDGE");
        System.out.println("5 - VACUUM_CLEANER");
        System.out.println("6 - ELEKTROVENIK");
        System.out.println("7 - WASHER");
        System.out.println("8 - STEAM_CLEANE");
    }

    private static FirmName getFirmName() {
        getFirmNamePointMenu();
        Scanner scanner = new Scanner(System.in);
        int pointMenu = scanner.nextInt();
        FirmName firmName = null;
        switch (pointMenu) {
            case 1:
                firmName = FirmName.BOSH;
                break;
            case 2:
                firmName = FirmName.ELECTROLUX;
                break;
            case 3:
                firmName = FirmName.VECO;
                break;
            case 4:
                firmName = FirmName.UNDEFENED;
                break;
            default:
                System.out.println("Wrong number");
                System.out.println("Please repeat choosing numbers");

        }
        return firmName;
    }

    private static void getFirmNamePointMenu(){
        System.out.println("Input number by firm name");
        System.out.println("1 - BOSH");
        System.out.println("2 - ELECTROLUX");
        System.out.println("3 - VECO");
        System.out.println("4 - UNDEFENED");
    }

    private static int getStartPower() {
        System.out.println("Input start power");
        Scanner scanner = new Scanner(System.in);
        int startPower = scanner.nextInt();
        return startPower;
    }

    private static int getEndPower() {
        System.out.println("Input end power");
        Scanner scanner = new Scanner(System.in);
        int endPower = scanner.nextInt();
        return endPower;
    }

    private static int getLifetime() {
        System.out.println("Input lifetime");
        Scanner scanner = new Scanner(System.in);
        int lifetime = scanner.nextInt();
        return lifetime;
    }
}