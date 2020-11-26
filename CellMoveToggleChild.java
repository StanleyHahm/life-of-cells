import java.util.ArrayList;

public class CellMoveToggleChild extends CellMoveToggle{
  public static int numAlive;

  public CellMoveToggleChild(int currRow, int currCol, int mass){
    this.currRow = currRow;
    this.currCol = currCol;
    this.mass = mass;
    //WHAT DO YOU WANT ME TO DO WITH NUMALIVE
    numAlive += 1;
  }

  public CellMoveToggleChild(CellMoveToggleChild
    otherCellMoveToggleChild){
    currRow = otherCellMoveToggleChild.currRow;
    currCol = otherCellMoveToggleChild.currCol;
    mass = otherCellMoveToggleChild.mass;
  }

  public boolean checkApoptosis(List<Cell> neighbors){
    //WHAT DO YOU WANT ME TO DO W/ NUMALIVE
    numAlive -= 1;
    if((CellMoveToggle.checkApoptosis == true)
      && (neighbors.size() < 10)){
      return true;
    }
    else{
      return false;
    }
  }
}
