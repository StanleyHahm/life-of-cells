import java.util.*;

public class CellMoveToggleChild extends CellMoveToggle{
  public static int numAlive;

  public CellMoveToggleChild(int currRow, int currCol, int mass){
    super(currRow, currCol, mass);
    numAlive += 1;
  }

  public CellMoveToggleChild(CellMoveToggleChild
    otherCellMoveToggleChild){
    super(otherCellMoveToggleChild);
    numAlive += 1;
  }

  public void apoptosis(){
    super.apoptosis();
    numAlive -= 1;
  }

  public boolean checkApoptosis(List<Cell> neighbors){
    if((super.checkApoptosis(neighbors) == true)
      && (neighbors.size() < 10)){
      return true;
    }
    else{
      return false;
    }
  }

  //main
}
