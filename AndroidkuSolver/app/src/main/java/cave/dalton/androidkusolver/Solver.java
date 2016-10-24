package cave.dalton.androidkusolver;

import android.util.Log;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Dalton on 10/22/2016.
 */
public class Solver {

    private static final int DIMENSION = 9;
    private static boolean solved;

    private static final String TAG = Solver.class.getSimpleName();

//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        int[][] grid = new int[DIMENSION][DIMENSION];
//
//        for(int i = 0; i < DIMENSION; ++i){
//            for(int j = 0; j < DIMENSION; ++j){
//                grid[i][j] = in.nextInt();
//            }
//        }
//
////        grid = setGrid(grid);
//        solved = false;
//        printGrid(grid);
//
//        solve(grid);
//        Pair<Integer, Integer> spot = isFull(grid);
//        if(spot == null){
//            System.out.println("SOLUTION");
//        }
//        else {
//            System.out.println(spot.getKey() + "," + spot.getValue());
//        }
//        printGrid(grid);
//    }

    public static void setSolved(boolean isSolved){
        solved = isSolved;
    }

    public static int[][] solve(int[][] grid){

        int i;
        int j;
        ArrayList<Integer> possibilities;
//        printGrid(grid); ///todo: remove this is for debugging

        //check to see if the board is full
        Pair location = isFull(grid);
        if(location == null){
            Log.d(TAG, "Board Solved!");
            printGrid(grid);
            solved = true;
            return grid;
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
                    return grid;
                }
            }

