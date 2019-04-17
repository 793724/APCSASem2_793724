import java.util.ArrayList;
/**
 * Homework 415 - Problem 5
 *
 * @ Emma Chiu
 * @ 4/15/19
 */

public class Cell {
    // instance variables
    boolean occupied;
    int id;
    int rows;
    int cols;
    ArrayList<Cell> neighbors = new ArrayList<Cell>();
    
    public Cell(){
        // initialize variables
        occupied = false;
        id = 0;
    }
    
    public boolean getOccupied(){
        return occupied;
    }
    
    public void setOccupied(){
        occupied = true;
    }
    
    public void setRows(int r){
        rows = r;
    }
    
    public void setCols(int c){
        cols = c;
    }
    
    public int getRows(){
        return rows;
    }
    
    public int getCols(){
        return cols;
    }
    
    public void loadNeighbors(){
        // makes a new grid tester object
        GridTester g = new GridTester(4, 5);
        // sets cell neighbors
        neighbors = g.findNeighbors(this);
    }
}