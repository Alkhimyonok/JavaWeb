package by.epam.jwd.unit0;

import java.util.ArrayList;

public class Task8 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 14, 21, 23};
        int K = 7;
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i : array) {
            if (i % K == 0) {
                answer.add(i);
            }
        }
        System.out.println(answer.toString());
    }
}
