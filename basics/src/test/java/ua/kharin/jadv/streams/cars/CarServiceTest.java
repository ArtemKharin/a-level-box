package ua.kharin.jadv.streams.cars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarServiceTest {
    private CarService service;
    private Car car1;
    private Car car2;
    private Car car3;
    private List<String> hybridCarOwners = List.of("Lname1", "Lname2", "Lname3");

    @BeforeEach
    void setUp() {
        car1 = new Car("Lamborghini", 1500, CarType.PETROL, List.of("Happy"));
        car2 = new Car("Toyota", 2200, CarType.HYBRID, hybridCarOwners);
        car3 = new Car("Toyota", 2800, CarType.ELECTRIC, List.of("Testerov"));
        service = new CarService(List.of(car1, car2, car3));
    }

    @Test
    void findHybridCarOwners() {
        assertEquals(hybridCarOwners, service.findHybridCarOwners());
    }

    @Test
    void findCarsByName() {
        List<Car> result = service.findCarsByName("Toyota");
        assertEquals(2, result.size());
        assertTrue(result.contains(car2));
        assertTrue(result.contains(car3));
    }

    @Test
    void findCarsWithWeightLessThan() {
        List<Car> result = service.findCarsWithWeightLessThan(2500);
        assertEquals(2, result.size());
        assertTrue(result.contains(car1));
        assertTrue(result.contains(car2));
    }
}