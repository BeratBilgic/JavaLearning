package Interface;

public abstract class Animal implements Height{
    private int height;
    private int weight;
    public abstract boolean isItAlive();

    @Override
    public int heightCentimeter() {
        return this.getHeight();
    }
    
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
}
