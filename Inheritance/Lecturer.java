package Inheritance;

public class Lecturer extends Academician {
    private String title;

    public Lecturer(String fullName, String email, String phone, String department, String tasks, String lesson, String title) {
        super(fullName, email, phone, department, tasks, lesson);
        this.title = title;
    }

    public String login(){  //Metot Overriding
        return this.title + super.login();
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
