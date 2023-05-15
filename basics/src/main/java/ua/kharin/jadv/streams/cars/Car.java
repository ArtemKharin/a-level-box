package ua.kharin.jadv.streams.cars;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Car {
    private String name;
    private int weight;
    private CarType type;
    private List<String> owners;
}
