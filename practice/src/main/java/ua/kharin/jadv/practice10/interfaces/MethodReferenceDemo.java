package ua.kharin.jadv.practice10.interfaces;

public class MethodReferenceDemo {
    public static void main(String[] args) {
        Operation op = Integer::sum;
        int result = op.calculate(20, 10);
        System.out.println(result); // 30
    }
}
