package ua.kharin.open.bad;

import java.util.List;

public class AnimalService {
    public void makeSound(List<Animal> animals) {
        for (Animal animal : animals) {
            if ("lion".equals(animal.getName())) {
                System.out.println("roar");
            }
            if ("mouse".equals(animal.getName())) {
                System.out.println("squeak");
            }
            if ("snake".equals(animal.getName())) {
                System.out.println("hiss");
            }
        }
    }
}
