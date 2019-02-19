import java.util.*;
import java.io.*;
import java.awt.*;
/**
 * Brandi Durham 
 * 
 * MapDataDrawer class takes a data file of number, puts them into an 2D array.
 * It has methods to find the min and max, find the index of the row of the min
 * value of a certian column, draw the map, draw the path of the lowest elevation change.
 * 
 */

public class MapDataDrawer
{
  // store map data in grid array
  private int[][] grid; 
  
  // Read 2D array into grid. Data in file "filename", grid is rows x cols
  public MapDataDrawer(String filename, int rows, int cols) throws Exception{
      File reviewFile = new File(filename);
      Scanner reviewScanner = new Scanner(reviewFile);
      grid = new int[rows][cols];
      for(int r = 0;r < rows; r++)
      {
          for (int c = 0; c < cols; c++)
          {
              int newInt = reviewScanner.nextInt();
              grid[r][c] = newInt;
              //System.out.print(grid[r][c] + " ");
          }
          //System.out.println();
        }
        
  }
  
  /**
   * @return the min value in the entire grid
   */
  public int findMin(){
      int min = grid[0][0];
      for(int r = 0; r < grid.length; r++)
      {
          for(int c = 0; c< grid[r].length; c++)
          {
              if(grid[r][c] < min)
              {
              min = grid[r][c];
            }
            }
        }
      return min;  
  }
  
  /**
   * @return the max value in the entire grid
   */
  public int findMax(){
      int max = grid[0][0];
      for(int r = 0; r < grid.length; r++)
      {
          for(int c = 0; c< grid[r].length; c++)
          {
              if(grid[r][c] > max)
              {
              max = grid[r][c];
            }
            }
        }
      return max; 
  }
  
  /**
   * @param col the column of the grid to check
   * @return the index of the row with the lowest value in the given col for the grid
   */
  public  int indexOfMinRow(int col){
      int min = grid[0][col];
      int minPos = 0;
      for(int r = 0; r< grid.length; r++)
      {
          if(grid[r][col] < min)
          {
              min = grid[r][col];
              minPos = r;
          }
      }
      return minPos;  
  }
  
  
  /**
   * DON'T CHANGE THIS CODE, except to uncomment it when you instantiate the grid
   * Draws the grid using the given Graphics object. 
   * Colors should be grayscale values 0-255, scaled based on min/max values in grid
   */
  
  // ******ALERT******
  // Note - until you instantiate a grid, through the constructor, this
  // method will generate a null pointer exception, since there is no grid.length
  // ********************
  public void drawMap(Graphics g){
      
    int minVal = findMin();
    int maxVal = findMax();
    double range = maxVal - minVal;
    
    for(int row=0; row < grid.length; row++){
      for(int col=0; col<grid[0].length; col++){
         int val = (int)(((grid[row][col]-minVal)/range) * 255);
         g.setColor(new Color(val,255-val,255-val));
         g.setColor(new Color(val,val,val));
         g.fillRect(col,row,1,1);
        }
    }      
  }
  

   /**
   * Find a path from West-to-East starting at given row.
   * Choose a foward step out of 3 possible forward locations, using greedy method described in assignment.
   * @return the total change in elevation traveled from West-to-East
   */
  public int drawLowestElevPath(Graphics g, int row){
    int currY = row; // row in grid of step one
    // draw initial step - column 0, current row (sent in as parameter)
    g.fillRect(0,row,1,1);
    
    // Code to compute next step
   

    int minVal= 0;
    int elevChange = 0;
    int c;
    Random randomNum = new Random();
    
    for(c = 0; c<grid[currY].length-1; c++)
    {
        minVal = Math.abs(grid[currY][c] - grid[currY][c+1]);
        if(currY == 0)
        {

            if(minVal > Math.abs(grid[currY][c] - grid[currY+1][c+1]))
            {
                minVal = Math.abs(grid[currY][c] - grid[currY+1][c+1]);
                currY = currY+1;
            }
        }
        else if(currY == grid.length-1)
        {

            if(minVal > Math.abs(grid[currY][c] - grid[currY-1][c+1]))
            {
                minVal = Math.abs(grid[currY][c] - grid[currY-1][c+1]);
                currY = currY-1;
            }
        }
        else if(currY !=0 && currY !=grid.length-1)
        {
            if(minVal > Math.abs(grid[currY][c] - grid[currY+1][c+1]) && (Math.abs(grid[currY][c] - grid[currY+1][c+1]) < Math.abs(grid[currY][c] - grid[currY-1][c+1])))
            {
                minVal = Math.abs(grid[currY][c] - grid[currY+1][c+1]);
                currY = currY+1;
            }
            else if(minVal > Math.abs(grid[currY][c] - grid[currY-1][c+1]) && (Math.abs(grid[currY][c] - grid[currY-1][c+1]) < Math.abs(grid[currY][c] - grid[currY+1][c+1])))
            {
                minVal = Math.abs(grid[currY][c] - grid[currY-1][c+1]);
                currY = currY-1;
            }
            else if(Math.abs(grid[currY][c] - grid[currY+1][c+1]) == Math.abs(grid[currY][c] - grid[currY-1][c+1]) && (Math.abs(grid[currY][c] - grid[currY-1][c+1])< minVal))
            {
                int ranNum = randomNum.nextInt(2);
                if(ranNum == 0)
                {
                    minVal = Math.abs(grid[currY][c] - grid[currY-1][c+1]);
                    currY = currY -1;
                }
                else
                {
                    minVal = Math.abs(grid[currY][c] - grid[currY+1][c+1]);
                    currY = currY +1;
                }
            }
        }
        elevChange += minVal;
        g.fillRect(c,currY,1,1);
        
    }
    
    // draw next step where x is currently column and currY is row in grid
    //int x = 0; // the value of x will be generated by a loop that goes through the
    // columns, but for now, need something to put in "paint" statement
    g.fillRect(c,currY,1,1);
    
    return elevChange; // computed change in elevation
  }
  
  /**
   * @return the index of the starting row for the lowest-elevation-change path in the entire grid.
   */
  public int indexOfLowestElevPath(Graphics g){
      int rowLowElev = 0;
      int min = drawLowestElevPath(g, 0);
      for(int r = 1; r<grid.length; r++)
      {
          if(min > drawLowestElevPath(g, r))
          {
              min = drawLowestElevPath(g, r);
              rowLowElev = r;
            }
        }
     
      return rowLowElev; // row of path with lowest elevation
  
  }
  
  
}