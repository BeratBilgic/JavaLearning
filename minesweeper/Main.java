package minesweeper;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rowNum1,colNum1;
        char answer;
        boolean game = true;
        System.out.println("Welcome to the minesweeper");

        while (game) {
            System.out.println("Enter the row and column values you want to play.");
            System.out.print("Row : ");
            rowNum1 = input.nextInt();
            System.out.print("Column : ");
            colNum1 = input.nextInt();
    
            Minesweeper mine = new Minesweeper(rowNum1,colNum1);
            mine.run();   
            
            System.out.println("Do you want to play again ? (y/n)"); 
            answer = input.next().charAt(0);
            if (answer == 'n' ) {
                game = false;
            }
        }
        input.close();
    }
}
