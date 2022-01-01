package Inheritance;

public abstract class Officers extends Employee {
    private String section,shift;

    public Officers(String fullName, String email, String phone, String section, String shift) {
        super(fullName, email, phone);
        this.section = section;
        this.shift = shift;
    }


    public String getSection() {
        return this.section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getShift() {
        return this.shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
}
