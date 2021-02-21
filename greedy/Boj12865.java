package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int maxBag = Integer.parseInt(st.nextToken());

        //dp[i][w]=> n개를 사용해서 만들수있는 w 무게 중 최대 value값

        int[][]dp = new int[n+1][maxBag+1];
        int[]weight = new int[n];
        int[]value = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= maxBag; j++) {
                if(i==0||j==0) dp[i][j] = 0;
                else if(weight[i-1]<=j){
                    dp[i][j] = Math.max(
                            dp[i-1][j-weight[i-1]]+value[i-1],
                            dp[i-1][j]
                    );
                }
                else dp[i][j] = dp[i-1][j];
            }
        }
        System.out.println(dp[n][maxBag]);


    }
}
