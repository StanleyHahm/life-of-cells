import java.util.*;

public class CellMoveUp extends Cell{
  public CellMoveUp(int currRow, int currCol, int mass){
    super(currRow, currCol, mass);
  }

  public CellMoveUp(CellMoveUp otherCellMoveUp){
    super(otherCellMoveUp);
  }

  public String toString(){
    return "^";
  }

  public boolean checkApoptosis(List<Cell> neighbors){
    if(neighbors.size() != 4){
      return true;
    }
    else{
      return false;
    }
  }
}
