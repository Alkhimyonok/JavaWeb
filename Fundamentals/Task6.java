package by.epam.jwd.unit0;

public class Task6 {
    public static void main(String[] args) {
        int a = 3;
        int b = 8;
        int c = 6;
        int min = a;
        if (b < min) {
            min = b;
        }
        if (c < min) {
            min = c;
        }
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        int sum = min + max;
        System.out.println(sum);
    }
}
