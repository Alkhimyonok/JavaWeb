package by.epam.jwd.unit0;

public class Task7 {
    private static double f(int x) {
        return Math.pow(Math.sin(x), 2) - Math.cos(2 * x);
    }

    public static void main(String[] args) {
        int a = 1;
        int b = 7;
        int h = 1;
        while (a <= b) {
            System.out.println("F(" + a + ")=" + f(a));
            a += h;
        }
    }
}
