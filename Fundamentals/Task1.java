package by.epam.jwd.unit0;

public class Task1 {
    public static void main(String[] args) {
        int arg = 1234;
        int thousands = arg / 1000;
        int hundreds = arg / 100 - thousands * 10;
        int tens = arg / 10 - hundreds * 10 - thousands * 100;
        int ones = arg - tens * 10 - hundreds * 100 - thousands * 1000;
        int sum1 = thousands + hundreds;
        int sum2 = tens + ones;
        System.out.println(sum1 == sum2);
    }
}
