public class MainClass {
    public static void main(String[] args){
        Class class1 = new Class(5,6);
        //class1.num1 = 5;
        //class1.num2 = 8;
        System.out.println(class1.num1);
        Class class2 = new Class(1,32); 
        class2.num1 = 31;
        System.out.println(class2.num1);
        class1.hello();
    }
}
