package ua.kharin.jadv.wrapper;

/*Создать класс IntegerBox, который содержит в себе:
        •	int поле value
        •	конструктор с int параметром
        •	метод toString который возвращает значение value
        •	метод void increase(int value)
        •	метод void decrease(int value)

        в main вызвать конструктор,
        вывести в консоль значение переменной IntegerBox,
        вызвать метод increase(2),
        вывести в консоль,
        вызвать метод decrease(3),
        вывести в консоль
*/

public class IntegerBox {
    private int value;

    public IntegerBox(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        IntegerBox box = new IntegerBox(5);
        System.out.println(box);
        box.increase(2);
        System.out.println(box);
        box.decrease(3);
        System.out.println(box);
    }

    public void increase(int value) {
        this.value += value;
    }

    public void decrease(int value) {
        this.value -= value;
    }

    @Override
    public String toString() {
        return "IntegerBox{" +
                "value=" + value +
                '}';
    }
}
