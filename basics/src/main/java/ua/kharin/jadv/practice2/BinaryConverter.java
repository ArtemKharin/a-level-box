package ua.kharin.jadv.practice2;

public class BinaryConverter {
    public static void main(String[] args) {
        int decimal = 77;

        String binary = Integer.toBinaryString(decimal);
        System.out.println(binary);

        System.out.println(Integer.parseInt(binary, 2));
    }
}
