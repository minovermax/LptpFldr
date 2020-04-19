package com.ksad;

// importing array index bound error
import java.lang.ArrayIndexOutOfBoundsException;

/**
 * A class for Project 4, Maze Solver.
 * Takes a maze, and solves it using recursion.
 * @author Soungmin Lee
 * @version Nov, 18
 *
 */
public class Maze {

    // maze that's processing
    private char[][] processMaze;

    // maze that's been explored
    private char[][] exploredMaze;

    // path that indicates the path
    private String finalPath = "";


    /**
     * The constructor; takes a maze as a parameter and sets initial variables.
     * @param mazeIn The maze to be solved.
     */
    public Maze(char[][] mazeIn) {
        processMaze = mazeIn;
        exploredMaze = processMaze;
    } // constructor

    /**
     * The toString() method. Makes the 2 dimensional array and formats it.
     * @return Returns a properly formatted maze.
     */
    public String toString() {
        String formattedMaze = "";
        for (char[] chars : processMaze) {
            for (int c = 0; c < processMaze[0].length; ++c)
                formattedMaze = formattedMaze.concat(String.valueOf(chars[c]));
            formattedMaze = formattedMaze.concat("\n");
        }

        return formattedMaze;
    } // toString

    /**
     * The solver() method. Initiates the recursion method, solverRec()
     * @return Returns a final path.
     */
    public String solver() {

        solverRec(0, 1);

        if (exploredMaze[0][3] == '!') {
            return finalPath;
        } else {
            return "";
        }
    } // solver

    /**
     * The solverRec() method. Takes initial row and column, and sets the 'finalPath' and 'exploredMaze'
     * @param row The row that the recursion starts.
     * @param column The column that the recursion starts.
     */
    private void solverRec(int row, int column) {

        // base case
        if (row == 0 && column == 3) { // check destination

            exploredMaze[row][column] = '!';


        } else {

            if (isOpen(row - 1, column)) { // check north
                exploredMaze[row][column] = 'N';
                finalPath = finalPath.concat("N");
                solverRec(row - 1, column);

            }

            if (isOpen(row, column + 1)) {  // check east
                exploredMaze[row][column] = 'E';
                finalPath = finalPath.concat("E");
                solverRec(row, column + 1);

            }

            if (isOpen(row + 1, column)) {  // check south
                exploredMaze[row][column] = 'S';
                finalPath = finalPath.concat("S");
                solverRec(row + 1, column);

            }

            if (isOpen(row, column - 1)) {  // check west
                exploredMaze[row][column] = 'W';
                finalPath = finalPath.concat("W");
                solverRec(row, column - 1);


            }

            if (processMaze[row][column] == ' ') {   // dead end
                processMaze[row][column] = 'X';

            }
        }
    } // solverRec


    /**
     * The isOpen() method. Takes a certain row and column, then indicates if the next position is open.
     * @param row The row checked.
     * @param column The column checked.
     * @return Returns true if open, false if closed (wall)
     */
    private boolean isOpen(int row, int column) {
        try {
            if (processMaze[row][column] != ' ')
                return false;
            else {
                return true;
            }

        } catch (ArrayIndexOutOfBoundsException err) {   // just in case if the solverRec() asks for an out of bound position
            return false;
        }
    } // isOpen

} // end of code
