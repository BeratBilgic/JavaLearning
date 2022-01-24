package Inheritance;

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("Ahmet","ahmet@gmail.com","05389284523");
        //Academician a1 = new Academician("Ali", "ali@gmail.com", "03122345467", "Computer Science", "task1", "CS101");
        //Officers o1 = new Officers("Kemal", "kemal@gmail.com", "09872345434", "InformationTechnologies", "full-time");
        Lecturer l1 = new Lecturer("John", "john@gmail.com", "09322347632", "Computer Science", "tasks2", "CS201", "Prof.");
        Assistant ast1 = new Assistant("Ayşe", "ayşe@gmail.com", "05344012545", "Computer Science", "tasks3", "CS101", "master");
        /*System.out.println(e1.login());
        System.out.println(a1.login());
        System.out.println(o1.login());
        System.out.println(l1.login());
        System.out.println(ast1.login());*/
        Employee e2 = new Lecturer("Tom","tom@gmail.com","03452342343","Computer Science" ,"task4","CS301","Doc."); //Polymorphism
        System.out.println(e2.login());

        Employee[] loginList= {e1,l1,ast1}; 
        Employee.toList(loginList);
    }
} 