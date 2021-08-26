package ua.kharin.jadv.practice10.interfaces;

public class LambdaDemo {
    public static void main(String[] args) {
        Operation op = (x, y) -> x + y;
        int result = op.calculate(20, 10);
        System.out.println(result); // 30
    }
}
