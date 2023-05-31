package ua.kharin.jadv.practice21.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import ua.kharin.jadv.practice21.annotations.Min;
import ua.kharin.jadv.practice21.annotations.ValidColor;

//Создать класс Toy с полями:
//- высота
//- цвет
//- название
//
//Добавить валидацию через аннотации для высоты и цвета (только Red и Green доступны).
//Проверить валидацию.
@Data
@AllArgsConstructor
public class Toy {
    @ValidColor(validValues = {Color.GREEN, Color.RED})
    private Color color;
    @Min(minValue = 10)
    private int height;
    private String name;
}
