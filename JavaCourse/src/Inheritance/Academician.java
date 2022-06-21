package Inheritance;

public abstract class Academician extends Employee {
    
    private String tasks,department;
    private String lesson;

    public Academician(String fullName, String email, String phone, String department, String tasks, String lesson) {
        super(fullName, email, phone);
        this.department = department;
        this.tasks = tasks;
        this.lesson = lesson;
    }

    public void attendClass(){
        System.out.println("attended the class");
    }

    @Override
    protected String login(){  //Metot Overriding
        return super.login() + "through gate a";
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTasks() {
        return this.tasks;
    }

    public void setTasks(String tasks) {
        this.tasks = tasks;
    }

    public String getLesson() {
        return this.lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }
}