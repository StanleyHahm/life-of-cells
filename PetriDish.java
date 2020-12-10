/**
*  NAME: Stanley Hahm
*  ID: A14609365
*  EMAIL: sthahm@ucsd.edu
*
*  For this code, we are trying to get the board and put it into
*  a new 2D array.
*/
import java.util.*;

/**
*  This class sets the sets the board to the 2D array of Cell.java.
*  It also intereacts w/ the other Cell subclasses if the element
*  in the board meets that.
*/
public class PetriDish{

  public Cell[][] dish;
  public List<Movable> movables;
  public List<Divisible> divisibles;

  /**
  *  This is the constructor method that prints the board into
  *  the instance variable dish.
  *
  *  @param board the 2D string array that has the Cell Types and
  *  masses of each cell
  */
  public PetriDish(String[][] board){
    String cellType;
    int mass;
    String str;
    String[] split_str;
    dish = new Cell[board.length][board[0].length];
    for(int row = 0; row < board.length; row++){
      for(int col = 0; col < board[0].length; col++){
        //checks if the element is null or not
        if(board[row][col] != "null"){
          str = board[row][col];

          //splits the board element into cellType & mass
          split_str = str.split(" ", 0);
          cellType = split_str[0];
          mass = Integer.parseInt(split_str[1]);

          //checks cellTypes and sets new variables to that
          //cell type
          if(cellType.equals("CellStationary")){
            dish[row][col] = new CellStationary(row, col, mass);
          }
          if(cellType.equals("CellMoveUp")){
            System.out.println("It works!");
            dish[row][col] = new CellMoveUp(row, col, mass);
          }
          if(cellType.equals("CellDivide")){
            dish[row][col] = new CellDivide(row, col, mass);
          }
          if(cellType.equals("CellMoveToggle")){
            dish[row][col] = new CellMoveToggle(row, col, mass);
          }
          if(cellType.equals("CellMoveDiagonal")){
            dish[row][col] = new CellMoveDiagonal(row, col, mass);
          }
          if(cellType.equals("CellMoveToggleChild")){
            dish[row][col] = new CellMoveToggleChild(row, col, mass);
          }
        }
        else{
          dish[row][col] = null;
        }
      }
    }
  }

  public List<Cell> getNeighborsOf(int row, int col){
    List<Cell> neighbors = new ArrayList<Cell>();

    int numRow = dish.length;
    int numCol = dish[0].length;

    if((row >= numRow) || (col >= numCol)){
      return null;
    }

    //northwest
    if(dish[(row-1) % numRow][(col-1) % numCol] != null){
      neighbors.add(dish[(row-1) % numRow][(col-1) % numCol]);
    }

    //north
    if(dish[(row-1) % numRow][(col)] != null){
      neighbors.add(dish[(row-1) % numRow][col]);
    }

    //northeast
    if(dish[(row-1) % numRow][(col+1) % numCol] !=  null){
      neighbors.add(dish[(row-1) % numRow][(col+1) % numCol]);
    }

    //west
    if(dish[row][(col-1) % numCol] != null){
      neighbors.add(dish[row][(col-1) % numCol]);
    }

    //east
    if(dish[row][(col+1) % numCol] != null){
      neighbors.add(dish[row][(col+1) % numCol]);
    }

    //southwest
    if(dish[(row+1) % numRow][(col-1) % numCol] != null){
      neighbors.add(dish[(row+1) % numRow][(col-1) % numCol]);
    }

    //south
    if(dish[(row+1) % numRow][col] != null){
      neighbors.add(dish[(row-1) % numRow][col]);
    }

    //southeast
    if(dish[(row+1) % numRow][(col+1) % numCol] != null){
      neighbors.add(dish[(row+1) % numRow][(col+1) % numCol]);
    }

    return neighbors;
  }

