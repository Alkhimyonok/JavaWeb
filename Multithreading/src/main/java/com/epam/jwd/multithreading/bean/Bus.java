package com.epam.jwd.multithreading.bean;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bus implements Runnable {
    private List<Passenger> passengers;
    private List<BusStop> path;
    private long id;

    public Bus() {
        passengers = new ArrayList<>();
        path = new ArrayList<>();
    }

    public Bus(List<Passenger> passengers, List<BusStop> path, long id) {
        this.passengers = passengers;
        this.path = path;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Passenger> debarkationPassengers() {
        List<Passenger> passengers = this.passengers;
        this.passengers.clear();
        return passengers;
    }
    public void addPassengers(List<Passenger> passengers){
        this.passengers.addAll(passengers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bus bus = (Bus) o;
        return Objects.equals(passengers, bus.passengers) &&
                Objects.equals(path, bus.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passengers, path);
    }

    @Override
    public void run() {
        for (BusStop i : path) {
            i.add(this);
            i.remove(this);
        }
    }
}
