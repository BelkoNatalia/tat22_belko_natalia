package threadTask;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Port {
    private int maxLoadCapacity;
    private int currentNumberContainer;
    private Lock lock = new ReentrantLock();

    public Port(int maxLoadCapacity) {
        this.maxLoadCapacity = maxLoadCapacity;
    }

    public boolean load(int loadedContainers){
        lock.lock();
        boolean isLoad = false;
        if(loadedContainers < (maxLoadCapacity - currentNumberContainer)){
            currentNumberContainer = currentNumberContainer + loadedContainers;
            isLoad = true;
        }
        lock.unlock();
        return isLoad;
    }

    public boolean unLoad(int unLoadedContainers){
        lock.lock();
        boolean isUnLoad = false;
        if(currentNumberContainer >= unLoadedContainers){
            currentNumberContainer = currentNumberContainer - unLoadedContainers;
            isUnLoad = true;
        }
        lock.unlock();
        return isUnLoad;
    }
}
