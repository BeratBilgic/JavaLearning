package Interface;

public class Human extends Animal {

    public Human(int height,int weight){
        this.setHeight(height);
        this.setWeight(weight);
    }

    @Override
    public boolean isItAlive() {
        return true;
    }

    @Override
    public double heightMetre() {
        return this.getHeight()/100.0;
    }
    
}
