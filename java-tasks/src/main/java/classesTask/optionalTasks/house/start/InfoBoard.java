package classesTask.optionalTasks.house.start;

import classesTask.optionalTasks.house.entity.House;
import classesTask.optionalTasks.house.entity.Flat;

public class InfoBoard {
    private House house;
    public InfoBoard(House house) {
        this.house = house;
    }

    public void printFlatsWithGivenQuantityRooms(int givenQuantityOfRooms) {
        System.out.println("List of flats with the given quantity of rooms");
        Flat [] flatsInTheHouse = house.getFlatsInTheHouse();
        for (int i = 0; i < flatsInTheHouse.length; i++) {
            Flat flat = flatsInTheHouse[i];
            if (flat.getQuantityOfRooms() == givenQuantityOfRooms) {
                printFlat(flat);
            }
        }
    }
    public void printFlatsWithGivenQuantityRoomsAndFloorsInterval(int givenQuantityOfRooms, int startFloor, int endFloor) {
        System.out.println("List of flats with the given quantity of rooms and floors interval");
        Flat [] flatsInTheHouse = house.getFlatsInTheHouse();
        for (int i = 0; i < flatsInTheHouse.length; i++) {
            Flat flat = flatsInTheHouse[i];
            int quantityRoomInFlat = flat.getQuantityOfRooms();
            int floor = flat.getFloorOfFlat();
            if (quantityRoomInFlat == givenQuantityOfRooms && floor >= startFloor && floor <= endFloor) {
                printFlat(flat);
            }
        }
    }
    public void printFlatsByAreaMoreThanGiven(double givenArea) {
        System.out.println("List of flats with an area greater than the given");
        Flat [] flatsInTheHouse = house.getFlatsInTheHouse();
        for (int i = 0; i < flatsInTheHouse.length; i++) {
            Flat flat = flatsInTheHouse[i];
            if (flat.getAreaOfFlat() > givenArea) {
                printFlat(flat);
            }
        }
    }
    private void printFlat(Flat flat) {
        System.out.println(flat);
    }
}
