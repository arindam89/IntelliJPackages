package com.arindam.algo.dp;

import java.util.Vector;

/**
 * Created by arpaul on 9/9/14.
 */
public class LIS {
    // This method starts solving the problem.
    public int[] solve(int[] in){
        // If input array is empty.
        if(in.length <= 0) {
            System.out.println("The input array is empty nothing to do..");
            return null;
        } else if(in.length == 1){
            // Input array has only one element so the result it itself.
            return in;
        }
        // Otherwise initialize the Vectors.
        Vector<Vector<Integer>> lis = new Vector<Vector<Integer>>(in.length);
        // For the first array elements element the lis is itself.
        lis.add(0, getVectorFromInteger(in[0]));

        // From here one start the DP.
        for (int i = 1; i < in.length; i++) {
            calculateLIS(i, in, lis);
        }

        // Print the longest LIS
        return generateLIS(lis);
    }

    private Vector<Integer> getVectorFromInteger(int element){
        Vector<Integer> v = new Vector<Integer>();
        v.add(element);
        return v;
    }

    private void calculateLIS(int i,int[] in, Vector<Vector<Integer>> lis){
        // Do some stuff only if it does make sense add the current element can increase the LIS.
        // find the suitable lis index.
        int max = -1;
        int index = -1;
        for (int j = 0; j < i; j++) {
            if(in[j]<in[i]){
                if(max < (lis.get(j).size() + 1)){
                    max = lis.get(j).size() + 1;
                    index = j;
                }
            }
        }

        // Now I have the index where the vector has longest subsequence including current element.
        if(index == -1){
            // Only one element having the current one.
            lis.add(i, getVectorFromInteger(in[i]));
        } else {
            copyAndAddVector(lis, i, index, in);
        }
    }

    private void copyAndAddVector(Vector<Vector<Integer>> lis, int i,int index, int[] in){
        Vector<Integer> v = new Vector<Integer>();
        for (int j = 0; j < lis.get(index).size(); j++) {
            v.add(lis.get(index).get(j));
        }
        v.add(in[i]);
        lis.add(i,v);
    }

    private int[] generateLIS(Vector<Vector<Integer>> lis){
        int max = 0;
        int index = 0;
        for(Vector<Integer> v: lis){
            if(max < v.size()){
                max = v.size();
                index = lis.indexOf(v);
            }
        }

        int[] result = new int[lis.elementAt(index).size()];
        int i = 0;
        for(Integer element: lis.elementAt(index)){
            result[i] = element;
            i++;
        }

        return result;
    }
}
