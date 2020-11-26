import java.util.*;

public class CellDivide extends Cell{
  public int direction;

  public CellDivide(int currRow, int currCol, int mass){
    super(currRow, currCol, mass);
    this.direction = 1;
  }

  public CellDivide(CellDivide otherCellDivide){
    super(otherCellDivide);
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
