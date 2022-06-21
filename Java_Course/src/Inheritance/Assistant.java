package Inheritance;

public class Assistant extends Academician {
    private String master;

    public Assistant(String fullName, String email, String phone, String department, String tasks, String lesson, String master) {
        super(fullName, email, phone, department, tasks, lesson);
        this.master = master;
    }
    
    @Override
    public String login(){ //Metot Overriding
        return "Assistant." + super.login();
    }

    public String getMaster() {
        return this.master;
    }

    public void setMaster(String master) {
        this.master = master;
    }
}
