import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Minesweeper implements MouseListener{
    JFrame frame ;
    Btn[][] board = new Btn[10][10];
    int openButton = 0;

    public Minesweeper () {
        frame = new JFrame("Minesweeper");
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(10,10));
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                Btn b = new Btn(row, col);
                b.addMouseListener(this);
                frame.add(b);
                board[row][col] = b;
            }
        }
        generateMine();
        updateCount();
        
        frame.setVisible(true);
    }

    public void generateMine(){
        int i = 0,randRow,randCol;
        while (i < 10) {
            randRow = (int) (Math.random() * board.length);
            randCol = (int) (Math.random() * board[0].length);
            if(!board[randRow][randCol].isMine()){
                board[randRow][randCol].setMine(true);
                i++;
            }
        }
    }

    private void updateCount() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col].isMine()) {
                    counting(row,col);
                }
            }
        }
    }

    private void counting(int row, int col) {
        for (int i = row-1; i <= row+1; i++) {
           for (int j = col-1; j <= col+1; j++) {
               try {
                   board[i][j].setCount(board[i][j].getCount() + 1);
               } catch (Exception e) {
               }
           } 
        }
    }
    public void print() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col].isMine()) {
                    board[row][col].setIcon(new ImageIcon("mine.png"));
                    board[row][col].setEnabled(false);
                }else{
                    board[row][col].setText(board[row][col].getCount()+"");
                    board[row][col].setEnabled(false);
                }
            }
        }        
    }
   
    public void open(int row, int col){
        if (row < 0 || row > board.length || col < 0 || col > board.length || board[row][col].getText().length() > 0 
        || board[row][col].isEnabled() == false) {
            return;
        }else if (board[row][col].getCount() != 0) {
            board[row][col].setText(board[row][col].getCount() + "");
            board[row][col].setEnabled(false);
            openButton++;
        }else{
            board[row][col].setEnabled(false);
            openButton++;
            board[row][col].setOpaque(true);
            board[row][col].setBackground(Color.GRAY);
            open(row-1, col);
            open(row, col-1);
            open(row+1, col);
            open(row, col+1);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Btn b = (Btn) e.getComponent();
        if(e.getButton() == 1){
            if (b.isMine()) {
                JOptionPane.showMessageDialog(frame,"GAME OVER");
                print();
            }else{
                open(b.getRow(), b.getColumn());
                if (openButton == (board.length * board[0].length) - 10) {
                    JOptionPane.showMessageDialog(frame,"YOU WON");
                }
            }
        }else if(e.getButton() == 3){
            if (!b.isFlag()) {
                b.setFlag(true);
                b.setIcon(new ImageIcon("flag.png")); 
            }else{
                b.setFlag(false);
                b.setIcon(null);
            }
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }
    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
