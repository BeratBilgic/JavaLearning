package Interface;

interface Height {
    int variable = 0;
    double heightMetre();
    int heightCentimeter();
    default double heightKilometer(){
        return 0;
    }

    static String definition() {
		return "This interface is about height.";
	}
    
}
