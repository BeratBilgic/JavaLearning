package Inheritance;

public class Security extends Officers{
    private String document;

    public Security(String fullName, String email, String phone, String section, String shift, String document) {
        super(fullName, email, phone, section, shift);
        this.document = document;
    }
    
    public String getDocument() {
        return this.document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}