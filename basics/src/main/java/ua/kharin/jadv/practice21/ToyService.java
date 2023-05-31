package ua.kharin.jadv.practice21;

import ua.kharin.jadv.practice21.annotations.Min;
import ua.kharin.jadv.practice21.annotations.ValidColor;
import ua.kharin.jadv.practice21.model.Color;
import ua.kharin.jadv.practice21.model.Toy;

import java.lang.reflect.Field;
import java.util.Arrays;

public class ToyService {
    public static void validateToy(Toy toy) {
        Class<? extends Toy> toyClass = toy.getClass();
        for (Field field : toyClass.getDeclaredFields()) {
            validateField(field, toy);
        }
    }

    private static void validateField(Field field, Toy toy) {
        if (field.isAnnotationPresent(ValidColor.class)) {
            validateColor(field, toy);
        }
        if (field.isAnnotationPresent(Min.class)) {
            validateMinValue(field, toy);
        }
    }

    private static void validateMinValue(Field field, Toy toy) {
        try {
            field.setAccessible(true);
            int value = field.getInt(toy);
            int minValue = field.getAnnotation(Min.class).minValue();
            if (minValue > value) {
                throw new ValidationException("Wrong value, minimum: " + minValue);
            }
        } catch (IllegalAccessException e) {
            throw new ValidationException("Validation of min value failed", e);
        }
    }

    private static void validateColor(Field field, Toy toy) {
        try {
            field.setAccessible(true);
            Color value = (Color) field.get(toy);
            Color[] validColors = field.getAnnotation(ValidColor.class).validValues();
            for (Color validColor : validColors) {
                if (validColor.equals(value)) {
                    return;
                }
            }
            throw new ValidationException("Wrong color, valid values: " + Arrays.toString(validColors));
        } catch (IllegalAccessException e) {
            throw new ValidationException("Validation of color failed", e);
        }
    }
}
