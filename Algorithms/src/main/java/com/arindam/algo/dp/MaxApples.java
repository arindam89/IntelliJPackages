package com.arindam.algo.dp;

/**
 * Created by arpaul on 9/14/14.
 */
public class MaxApples {

    public int findMaxFruit(int[][] input, int i, int j){
        /*
            There are only two ways to come to a row r and col c
            One way is from r-1 , c
            Other is from r, c-1
            Base cases are:
                r = 0. c = 0 return input[0][0]
         */
        int MaxSoFar[][] = new int[input.length][input[0].length];

        // Initialize MaxSoFar
        for (int row = 0; row < input.length; row++) {
            for (int col = 0; col < input[0].length; col++) {
                MaxSoFar[row][col] = 0;
            }
        }


        // Start the DP
        for (int row = 0; row < input.length; row++) {
            for (int col = 0; col < input[0].length; col++) {
                if((row == 0) && (col == 0)){
                    MaxSoFar[row][col] = input[row][col];
                }
                else if(row == 0 ){
                    MaxSoFar[row][col] = MaxSoFar[row][col-1] + input[row][col];
                }
                else if(col == 0 ){
                    MaxSoFar[row][col] = MaxSoFar[row-1][col] + input[row][col];
                }
                else {
                    MaxSoFar[row][col] =
                            Math.max(MaxSoFar[row][col-1],MaxSoFar[row-1][col]) + input[row][col];
                }
            }
        }

        // Return the result
        return MaxSoFar[i][j];
    }
}
