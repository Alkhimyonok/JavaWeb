package by.epam.jwd.unit0;

public class Task5 {
    public static void main(String[] args) {
        int a = -2;
        int b = 3;
        int c = 4;
        int[] buff = new int[3];
        buff[0] = a;
        buff[1] = b;
        buff[2] = c;
        for (int i = 0; i < 3; i++) {
            if (buff[i] >= 0) {
                buff[i] = (int) Math.pow(buff[i], 2);
            } else {
                buff[i] = (int) Math.pow(buff[i], 4);
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(buff[i] + " ");
        }
    }
}
