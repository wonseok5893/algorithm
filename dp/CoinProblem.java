package dp;

import java.util.Arrays;

public class CoinProblem {
    public static void main(String[] args) {
        //Time complexity of this function: O(mn)
        //Space Complexity of this function: O(n)

        // table[i] will be storing the number of solutions
        // for value i. We need n+1 rows as the table is
        // constructed in bottom up manner using the base
        // case (n = 0)
        int n = 10;
        int[]S = new int[]{2,3,5,6};
        int m = S.length;
        long[] table = new long[n+1];

        // Initialize all table values as 0
        Arrays.fill(table, 0);   //O(n)

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i=0; i<m; i++) {
            for (int j = S[i]; j <= n; j++) {
                table[j] += table[j - S[i]];
            }
            for (long e : table) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
}
}
