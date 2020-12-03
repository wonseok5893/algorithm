package dfs;

import java.util.LinkedList;
import java.util.Queue;

public class Programmersdfs {
    public static void main(String[] args) {
        new Programmersdfs().solution(4);
    }

    static long result;

    public long solution(int n) {
//        Queue<Integer> queue = new LinkedList<>();
//        queue.offer(0);
//        while (!queue.isEmpty()) {
//            int start = queue.poll();
//            if(start == n){
//                result++;
//                continue;
//            }
//            for(int i=1;i<=2;i++){
//                int next = start+i;
//                if(next>n)continue;
//                queue.offer(next);
//            }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2])%1234567;
        }
        System.out.println(dp[n]);
        return dp[n];

    }
//

    private void dfs(int start, int n) {
        if (start == n) {
            result = (result + 1) % 1234567;
            return;
        }
        if (start > n) {
            return;
        }
        dfs(start + 1, n);
        dfs(start + 2, n);
    }
}
