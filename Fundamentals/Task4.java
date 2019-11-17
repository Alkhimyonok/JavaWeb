package by.epam.jwd.unit0;

public class Task4 {
    public static void main(String[] args) {
        double x = 0.1;
        double y = -1;
        boolean answer = false;
        if ((y >= 0 && y <= 4 && x >= -2 && x <= 2) || (y >= -3 && y <= 0 && x >= -4 && x <= 4)) {
            answer = true;
            if (x >= -0.5 && x <= 0.5 && y >= -1.5 && y <= -0.5) {
                answer = false;
            }
        }
        System.out.println(answer);
    }
}
