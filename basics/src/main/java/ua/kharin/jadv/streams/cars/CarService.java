package ua.kharin.jadv.streams.cars;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class CarService {
    private List<Car> cars;

    public List<String> findHybridCarOwners() {
        return cars.stream()
                .filter(it -> it.getType().equals(CarType.HYBRID))
                .flatMap(it -> it.getOwners().stream())
                .distinct()
                .toList();
    }

    public List<Car> findCarsByName(String name) {
        return cars.stream()
                .filter(it -> Objects.equals(it.getName(), name))
                .toList();
    }

    public List<Car> findCarsWithWeightLessThan(int weightLimit) {
        return cars.stream()
                .filter(it -> it.getWeight() < weightLimit)
                .toList();
    }

}
