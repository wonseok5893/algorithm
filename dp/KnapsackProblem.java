package dp;

public class KnapsackProblem {
    public static void main(String[] args) {
    solution(50,new int[]{10,20,30},new int[]{60,100,120},3);
    }


    public static int solution(int W, int wt[], int val[], int n) {
        int[][] dp = new int[n + 1][W + 1];
        int i,w;
        //dp[i][w]=> n개를 사용해서 만들수있는 w 무게 중 최대 value값

        for(i=0;i<=n;i++){
            for(w=0;w<=W;w++){
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (wt[i - 1] <= w)
                    dp[i][w] = Math.max(
                            dp[i-1][w-wt[i-1]]+val[i-1],
                            dp[i-1][w]
                    );
                else
                    dp[i][w] = dp[i-1][w];
            }
        }

        System.out.println(dp[n][W]);
        return dp[n][W];
    }
}
