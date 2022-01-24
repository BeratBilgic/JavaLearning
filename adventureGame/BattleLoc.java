package adventureGame;

import java.util.Scanner;

public abstract class BattleLoc extends Location {
    protected Obstacle obstacle;
    protected String award;
    Scanner scan = new Scanner(System.in);

    BattleLoc(Player player, String name, Obstacle obstacle, String award) {
        super(player);
        this.name = name;
        this.obstacle = obstacle;
        this.award = award;
    }

    public boolean getLocation(){
        int obstCount = obstacle.obstCount();
        System.out.println("\nYou are in the " + name);
        System.out.println("There are " + obstCount + " " + obstacle.getoName() +" here\n");
        System.out.println("<C>ombat or <F>lee");
        String decision = scan.nextLine();
        decision = decision.toUpperCase();
        if (decision.equals("C")) {
            if (combat(obstCount)) {
                return true;
            }else{
                System.out.println("****************");
                System.out.println("*** You died ***");
                System.out.println("****************");
                return false;
            }
        }
        return true;
    }

    public boolean combat(int obstCount){
        int rObstHealth = obstacle.getHealth();
        for (int i = 0; i < obstCount; i++) {
            obstacle.setHealth(rObstHealth);
            player.playerStats();
            enemyStats();
            while (obstacle.getHealth() > 0) {
                System.out.println("\n<H>it or <F>lee");
                String decision = scan.nextLine();
                decision = decision.toUpperCase();
                if (decision.equals("H")) {
                    System.out.println("******************************");
                    System.out.println("You hit the " + obstacle.getoName());
                    obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
                    afterHit();
                    if (obstacle.getHealth() > 0) {
                        System.out.println(obstacle.getoName() + " hits you");
                        player.setHealth(player.getHealth() - (obstacle.getDamage() - player.getInventory().getBlock()));
                        afterHit();
                    }   
                }else{
                    return true;
                }
                if (player.getHealth() > 0 && obstacle.getHealth() <= 0) {
                    player.setMoney(player.getMoney() + obstacle.getPrize());
                    System.out.println("------------------------");
                    System.out.println("You killed the " + obstacle.getoName());
                    System.out.println("Your current money = " + player.getMoney());
                    System.out.println("------------------------\n");
                }
                else if(player.getHealth() <= 0) {
                    return false;
                }
            }
        }
        System.out.println("---------------------------------");
        System.out.println("You killed " + obstCount + " " + obstacle.getoName() + " in the " + name);
        if (this.award.equals("Food") && player.getInventory().isFood() == false) {
            player.getInventory().setFood(true);
            System.out.println("You earned " + this.award);
        }else if(this.award.equals("Firewood") && player.getInventory().isFirewood() == false){
            player.getInventory().setFirewood(true);
            System.out.println("You earned " + this.award);
        }else if(this.award.equals("Water") && player.getInventory().isWater() == false){
            player.getInventory().setWater(true);
            System.out.println("You earned " + this.award);
        }
        System.out.println("---------------------------------");

        return true;
    }

    public void enemyStats(){
        System.out.println("\nEnemy Stats");
        System.out.println("*************");
        System.out.println("Name = "+ obstacle.getoName() +"\nDamage = " + obstacle.getDamage() + "\nHealth = " + obstacle.getHealth());
    }

    public void afterHit(){
        System.out.println("Player Health = " + player.getHealth());
        System.out.println(obstacle.getoName() + " Health = " + obstacle.getHealth()+ "\n");
    }
}