  public void move(){
    int[] newPosition;
    for(int i = 0; i < movables.size(); i++){
      newPosition = movables.get(i).getMove();

      //if the row or column is negative, we wrap it around using
      //dish row length or col length respectively
      if(newPosition[0] < 0){
        newPosition[0] += dish.length;
      }
      if(newPosition[1] < 0){
        newPosition[1] += dish[0].length;
      }

      //if row or column is above the row or col length of dish, we
      //wrap around using the modulo
      if(newPosition[0] >= dish.length){
        newPosition[0] %= dish.length;
      }
      if(newPosition[1] >= dish[0].length){
        newPosition[1] %= dish[0].length;
      }

      //if there's nothing there, place the movable object there
      if(dish[newPosition[0]][newPosition[1]] == null){
        dish[newPosition[0]][newPosition[1]] = (Cell)movables.get(i);
      }

      //if there's a non-movable object there, kill it
      if((!(dish[newPosition[0]][newPosition[1]] instanceof Movable))
      && (dish[newPosition[0]][newPosition[1]] != null)){

        dish[newPosition[0]][newPosition[1]] = (Cell)movables.get(i);
      }
      //if movable object is there, then check which one has bigger mass
      //the smaller mass object dies
      if(dish[newPosition[0]][newPosition[1]] instanceof Movable){
        if((dish[newPosition[0]]
        [newPosition[1]].compareTo((Cell)movables.get(i))) < 0){
          dish[newPosition[0]][newPosition[1]].apoptosis();
          dish[newPosition[0]][newPosition[1]] = (Cell)movables.get(i);
        }
      //if both movables equal each other, kill both
        else if((dish[newPosition[0]]
        [newPosition[1]].compareTo((Cell)movables.get(i))) == 0){
          dish[newPosition[0]][newPosition[1]].apoptosis();
          movables.remove(i);
          dish[newPosition[0]][newPosition[1]] = null;
        }
        else{
          movables.remove(i);
        }
      }
    }


  }

  public void divide(){
    int[] spawnPosition;
    for(int i = 0; i < divisibles.size(); i++){
      spawnPosition = divisibles.get(i).getDivision();

      //if the row or column is negative, we wrap it around using
      //dish row length or col length respectively
      if(spawnPosition[0] < 0){
        spawnPosition[0] += dish.length;
      }
      if(spawnPosition[1] < 0){
        spawnPosition[1] += dish[0].length;
      }

      //if row or column is above the row or col length of dish, we
      //wrap around using the modulo
      if(spawnPosition[0] >= dish.length){
        spawnPosition[0] %= dish.length;
      }
      if(spawnPosition[1] >= dish[0].length){
        spawnPosition[1] %= dish[0].length;
      }

      if(dish[spawnPosition[0]][spawnPosition[1]] == null){
        dish[spawnPosition[0]][spawnPosition[1]] = (Cell)divisibles.get(i);
      }
      if(dish[spawnPosition[0]][spawnPosition[1]] instanceof Divisible){
        if((dish[spawnPosition[0]]
        [spawnPosition[1]].compareTo((Cell)divisibles.get(i)) < 0)){
          dish[spawnPosition[0]][spawnPosition[1]].apoptosis();
          dish[spawnPosition[0]][spawnPosition[1]] = (Cell)divisibles.get(i);
        }
        else if((dish[spawnPosition[0]]
        [spawnPosition[1]].compareTo((Cell)divisibles.get(i)) == 0)){
          dish[spawnPosition[0]][spawnPosition[1]].apoptosis();
          divisibles.remove(i);
          dish[spawnPosition[0]][spawnPosition[1]] = null;
        }
        else{
          divisibles.remove(i);
        }
      }
    }
  }

  public void update(){
    List<Cell> neighbors = new ArrayList<Cell>();
    for(int row = 0; row < dish.length; row++){
      for(int col = 0; col < dish[row].length; col++){
        neighbors = getNeighborsOf(row, col);
        if(dish[row][col].checkApoptosis(neighbors) == true){
          dish[row][col].apoptosis();
          dish[row][col] = null;
        }
        if((dish[row][col] == null)
          && (neighbors.size() >= 2) && (neighbors.size() <= 3)){
          dish[row][col] = neighbors.get(0);
        }
      }
    }
  }

  public void iterate(){
    move();
    divide();
    update();
  }
}
