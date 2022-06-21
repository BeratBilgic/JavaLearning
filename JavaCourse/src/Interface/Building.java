package Interface;

public class Building implements Height {

    @Override
    public double heightMetre() {
        return 20;
    }

    @Override
    public int heightCentimeter() {
        return 2000;
    }

    @Override
    public double heightKilometer() {
        return 0.02;
    }
    
}
