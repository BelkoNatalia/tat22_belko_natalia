package threadTask;


import threadTask.action.ActionShip;

import java.util.concurrent.TimeUnit;

public class Ship extends Thread {
    private int maxLoadCapacity;
    private int currentNumberContainer;
    private ActionShip action;
    private Port destinationPort;
    private static final int MAX_NUMBER_TRIES = 5;
    private static final int WAITING_TIME = 5;
    private String name;


    public Ship(String name, int maxLoadCapacity, int currentNumberContainer, ActionShip action, Port destinationPort) {
        this.name = name;
        this.maxLoadCapacity = maxLoadCapacity;
        this.currentNumberContainer = currentNumberContainer;
        this.action = action;
        this.destinationPort = destinationPort;
    }

    @Override
    public void run() {
        int counterTries = 0;
        while (counterTries < MAX_NUMBER_TRIES) {
            counterTries++;
            boolean isLoad = false;
            boolean isUnLoad = false;
            boolean isUnLoadLoad = false;
            switch (action) {
                case LOAD:
                    isLoad = destinationPort.unLoad(maxLoadCapacity - currentNumberContainer);
                    System.out.println(name + " -Loading- "  + currentNumberContainer + " | " + isLoad);
                    break;
                case UNLOAD:
                    isUnLoad = destinationPort.load(currentNumberContainer);
                    System.out.println(name + "-Unloading-" + currentNumberContainer + " | " + isUnLoad);
                    break;
                case UNLOAD_LOAD:
                    isUnLoad = destinationPort.load(currentNumberContainer);
                    isLoad = destinationPort.unLoad(maxLoadCapacity);

                    if(isLoad && isUnLoad){
                        isUnLoadLoad = true;
                    }
                    System.out.println(name + "-Loading-Unloading- " + currentNumberContainer + " | " + isUnLoad);

                    break;
            }
            if (isLoad || isUnLoad || isUnLoadLoad) {
                counterTries = MAX_NUMBER_TRIES;
            } else {
                try {
                    System.out.println(name + "-Waiting for, с: " + WAITING_TIME);
                    TimeUnit.SECONDS.sleep(WAITING_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Finish " + name);
    }
}