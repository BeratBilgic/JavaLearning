package Inheritance;

public class Employee {
    private String fullName,email,phone;
    static int loginCounter = 0;

    public Employee(String fullName, String email, String phone){
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
    }

	protected String login(){
        return this.fullName + " Signed in";
    }

    public static int loginCount(){
        return ++Employee.loginCounter;
    }

	public static void toList(Employee[] arr){ //Polymorphism
		for (Employee i : arr) {
			System.out.println(i.login());
		}
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
