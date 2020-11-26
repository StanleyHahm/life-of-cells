public class PetriDish{

  public Cell[][] dish;

  public PetriDish(String[][] board){
    String cellType;
    int mass;
    String str;
    String[] split_str;
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[i].length; j++){
        if(board[i][j] != "null"){
          str = board[i][j];
          split_str = str.split(" ", 0);
          cellType = split_str[0];
          System.out.println(cellType);
          mass = Integer.parseInt(split_str[1]);
          if(cellType == "CellStationary"){
            CellStationary station = new CellStationary(i, j, mass);
          }
          if(cellType == "CellMoveUp"){
            CellMoveUp moveUp = new CellMoveUp(i, j, mass);
          }
          if(cellType == "CellDivide"){
            CellDivide divide = new CellDivide(i, j, mass);
          }
          if(cellType == "CellMoveToggle"){
            CellMoveToggle moveToggle = new CellMoveToggle(i, j, mass);
          }
          if(cellType == "CellMoveDiagonal"){
            CellMoveDiagonal moveDia = new CellMoveDiagonal(i, j, mass);
          }
          if(cellType == "CellMoveToggleChild"){
            CellMoveToggleChild child = new CellMoveToggleChild(i, j, mass);
          }
          dish[i][j] = Cell(i, j, mass);
        }
        else{
          dish[i][j] = null;
        }
      }
    }
    CellMoveUp something = new CellMoveUp(i, j, mass);
  }
  /**
  public String toString(){
    StringBuilder sb = new StringBuilder();
    //typically 2*board.length+3 would display the board nicely
    sb.append(HORIZONTAL_BARS);
    for(int i = 0; i < board.length; i++){
      sb.append(VERTICAL_BAR);
      for(int j = 0; j < board[0].length; j++){
        sb.append(board[i][j] == null ? EMPTY_STRING : board[i][j].toString());
        sb.append(VERTICAL_BAR);
      }
      sb.append(NEW_LINE);
      sb.append(HORIZONTAL_BARS);
    }
    return sb.toString();
  }
  */

  public void main (String[] args){
    String[][] petri = new String[][]{
    {"CellMoveUp 0", "CellMoveToggle 1", "CellMoveToggleChild 2", "null"},
    {"CellMoveDiagonal 3", "CellDivide 4", "CellMoveToggle 5", "null"} };
    PetriDish(petri);
  }

}