            //backtrack
            grid[i][j] = 0;
        }
        return grid;
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

    public static Pair isFull(int[][] grid){
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
        StringBuilder sb = new StringBuilder();
        sb.append("-------------------------\n");
        int temp = 0;
        for(int i = 0; i < DIMENSION; ++i){
            for (int j = 0; j < DIMENSION; ++j){
                if(j % 3 == 0) sb.append("| ");
                temp = grid[i][j];
                if(temp == 0){
                    sb.append("  ");
                }
                else {
                    sb.append(grid[i][j] + " ");
                }
            }
            sb.append("|\n");
            if((i+1) % 3 == 0){
                sb.append("-------------------------\n");
            }
        }

        Log.d(TAG, sb.toString());
        
        //set the actual view numbers so we can see from the app
        //setGridInView(grid, sa);
    }
    
    public static void setGridInView(int[][] grid, SolverActivity sa){
        
        //row 1
        ((EditText)sa.findViewById(R.id.r0c0)).setText(grid[0][0]);
        ((EditText)sa.findViewById(R.id.r0c1)).setText(grid[0][1]);
        ((EditText)sa.findViewById(R.id.r0c2)).setText(grid[0][2]);
        ((EditText)sa.findViewById(R.id.r0c3)).setText(grid[0][3]);
        ((EditText)sa.findViewById(R.id.r0c4)).setText(grid[0][4]);
        ((EditText)sa.findViewById(R.id.r0c5)).setText(grid[0][5]);
        ((EditText)sa.findViewById(R.id.r0c6)).setText(grid[0][6]);
        ((EditText)sa.findViewById(R.id.r0c7)).setText(grid[0][7]);
        ((EditText)sa.findViewById(R.id.r0c8)).setText(grid[0][8]);
        
        //row 2
        ((EditText)sa.findViewById(R.id.r1c0)).setText(grid[1][0]);
        ((EditText)sa.findViewById(R.id.r1c1)).setText(grid[1][1]);
        ((EditText)sa.findViewById(R.id.r1c2)).setText(grid[1][2]);
        ((EditText)sa.findViewById(R.id.r1c3)).setText(grid[1][3]);
        ((EditText)sa.findViewById(R.id.r1c4)).setText(grid[1][4]);
        ((EditText)sa.findViewById(R.id.r1c5)).setText(grid[1][5]);
        ((EditText)sa.findViewById(R.id.r1c6)).setText(grid[1][6]);
        ((EditText)sa.findViewById(R.id.r1c7)).setText(grid[1][7]);
        ((EditText)sa.findViewById(R.id.r1c8)).setText(grid[1][8]);
        
        //row 3
        ((EditText)sa.findViewById(R.id.r2c0)).setText(grid[2][0]);
        ((EditText)sa.findViewById(R.id.r2c1)).setText(grid[2][1]);
        ((EditText)sa.findViewById(R.id.r2c2)).setText(grid[2][2]);
        ((EditText)sa.findViewById(R.id.r2c3)).setText(grid[2][3]);
        ((EditText)sa.findViewById(R.id.r2c4)).setText(grid[2][4]);
        ((EditText)sa.findViewById(R.id.r2c5)).setText(grid[2][5]);
        ((EditText)sa.findViewById(R.id.r2c6)).setText(grid[2][6]);
        ((EditText)sa.findViewById(R.id.r2c7)).setText(grid[2][7]);
        ((EditText)sa.findViewById(R.id.r2c8)).setText(grid[2][8]);
        
        //row 4
        ((EditText)sa.findViewById(R.id.r3c0)).setText(grid[3][0]);
        ((EditText)sa.findViewById(R.id.r3c1)).setText(grid[3][1]);
        ((EditText)sa.findViewById(R.id.r3c2)).setText(grid[3][2]);
        ((EditText)sa.findViewById(R.id.r3c3)).setText(grid[3][3]);
        ((EditText)sa.findViewById(R.id.r3c4)).setText(grid[3][4]);
        ((EditText)sa.findViewById(R.id.r3c5)).setText(grid[3][5]);
        ((EditText)sa.findViewById(R.id.r3c6)).setText(grid[3][6]);
        ((EditText)sa.findViewById(R.id.r3c7)).setText(grid[3][7]);
        ((EditText)sa.findViewById(R.id.r3c8)).setText(grid[3][8]);
        
        //row 5
        ((EditText)sa.findViewById(R.id.r4c0)).setText(grid[4][0]);
        ((EditText)sa.findViewById(R.id.r4c1)).setText(grid[4][1]);
        ((EditText)sa.findViewById(R.id.r4c2)).setText(grid[4][2]);
        ((EditText)sa.findViewById(R.id.r4c3)).setText(grid[4][3]);
        ((EditText)sa.findViewById(R.id.r4c4)).setText(grid[4][4]);
        ((EditText)sa.findViewById(R.id.r4c5)).setText(grid[4][5]);
        ((EditText)sa.findViewById(R.id.r4c6)).setText(grid[4][6]);
        ((EditText)sa.findViewById(R.id.r4c7)).setText(grid[4][7]);
        ((EditText)sa.findViewById(R.id.r4c8)).setText(grid[4][8]);
        
        //row 6
        ((EditText)sa.findViewById(R.id.r5c0)).setText(grid[5][0]);
        ((EditText)sa.findViewById(R.id.r5c1)).setText(grid[5][1]);
        ((EditText)sa.findViewById(R.id.r5c2)).setText(grid[5][2]);
        ((EditText)sa.findViewById(R.id.r5c3)).setText(grid[5][3]);
        ((EditText)sa.findViewById(R.id.r5c4)).setText(grid[5][4]);
        ((EditText)sa.findViewById(R.id.r5c5)).setText(grid[5][5]);
        ((EditText)sa.findViewById(R.id.r5c6)).setText(grid[5][6]);
        ((EditText)sa.findViewById(R.id.r5c7)).setText(grid[5][7]);
        ((EditText)sa.findViewById(R.id.r5c8)).setText(grid[5][8]);
        
        //row 7
        ((EditText)sa.findViewById(R.id.r6c0)).setText(grid[6][0]);
        ((EditText)sa.findViewById(R.id.r6c1)).setText(grid[6][1]);
        ((EditText)sa.findViewById(R.id.r6c2)).setText(grid[6][2]);
        ((EditText)sa.findViewById(R.id.r6c3)).setText(grid[6][3]);
        ((EditText)sa.findViewById(R.id.r6c4)).setText(grid[6][4]);
        ((EditText)sa.findViewById(R.id.r6c5)).setText(grid[6][5]);
        ((EditText)sa.findViewById(R.id.r6c6)).setText(grid[6][6]);
        ((EditText)sa.findViewById(R.id.r6c7)).setText(grid[6][7]);
        ((EditText)sa.findViewById(R.id.r6c8)).setText(grid[6][8]);
        
        //row 8
        ((EditText)sa.findViewById(R.id.r7c0)).setText(grid[7][0]);
        ((EditText)sa.findViewById(R.id.r7c1)).setText(grid[7][1]);
        ((EditText)sa.findViewById(R.id.r7c2)).setText(grid[7][2]);
        ((EditText)sa.findViewById(R.id.r7c3)).setText(grid[7][3]);
        ((EditText)sa.findViewById(R.id.r7c4)).setText(grid[7][4]);
        ((EditText)sa.findViewById(R.id.r7c5)).setText(grid[7][5]);
        ((EditText)sa.findViewById(R.id.r7c6)).setText(grid[7][6]);
        ((EditText)sa.findViewById(R.id.r7c7)).setText(grid[7][7]);
        ((EditText)sa.findViewById(R.id.r7c8)).setText(grid[7][8]);
        
        //row 9
        ((EditText)sa.findViewById(R.id.r8c0)).setText(grid[8][0]);
        ((EditText)sa.findViewById(R.id.r8c1)).setText(grid[8][1]);
        ((EditText)sa.findViewById(R.id.r8c2)).setText(grid[8][2]);
        ((EditText)sa.findViewById(R.id.r8c3)).setText(grid[8][3]);
        ((EditText)sa.findViewById(R.id.r8c4)).setText(grid[8][4]);
        ((EditText)sa.findViewById(R.id.r8c5)).setText(grid[8][5]);
        ((EditText)sa.findViewById(R.id.r8c6)).setText(grid[8][6]);
        ((EditText)sa.findViewById(R.id.r8c7)).setText(grid[8][7]);
        ((EditText)sa.findViewById(R.id.r8c8)).setText(grid[8][8]);
    }
}

class Pair{
    int key;
    int value;

    public Pair(int key, int value){
        this.key = key;
        this.value = value;
    }

    public int getKey(){
        return key;
    }

    public int getValue(){
        return value;
    }

}
