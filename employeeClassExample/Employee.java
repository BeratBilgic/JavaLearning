package employeeClassExample;

public class Employee {
    String name; 
    double salary;
    int workHours; 
    int hireYear;

    Employee(String name, double salary, int workHours, int hireYear){
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    public double tax()
    {
        double tax = 0.0;
        if(salary>1000)
        {
            tax = salary*0.03;
        }
        return tax;
    }
    public int bonus()
    {
        int extraHours = workHours - 40;
        if(extraHours > 0)
        {
            return 30 * extraHours;
    
        }
        return 0;
    }    
    public double raiseSalary()
    {
        int year = 2021-this.hireYear;
        if(year < 10)
        {
            return salary * 0.5;
        }else if(year > 9 && year < 20)
        {
            return salary * 0.10;
        }else if(year>19)
        {
            return salary * 0.15;
        }
        return year; 
    }
    public void print()
    {
        System.out.println();
        System.out.println("Tax : " + tax());
        System.out.println("Bonus : " + bonus());
        System.out.println("Raise of Salary : " + raiseSalary());
        System.out.println("Salary with tax and bonus : " + ( salary + bonus() - tax() ));
        System.out.println("Total salary with the raise of salary : " + ( salary + raiseSalary() ));
        System.out.println();
    }
}
