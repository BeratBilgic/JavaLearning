import java.util.Random;
import java.util.Scanner;

public class Minesweeper {
    public int row,column,size;
    public int[][] map;
    public int[][] board;

    Random rand = new Random();
    Scanner scan = new Scanner(System.in);

    Minesweeper(int row, int column){
        this.row = row;
        this.column = column;
        this.map = new int[row][column];
        this.board = new int[row][column];
        this.size = row * column;
    }

    public void run(){
        int rowNum,colNum,moveCount = 0,winControl;
        prepareGame();
        winControl = size - (size/4);
        System.out.println("Game has started");
        while (moveCount != winControl) {
            print(board);
            System.out.print("Row : ");
            rowNum = scan.nextInt() - 1;
            System.out.print("Column : ");
            colNum = scan.nextInt() - 1;
            if (rowNum < row && colNum < column) {
                if (map[rowNum][colNum] == -1){
                    board[rowNum][colNum] = -1;
                    print(board);
                    System.out.println("***************");
                    System.out.println("** GAME OVER **");
                    System.out.println("***************");
                    return;
                }
                else if (board[rowNum][colNum] == 0){
                    check(rowNum, colNum);
                    moveCount++;
                }
            }
        }
        print(board);
        System.out.println("*************");
        System.out.println("** YOU WON **");
        System.out.println("*************");
    }

    public void prepareGame(){
        int count = 0,randRow,randColumn;
        while( count < (size / 4) ){
            randRow = rand.nextInt(row);
            randColumn = rand.nextInt(column);
            if (map[randRow][randColumn] != -1){
                map[randRow][randColumn] = -1;
                count++;
            }
        }
    }

    public void print(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] >= 0){
                    System.out.print(" ");
                }
                System.out.print(arr[i][j] + " " );
            }
            System.out.println();
        }
    }

    public void check(int r, int c)
    {
        for (int i = r-1; i <= r+1; i++) {
            for (int j = c-1 ; j <= c+1 ; j++) {
                if (i >= 0 && j >= 0 && i<row && j<column && map[i][j] == -1) {
                    board[r][c]++;    
                }
            }
        }
        if(board[r][c] == 0)
        {
            board[r][c] = -2 ; 
        }
    }
}
