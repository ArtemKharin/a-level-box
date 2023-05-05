package ua.kharin.jadv.practice14;

import java.util.ArrayList;
import java.util.List;

public class Garage<T extends Vehicle> {
    private List<T> transport = new ArrayList<>();

    public T get(int i) {
        return transport.get(i);
    }

    public void add(T obj) {
        transport.add(obj);
    }

    public <S extends T> List<T> getByType(Class<S> classType) {
        return transport.stream().filter(classType::isInstance).toList();
    }

    public static void main(String[] args) {
        Garage<Vehicle> garage = new Garage<>();
        garage.add(new Vehicle());
        garage.add(new Vehicle());
        garage.add(new Car());
        garage.add(new Car());
        System.out.println(garage.get(0));
        System.out.println(garage.get(1));
        System.out.println(garage.get(2));
        System.out.println(garage.get(3));
        System.out.println(garage.getByType(Vehicle.class));
        System.out.println(garage.getByType(Car.class));
    }
}

class Vehicle {
    @Override
    public String toString() {
        return "Vehicle{}";
    }
}

class Car extends Vehicle {
    @Override
    public String toString() {
        return "Car{}";
    }
}
