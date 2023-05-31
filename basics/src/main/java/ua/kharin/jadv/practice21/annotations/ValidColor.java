package ua.kharin.jadv.practice21.annotations;

import ua.kharin.jadv.practice21.model.Color;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidColor {
    Color[] validValues() default {};
}
