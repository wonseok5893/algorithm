package bfs;

import java.util.Stack;

public class Programmers208959 {
    public static void main(String[] args) {
        solution(30);
    }
    public static long solution(int n) {
        //0,1,2
        //마지막에 2개로 점프
        //에[dp[n-1]+dp[n-2]]
        //n==2
        //1,1   2
        //n==3 dp[2]+dp[1]
        //1,1,1  1,2   2,1
        //n==4 dp[3] +dp[2]
        // 1,1,1,1 1,1,2  4+ 1 = 5
        long[] arr = new long[n+1];
        arr[2] = 2;
        arr[3] = 3;
        for(int i=4;i<=n;i++){
            arr[i] = (arr[i-1]+arr[i-2])%1234567;
        }
        for (long e : arr) {
            System.out.println(e);
        }
        return arr[n];
    }
}
