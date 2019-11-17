package by.epam.jwd.unit0;

public class Task9 {
    public static void main(String[] args) {
        int[] array1 = {2, 4, 6, 8};
        int[] array2 = {1, 3, 5, 7, 9};
        int k = 3;
        int[] result = new int[array1.length + array2.length];
        for (int i = 0; i < k; i++) {
            result[i] = array1[i];
        }
        for (int i = 0; i < array2.length; i++) {
            result[i + k] = array2[i];
        }
        for (int i = k; i < array1.length; i++) {
            result[k + array2.length] = array1[i];
        }
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
