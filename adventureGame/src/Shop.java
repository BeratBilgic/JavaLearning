import java.util.Scanner;

public class Shop extends SafeLoc {
    Scanner scan = new Scanner(System.in);

    Shop(Player player) {
        super(player, "Item Shop");
    }
    @Override
    public boolean getLocation() {
        System.out.println("\nYour money = " + player.getMoney());
        System.out.println("What do you want to purchase");
        System.out.println("1 - Weapon");
        System.out.println("2 - Armor");
        System.out.println("0 - Cancel");
        System.out.print("Your choice = ");
        int selMenu = scan.nextInt();
        while (selMenu < 0 || selMenu > 2) {
            System.out.print("Please enter a valid value = ");
            selMenu = scan.nextInt();
        }
        switch (selMenu) {
            case 1:
                int selWep = weaponMenu();
                buyWeapon(selWep);
                break;
            case 2:
                int selArm = armorMenu();
                buyArmor(selArm);
                break;
            default:
                break;
        }
        return true;
    }

    public int weaponMenu(){
        System.out.println("\nId - Weapon Name\tPrice\tDamage");
        System.out.println("1 - Knife\t\t25\t+2");
        System.out.println("2 - Sword\t\t35\t+4");
        System.out.println("3 - Katana\t\t45\t+7");
        System.out.println("0 - Cancel");
        System.out.print("Your choice = ");
        int selWep = scan.nextInt();
        while (selWep < 0 || selWep > 3) {
            System.out.print("Please enter a valid value = ");
            selWep = scan.nextInt();
        }
        return selWep;
    }
    public void buyWeapon(int selWep){
        int damage = 0;int price = 0 ;
        String wName = null;
        switch (selWep) {
            case 1:
                wName = "Knife";
                price = 25;
                damage = 2;
                break;
            case 2:
                wName = "Sword";
                price = 35;
                damage = 4;
                break;
            case 3:
                wName = "Katana";
                price = 45;
                damage = 7;
                break;
            default:
                break;
        }
        if (player.getMoney() >= price) {
            player.getInventory().setDamage(damage);
            player.getInventory().setwName(wName);
            player.setMoney(player.getMoney() - price);
            System.out.println("\nYou bought " + wName);
            System.out.println("Your money = " + player.getMoney());
            System.out.println("Previous damage = "+ player.getDamage());
            System.out.println("Current damage = "+ player.getTotalDamage());
        }else{
            System.out.println("\nInsufficient balance");
        }
    }

    public int armorMenu(){
        System.out.println("\nId - Armor Name \tPrice\tBlock");
        System.out.println("1 - Light armor \t15\t+1");
        System.out.println("2 - Medium armor\t25\t+3");
        System.out.println("3 - Heavy armor \t40\t+5");
        System.out.println("0 - Cancel");
        System.out.print("Your choice = ");
        int selArm = scan.nextInt();
        while (selArm < 0 || selArm > 3) {
            System.out.print("Please enter a valid value = ");
            selArm = scan.nextInt();
        }
        return selArm;
    }

    public void buyArmor(int selArm){
        int block = 0;int price = 0 ;
        String aName = null;
        switch (selArm) {
            case 1:
                aName = "Light armor";
                block = 1;
                price = 15;
                break;
            case 2:
                aName = "Medium armor";
                block = 3;
                price = 25;
                break;
            case 3:
                aName = "Heavy armor";
                block = 5;
                price = 40;
                break;
            default:
                break;
        }
        if (player.getMoney() > price) {
            player.getInventory().setaName(aName);
            player.getInventory().setBlock(block);
            player.setMoney(player.getMoney() - price);
            System.out.println("\nYou bought " + aName);
            System.out.println("Your money = " + player.getMoney());
            System.out.println("Blocked damage = " + block);
        }else{
            System.out.println("\nInsufficient balance");
        }
    }
}
