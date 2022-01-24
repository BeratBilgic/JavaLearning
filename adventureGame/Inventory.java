package adventureGame;

public class Inventory {
    private boolean water,food,firewood;
    private String wName,aName;
    private int damage,block;
    
    Inventory(){
        this.water = false;
        this.food = false;
        this.firewood = false;
        this.wName = null;
        this.aName = null;
        this.damage = 0;
        this.block = 0;
    }

    public int getBlock() {
        return block;
    }
    public void setBlock(int block) {
        this.block = block;
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public String getaName() {
        return aName;
    }
    public void setaName(String aName) {
        this.aName = aName;
    }
    public String getwName() {
        return wName;
    }
    public void setwName(String wName) {
        this.wName = wName;
    }
    public boolean isFirewood() {
        return firewood;
    }
    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }
    public boolean isFood() {
        return food;
    }
    public void setFood(boolean food) {
        this.food = food;
    }
    public boolean isWater() {
        return water;
    }
    public void setWater(boolean water) {
        this.water = water;
    }
}