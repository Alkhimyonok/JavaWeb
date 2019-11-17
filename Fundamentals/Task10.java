package by.epam.jwd.unit0;

public class Task10 {
    public static void main(String[] args) {
        int n = 4;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    result[i][j] = j + 1;
                }
            } else {
                for (int j = 0; j < n; j++) {
                    result[i][j] = n - j;
                }
            }
        }
        for (int[] buff : result) {
            for (int i : buff) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }
}
