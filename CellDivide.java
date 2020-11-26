import java.util.ArrayList;

public class CellDivide extends Cell{
  public int direction;

  public CellDivide(int currRow, int currCol, int mass){
    this.currRow = currRow;
    this.currCol = currCol;
    this.mass = mass;
    this.direction = 1;
  }

  public CellDivide(CellDivide otherCellDivide){
    currRow = otherCellDivide.currRow;
    currCol = otherCellDivide.currCol;
    mass = otherCellDivide.mass;
  }

  public String toString(){
    return "+";
  }

  public boolean checkApoptosis(List<Cell> neighbors){
    if(neighbors.size() == 3){
      return true;
    }
    else{
      return false;
    }
  }
}
