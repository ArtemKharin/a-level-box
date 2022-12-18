package ua.kharin.open.good;

import java.util.List;

public class AnimalService {
    public void makeSound(List<Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal.getSound());
        }
    }
}
