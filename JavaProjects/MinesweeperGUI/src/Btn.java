import javax.swing.JButton;

public class Btn extends JButton {
    private int row,column,count;
    private Boolean mine,flag;

    public Btn(int row,int column){
        this.row = row;
        this.column = column;
        this.count = 0;
        this.mine = false;
        this.flag = false;
    }

    public int getColumn() {
        return column;
    }
    public void setColumn(int column) {
        this.column = column;
    }
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public Boolean isMine() {
        return mine;
    }
    public void setMine(Boolean mine) {
        this.mine = mine;
    }
    public Boolean isFlag() {
        return flag;
    }
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}
