import java.util.ArrayList;

public class CellStationary extends Cell{
  public CellStationary(int currRow, int currCol, int mass){
    super(currRow, currCol, mass);
  }

  public CellStationary(CellStationary otherCellStationary){
    currRow = otherCellStationary.currRow;
    currCol = otherCellStationary.currCol;
    mass = otherCellStationary.mass;
  }

  public String toString(){
    return ".";
  }

  public boolean checkApoptosis(List<Cell> neighbors){
    if((neighbors.size() <= 7) && (neighbors.size() >= 3)){
      return true;
    }
    else{
      return false;
    }
  }
}
