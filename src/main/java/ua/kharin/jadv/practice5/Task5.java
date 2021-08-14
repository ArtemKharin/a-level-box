package ua.kharin.jadv.practice5;

public class Task5 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {3, 3, 5, 6},
                {0, 0, 0, 0},
                {1, 2, 7, 9},
                {1, 1, 1, 1}};
        System.out.println(calcDiagonalSum(matrix));

    }

    public static int calcDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j) {
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }
}
