package javaMethod;

public class RecursiveMethod {
    public static void main(String[] args) {
        System.out.println(rec(10));
        System.out.println(add(10));
    }
    static int rec (int x){
        if(x==1)
        {
            return 1;
        } 
        return x + rec(x-1);
    }
    static int add (int x){
        int sum = 0;
        for(int i = 0 ; i <= x ;i++){
            sum+=i;
        }
        return sum;
    }
}
