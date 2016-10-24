package cave.dalton.androidkusolver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SolverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solver);

        final Button button = (Button) findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int[][] grid = createGridFromEntries();
                Solver.setSolved(false);
                grid = Solver.solve(grid);
                setViewStuff(grid);
            }
        });
//        int[][] grid = createGridFromEntries();
//        Solver.setSolved(false);
//        Solver.solve(grid);
    }
    
    private void setViewStuff(int[][] grid){
        //row 1
        ((EditText)findViewById(R.id.r0c0)).setText(String.valueOf(grid[0][0]));
        ((EditText)findViewById(R.id.r0c1)).setText(String.valueOf(grid[0][1]));
        ((EditText)findViewById(R.id.r0c2)).setText(String.valueOf(grid[0][2]));
        ((EditText)findViewById(R.id.r0c3)).setText(String.valueOf(grid[0][3]));
        ((EditText)findViewById(R.id.r0c4)).setText(String.valueOf(grid[0][4]));
        ((EditText)findViewById(R.id.r0c5)).setText(String.valueOf(grid[0][5]));
        ((EditText)findViewById(R.id.r0c6)).setText(String.valueOf(grid[0][6]));
        ((EditText)findViewById(R.id.r0c7)).setText(String.valueOf(grid[0][7]));
        ((EditText)findViewById(R.id.r0c8)).setText(String.valueOf(grid[0][8]));

        //row 2
        ((EditText)findViewById(R.id.r1c0)).setText(String.valueOf(grid[1][0]));
        ((EditText)findViewById(R.id.r1c1)).setText(String.valueOf(grid[1][1]));
        ((EditText)findViewById(R.id.r1c2)).setText(String.valueOf(grid[1][2]));
        ((EditText)findViewById(R.id.r1c3)).setText(String.valueOf(grid[1][3]));
        ((EditText)findViewById(R.id.r1c4)).setText(String.valueOf(grid[1][4]));
        ((EditText)findViewById(R.id.r1c5)).setText(String.valueOf(grid[1][5]));
        ((EditText)findViewById(R.id.r1c6)).setText(String.valueOf(grid[1][6]));
        ((EditText)findViewById(R.id.r1c7)).setText(String.valueOf(grid[1][7]));
        ((EditText)findViewById(R.id.r1c8)).setText(String.valueOf(grid[1][8]));

        //row 3
        ((EditText)findViewById(R.id.r2c0)).setText(String.valueOf(grid[2][0]));
        ((EditText)findViewById(R.id.r2c1)).setText(String.valueOf(grid[2][1]));
        ((EditText)findViewById(R.id.r2c2)).setText(String.valueOf(grid[2][2]));
        ((EditText)findViewById(R.id.r2c3)).setText(String.valueOf(grid[2][3]));
        ((EditText)findViewById(R.id.r2c4)).setText(String.valueOf(grid[2][4]));
        ((EditText)findViewById(R.id.r2c5)).setText(String.valueOf(grid[2][5]));
        ((EditText)findViewById(R.id.r2c6)).setText(String.valueOf(grid[2][6]));
        ((EditText)findViewById(R.id.r2c7)).setText(String.valueOf(grid[2][7]));
        ((EditText)findViewById(R.id.r2c8)).setText(String.valueOf(grid[2][8]));

        //row 4
        ((EditText)findViewById(R.id.r3c0)).setText(String.valueOf(grid[3][0]));
        ((EditText)findViewById(R.id.r3c1)).setText(String.valueOf(grid[3][1]));
        ((EditText)findViewById(R.id.r3c2)).setText(String.valueOf(grid[3][2]));
        ((EditText)findViewById(R.id.r3c3)).setText(String.valueOf(grid[3][3]));
        ((EditText)findViewById(R.id.r3c4)).setText(String.valueOf(grid[3][4]));
        ((EditText)findViewById(R.id.r3c5)).setText(String.valueOf(grid[3][5]));
        ((EditText)findViewById(R.id.r3c6)).setText(String.valueOf(grid[3][6]));
        ((EditText)findViewById(R.id.r3c7)).setText(String.valueOf(grid[3][7]));
        ((EditText)findViewById(R.id.r3c8)).setText(String.valueOf(grid[3][8]));

        //row 5
        ((EditText)findViewById(R.id.r4c0)).setText(String.valueOf(grid[4][0]));
        ((EditText)findViewById(R.id.r4c1)).setText(String.valueOf(grid[4][1]));
        ((EditText)findViewById(R.id.r4c2)).setText(String.valueOf(grid[4][2]));
        ((EditText)findViewById(R.id.r4c3)).setText(String.valueOf(grid[4][3]));
        ((EditText)findViewById(R.id.r4c4)).setText(String.valueOf(grid[4][4]));
        ((EditText)findViewById(R.id.r4c5)).setText(String.valueOf(grid[4][5]));
        ((EditText)findViewById(R.id.r4c6)).setText(String.valueOf(grid[4][6]));
        ((EditText)findViewById(R.id.r4c7)).setText(String.valueOf(grid[4][7]));
        ((EditText)findViewById(R.id.r4c8)).setText(String.valueOf(grid[4][8]));

        //row 6
        ((EditText)findViewById(R.id.r5c0)).setText(String.valueOf(grid[5][0]));
        ((EditText)findViewById(R.id.r5c1)).setText(String.valueOf(grid[5][1]));
        ((EditText)findViewById(R.id.r5c2)).setText(String.valueOf(grid[5][2]));
        ((EditText)findViewById(R.id.r5c3)).setText(String.valueOf(grid[5][3]));
        ((EditText)findViewById(R.id.r5c4)).setText(String.valueOf(grid[5][4]));
        ((EditText)findViewById(R.id.r5c5)).setText(String.valueOf(grid[5][5]));
        ((EditText)findViewById(R.id.r5c6)).setText(String.valueOf(grid[5][6]));
        ((EditText)findViewById(R.id.r5c7)).setText(String.valueOf(grid[5][7]));
        ((EditText)findViewById(R.id.r5c8)).setText(String.valueOf(grid[5][8]));

        //row 7
        ((EditText)findViewById(R.id.r6c0)).setText(String.valueOf(grid[6][0]));
        ((EditText)findViewById(R.id.r6c1)).setText(String.valueOf(grid[6][1]));
        ((EditText)findViewById(R.id.r6c2)).setText(String.valueOf(grid[6][2]));
        ((EditText)findViewById(R.id.r6c3)).setText(String.valueOf(grid[6][3]));
        ((EditText)findViewById(R.id.r6c4)).setText(String.valueOf(grid[6][4]));
        ((EditText)findViewById(R.id.r6c5)).setText(String.valueOf(grid[6][5]));
        ((EditText)findViewById(R.id.r6c6)).setText(String.valueOf(grid[6][6]));
        ((EditText)findViewById(R.id.r6c7)).setText(String.valueOf(grid[6][7]));
        ((EditText)findViewById(R.id.r6c8)).setText(String.valueOf(grid[6][8]));

        //row 8
        ((EditText)findViewById(R.id.r7c0)).setText(String.valueOf(grid[7][0]));
        ((EditText)findViewById(R.id.r7c1)).setText(String.valueOf(grid[7][1]));
        ((EditText)findViewById(R.id.r7c2)).setText(String.valueOf(grid[7][2]));
        ((EditText)findViewById(R.id.r7c3)).setText(String.valueOf(grid[7][3]));
        ((EditText)findViewById(R.id.r7c4)).setText(String.valueOf(grid[7][4]));
        ((EditText)findViewById(R.id.r7c5)).setText(String.valueOf(grid[7][5]));
        ((EditText)findViewById(R.id.r7c6)).setText(String.valueOf(grid[7][6]));
        ((EditText)findViewById(R.id.r7c7)).setText(String.valueOf(grid[7][7]));
        ((EditText)findViewById(R.id.r7c8)).setText(String.valueOf(grid[7][8]));

        //row 9
        ((EditText)findViewById(R.id.r8c0)).setText(String.valueOf(grid[8][0]));
        ((EditText)findViewById(R.id.r8c1)).setText(String.valueOf(grid[8][1]));
        ((EditText)findViewById(R.id.r8c2)).setText(String.valueOf(grid[8][2]));
        ((EditText)findViewById(R.id.r8c3)).setText(String.valueOf(grid[8][3]));
        ((EditText)findViewById(R.id.r8c4)).setText(String.valueOf(grid[8][4]));
        ((EditText)findViewById(R.id.r8c5)).setText(String.valueOf(grid[8][5]));
        ((EditText)findViewById(R.id.r8c6)).setText(String.valueOf(grid[8][6]));
        ((EditText)findViewById(R.id.r8c7)).setText(String.valueOf(grid[8][7]));
        ((EditText)findViewById(R.id.r8c8)).setText(String.valueOf(grid[8][8]));
    }
    
    private int parseIfNotEmpty(String str){
        if(str.equals("")){
            return 0;
        }
        else{
            return Integer.parseInt(str);
        }
    }

    private int[][] createGridFromEntries(){
        int[][] grid = new int[9][9];
        
        //row 1
        grid[0][0] = parseIfNotEmpty(((EditText)findViewById(R.id.r0c0)).getText().toString());
        grid[0][1] = parseIfNotEmpty(((EditText)findViewById(R.id.r0c1)).getText().toString());
        grid[0][2] = parseIfNotEmpty(((EditText)findViewById(R.id.r0c2)).getText().toString());
        grid[0][3] = parseIfNotEmpty(((EditText)findViewById(R.id.r0c3)).getText().toString());
        grid[0][4] = parseIfNotEmpty(((EditText)findViewById(R.id.r0c4)).getText().toString());
        grid[0][5] = parseIfNotEmpty(((EditText)findViewById(R.id.r0c5)).getText().toString());
        grid[0][6] = parseIfNotEmpty(((EditText)findViewById(R.id.r0c6)).getText().toString());
        grid[0][7] = parseIfNotEmpty(((EditText)findViewById(R.id.r0c7)).getText().toString());
        grid[0][8] = parseIfNotEmpty(((EditText)findViewById(R.id.r0c8)).getText().toString());

        //row 2
        grid[1][0] = parseIfNotEmpty(((EditText)findViewById(R.id.r1c0)).getText().toString());
        grid[1][1] = parseIfNotEmpty(((EditText)findViewById(R.id.r1c1)).getText().toString());
        grid[1][2] = parseIfNotEmpty(((EditText)findViewById(R.id.r1c2)).getText().toString());
        grid[1][3] = parseIfNotEmpty(((EditText)findViewById(R.id.r1c3)).getText().toString());
        grid[1][4] = parseIfNotEmpty(((EditText)findViewById(R.id.r1c4)).getText().toString());
        grid[1][5] = parseIfNotEmpty(((EditText)findViewById(R.id.r1c5)).getText().toString());
        grid[1][6] = parseIfNotEmpty(((EditText)findViewById(R.id.r1c6)).getText().toString());
        grid[1][7] = parseIfNotEmpty(((EditText)findViewById(R.id.r1c7)).getText().toString());
        grid[1][8] = parseIfNotEmpty(((EditText)findViewById(R.id.r1c8)).getText().toString());

        //row 3
        grid[2][0] = parseIfNotEmpty(((EditText)findViewById(R.id.r2c0)).getText().toString());
        grid[2][1] = parseIfNotEmpty(((EditText)findViewById(R.id.r2c1)).getText().toString());
        grid[2][2] = parseIfNotEmpty(((EditText)findViewById(R.id.r2c2)).getText().toString());
        grid[2][3] = parseIfNotEmpty(((EditText)findViewById(R.id.r2c3)).getText().toString());
        grid[2][4] = parseIfNotEmpty(((EditText)findViewById(R.id.r2c4)).getText().toString());
        grid[2][5] = parseIfNotEmpty(((EditText)findViewById(R.id.r2c5)).getText().toString());
        grid[2][6] = parseIfNotEmpty(((EditText)findViewById(R.id.r2c6)).getText().toString());
        grid[2][7] = parseIfNotEmpty(((EditText)findViewById(R.id.r2c7)).getText().toString());
        grid[2][8] = parseIfNotEmpty(((EditText)findViewById(R.id.r2c8)).getText().toString());
        
        //row 4
        grid[3][0] = parseIfNotEmpty(((EditText)findViewById(R.id.r3c0)).getText().toString());
        grid[3][1] = parseIfNotEmpty(((EditText)findViewById(R.id.r3c1)).getText().toString());
        grid[3][2] = parseIfNotEmpty(((EditText)findViewById(R.id.r3c2)).getText().toString());
        grid[3][3] = parseIfNotEmpty(((EditText)findViewById(R.id.r3c3)).getText().toString());
        grid[3][4] = parseIfNotEmpty(((EditText)findViewById(R.id.r3c4)).getText().toString());
        grid[3][5] = parseIfNotEmpty(((EditText)findViewById(R.id.r3c5)).getText().toString());
        grid[3][6] = parseIfNotEmpty(((EditText)findViewById(R.id.r3c6)).getText().toString());
        grid[3][7] = parseIfNotEmpty(((EditText)findViewById(R.id.r3c7)).getText().toString());
        grid[3][8] = parseIfNotEmpty(((EditText)findViewById(R.id.r3c8)).getText().toString());

        //row 5
        grid[4][0] = parseIfNotEmpty(((EditText)findViewById(R.id.r4c0)).getText().toString());
        grid[4][1] = parseIfNotEmpty(((EditText)findViewById(R.id.r4c1)).getText().toString());
        grid[4][2] = parseIfNotEmpty(((EditText)findViewById(R.id.r4c2)).getText().toString());
        grid[4][3] = parseIfNotEmpty(((EditText)findViewById(R.id.r4c3)).getText().toString());
        grid[4][4] = parseIfNotEmpty(((EditText)findViewById(R.id.r4c4)).getText().toString());
        grid[4][5] = parseIfNotEmpty(((EditText)findViewById(R.id.r4c5)).getText().toString());
        grid[4][6] = parseIfNotEmpty(((EditText)findViewById(R.id.r4c6)).getText().toString());
        grid[4][7] = parseIfNotEmpty(((EditText)findViewById(R.id.r4c7)).getText().toString());
        grid[4][8] = parseIfNotEmpty(((EditText)findViewById(R.id.r4c8)).getText().toString());
        
        //row 6
        grid[5][0] = parseIfNotEmpty(((EditText)findViewById(R.id.r5c0)).getText().toString());
        grid[5][1] = parseIfNotEmpty(((EditText)findViewById(R.id.r5c1)).getText().toString());
        grid[5][2] = parseIfNotEmpty(((EditText)findViewById(R.id.r5c2)).getText().toString());
        grid[5][3] = parseIfNotEmpty(((EditText)findViewById(R.id.r5c3)).getText().toString());
        grid[5][4] = parseIfNotEmpty(((EditText)findViewById(R.id.r5c4)).getText().toString());
        grid[5][5] = parseIfNotEmpty(((EditText)findViewById(R.id.r5c5)).getText().toString());
        grid[5][6] = parseIfNotEmpty(((EditText)findViewById(R.id.r5c6)).getText().toString());
        grid[5][7] = parseIfNotEmpty(((EditText)findViewById(R.id.r5c7)).getText().toString());
        grid[5][8] = parseIfNotEmpty(((EditText)findViewById(R.id.r5c8)).getText().toString());
        
        //row 7
        grid[6][0] = parseIfNotEmpty(((EditText)findViewById(R.id.r6c0)).getText().toString());
        grid[6][1] = parseIfNotEmpty(((EditText)findViewById(R.id.r6c1)).getText().toString());
        grid[6][2] = parseIfNotEmpty(((EditText)findViewById(R.id.r6c2)).getText().toString());
        grid[6][3] = parseIfNotEmpty(((EditText)findViewById(R.id.r6c3)).getText().toString());
        grid[6][4] = parseIfNotEmpty(((EditText)findViewById(R.id.r6c4)).getText().toString());
        grid[6][5] = parseIfNotEmpty(((EditText)findViewById(R.id.r6c5)).getText().toString());
        grid[6][6] = parseIfNotEmpty(((EditText)findViewById(R.id.r6c6)).getText().toString());
        grid[6][7] = parseIfNotEmpty(((EditText)findViewById(R.id.r6c7)).getText().toString());
        grid[6][8] = parseIfNotEmpty(((EditText)findViewById(R.id.r6c8)).getText().toString());
        
        //row 8
        grid[7][0] = parseIfNotEmpty(((EditText)findViewById(R.id.r7c0)).getText().toString());
        grid[7][1] = parseIfNotEmpty(((EditText)findViewById(R.id.r7c1)).getText().toString());
        grid[7][2] = parseIfNotEmpty(((EditText)findViewById(R.id.r7c2)).getText().toString());
        grid[7][3] = parseIfNotEmpty(((EditText)findViewById(R.id.r7c3)).getText().toString());
        grid[7][4] = parseIfNotEmpty(((EditText)findViewById(R.id.r7c4)).getText().toString());
        grid[7][5] = parseIfNotEmpty(((EditText)findViewById(R.id.r7c5)).getText().toString());
        grid[7][6] = parseIfNotEmpty(((EditText)findViewById(R.id.r7c6)).getText().toString());
        grid[7][7] = parseIfNotEmpty(((EditText)findViewById(R.id.r7c7)).getText().toString());
        grid[7][8] = parseIfNotEmpty(((EditText)findViewById(R.id.r7c8)).getText().toString());
        
        //row 9
        grid[8][0] = parseIfNotEmpty(((EditText)findViewById(R.id.r8c0)).getText().toString());
        grid[8][1] = parseIfNotEmpty(((EditText)findViewById(R.id.r8c1)).getText().toString());
        grid[8][2] = parseIfNotEmpty(((EditText)findViewById(R.id.r8c2)).getText().toString());
        grid[8][3] = parseIfNotEmpty(((EditText)findViewById(R.id.r8c3)).getText().toString());
        grid[8][4] = parseIfNotEmpty(((EditText)findViewById(R.id.r8c4)).getText().toString());
        grid[8][5] = parseIfNotEmpty(((EditText)findViewById(R.id.r8c5)).getText().toString());
        grid[8][6] = parseIfNotEmpty(((EditText)findViewById(R.id.r8c6)).getText().toString());
        grid[8][7] = parseIfNotEmpty(((EditText)findViewById(R.id.r8c7)).getText().toString());
        grid[8][8] = parseIfNotEmpty(((EditText)findViewById(R.id.r8c8)).getText().toString());
        
        return grid;
    }
}
