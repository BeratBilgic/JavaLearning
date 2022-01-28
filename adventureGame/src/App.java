import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            Game game = new Game();
            game.run();
            System.out.println("\nDo you want to play again <Y>es/<N>o");
            String dec = scan.nextLine();
            dec = dec.toUpperCase();
            if (dec.equals("Y")) {
                game.run();
            }else{
                break;
            }
        }
        scan.close();
    }
}