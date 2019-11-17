package by.epam.jwd.unit0;

public class Task2 {
    private static double f(int a, int b, int c){
        return (b+Math.sqrt(Math.pow(b,2)+4*a*c))/2*a-Math.pow(a,3)*c+Math.pow(b,-2);
    }
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;
        System.out.println(f(a,b,c));
    }
}
