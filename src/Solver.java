import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Dalton on 10/22/2016.
 */
public class Solver {

    private static final int DIMENSION = 9;
    private static boolean solved;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[][] grid = new int[DIMENSION][DIMENSION];

        for(int i = 0; i < DIMENSION; ++i){
            for(int j = 0; j < DIMENSION; ++j){
                grid[i][j] = in.nextInt();
            }
        }

//        grid = setGrid(grid);
        solved = false;
        printGrid(grid);

        solve(grid);
//        Pair<Integer, Integer> spot = isFull(grid);
//        if(spot == null){
//            System.out.println("SOLUTION");
//        }
//        else {
//            System.out.println(spot.getKey() + "," + spot.getValue());
//        }
//        printGrid(grid);
    }

    public static void solve(int[][] grid){

        int i;
        int j;
        ArrayList<Integer> possibilities;
//        printGrid(grid); ///todo: remove this is for debugging

        //check to see if the board is full
        Pair<Integer, Integer> location = isFull(grid);
        if(location == null){
            System.out.println("Board Solved!");
            printGrid(grid);
            solved = true;
            return;
        }
        else{
            //location is the first vacant spot
            i = location.getKey();
            j = location.getValue();

            //get the possibilites for this location
            possibilities = getPossibilites(i, j, grid);

            //go through possibilities and call the function again and again
            for(int k = 0; k < possibilities.size(); ++k){
                grid[i][j] = possibilities.get(k);
                solve(grid);
                if(solved){
                    return;
                }
            }

            //backtrack
            grid[i][j] = 0;
        }
    }

    public static ArrayList<Integer> getPossibilites(int i, int j, int[][] grid){
        ArrayList<Integer> possibilities = new ArrayList<>();
        for(int k = 0; k < 10; ++k){
            possibilities.add(k);
        }

        //remove from potential anything that shows up in the same row
        for(int k = 0; k < 9; ++k){
            if(possibilities.contains(grid[i][k])) {
                possibilities.remove((Integer)grid[i][k]);
            }
        }

        //remove from potential anything that shows up in the same column
        for(int k = 0; k < 9; ++k){
            if(possibilities.contains(grid[k][j])) {
                possibilities.remove((Integer)grid[k][j]);
            }
        }

        //remove from potential anything that shows up in the same square
        removeSquare(possibilities, i, j, grid);

        return possibilities;
    }

    public static void removeSquare(ArrayList<Integer> possibilities, int i, int j, int[][] grid){
        //find row range start
        int rs = findRangeStart(i);

        //find row range end
        int re = findRangeEnd(i);

        //find column range start
        int cs = findRangeStart(j);

        //find column range end;
        int ce = findRangeEnd(j);

        //remove range
        for(int m = rs; m <= re; ++m){
            for(int n = cs; n <= ce; ++n){
                if(possibilities.contains(grid[m][n])) {
                    possibilities.remove((Integer)grid[m][n]);
                }
            }
        }

    }

    public static int findRangeStart(int i){
        int start;
        if(i % 3 == 0){
            start = i;
        }
        else if(i % 3 == 1){
            start = i - 1;
        }
        else{
            start =  i - 2;
        }

        return start;
    }

    public static int findRangeEnd(int i){
        int end;

        if(i % 3 == 0){
            end = i + 2;
        }
        else if(i % 3 == 1){
            end = i + 1;
        }
        else{
            end = i;
        }

        return end;
    }

    public static Pair<Integer, Integer> isFull(int[][] grid){
        for(int i = 0; i < DIMENSION; ++i){
            for(int j = 0; j < DIMENSION; ++j){
                if (grid[i][j] == 0){
                    return new Pair(i, j);

                }
            }
        }
        return null;
    }

    public static int[][] setGrid(int[][] grid){
        //first row
        grid[0][0] = 6;
        grid[0][1] = 7;
        grid[0][6] = 5;
        grid[0][7] = 1;
        grid[0][8] = 2;

        //second row
        grid[1][0] = 9;
        grid[1][4] = 3;
        grid[1][5] = 5;

        //third row
        grid[2][3] = 6;
        grid[2][7] = 7;

        //fourth row
        grid[3][0] = 7;
        grid[3][6] = 3;

        //fifth row
        grid[4][3] = 4;
        grid[4][6] = 8;

        //sixth row
        grid[5][0] = 1;

        //seventh row
        grid[6][3] = 1;
        grid[6][4] = 2;

        //eight row
        grid[7][1] = 8;
        grid[7][7] = 4;

        //ninth row
        grid[8][1] = 5;
        grid[8][6] = 6;

        return grid;
    }

    public static void printGrid(int[][] grid){
        System.out.println("-------------------------");
        int temp = 0;
        for(int i = 0; i < DIMENSION; ++i){
            for (int j = 0; j < DIMENSION; ++j){
                if(j % 3 == 0) System.out.print("| ");
                temp = grid[i][j];
                if(temp == 0){
                    System.out.print("  ");
                }
                else {
                    System.out.print(grid[i][j] + " ");
                }
            }
            System.out.println("|");
            if((i+1) % 3 == 0){
                System.out.println("-------------------------");
            }
        }
    }
}
