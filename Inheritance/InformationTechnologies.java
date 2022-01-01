package Inheritance;

public class InformationTechnologies extends Officers {
    private String tasks;

    public InformationTechnologies(String fullName, String email, String phone, String section, String shift, String tasks) {
        super(fullName, email, phone, section, shift);
        this.tasks = tasks;
    }

    public String getTasks() {
        return this.tasks;
    }

    public void setTasks(String tasks) {
        this.tasks = tasks;
    }
}