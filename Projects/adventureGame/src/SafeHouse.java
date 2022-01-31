import java.util.Scanner;

public class SafeHouse extends SafeLoc {
    Scanner scan = new Scanner(System.in);

    SafeHouse(Player player) {
        super(player, "Safe House");
    }
    @Override
    public boolean getLocation(){
        player.setHealth(player.getrHealth());
        System.out.println("\nYou are healed");
        System.out.println("You are in the SAFE HOUSE");
        if (player.getInventory().isFirewood() == true && player.getInventory().isWater() == true && player.getInventory().isFood() == true) {
            System.out.println("\n********************************************");
            System.out.println("****************  You won  *****************");
            System.out.println("*** You collected all the items you need ***");
            System.out.println("********************************************\n");
        }
        System.out.println("<E>xit or <P>layer stats");
        String selCase = scan.nextLine();
        selCase = selCase.toUpperCase();
        if (selCase.equals("P")) {
            player.playerStats();
        }
        return true;
    }
}
