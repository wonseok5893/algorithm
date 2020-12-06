package implement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ProgrammersEvenCounting {
    public static void main(String[] args) {
        new ProgrammersEvenCounting().solution(new int[][]{{1,0,0,1,1},
                {0,0,0,0,0}
        ,{1,1,0,0,0},{0,0,0,0,1}});
    }

    static int rowLen;

    public int solution(int[][] a) {
        rowLen = a.length;
        int colLen = a[0].length;
        int[] countCol = new int[colLen];
        for (int i = 0; i < colLen; i++) {
            int count = 0;
            for (int j = 0; j < rowLen; j++) {
                if (a[j][i] == 1) count++;
            }
            countCol[i] = count;
        }
        int[] factorial = new int[301];
        factorial[0] = 1;
        factorial[1] = 1;
        for (int i = 2; i < 300; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        int[][] dp = new int[colLen][rowLen + 1];
        //dp[col][num]
        dp[0][countCol[0]] = comb(rowLen, countCol[0], factorial);
        int startNum = countCol[0];
        for (int i = 1; i < colLen; i++) {
            int nextNum = 0;
            int suffix = 0;
            if (startNum > countCol[i]) {
                nextNum += startNum-countCol[i];
                suffix = comb(startNum, countCol[i], factorial
                );
            } else if (startNum == countCol[i]) {
                nextNum = 0;
                suffix = 1;
            } else {
                nextNum += countCol[i] - startNum;
                suffix = comb(rowLen-startNum, nextNum, factorial
                );
            }
            dp[i][nextNum] = dp[i - 1][startNum] * suffix;
        }
        System.out.println(dp[colLen-1][rowLen]);
        for (int[] d : dp) {
            for (int e : d) {
                System.out.print(e+" ");
            }
            System.out.println();
        }
        System.out.println();
        return dp[colLen-1][rowLen];
    }

    public int comb(int a, int b, int[] factorial) {
        int aF = factorial[a];
        int bF = factorial[b];
        int cF = factorial[a - b];
        return aF / (bF * cF);
    }
}
