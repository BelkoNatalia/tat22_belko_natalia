package classesTask.optionalTasks.house.start;

import classesTask.optionalTasks.house.entity.Flat;
import classesTask.optionalTasks.house.entity.House;

public class Runner {

    public static void main(String[] args) {

        Flat firstFlat = new Flat(1, 48, 50, 2, 2);
        Flat secondFlat = new Flat(2, 6, 61.7, 4, 3);
        Flat thirdFlat = new Flat(3, 56, 75, 3, 5);

        Flat[] currentFlats = {firstFlat, secondFlat, thirdFlat};
        House buildHouse = new House(currentFlats);
        InfoBoard  infoBoard = new InfoBoard(buildHouse);

        infoBoard.printFlatsByAreaMoreThanGiven(20);
        infoBoard.printFlatsWithGivenQuantityRooms(5);
        infoBoard.printFlatsWithGivenQuantityRoomsAndFloorsInterval(3, 1, 5);

    }
}