package tryCatchThrow;

public class Throw {
    public static void main(String[] args) {
        int a = 0;
        if (a == 0) {
            System.out.println("Divisor cannot be equal to zero");
            throw new ArithmeticException("-Exception-");
        }
    }
}
