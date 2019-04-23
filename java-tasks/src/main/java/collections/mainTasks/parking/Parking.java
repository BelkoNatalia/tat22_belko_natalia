package collections.mainTasks.parking;

import java.util.List;

public class Parking {
    private List<Integer> parking;

    public Parking(List<Integer> parking) {
        this.parking = parking;
    }

    public boolean driveOff(int driveOffNumberPlace) {
        boolean isDriveOff = false;
        int currentNumberParking = driveOffNumberPlace - 1;
        if (parking.get(currentNumberParking) == 1) {
            parking.remove(currentNumberParking);
            parking.add(currentNumberParking, 0);
            isDriveOff = true;
        }
        return isDriveOff;
    }

    public boolean arrive(int startNumberPlace)  {
        boolean isArrive = false;
        for (int i = startNumberPlace; i < parking.size(); i++) {
            int currentPlaceState = parking.get(i);
            if (currentPlaceState == 0) {
                parking.remove(i);
                parking.add(i, 1);
                i = parking.size();
                isArrive = true;
            }
        }
        return isArrive;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "parking=" + parking +
                '}';
    }
}
