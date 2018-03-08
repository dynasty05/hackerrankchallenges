/**
 * Created by ribake on 07/03/2018.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        Solution s = new Solution();

        // shift left k times
        for (int i=1; i <= k; i++){
            a = s.shiftLeft(a);
        }

        // print out result
        for(int i=0; i<n; i++){
            System.out.print(String.valueOf(a[i]));
            // space only between array values i.e after element at index 0 up till after element at index n - 2
            if(i < n-1){
                System.out.print("\t");
            }
        }
    }

    private int[] shiftLeft(int[] items) {
        // zeroth element always goes to end of array
        int zeroth = items[0];

        // move first till last item one index left
        for (int i = 1; i < items.length; i++) {
            items[i - 1] = items[i];
        }

        // put zeroth at last index
        items[items.length - 1] = zeroth;

        return items;
    }

}
