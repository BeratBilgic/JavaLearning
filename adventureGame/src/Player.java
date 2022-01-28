import java.util.Scanner;

public class Player {
    private int damage,health,money,rHealth;
    private String name,cName;
    private Inventory inventory;
    Scanner scan = new Scanner(System.in);

    public Player(String name){
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectCha(){
        switch (chaMenu()) {
            case 1:
                createChar("Samurai", 5, 21, 15);
                break;
            case 2:
                createChar("Archer", 7, 18, 20);
                break;
            case 3:
                createChar("Knight", 8, 24, 5);
                break;
            default :
                createChar("Samurai", 5, 21, 15);
                break;
        }
        System.out.println("\nName = " + name  + "\nCharacter Name = " + cName);
        System.out.println("Damage = "+ getTotalDamage() + "\nHealth = " + health + "\nMoney = " + money );
    }
    public int chaMenu(){
        System.out.println("\nID   Character Name\tDamage\tHealth\tMoney");
        System.out.println("1      Samurai\t\t5\t21\t15");
        System.out.println("2      Archer\t\t7\t18\t20");
        System.out.println("3      Knight\t\t8\t24\t5");
        System.out.print("Choose a character = ");
        int charId = scan.nextInt(); 
        while (charId > 3 || charId < 1){
            System.out.print("Please enter a valid value = ");
            charId = scan.nextInt();
        }

        return charId;   
    }
    public void playerStats(){
        System.out.println("\nPlayer Stats");
        System.out.println("*************");
        System.out.println("Damage = " + getTotalDamage() + "\nHealth = " + health + "\nMoney = " + money );
        if (getInventory().getDamage() > 0) {
            System.out.println("Weapon = " + getInventory().getwName() + " +" + getInventory().getDamage() + " extra damage");
        }
        if (getInventory().getBlock() > 0) {
            System.out.println("Armor = " + getInventory().getaName() + " -> " + getInventory().getBlock() + " damage blocks");
        }
    }
    public void createChar(String cName, int damage, int health, int money){
        setcName(cName);
        setDamage(damage);
        setHealth(health);
        setMoney(money);
        setrHealth(health);
    }

    public int getTotalDamage(){
        return getDamage() + getInventory().getDamage();
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public String getcName() {
        return cName;
    }
    public void setcName(String cName) {
        this.cName = cName;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Inventory getInventory() {
        return inventory;
    }
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    public int getrHealth() {
        return rHealth;
    }
    public void setrHealth(int rHealth) {
        this.rHealth = rHealth;
    }
}
