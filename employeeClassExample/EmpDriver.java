package employeeClassExample;

import java.util.Scanner;

public class EmpDriver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Name : "); 
        String name = scan.next();
        System.out.print("Salary : ");
        double salary = scan.nextDouble();
        System.out.print("Work Hours : ");
        int workHours = scan.nextInt();
        System.out.print("Hire Date : ");
        int hireYear = scan.nextInt();
        
        Employee emp1 = new Employee(name , salary , workHours , hireYear);
        emp1.print();

        Employee emp2 = new Employee("ali", 4000 , 50 , 1986);
        emp2.print();
        
        scan.close();
    }
}
