package adventureGame;

import java.util.Random;

public abstract class Obstacle {
    private String oName;
    private int damage,prize,health,maxNumber;
    Obstacle(String oName, int damage, int prize, int health, int maxNumber){
        this.oName = oName;
        this.damage = damage;
        this.prize = prize;
        this.health = health;
        this.maxNumber = maxNumber;
    }

    public int obstCount(){
        Random rand = new Random();
        return rand.nextInt(this.maxNumber) + 1;
    }

    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getPrize() {
        return prize;
    }
    public void setPrize(int prize) {
        this.prize = prize;
    }
    public String getoName() {
        return oName;
    }
    public void setoName(String oName) {
        this.oName = oName;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getMaxNumber() {
        return maxNumber;
    }
    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }
}
