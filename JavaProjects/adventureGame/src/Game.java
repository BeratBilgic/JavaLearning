import java.util.Scanner;

public class Game {
    Player player;
    Location location;
    Scanner scan = new Scanner(System.in);

    public void run(){
        System.out.println("\nWelcome to adventure game");
        System.out.print("Please enter your name : ");
        String playerName = scan.nextLine();
        Player player = new Player(playerName);
        player.selectCha();
        start(player);
    }

    public void start(Player player){
        while (true) {
            System.out.println("\n****************************************");
            System.out.println("\nPlease select location you want to go");
            System.out.println("1 - Safe House --> Your house, no enemies.");
            System.out.println("2 - Cave       --> There will be zombies.");
            System.out.println("3 - Forest     --> There will be vampires");
            System.out.println("4 - River      --> There will be bears");
            System.out.println("5 - Shop       --> You can buy stuff");
            System.out.println("0 - Need Help");
            System.out.println("-1 - QUIT");
            System.out.print("Your choice = ");
            int selLoc = scan.nextInt();
            while (selLoc < -1 || selLoc > 5) {
                System.out.print("Please enter a valid value = ");
                selLoc = scan.nextInt();
            }
            switch (selLoc) {
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new Cave(player);
                    break;
                case 3:
                    location = new Forest(player);
                    break;
                case 4:
                    location = new River(player);
                    break;
                case 5:
                    location = new Shop(player);
                    break;
                case 0:
                    location = new Help(player);
                    break;
                case -1:
                    return;
                default:
                    location = new SafeHouse(player);
                    break;
            }
            if (location.getLocation() == false) {
                break;
            }
        }
    }
}
