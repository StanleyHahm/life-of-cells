import java.util.*;

public class PetriDish{

  public Cell[][] dish;

  public PetriDish(String[][] board){
    String cellType;
    int mass;
    String str;
    String[] split_str;
    for(int row = 0; row < board.length; row++){
      for(int col = 0; col < board[row].length; col++){
        if(board[row][col] != "null"){
          str = board[row][col];
          split_str = str.split(" ", 0);
          cellType = split_str[0];
          System.out.println(cellType);
          mass = Integer.parseInt(split_str[1]);
          if(cellType == "CellStationary"){
            CellStationary station = new CellStationary(row, col, mass);
          }
          if(cellType == "CellMoveUp"){
            CellMoveUp moveUp = new CellMoveUp(row, col, mass);
          }
          if(cellType == "CellDivide"){
            CellDivide divide = new CellDivide(row, col, mass);
          }
          if(cellType == "CellMoveToggle"){
            CellMoveToggle moveToggle = new CellMoveToggle(row, col, mass);
          }
          if(cellType == "CellMoveDiagonal"){
            CellMoveDiagonal moveDia = new CellMoveDiagonal(row, col, mass);
          }
          if(cellType == "CellMoveToggleChild"){
            CellMoveToggleChild child = new
              CellMoveToggleChild(row, col, mass);
          }
          //dish[row][col] = Cell(row, col, mass);
        }
        else{
          dish[row][col] = null;
        }
      }
    }
  }
}
