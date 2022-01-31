import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        int rowNum1,colNum1;
        System.out.println("Welcome to the minesweeper");

        while (true) {
            System.out.println("Enter the row and column values you want to play.");
            System.out.print("Row : ");
            rowNum1 = scan.nextInt();
            System.out.print("Column : ");
            colNum1 = scan.nextInt();
    
            Minesweeper mine = new Minesweeper(rowNum1,colNum1);
            mine.run();   
            
            System.out.println("\nDo you want to play again ? <Y>es/<N>o"); 
            String answer = scan.nextLine();
            answer = answer.toUpperCase();
            if (!answer.equals("Y")) {
                break;
            }
        }
        scan.close();
    }
}
