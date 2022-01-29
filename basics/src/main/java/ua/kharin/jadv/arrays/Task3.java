package ua.kharin.jadv.arrays;

public class Task3 {
    //-	Известны данные о стоимости каждого из 12 товаров.
    // Найти общую стоимость тех товаров, которые стоят дороже 1000 uah
    // (количество таких товаров неизвестно).
    public static void main(String[] args) {
        double[] prices = {1234, 100.4, 222.22, 1111,
                111, 15.9, 20000.99, 1999.99,
                12.50, 66.3, 650_000, 650001};
        System.out.println(calcSumConditionally(prices));
    }

    public static double calcSumConditionally(double[] prices) {
        double sum = 0;
        for (double price : prices) {
            if (price > 1000) {
                sum += price;
            }
        }
        return sum;
    }
}
