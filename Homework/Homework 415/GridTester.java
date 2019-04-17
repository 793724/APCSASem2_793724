import java.util.ArrayList;
/**
 * Homework 415 - Problem 5
 *
 * @ Emma Chiu
 * @ 4/15/19
 */

public class GridTester {
    // instance variables
    Cell[][] cell;
    int rows;
    int cols;
    
    public GridTester(int r, int c) {
        // initialize variables
        rows = r;
        cols = c;
        cell = new Cell[rows][cols];
    }
    
    public void loadOccupied(){
        // calculates a third of the total cells
        int toLoad = rows*cols/3;
        int loaded = 0;
        while(loaded < toLoad) {
            // loads a third of the total cells
            int a = (int)(Math.random()*rows);
            int b = (int)(Math.random()*cols);
            if(!cell[a][b].getOccupied()){
                // sets cell to occupied if it isn't already
                cell[a][b].setOccupied();
                cell[a][b].setRows(a);
                cell[a][b].setCols(b);
                loaded++;
            }
        }
    }
    
    public int getRows(){
        return rows;
    }
    
    public ArrayList<Cell> findNeighbors(Cell c){
        // helper method for loadNeighbors()
        ArrayList<Cell> n = new ArrayList<Cell>();
        if((c.getRows() > 0) && (cell[c.getRows() - 1][c.getCols()].getOccupied() == false)){
            n.add(cell[c.getRows() -1 ][c.getCols()]);
        }
        if((c.getRows() < rows) && (cell[c.getRows() + 1][c.getCols()].getOccupied() == false)){
            n.add(cell[c.getRows() + 1][c.getCols()]);
        }
        if((c.getCols() > 0) && (cell[c.getRows()][c.getCols() - 1].getOccupied() == false)){
            n.add(cell[c.getRows()][c.getCols() - 1]);
        }
        if((c.getCols() < cols) && (cell[c.getRows()][c.getCols() + 1].getOccupied() == false)){
            n.add(cell[c.getRows()][c.getCols() + 1]);
        }
        return n;
    }
}