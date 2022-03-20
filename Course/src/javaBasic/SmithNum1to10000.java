package javaBasic;

public class SmithNum1to10000 {
    public static void main(String[] args) {
        int sumDig = 0, num, digit, sumDiv = 0, div, divDigit;
        for (int i = 1; i <= 10000; i++) {
            if (!checkPrime(i)) {
                num = i;
                sumDig = 0;
                sumDiv = 0;
                while (num > 0) {
                    digit = num % 10;
                    sumDig = sumDig + digit;
                    num = num / 10;
                }
                num = i;
                while (num > 1) {
                    div = findDiv(num);
                    num = num / div;
                    if (checkPrime(div)) {
                        while (div > 0) {
                            divDigit = div % 10;
                            div = div/10;
                            sumDiv = sumDiv + divDigit;
                        }
                    }
                }
                if (sumDig == sumDiv) {
                    System.out.println(i);
                }
            }
        }
    }

    public static boolean checkPrime(int x){
        int div = x/2;
        while (div > 1){
            if (x % div == 0) {
                return false;
            }else{
                div--;
            }
        }
        return true;
    }

    public static int findDiv(int num1){
        int div = num1/2;
        while (div > 1) {
            if (num1 % div == 0) {
                return num1/div;
            }else{
                div--;
            }
        }
        return num1/div;
    }
}
