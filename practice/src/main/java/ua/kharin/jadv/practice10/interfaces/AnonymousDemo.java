package ua.kharin.jadv.practice10.interfaces;

public class AnonymousDemo {
    public static void main(String[] args) {
        Operation op = new Operation() {
            public int calculate(int x, int y) {
                return x + y;
            }
        };
        int result = op.calculate(20, 10);
        System.out.println(result); // 30
    }
}
