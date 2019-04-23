package threadTask;

import threadTask.action.ActionShip;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Run {
    private static final int NUMBER_OF_DOCK = 5;

    public static void main(String[] args) {

        Port port = new Port(50);

        ExecutorService dock = Executors.newFixedThreadPool(NUMBER_OF_DOCK);

        List<Ship> listShip = new ArrayList<Ship>();
        listShip.add(new Ship("firstShip",20, 5, ActionShip.UNLOAD, port));
        listShip.add(new Ship("secondShip", 100, 80, ActionShip.LOAD, port));
        listShip.add(new Ship("thirdShip",30, 5, ActionShip.UNLOAD, port));
        listShip.add(new Ship("fourthShip", 100, 80, ActionShip.LOAD, port));
        listShip.add(new Ship("fifthShip", 40, 5, ActionShip.UNLOAD_LOAD, port));
        listShip.add(new Ship("sixthShip", 10, 1, ActionShip.LOAD, port));

        for(Ship ship: listShip){
            dock.execute(ship);
        }

        dock.shutdown();
    }
}
