package com.epam.jwd.multithreading.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BusStop {
    private static final int MAX_COUNT_BUSES = 2;
    private Semaphore semaphore;
    private List<Bus> buses;
    private long id;

    public BusStop() {
    }

    public BusStop(long id) {
        semaphore = new Semaphore(MAX_COUNT_BUSES, true);
        this.id = id;
        this.buses = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusStop busStop = (BusStop) o;
        return Objects.equals(buses, busStop.buses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buses);
    }

    public void add(Bus bus) {
        System.out.println("Автобус подъехал " + bus.getId() + " к " + id);
        try {
            semaphore.acquire();
            buses.add(bus);
            System.out.println("Автобус стоит" + bus.getId() + " на " + id);
            Lock lock = new ReentrantLock();
            lock.lock();
            if (buses.size() > 1) {
                int index = 0;
                if(buses.indexOf(bus)==0){
                    index = 1;
                }
                buses.get(index).addPassengers(bus.debarkationPassengers());
                System.out.println("Пасажиры перешли с автобуса " + bus.getId() + " в автобус " + buses.get(0).getId());
            }
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void remove(Bus element) {
        buses.remove(element);
        semaphore.release();
        System.out.println("Автобус уехал " + element.getId() + " c " + id);
    }
}
