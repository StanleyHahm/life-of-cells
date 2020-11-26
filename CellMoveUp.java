import java.util.ArrayList;

public class CellMoveUp extends Cell{
  public CellMoveUp(int currRow, int currCol, int mass){
    this.currRow = currRow;
    this.currCol = currCol;
    this.mass = mass;
  }

  public CellMoveUp(CellMoveUp otherCellMoveUp){
    currRow = otherCellMoveUp.currRow;
    currCol = otherCellMoveUp.currCol;
    mass = otherCellMoveUp.mass;
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
