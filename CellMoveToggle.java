import java.util.ArrayList;

public class CellMoveToggle extends CellMoveUp{
  public boolean toggled;

  public CellMoveToggle(int currRow, int currCol, int mass){
    super(currRow, currCol, mass);
    toggled = true;
  }

  public CellMoveToggle(CellMoveToggle otherCellMoveToggle){
    currRow = otherCellMoveToggle.currRow;
    currCol = otherCellMoveToggle.currCol;
    mass = otherCellMoveToggle.mass;
  }

  public String toString(){
    if(toggled == true){
      return "T";
    }
    else{
      return "t";
    }
  }

  public boolean checkApoptosis(List<Cell> neighbors){
    if((neighbors.size() < 2) && (neighbors.size() > 5)){
      return true;
    }
    else{
      return false;
    }
  }
}
