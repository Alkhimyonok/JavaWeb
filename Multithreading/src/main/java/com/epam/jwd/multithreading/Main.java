package com.epam.jwd.multithreading;

import com.epam.jwd.multithreading.bean.BusStop;
import com.epam.jwd.multithreading.bean.Passenger;
import com.epam.jwd.multithreading.bean.Bus;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Passenger> passengers1 = new ArrayList<>();
        passengers1.add(new Passenger(1));
        passengers1.add(new Passenger(2));
        passengers1.add(new Passenger(3));
        List<BusStop> stops1 = new ArrayList<>();
        stops1.add(new BusStop(1));
        stops1.add(new BusStop(2));
        stops1.add(new BusStop(3));
        Bus bus1 = new Bus(passengers1, stops1, 1);
        Thread thread1 = new Thread(bus1);

        List<Passenger> passengers2 = new ArrayList<>();
        passengers2.add(new Passenger(4));
        passengers2.add(new Passenger(5));
        passengers2.add(new Passenger(6));
        Bus bus2 = new Bus(passengers2, stops1, 2);
        Thread thread2 = new Thread(bus2);

        List<Passenger> passengers3 = new ArrayList<>();
        passengers3.add(new Passenger(7));
        passengers3.add(new Passenger(8));
        passengers3.add(new Passenger(9));
        Bus bus3 = new Bus(passengers3, stops1, 3);
        Thread thread3 = new Thread(bus3);

        List<Passenger> passengers4 = new ArrayList<>();
        passengers4.add(new Passenger(10));
        passengers4.add(new Passenger(11));
        passengers4.add(new Passenger(12));
        Bus bus4 = new Bus(passengers4, stops1, 4);
        Thread thread4 = new Thread(bus4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
